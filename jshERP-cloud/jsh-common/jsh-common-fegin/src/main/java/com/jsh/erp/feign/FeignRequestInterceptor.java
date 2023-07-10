package com.jsh.erp.feign;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: huangS
 * @ClassName: FeignRequestInterceptor
 * @Description: TODO
 * @DateTime: 2023/7/10-14:46
 * @Version: 1.0
 **/
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
        @Override
        public void apply(RequestTemplate requestTemplate) {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
                String token = request.getHeader("X-Access-Token");
                if(StringUtils.hasText(token)) {
                    requestTemplate.header("X-Access-Token", token);
                }
            }
        }
    }

}

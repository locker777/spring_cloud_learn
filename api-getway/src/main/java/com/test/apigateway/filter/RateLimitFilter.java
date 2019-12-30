package com.test.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.test.apigateway.RateLimitException;
import org.springframework.stereotype.Component;
import org.w3c.dom.ranges.RangeException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @Auther: zjc
 * @Date: 2019/12/24 10:13
 * @Description: 限流拦截器
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);//每秒放100个令牌

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        if (!RATE_LIMITER.tryAcquire()) {//没有拿到令牌，方法是去取令牌

            throw new RateLimitException();
        }
        return null;
    }
}

package com.test.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.test.apigateway.constant.RedisConstant;
import com.test.apigateway.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Auther: zjc
 * @Date: 2019/12/19 14:21
 * @Description: 权限拦截 区分买家和卖家
 */
@Component
public class AuthBuyFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if ("/order/order/create".equals(request.getRequestURI())) {
            return true;
        }
        return false;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 要实现的逻辑
     *
     * @return
     */
    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        /**
         * /order/create 只能买家访问(cookie里有openId)
         *
         * /product/list 都可访问
         */
        Cookie cookie = CookieUtil.get(request, "openid");
        if (cookie == null || StringUtils.isBlank(cookie.getValue())) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}

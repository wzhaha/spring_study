package com.springcloud.project.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class TokenFilter extends ZuulFilter {

    @Value("${server.port}")
    private String port;

    //过滤器类型
    @Override
    public String filterType() {
        return "pre";//请求之前进行过滤
    }

    //过滤器执行顺序,请求在同一阶段的时候存在多个过滤器时，过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器业务逻辑
    @Override
    public Object run() throws ZuulException {
        try {
            // 1.获取上下文
            RequestContext context=RequestContext.getCurrentContext();
            //获取request
            HttpServletRequest request=context.getRequest();
            InputStream inputStream=request.getInputStream();
            //获取token
            String usertoken=request.getParameter("userToken");

            System.out.println("请求方法是:"+request.getMethod());
            String reqBody= StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));

            System.out.println("请求体:"+reqBody);
            System.out.println("网关服务器端口号是："+port);
            if(usertoken==null){
                context.setSendZuulResponse(false);
                context.setResponseBody("token is null");
                context.setResponseStatusCode(401);
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        //正常执行
        return null;
    }
}

package com.iot.nero.filter;


import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Author nero
 * Date   2016/10/20 0020
 * Time   16:15
 * Email  nerosoft@outlook.com
 */
@Component
public class CORSFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String origin = (String) servletRequest.getRemoteHost() + ":" + servletRequest.getRemotePort();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getHeader("Origin") != null) {
            if (request.getHeader("Origin").contains("localhost")) {
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            } else if (request.getHeader("Origin").contains("47.94.251.146")) {
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            } else if (request.getHeader("Origin").contains("cenocloud")) {
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            } else if (request.getHeader("Origin").contains("139.199.184.19")) {
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            }
        }

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,x-requested-with,Authorization,FromAgent,SSO-ID,SSO-TOKEN");
        response.setHeader("Access-Control-Allow-Credentials", "true");


        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(request);

        //获得所有请求参数名
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            //得到参数名
            String name = params.nextElement().toString();

            //得到参数对应值
            String value = request.getParameter(name);

            requestWrapper.addParameter( name, StringEscapeUtils.escapeSql(value));

        }



        filterChain.doFilter(requestWrapper, servletResponse);

    }

    public class ParameterRequestWrapper extends HttpServletRequestWrapper {

        private Map<String, String[]> params = new HashMap<String, String[]>();


        @SuppressWarnings("unchecked")
        public ParameterRequestWrapper(HttpServletRequest request) {
            // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
            super(request);
            //将参数表，赋予给当前的Map以便于持有request中的参数
            this.params.putAll(request.getParameterMap());
        }

        //重载一个构造方法
        public ParameterRequestWrapper(HttpServletRequest request, Map<String, Object> extendParams) {
            this(request);
            addAllParameters(extendParams);//这里将扩展参数写入参数表
        }

        @Override
        public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
            String[] values = params.get(name);
            if (values == null || values.length == 0) {
                return null;
            }
            return values[0];
        }

        public String[] getParameterValues(String name) {//同上
            return params.get(name);
        }

        public void addAllParameters(Map<String, Object> otherParams) {//增加多个参数
            for (Map.Entry<String, Object> entry : otherParams.entrySet()) {
                addParameter(entry.getKey(), entry.getValue());
            }
        }

        public void addParameter(String name, Object value) {//增加参数
            if (value != null) {
                if (value instanceof String[]) {
                    params.put(name, (String[]) value);
                } else if (value instanceof String) {
                    params.put(name, new String[]{(String) value});
                } else {
                    params.put(name, new String[]{String.valueOf(value)});
                }
            }
        }

    }

    public void destroy() {

    }
}

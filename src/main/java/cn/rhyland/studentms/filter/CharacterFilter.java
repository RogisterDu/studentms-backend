package cn.rhyland.studentms.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "CharacterFilter")
public class CharacterFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 拦截所有的请求 解决全站中文乱码
        // 指定 request 和 response 的编码
        request.setCharacterEncoding("utf-8"); // 只对消息体有效
        response.setContentType("text/html;charset=utf-8");
        // 对request进行包装
        CharacterRequest characterRequest = new CharacterRequest(request);
        chain.doFilter(characterRequest, response);
    }
}
// 继承 默认包装类HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper {
    public CharacterRequest(HttpServletRequest request) {
        super(request);
    }
    // 子类继承父类一定会覆写一些方法，此处用于重写getParamter()方法
    public String getParameter(String name) {
        // 调用被包装对象的getParameter()方法，获得请求参数
        String value = super.getParameter(name);
        if (value == null)
            return null;
        // 判断请求方式
        String method = super.getMethod();
        if ("get".equalsIgnoreCase(method)) {
            value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        }
        // 解决乱码后返回结果
        return value;
    }
}

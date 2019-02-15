package cn.su;

import javax.servlet.*;
import java.io.IOException;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EncodeFilter implements Filter {
    private String encoding;
    private Boolean forceEncoding = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        System.out.println("设置字符集编码为"+encoding);

    }

    @Override
    public void destroy() {

    }
}

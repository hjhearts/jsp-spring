/*package work05;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class EncoderFilter implements Filter {
    ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("UTF-8 Encoding...");
        context = filterConfig.getServletContext();
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("doFilter 호출");
        servletRequest.setCharacterEncoding("utf-8");
        String context = ((HttpServletRequest)servletRequest).getContextPath();
        String pathInfo = ((HttpServletRequest)servletRequest).getRequestURI();
        String realPath = servletRequest.getRealPath(pathInfo);
        String msg = " Context 정보:" + context
                + "\n URI 정보:" + pathInfo
                + "\n 물리적 경로:" + realPath;
        System.out.println(msg);
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("작업시간 : " + (end-start) + "ms");
    }
}

 */

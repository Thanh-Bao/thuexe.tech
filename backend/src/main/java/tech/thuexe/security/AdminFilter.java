package tech.thuexe.security;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if(session.getAttribute("HAD_LOGIN")==null){
            request.getRequestDispatcher("/admin/login").forward(request, response);
        } else {
            filterChain.doFilter(request,response);
        }
    }
}

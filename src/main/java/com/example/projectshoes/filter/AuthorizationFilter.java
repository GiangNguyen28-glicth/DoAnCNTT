package com.example.projectshoes.filter;

import com.example.projectshoes.constant.SystemConstant;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.utils.SessionUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter implements Filter {

  private ServletContext context;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.context = filterConfig.getServletContext();
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    String url = request.getRequestURI();
    if (url.startsWith("/admin")) {
      UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
      if (user != null) {
        if (user.getRole().getCode().equals(SystemConstant.ADMIN)) {
          filterChain.doFilter(servletRequest, servletResponse);
        } else if (user.getRole().getCode().equals(SystemConstant.USER)) {
          response.sendRedirect(request.getContextPath()
              + "/dang-nhap?action=login&message=not_permission&alert=warning");
        }
      } else {
        response.sendRedirect(
            request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=info");
      }
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  @Override
  public void destroy() {
  }
}

package com.example.projectshoes.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

  private static CookieUtil cookieUtil = null;

  public static CookieUtil getInstance() {
    if (cookieUtil == null) {
      cookieUtil = new CookieUtil();
    }
    return cookieUtil;
  }

  public void putValue(HttpServletResponse response, String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setPath("/");
    cookie.setMaxAge(10);
    response.addCookie(cookie);
  }

  public Cookie[] getCookie(HttpServletRequest request) {
    return request.getCookies();
  }
}

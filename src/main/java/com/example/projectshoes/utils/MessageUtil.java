package com.example.projectshoes.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
    public static void showMessage(HttpServletRequest request){
        if(request.getParameter("message") !=null ){
            String messageResponse = "";
            String alert = "";
            String message = request.getParameter("message");
        }
    }
}

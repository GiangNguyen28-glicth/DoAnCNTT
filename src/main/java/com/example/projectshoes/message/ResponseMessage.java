package com.example.projectshoes.message;

public class ResponseMessage {

  private static ResponseMessage responseMessage = null;
  private String message;

  public static ResponseMessage getInstance() {
    if (responseMessage == null) {
      responseMessage = new ResponseMessage();
    }
    return responseMessage;
  }

  public static ResponseMessage getResponseMessage() {
    return responseMessage;
  }

  public static void setMessage(String message) {
    ResponseMessage.responseMessage.message = message;
  }

  public String getMessage() {
    return message;
  }
}

package com.example.projectshoes.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OtpUtil {

  public static String generateOtp(final int lengthOfOTP) {
    StringBuilder generateOTP = new StringBuilder();
    SecureRandom secureRandom = new SecureRandom();
    try {
      secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());
      for (int i = 0; i < lengthOfOTP; i++) {
        generateOTP.append(secureRandom.nextInt(9));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return generateOTP.toString();
  }

  public static void main(String[] args) {
    System.out.println(generateOtp(6));
  }

}


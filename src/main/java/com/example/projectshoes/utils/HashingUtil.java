package com.example.projectshoes.utils;
public class HashingUtil {

  private static final UpdatebleBCrypt bcrypt = new UpdatebleBCrypt(11);

  public static String hash(String password) {
    return bcrypt.hash(password);
  }

  public static boolean verifyAndUpdateHash(String password, String hash) {
    return bcrypt.verifyAndUpdateHash(password, hash);
  }
}

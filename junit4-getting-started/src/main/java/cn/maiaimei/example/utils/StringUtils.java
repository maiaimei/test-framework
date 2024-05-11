package cn.maiaimei.example.utils;

public class StringUtils {

  public static boolean hasText(CharSequence str) {
    if (str == null) {
      return false;
    } else {
      int strLen = str.length();
      if (strLen == 0) {
        return false;
      } else {
        for (int i = 0; i < strLen; ++i) {
          if (!Character.isWhitespace(str.charAt(i))) {
            return true;
          }
        }
        return false;
      }
    }
  }

  public static boolean hasLength(CharSequence str) {
    return str != null && str.length() > 0;
  }

  @Deprecated
  public static boolean isEmpty(Object str) {
    return str == null || "".equals(str);
  }
}

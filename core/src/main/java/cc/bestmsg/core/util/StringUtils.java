package cc.bestmsg.core.util;

/**
 * Created by  songzip on 2020/6/3.
 */
public class StringUtils {


    /**
     * Example: subString("12345","1","4")=23
     *
     * @param src
     * @param start
     * @param to
     * @return
     */
    public static Integer subStringToInteger(String src, String start, String to) {
        return stringToInteger(subString(src, start, to));
    }

    /**
     * Example: subString("abcd","a","c")="b"
     *
     * @param src
     * @param start null while start from index=0
     * @param to    null while to index=src.length
     * @return
     */
    public static String subString(String src, String start, String to) {
        int indexFrom = start == null ? 0 : src.indexOf(start);
        int indexTo = to == null ? src.length() : src.indexOf(to);
        if (indexFrom < 0 || indexTo < 0 || indexFrom > indexTo) {
            return null;
        }

        if (null != start) {
            indexFrom += start.length();
        }

        return src.substring(indexFrom, indexTo);

    }

    /**
     * @param in
     * @return
     */
    public static Integer stringToInteger(String in) {
        if (in == null) {
            return null;
        }
        in = in.trim();
        if (in.length() == 0) {
            return null;
        }

        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            System.err.println("stringToInteger fail,string=" + in);
            return null;
        }
    }

    public static boolean equals(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equalsIgnoreCase(b);
    }

    public static boolean isEmpty(String value) {
        if (value == null || value.length() == 0) {
            return true;
        }

        return false;
    }

    public static int lowerHashCode(String text) {
        if (text == null) {
            return 0;
        }
//        return text.toLowerCase().hashCode();
        int h = 0;
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            h = 31 * h + ch;
        }
        return h;
    }
}

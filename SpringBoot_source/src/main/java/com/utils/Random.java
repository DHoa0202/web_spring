package com.utils;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * String txt = "Hello ";<br>
 * int length = 20;<br>
 * System.out.println(Random.Number(txt, length));<br>
 * System.out.println(Random.UpperCase(txt, length));<br>
 * System.out.println(Random.LowerCase(txt, length));<br>
 * System.out.println(Random.NumAndUpp(txt, length));<br>
 * System.out.println(Random.NumAndLow(txt, length));<br>
 * System.out.println(Random.UppAndLow(txt, length));<br>
 * System.out.println(Random.NumUppLow(txt, length));<br>
 * for (int i = 0; i ⇐ 100; i++) {<br>
 * &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp System.out.println(Random.date(
 * "1/1/2020","12/31/2022"));<br>
 * }<br>
 * <hr>
 *
 * @since Sat Dec 18 19:31:34 ICT 2021
 * @version 1.0
 */
public class Random {

    private final static java.util.Random r = new java.util.Random();

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi chứa số" sau khi random
     */
    public static String Number(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        try {
            Integer.parseInt(firstText);
        } catch (NumberFormatException e) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 47 && i < 58) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi chứa kí tự in HOA" sau khi random
     */
    public static String UpperCase(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 64 && i < 91) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi chứa kí tự in thường" sau khi random
     */
    public static String LowerCase(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 96 && i < 123) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi" sau khi random bao gồm "số", kí tự in "HOA".
     */
    public static String NumAndUpp(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 47 && i < 58) {
                firstText += (char) i;
            } else if (i > 64 && i < 91) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi" sau khi random bao gồm "số", kí tự in "thường".
     */
    public static String NumAndLow(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 47 && i < 58) {
                firstText += (char) i;
            } else if (i > 96 && i < 123) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi" sau khi random bao gồm kí tự in "HOA" và kí tự in
     * "thường".
     */
    public static String UppAndLow(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 64 && i < 91) {
                firstText += (char) i;
            } else if (i > 96 && i < 123) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * @param firstText chuỗi kí tự đầu tiên
     * @param length độ dài chuỗi kí tự
     * @return kết quả "chuỗi" sau khi random bao gồm "số", kí tự in "HOA", kí
     * tự in "thường".
     */
    public static String NumUppLow(String firstText, int length) {
        if (firstText == null) {
            firstText = "";
        }
        while (firstText.length() < length) {
            int i = r.nextInt(122);
            if (i > 47 && i < 58) {
                firstText += (char) i;
            } else if (i > 64 && i < 91) {
                firstText += (char) i;
            } else if (i > 96 && i < 123) {
                firstText += (char) i;
            }
        }
        return firstText;
    }

    /**
     * <h3>Kiểu định dạng <em style="color:'red'">"MM/dd/yyyy"</em></h3>
     * random trong khoảng ngày
     * <hr>
     *
     * @param firstDate chuỗi kí tự ngày đầu tiên
     * <strong style="color:'red'">"MM/dd/yyyy"</strong>
     * @param endDate độ dài chuỗi kí tự ngày cuối cùng
     * <strong style="color:'red'">"MM/dd/yyyy"</strong>
     * @return kết quả ngày được random trong khoảng [firstDate,endDate]
     */
    @SuppressWarnings("deprecation")
	public static Date date(String firstDate, String endDate) {
        Date date = new Date();
        long minTime = date.getTime() - 15778800000L;
        long maxTime = date.getTime() + 15778800000L;

        try {
            minTime = new Date(firstDate).getTime();
            maxTime = new Date(endDate).getTime();
        } catch (Exception e) {
        }

        long nextLong = ThreadLocalRandom.current().nextLong(minTime, maxTime);
        return new Date(nextLong);
    }
    
}
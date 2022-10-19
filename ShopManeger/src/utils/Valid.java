package utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

public class Valid {
    public static final String VALID_EMAIL = "^([A-Z|a-z|0-9](\\.|_)?)+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.)?[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}$";
    public static final String VALID_PASSWORD = "^([A-Za-z0-9]{8,})";
    public static final String VALID_NAME = "^([A-Z]+[a-z]*[ ]?)+$";

    public static final String VALID_NAMEPRODUCT = "^([A-z0-9]*[ ]?)+$";
    public static final String VAILD_USERNAME = "^[A-z_](\\w|\\.|_){5,31}$"; //^(?!.*\.\.)(?!.*\.$)[^\W][\w.]{5,31}$
    public static final String VALID_PHONE = "^[0][1-9][0-9]{8,9}$";

    public static boolean isValidEmail(String email) {
        return Pattern.compile(VALID_EMAIL).matcher(email).matches();
    }
    public static boolean isValidPassWord(String password) {
        return Pattern.compile(VALID_PASSWORD).matcher(password).matches();
    }
    public static boolean isValidName(String name) {
        return Pattern.compile(VALID_NAME).matcher(name).matches();
    }
    public static boolean isValidNameProduct(String name) {
        return Pattern.compile(VALID_NAMEPRODUCT).matcher(name).matches();
    }
    public static boolean isValidUserName(String userName) {
        return Pattern.compile(VAILD_USERNAME).matcher(userName).matches();
    }
    public static boolean isValidPhone(String phone) {
        return Pattern.compile(VALID_PHONE).matcher(phone).matches();
    }


    public static String localDateTimeToDateWithSlash(LocalDateTime localDateTime) {
        if(localDateTime!= null){
            return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDateTime);
        }
        return "";
    }

    public static String priceWithDecimal (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00 VND");
        return formatter.format(price);
    }

    public static String priceWithoutDecimal (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.## VND");
        return formatter.format(price);
    }

    public static String priceToString(Double price) {
        String toShow = priceWithoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return priceWithDecimal(price);
        } else {
            return priceWithoutDecimal(price);
        }
    }
}

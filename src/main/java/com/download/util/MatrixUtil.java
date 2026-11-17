package com.download.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author test
 */
public class MatrixUtil {

    public static Date StringtoDate(String str) {
        Date returnDate = null;

        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            returnDate = f.parse(str);
        } catch (ParseException e) {
        }
        return returnDate;
    }

    public static long StringtoLong(String str) {
        Date returnDate = null;

        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            returnDate = f.parse(str);
        } catch (ParseException e) {
        }
        return returnDate.getTime();
    }

    public static boolean validateEmail(String email) {
        if(email!=null){
            String EMAIL_PATTERN
                    = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }
   
}

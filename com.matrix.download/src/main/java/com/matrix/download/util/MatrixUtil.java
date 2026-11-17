package com.matrix.download.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author test
 */
public class MatrixUtil {

    public static Date StringtoDate(String str) {
        Date returnDate=null;

        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            returnDate = f.parse(str);
        } catch (ParseException e) {
        }
        return returnDate;
    }
    
    public static long StringtoLong(String str) {
        Date returnDate=null;

        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            returnDate = f.parse(str);
        } catch (ParseException e) {
        }
        return returnDate.getTime();
    }
}

package com.htichina.web.common;

import com.htichina.common.web.Constant;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class B2CUtils {
    public static Logger logger = Logger.getLogger(B2CUtils.class.getName());

    public synchronized static String getPropertyFromFile(String key)
    {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("system.system", locale);
        return rb.getString(key).trim();
    }

    public synchronized static String getPropertyFromFile(String filename, String key)
    {
        ResourceBundle rb = ResourceBundle.getBundle(filename);
        return rb.getString(key).trim();
    }

    public static Timestamp calculateEndDate(Timestamp startDate, int duration, String type) {
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(startDate);
        switch (type.toUpperCase()) {
            case Constant.DB_DATE_TYPE_DAY:
                sCalendar.add(Calendar.DATE, duration);
                break;
            case Constant.DB_DATE_TYPE_MONTH:
                sCalendar.add(Calendar.MONTH, duration);
                break;
            case Constant.DB_DATE_TYPE_YEAR:
                sCalendar.add(Calendar.YEAR, duration);
                break;
        }
        return new Timestamp(sCalendar.getTime().getTime());
    }

    public static boolean isEndDateReached(String endDate) {
        Date now = new Date();
        Date end = null;
        try {
            end = Constant.WEB_DATE_FORMATTER_DEFAULT.parse(endDate);
        } catch(ParseException pe) {
            logger.warn("the end date format is not yyyy-MM-dd HH:mm:ss");
            pe.printStackTrace();
        }
        if(end != null) {
            return now.after(end);
        } else {
            return false;
        }

    }


    public static Timestamp date2Timestamp(Date s) {
        if(s == null) {
            return null;
        } else {
            return new Timestamp(s.getTime());
        }
    }

    public static double string2Double(String s) {
        if(s == null) {
            return 0;
        } else {
            if(s.equals("")) {
                return 0;
            } else {
                return Double.valueOf(s);
            }
        }
    }

    /**
     * convert double to string with format 0.00
     * @param number
     * @return
     */
    public static String formatDouble(double number) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("0.00");
        return df.format(number);
    }

//    public static String formatChineseDate(Timestamp date) {
//        Calendar sCalendar = Calendar.getInstance();
//        sCalendar.setTime(date);
//        int year = sCalendar.get(Calendar.YEAR);
//        int month = sCalendar.get(Calendar.MONTH) + 1;
//        int day = sCalendar.get(Calendar.DATE);
//        return year + "年" + month  + "月" + day + "日";
//    }

    public static boolean string2Boolean(String s) {
        return s != null && !s.equals("") && (s.equalsIgnoreCase("y") || s.equals("1"));
    }

    /**
     * convert payment channel defined in database to the transaction channel that payment interface needed.
     */
    public static String convertPaymentChannel(String paymentChannel) {
        String transactionChannel = null;
        switch (paymentChannel) {
            case Constant.DB_ORDER_PAYMENT_CHANNEL_CALLBACK:
                transactionChannel = Constant.WEB_PAYMENT_INTEGRATION_MODE_CALLBACK;
                break;
            case Constant.DB_ORDER_PAYMENT_CHANNEL_TRANSFER:
                transactionChannel = Constant.WEB_PAYMENT_INTEGRATION_MODE_TRANSFER;
                break;
        }
        return transactionChannel;
    }

    /**
     * parsing orderNo from transactionNo
     * @param orderNo
     * @return
     */
    public static String getTransactionNoByOrderNo(String orderNo) {
        String transactionNo = orderNo.substring(2);
        transactionNo = transactionNo.split("\\|")[0];
        return transactionNo;
    }

    public static String getTxtBatchNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }
}

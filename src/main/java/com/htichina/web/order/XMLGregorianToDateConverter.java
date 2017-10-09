package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by user on 2016/4/6.
 */
public class XMLGregorianToDateConverter {
    public static String xmlDate2Date(XMLGregorianCalendar cal) throws ParseException{
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateType = cal.toGregorianCalendar().getTime();
        String dateTimeString=simpleDateFormat.format(dateType);
        return dateTimeString;
    }

    public static Date String2Date(String str){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date= null;
        try{
            date = simpleDateFormat.parse(str);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return date;

    }

    public static int dateDaysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int stringDaysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d1=sdf.parse("2012/09/08 10:10:10");
        Date d2=sdf.parse("2012/09/15 00:00:00");
        String str="2012/09/08 10:10:10";
        String str1="2015/09/08 10:10:10";
        Date date=new Date();

        System.out.println(stringDaysBetween(str,sdf.format(date)));
    }
}

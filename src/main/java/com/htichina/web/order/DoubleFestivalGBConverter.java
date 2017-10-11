package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="DoubleFestivalGBConverter")
public class DoubleFestivalGBConverter implements Converter {
    public final static String GB = "GB";
    public final static String MB = "MB";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s != null) {
            Double volume = Double.valueOf(s);
            if(volume >= 2000) {
                return removeZero(String.valueOf(volume / 2000)) + GB + "+" + removeZero(String.valueOf(volume / 2000)) + GB;
            } else {
                return removeZero(String.valueOf(volume/2)) + MB + "+" + removeZero(String.valueOf(volume/2)) + MB;
            }
        } else {
            return 0;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                Double volume = Double.valueOf(s);
                if(volume >= 2000) {
                    return removeZero(String.valueOf(volume / 2000)) + GB + "+" + removeZero(String.valueOf(volume / 2000)) + GB;
                } else {
                    return removeZero(String.valueOf(volume/2)) + MB + "+" + removeZero(String.valueOf(volume/2)) + MB;
                }
            }
            if (o instanceof Double) {
                Double s = (Double) o;
                if(s >= 2000) {
                    return removeZero(String.valueOf(s / 2000)) + GB + "+" + removeZero(String.valueOf(s / 2000)) + GB;
                } else {
                    return removeZero(String.valueOf(s/2)) + MB + "+" + removeZero(String.valueOf(s/2)) + MB;
                }
            }
        }

        return "0";
    }

    private String removeZero(String value) {
        if(value.endsWith(".0")) {
            return value.substring(0, value.length() - 2);
        }
        return value;
    }


//    public static void main(String[] args) {
//        Double d = 100.0;
//        System.out.println(removeZero(String.valueOf(d)));
//    }
}


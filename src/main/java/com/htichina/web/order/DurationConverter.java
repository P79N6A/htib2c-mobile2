package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="DurationConverter")
public class DurationConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s != null) {
            Integer duration = Integer.valueOf(s);
            if(duration == 12) {
                return "一年包";
            } else if(duration == 24){
                return "两年包";
            } else if(duration == 36){
                return "三年包";
            } else if(duration == 48){
                return "四年包";
            } else if(duration == 60){
                return "五年包";
            } else {
                return duration + "个月";
            }
        } else {
            return "";
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object s) {
        if(s != null) {
            Integer duration = (Integer) s;
            if(duration == 12) {
                return "一年包";
            } else if(duration == 24){
                return "两年包";
            } else if(duration == 36){
                return "三年包";
            } else if(duration == 48){
                return "四年包";
            } else if(duration == 60){
                return "五年包";
            } else {
                return duration + "个月";
            }
        } else {
            return "";
        }
    }
}


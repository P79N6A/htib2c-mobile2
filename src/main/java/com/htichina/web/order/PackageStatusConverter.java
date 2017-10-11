package com.htichina.web.order;

import com.htichina.common.web.Constant;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="PackageStatusConverter")
public class PackageStatusConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s.equalsIgnoreCase("Active")) {
            return "已开通";
        } else if(s.startsWith("Pending")) {
            return "待开通";
        } else if(s.equalsIgnoreCase("Expired")) {
            return "过期";
        } else if(s.equalsIgnoreCase("Closed") || s.equalsIgnoreCase("Inactive")  || s.equalsIgnoreCase("Cancelled")) {
            return "关闭";
        } else {
            return s;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                if(s.equalsIgnoreCase("Active")) {
                    return "已开通";
                } else if(s.startsWith("Pending")) {
                    return "待开通";
                } else if(s.equalsIgnoreCase("Expired")) {
                    return "过期";
                } else if(s.equalsIgnoreCase("Closed") || s.equalsIgnoreCase("Inactive")  || s.equalsIgnoreCase("Cancelled")) {
                    return "关闭";
                } else {
                    return s;
                }
            } else {
                return o.toString();
            }
        }
        return "";
    }
}


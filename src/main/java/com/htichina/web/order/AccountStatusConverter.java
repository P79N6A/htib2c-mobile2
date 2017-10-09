package com.htichina.web.order;

import com.htichina.common.web.Constant;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="AccountStatusConverter")
public class AccountStatusConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_ACTIVE)) {
            return "有效";
        } else if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_INACTIVE)) {
            return "待续约";
        } else if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_CLOSED)) {
            return "注销";
        } else if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_DECLINED)) {
            return "拒绝服务";
        } else {
            return s;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_ACTIVE)) {
                    return "有效";
                } else if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_INACTIVE)) {
                    return "待续约";
                } else if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_CLOSED)) {
                    return "注销";
                } else if(s.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_DECLINED)) {
                    return "拒绝服务";
                }else {
                    return s;
                }
            } else {
                return o.toString();
            }
        }
        return "";
    }
}


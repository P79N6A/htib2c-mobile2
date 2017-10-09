package com.htichina.web.POC;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@Scope("session")
public class MobileBean implements Serializable {

    private static final long serialVersionUID = -7784214551830400323L;

    public String number;

    public String communicationToken;

    public String primaryContactIndicator;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCommunicationToken() {
        return communicationToken;
    }

    public void setCommunicationToken(String communicationToken) {
        this.communicationToken = communicationToken;
    }

    public String getPrimaryContactIndicator() {
        return primaryContactIndicator;
    }

    public void setPrimaryContactIndicator(String primaryContactIndicator) {
        this.primaryContactIndicator = primaryContactIndicator;
    }
}

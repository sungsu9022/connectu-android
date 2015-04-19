package com.connectu.login.model;

/**
 * Created by Bono on 2015-04-19.
 */
public class LoginModel {
    private String identfication;
    private String password;

    public String getPassword(){
        return this.password;
    }

    public void setIdentfication(String identification){
        this.identfication = identification;
    }

    public String getIdentfication(){
        return this.identfication;
    }

    public void setPassword(String password){
        this.password = password;
    }



}

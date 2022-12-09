package com.example.ccmsreportes.model.Usuario;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginProfesor {

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("pass")
    @Expose
    private String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LoginProfesor withUser(String user) {
        this.user = user;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LoginProfesor withPass(String pass) {
        this.pass = pass;
        return this;
    }
}

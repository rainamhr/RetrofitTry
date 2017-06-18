package com.example.cksya.retrofittry.Response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cksya on 6/10/17.
 */

public class Phone {
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("home")
    private String home;
    @SerializedName("office")
    private String office;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}

package com.example.wamanahyaha;

public class loginmanagerclass {
    private String PASS;
    private String USEREMAIL;

    public loginmanagerclass(String USEREMAIL, String PASS) {
        this.USEREMAIL = USEREMAIL;
        this.PASS = PASS;
    }

    public String getUSEREMAIL() {
        return USEREMAIL;
    }

    public void setUSEREMAIL(String USEREMAIL) {
        this.USEREMAIL = USEREMAIL;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }




}

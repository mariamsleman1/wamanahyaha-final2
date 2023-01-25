package com.example.wamanahyaha;

import android.widget.ImageView;

import java.util.List;

public class personaldetailspenefactor {
    private String EMAILS;
    private String PHONENUM;
    private String LIVING;




    public String getPHONENUM() {
        return PHONENUM;
    }



    public String getEMAILS() {
        return EMAILS;
    }
    public String getLIVING() {
        return LIVING;
    }



    public  personaldetailspenefactor(String EMAILS, String PHONENUM, String LIVING) {
        this.EMAILS=EMAILS;
        this.PHONENUM=PHONENUM;
        this.LIVING=LIVING;

    }


    public void setEMAILS(String EMAILS) {
        this.EMAILS = EMAILS;
    }

    public void setPHONENUM(String PHONENUM) {
        this.PHONENUM = PHONENUM;
    }

    public void setLIVING(String LIVING) {
        this.LIVING = LIVING;
    }



}

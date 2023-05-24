package com.example.wamanahyaha.classes;

import android.widget.ImageView;

import java.util.List;

public class personaldetailspenefactor {
    private String EMAILS;
    private String PHONENUM;





    public String getPHONENUM() {
        return PHONENUM;
    }



    public String getEMAILS() {
        return EMAILS;
    }




    public  personaldetailspenefactor(String EMAILS, String PHONENUM) {
        this.EMAILS=EMAILS;
        this.PHONENUM=PHONENUM;


    }


    public void setEMAILS(String EMAILS) {
        this.EMAILS = EMAILS;
    }

    public void setPHONENUM(String PHONENUM) {
        this.PHONENUM = PHONENUM;
    }





}

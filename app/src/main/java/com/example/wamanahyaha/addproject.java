package com.example.wamanahyaha;

import android.widget.ImageView;

public class addproject {

    private ImageView projectimage;
    private String projectname;
    private String projectdetails;


    public addproject(ImageView projectimage, String projectname, String projectdetails) {
        this.projectimage = projectimage;
        this.projectname = projectname;
        this.projectdetails = projectdetails;
    }


    public ImageView getProjectimage() {
        return projectimage;
    }

    public void setProjectimage(ImageView projectimage) {
        this.projectimage = projectimage;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdetails() {
        return projectdetails;
    }

    public void setProjectdetails(String projectdetails) {
        this.projectdetails = projectdetails;
    }

}

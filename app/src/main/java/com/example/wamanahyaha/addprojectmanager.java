package com.example.wamanahyaha;

import android.widget.ImageView;

public class addprojectmanager {
    private ImageView addprojectimage;
    private String projectname;
    private String projectdeatails;
    private String dateofproject;

    public ImageView getAddprojectimage() {
        return addprojectimage;
    }

    public void setAddprojectimage(ImageView addprojectimage) {
        this.addprojectimage = addprojectimage;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdeatails() {
        return projectdeatails;
    }

    public void setProjectdeatails(String projectdeatails) {
        this.projectdeatails = projectdeatails;
    }

    public String getDateofproject() {
        return dateofproject;
    }

    public void setDateofproject(String dateofproject) {
        this.dateofproject = dateofproject;
    }

    public addprojectmanager(ImageView addprojectimage, String projectname, String projectdeatails, String dateofproject) {
        this.addprojectimage = addprojectimage;
        this.projectname = projectname;
        this.projectdeatails = projectdeatails;
        this.dateofproject = dateofproject;
    }
}

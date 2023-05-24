package com.example.wamanahyaha.classes;

import android.widget.ImageView;

public class addprojectmanager {

    private String projectname;
    private String projectdeatails;
    private String dateofproject;




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

    public addprojectmanager(String projectname, String projectdeatails, String dateofproject) {
        this.projectname = projectname;
        this.projectdeatails = projectdeatails;
        this.dateofproject = dateofproject;
    }

}

package com.example.wamanahyaha.fragments;

public class projectdatA {
   private String projectname;
    private String 	projectdeatails;

    public projectdatA() {
    }

    public projectdatA(String projectname, String projectdeatails) {
        this.projectname = projectname;
        this.projectdeatails = projectdeatails;
    }

    public String getNameproject() {

        return projectname;
    }

    public void setNameproject(String nameproject) {

        this.projectname = nameproject;
    }

    public String getDetailsproject() {

        return 	projectdeatails;
    }

    public void setDetailsproject(String detailsproject) {
        this.projectdeatails = detailsproject;
    }




}

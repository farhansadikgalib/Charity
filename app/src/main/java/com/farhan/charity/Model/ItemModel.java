package com.farhan.charity.Model;

public class ItemModel {

    private int profileImg;
    private String applicantName;
    private String appliedfor;
    private String amount;


    public ItemModel(int profileImg, String applicantName, String appliedfor, String amount) {
        this.profileImg = profileImg;
        this.applicantName = applicantName;
        this.appliedfor = appliedfor;
        this.amount = amount;
    }


    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getAppliedfor() {
        return appliedfor;
    }

    public void setAppliedfor(String appliedfor) {
        this.appliedfor = appliedfor;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
package com.farhan.charity.Model;

public class ItemModel {

    private  String users_name_bn;
    private  String application_amount;
    private String application_title_bn;
    private String users_image;


    public ItemModel(String users_name_bn, String application_amount, String application_title_bn, String users_image) {
        this.users_name_bn = users_name_bn;
        this.application_amount = application_amount;
        this.application_title_bn = application_title_bn;
        this.users_image = users_image;
    }


    public String getUsers_name_bn() {
        return users_name_bn;
    }

    public void setUsers_name_bn(String users_name_bn) {
        this.users_name_bn = users_name_bn;
    }

    public String getApplication_amount() {
        return application_amount;
    }

    public void setApplication_amount(String application_amount) {
        this.application_amount = application_amount;
    }

    public String getApplication_title_bn() {
        return application_title_bn;
    }

    public void setApplication_title_bn(String application_title_bn) {
        this.application_title_bn = application_title_bn;
    }

    public String getUsers_image() {
        return users_image;
    }

    public void setUsers_image(String users_image) {
        this.users_image = users_image;
    }
}
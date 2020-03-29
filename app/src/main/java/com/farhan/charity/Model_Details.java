package com.farhan.charity;

public class Model_Details {

    private  String users_name_bn;
    private  String application_amount;
    private String application_title_bn;
    private String users_image;
    private  String application_id;
    private  String application_status;

    public Model_Details() {
    }

    public Model_Details(String users_name_bn, String application_amount, String application_title_bn, String users_image, String application_id, String application_status) {
        this.users_name_bn = users_name_bn;
        this.application_amount = application_amount;
        this.application_title_bn = application_title_bn;
        this.users_image = users_image;
        this.application_id = application_id;
        this.application_status = application_status;
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

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getApplication_status() {
        return application_status;
    }

    public void setApplication_status(String application_status) {
        this.application_status = application_status;
    }
}

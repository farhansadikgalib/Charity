package com.farhan.charity.DashbordAdapter;

public class DataModel {

    String Name,Number;
    int Image;

    public DataModel() {
    }

    public DataModel(String name, String number, int image) {
        Name = name;
        Number = number;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

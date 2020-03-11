package com.farhan.charity.Model;

import androidx.annotation.NonNull;

public class AllitemsModel {

    private String name;


    public AllitemsModel() {
    }


    public AllitemsModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

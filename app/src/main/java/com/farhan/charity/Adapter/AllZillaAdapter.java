package com.farhan.charity.Adapter;

import androidx.annotation.NonNull;

public class AllZillaAdapter {
    private String name;

    public AllZillaAdapter(String name) {
        this.name = name;
    }

    public AllZillaAdapter() {
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

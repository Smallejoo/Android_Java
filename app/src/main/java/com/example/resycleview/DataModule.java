package com.example.resycleview;

import java.util.List;

public class DataModule {
   private String Name;
    private String Description;
    private int Image;




    public DataModule(String name,String description,int image)
    {
        this.Name=name;
        this.Description=description;
        this.Image=image;
    }
    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public int getImage() {
        return Image;
    }
}

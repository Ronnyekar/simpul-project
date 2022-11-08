package com.example.todolistapp;

public class menu_model {
    String Title ;
    String Description;
    int Icon;

    public menu_model(String Title, String Description, int Icon){
        this.Title = Title;
        this.Description = Description;
        this.Icon = Icon;
    }

    public menu_model(String Title){
        this.Title = Title;
    }

    public String getTitle(){
        return this.Title;
    }

    public String getDescription(){ return this.Description;  }

    public int getIcon(){
        return this.Icon;
    }
}
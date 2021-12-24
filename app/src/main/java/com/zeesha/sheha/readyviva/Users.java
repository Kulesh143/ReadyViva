package com.zeesha.sheha.readyviva;

import java.util.ArrayList;

public class Users {
    private static ArrayList<Users> user_list=new ArrayList<>();
    private String id;
    private String name;
    private String marks;
    public Users(){

    }

    public Users(String id, String name, String marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public static ArrayList<Users> getUser_list() {
        return user_list;
    }

    public static void setUserArrayList(Users p) {
        Users.user_list.add(p);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}

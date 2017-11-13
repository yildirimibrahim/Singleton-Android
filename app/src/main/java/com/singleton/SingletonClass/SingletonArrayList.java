package com.singleton.SingletonClass;

import com.singleton.model.User;

import java.util.ArrayList;

/**
 * Created by ibrahim yildirim on 13/11/2017.
 */


public class SingletonArrayList {

    private ArrayList<User> arrayListUser;
    private static SingletonArrayList mInstance = null;

    private SingletonArrayList(){
        arrayListUser = new ArrayList<>();
        User user = new User();
        user.setUserId(1);
        user.setUserName("ibrahim yıldırım");
        arrayListUser.add(user);
       // setArrayListUser(arrayListUser);
    }

    public static SingletonArrayList getInstance(){
        if(mInstance == null)
        {
            mInstance = new SingletonArrayList();
        }
        return mInstance;
    }

    public void setArrayListUser(ArrayList<User> arrayListUser) {
        this.arrayListUser = arrayListUser;
    }

    public ArrayList<User> getArrayListUser() {
        return arrayListUser;
    }
}
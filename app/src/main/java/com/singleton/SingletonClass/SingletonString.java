package com.singleton.SingletonClass;

/**
 * Created by ibrahim yildirim on 13/11/2017.
 */

public class SingletonString {
    private static SingletonString mInstance = null;

    private String mString;

    private SingletonString(){
        mString = "Merhaba SingletonString";
    }

    public static SingletonString getInstance(){
        if(mInstance == null)
        {
            mInstance = new SingletonString();
        }
        return mInstance;
    }

    public String getString(){
        return this.mString;
    }

    public void setString(String value){
        mString = value;
    }
}

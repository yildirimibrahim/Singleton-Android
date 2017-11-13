package com.singleton.SingletonClass;

import java.util.Random;

/**
 * Created by ibrahim yildirim on 10/11/2017.
 */

public class SingletonNumber {
    private static SingletonNumber mInstance = null;

    public int value;
    int min = 65;
    int max = 80;

    private SingletonNumber(){
        value = 100;
    }

    public static SingletonNumber getInstance(){
        if(mInstance == null)
        {
            mInstance = new SingletonNumber();
        }
        return mInstance;
    }

    public int getValue() {
        Random r = new Random();
        value = r.nextInt(max - min + 1) + min;

        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

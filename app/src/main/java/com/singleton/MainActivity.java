package com.singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.singleton.SingletonClass.AppSharedPreferences;
import com.singleton.SingletonClass.SingletonArrayList;
import com.singleton.SingletonClass.SingletonNumber;
import com.singleton.SingletonClass.SingletonString;
import com.singleton.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvRandomValue ;
    TextView tvSingletonValue;
    TextView tvSharedPreferencesValue;
    TextView tvArrayListValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //random
        tvRandomValue = (TextView)findViewById(R.id.tvRandomValue);
        tvRandomValue.setText("Random Value :" + SingletonNumber.getInstance().getValue());

        //SingletonString
        tvSingletonValue = (TextView)findViewById(R.id.tvSingletonValue);
        tvSingletonValue.setText(SingletonString.getInstance().getString());

        //shared preferences
        tvSharedPreferencesValue = (TextView)findViewById(R.id.tvSharedPreferencesValue);
        if(AppSharedPreferences.with(MainActivity.this).getPreferenceLoad())
            setText(tvSharedPreferencesValue,true);
        else
            setText(tvSharedPreferencesValue,false);

        //array list
        tvArrayListValue = (TextView)findViewById(R.id.tvArrayListValue);
        tvArrayListValue.setText("user id: " +SingletonArrayList.getInstance().getArrayListUser().get(0).getUserId() +
         "\nuser name :" +SingletonArrayList.getInstance().getArrayListUser().get(0).getUserName());
    }

    public void onClickRandomButton(View view) {
        SingletonNumber.getInstance().setValue(1500);
        tvRandomValue.setText("Random Value :" + SingletonNumber.getInstance().getValue());
    }

    public void onClickSingletonButton(View view) {
        SingletonString.getInstance().setString("Click Button Singleton String");
        tvSingletonValue.setText(SingletonString.getInstance().getString());
    }

    public void onClickSharePreferencesButton(View view) {
        AppSharedPreferences.with(MainActivity.this).setPreferenceLoad(true);

        if(AppSharedPreferences.with(MainActivity.this).getPreferenceLoad())
            setText(tvSharedPreferencesValue,true);
        else
            setText(tvSharedPreferencesValue,false);
    }

    private void setText(TextView textView, boolean isShared){
        textView.setText("Shared Pref:" +isShared);
    }
    ArrayList<User> arrayListUser;
    User user;
    int i;
    public void onClickArrayListButton(View view) {
        i++;
        arrayListUser = new ArrayList<>();
        user = new User();
        user.setUserId(i);
        user.setUserName("Test onClick "+i);
        arrayListUser.add(user);
        SingletonArrayList.getInstance().setArrayListUser(arrayListUser);

        tvArrayListValue = (TextView)findViewById(R.id.tvArrayListValue);
        tvArrayListValue.setText("user id: " +SingletonArrayList.getInstance().getArrayListUser().get(0).getUserId() +
                "\nuser name :" +SingletonArrayList.getInstance().getArrayListUser().get(0).getUserName());
    }
}

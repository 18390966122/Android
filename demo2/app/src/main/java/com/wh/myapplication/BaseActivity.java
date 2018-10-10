package com.wh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
 * 创建者 曹晓丽
 * 创建时间 2018/10/8 14:13
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
    }
}

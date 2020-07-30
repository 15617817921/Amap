package com.example.mp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mp.utils.IntentUtil;

public class HomeAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void bt1(View view) {
        IntentUtil.go(this, MainActivity.class);
    }

    public void bt2(View view) {
        IntentUtil.go(this, MainActivity2.class);
    }
}
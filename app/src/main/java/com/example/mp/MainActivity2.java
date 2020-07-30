package com.example.mp;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mp.utils.LocationUtils;
/**
 * 调用一次
 * */
public class MainActivity2 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocationUtils.register(0, 0, new LocationUtils.OnLocationChangeListener() {
            @Override
            public void getLastKnownLocation(Location location) {
                LogUtils.E(location.getLongitude() + "---" + location.getLatitude());
//                tv.setText(location.getLongitude() + "---" + location.getLatitude());
            }

            @Override
            public void onLocationChanged(Location location) {
                LogUtils.E(location.getLongitude() + "---onLocationChanged"+ location.getLatitude() );
                tv.setText(location.getLongitude() + "---" + location.getLatitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                LogUtils.E("onStatusChanged"+provider+"\n"+status+"\n"+extras.toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocationUtils.unregister();
    }
}
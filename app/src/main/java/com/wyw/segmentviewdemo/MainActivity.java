package com.wyw.segmentviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SegmentView segementView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        segementView = findViewById(R.id.sv_segementView);
        segementView.setTitles(new String[]{"三连绝杀","四凡超绝","五世连杀"});
    }
}

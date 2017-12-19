package com.wyw.segmentviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SegmentView.onSegmentViewClickListener {

    private SegmentView segementView;
    private String[] titles = new String[]{"一血", "双杀", "三杀", "超神", "五杀" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        segementView = findViewById(R.id.sv_segementView);
        segementView.setTitles(titles);
        segementView.setOnSegmentViewClickListener(this);
    }



    @Override
    public void onSegmentViewClick(View view, int postion) {
        Toast.makeText(this, titles[postion], Toast.LENGTH_SHORT).show();
    }
}

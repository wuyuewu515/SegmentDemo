package com.wyw.segmentviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.List;

/**
 * 项目名称：SegmentViewDemo
 * 类描述：仿照ios通知栏切换
 * 创建人：伍跃武
 * 创建时间：2017/12/15 17:19
 */
public class SegmentView extends RadioGroup implements RadioGroup.OnCheckedChangeListener {
    public SegmentView(Context context) {
        this(context, null);
    }

    public SegmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setOrientation(LinearLayout.HORIZONTAL); //设置横向排列

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}

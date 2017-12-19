package com.wyw.segmentviewdemo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * 项目名称：SegmentViewDemo
 * 类描述：仿照ios通知栏切换
 * 创建人：伍跃武
 * 创建时间：2017/12/15 17:19
 */
public class SegmentView extends RadioGroup implements RadioGroup.OnCheckedChangeListener {
    private static int DEFAULT_NUM = 0;
    private static int START_ID = R.id.segmentview_id_start;
    private Context mContext;
    private Drawable line = getResources().getDrawable(R.mipmap.line);
    private int number; //选择框的数目
    private int textSize = 16; //字体大小
    private RadioButton radioButtons[];
    private String titles[];

    public SegmentView(Context context) {
        this(context, null);
    }

    public SegmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setOrientation(LinearLayout.HORIZONTAL); //设置横向排列
        line.setBounds(0, 0, 1, line.getMinimumHeight()); //设置分割线
        if (null != attrs) {
            TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.SegmentView);
            number = typedArray.getInt(R.styleable.SegmentView_sv_number, DEFAULT_NUM);
            textSize = typedArray.getInt(R.styleable.SegmentView_text_size, 16);
            initTextView(number);
            typedArray.recycle();
        }


    }

    private void initTextView(int number) {
        if (number <= 0)
            return;

        setBackgroundResource(R.drawable.shape_guide_corner20_gray);
        radioButtons = new RadioButton[number];
        titles = new String[number];

        //不同状态下的按钮显示不同的颜色
        ColorStateList csl = getResources().getColorStateList(R.color.selector_segment_color_tab);
        RadioButton radioButton;
        //实现中间部分的textview，两边都是圆角
        for (int i = 0; i < number; i++) {
            radioButton = new RadioButton(mContext);
            radioButton.setId(START_ID + i);
            // 设置textview的布局宽高并设置为weight属性都为1
            radioButton.setLayoutParams(new LayoutParams(dip2px(mContext, 90),
                    LayoutParams.MATCH_PARENT, 1));

            radioButton.setBackgroundResource(R.drawable.selector_tv_corner20_guid);
            radioButton.setCompoundDrawables(null, null, line, null);
            radioButton.setTextColor(csl);
            radioButton.setText(titles[i]);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setPadding(0, 12, 0, 12);
            radioButton.setButtonDrawable(null);
            setSegmentTextSize(radioButton, textSize);
            radioButtons[i] = radioButton;
        }
        //处理最后一个radiobutton，去掉右边的线
        radioButtons[number - 1].setCompoundDrawables(null, null, null, null);
        // 加入textview
        this.removeAllViews();
        for (RadioButton rb : radioButtons) {
            this.addView(rb);
        }
        this.invalidate();//重新draw()

        //有时候会出现点击了一次，再点击其他的时候总是会出现两个
        if (number > 1) {
            radioButtons[1].setChecked(true);
        }
        radioButtons[0].setChecked(true);

    }

    /**
     * 设置字体大小
     *
     * @param dp
     */
    private void setSegmentTextSize(RadioButton radioButton, int dp) {
        radioButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);
        radioButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    //设置选择器的标题
    public void setTitles(String[] titles) {
        this.titles = titles;
        number = titles.length;
        initTextView(number);
        for (int i = 0; i < titles.length; i++) {
            radioButtons[i].setText(titles[i]);
        }
        invalidate();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

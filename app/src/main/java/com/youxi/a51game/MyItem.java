package com.youxi.a51game;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by liusong on 2016/7/11.
 * 自定义布局显示下面图片加文字。
 */
public class MyItem extends RelativeLayout{
    private ImageView iv;
    private TextView tv;
    public MyItem(Context context) {
        this(context,null);
    }

    public MyItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        //导入布局
        LayoutInflater.from(context).inflate(R.layout.my_item,this,true);
        iv= (ImageView) findViewById(R.id.iv);
        tv= (TextView) findViewById(R.id.tv);

    }

    /**
     * 设置图片资源
     */
    public void setIv(int ivs) {
        iv.setImageResource(ivs);
    }

    /**
     * 设置文字
     */
    public void setTv(int tvs){
        tv.setText(tvs);
    }
    /**
     * 设置字体颜色
     */
    public void setTextColor(int cols){
        tv.setTextColor(cols);
    }
}

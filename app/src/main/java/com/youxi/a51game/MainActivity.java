package com.youxi.a51game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.youxi.fagment.DiscoverFragment;
import com.youxi.fagment.FriendFragment;
import com.youxi.fagment.MyFragment;
import com.youxi.fagment.NewsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MyItem first,second,third,fourth;
    private Fragment friend,discover,news,my,current;
    private FragmentManager fm;
    private MyItem[] myItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mylayout);
        init();

        //fragment管理
        fm=getSupportFragmentManager();
        news=new NewsFragment();
        discover=new DiscoverFragment();
        my=new MyFragment();
        if (friend==null){
            friend=new FriendFragment();
        }
        if (!friend.isAdded()) {
            fm.beginTransaction().add(R.id.frag, friend).commit();
            current = friend;
        }
//        第一次加载news时不会显示news的布局
//        如果将news改为当前的friend，friend不会隐藏。
//        current=news;
//        addOrShowFragment(friend);

        //为了设置字体颜色
        myItem=new MyItem[]{first,second,third,fourth};



    }

    //设置字体颜色
    private void setMyItemColor(MyItem my){
        for(MyItem item: myItem ){
            if(item==my){
                item.setTextColor(ContextCompat.getColor(this,R.color.text_blue));
            }else{
                item.setTextColor(ContextCompat.getColor(this,R.color.text_gray));
            }
        }
    }

    //装载fragment
    private void addOrShowFragment(Fragment showFragment){
        //判断是否添加到布局中
        if (!showFragment.isAdded()) {
            fm.beginTransaction().add(R.id.frag,showFragment).hide(current).commit();
        }else{
            fm.beginTransaction().hide(current).show(showFragment).commit();
        }
        current=showFragment;

    }


    //初始化
    private void init(){
        first= (MyItem) findViewById(R.id.first);
        first.setIv(R.drawable.fo_icon_friend_pressed);
        first.setTv(R.string.tab_menu_friend);
        //新版本设置字体颜色
        first.setTextColor(ContextCompat.getColor(this,R.color.text_blue));
        first.setOnClickListener(this);

        second= (MyItem) findViewById(R.id.second);
        second.setIv(R.drawable.fo_icon_news);
        second.setTv(R.string.tab_menu_news);
        second.setOnClickListener(this);

        third= (MyItem) findViewById(R.id.third);
        third.setIv(R.drawable.fo_icon_dis);
        third.setTv(R.string.tab_menu_discover);
        third.setOnClickListener(this);

        fourth= (MyItem) findViewById(R.id.fourth);
        fourth.setIv(R.drawable.fo_icon_my);
        fourth.setTv(R.string.tab_menu_my);
        fourth.setOnClickListener(this);
    }


    //监听事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first:
                addOrShowFragment(friend);
                first.setIv(R.drawable.fo_icon_friend_pressed);
                second.setIv(R.drawable.fo_icon_news);
                third.setIv(R.drawable.fo_icon_dis);
                fourth.setIv(R.drawable.fo_icon_my);
                setMyItemColor(first);
                break;
            case R.id.second:
                addOrShowFragment(news);
                setMyItemColor(second);
                first.setIv(R.drawable.fo_icon_friend);
                second.setIv(R.drawable.fo_icon_news_pressed);
                third.setIv(R.drawable.fo_icon_dis);
                fourth.setIv(R.drawable.fo_icon_my);

                break;
            case R.id.third:
                addOrShowFragment(discover);
                setMyItemColor(third);
                first.setIv(R.drawable.fo_icon_friend);
                second.setIv(R.drawable.fo_icon_news);
                third.setIv(R.drawable.fo_icon_dis_pressed);
                fourth.setIv(R.drawable.fo_icon_my);
                break;
            case R.id.fourth:
                addOrShowFragment(my);
                setMyItemColor(fourth);
                first.setIv(R.drawable.fo_icon_friend);
                second.setIv(R.drawable.fo_icon_news);
                third.setIv(R.drawable.fo_icon_dis);
                fourth.setIv(R.drawable.fo_icon_my_pressed);
                break;

        }

    }
}

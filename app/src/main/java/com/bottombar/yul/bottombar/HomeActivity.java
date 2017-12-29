package com.bottombar.yul.bottombar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bottombar.yul.bottombar.fragment.HomeFragment;
import com.bottombar.yul.bottombar.fragment.MyAdapter;
import com.bottombar.yul.bottombar.utils.AndyUtils;
import com.bottombar.yul.bottombar.view.NoScrollViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: HomeActivity
 * Author: yul
 * Describe: //TODO
 * Date: 2017-12-28 15:45
 **/

public class HomeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private NoScrollViewPager mViewPage;
    private RadioButton mItemBtn1;
    private RadioButton mItemBtn2;
    private RadioButton mItemBtn3;
    private RadioButton mItemBtn4;
    private RadioButton mItemBtn5;
    private RadioGroup mRadioGroup;
    private int width;
    private boolean noScroll,loadFrom;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initParams();


    }



    private void initView() {
        mViewPage = (NoScrollViewPager) findViewById(R.id.view_page);
        mItemBtn1 = (RadioButton) findViewById(R.id.item_btn_1);
        mItemBtn2 = (RadioButton) findViewById(R.id.item_btn_2);
        mItemBtn3 = (RadioButton) findViewById(R.id.item_btn_3);
        mItemBtn4 = (RadioButton) findViewById(R.id.item_btn_4);
        mItemBtn5 = (RadioButton) findViewById(R.id.item_btn_5);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
    }


    private void initParams() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) mItemBtn1.getLayoutParams();
        //获取当前控件的布局对象
        params.width=width/5;
        mItemBtn1.setLayoutParams(params);
        mItemBtn2.setLayoutParams(params);
        mItemBtn4.setLayoutParams(params);
        mItemBtn5.setLayoutParams(params);
        LinearLayout.LayoutParams params3= (LinearLayout.LayoutParams) mItemBtn3.getLayoutParams();
        //获取当前控件的布局对象
        params3.width=width/5;
        mItemBtn3.setLayoutParams(params3);

        initBtn(mItemBtn1,R.mipmap.comui_tab_home_selected,R.mipmap.comui_tab_home_clicked,false);
        initBtn(mItemBtn2,R.mipmap.comui_tab_pond_selected,R.mipmap.comui_tab_pond,false);
        initBtn(mItemBtn4,R.mipmap.comui_tab_message_selected,R.mipmap.comui_tab_message_clicked,false);
        initBtn(mItemBtn5,R.mipmap.comui_tab_person_selected,R.mipmap.comui_tab_person_clicked,false);
        mItemBtn1.setChecked(true);




        //构造适配器
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(HomeFragment.getInstens("闲鱼"));
        fragments.add(HomeFragment.getInstens("鱼塘"));
        fragments.add(HomeFragment.getInstens("消息"));
        fragments.add(HomeFragment.getInstens("我的"));

        mViewPage.setAdapter(new MyAdapter(getSupportFragmentManager(),fragments));
        mViewPage.setCurrentItem(0);
        mViewPage.addOnPageChangeListener(this);
        ((TextView) findViewById(R.id.net_txt)).setText("加载"+(loadFrom?"网络":"本地")+"图片");
        ((TextView) findViewById(R.id.control)).setText("控制ViewPage"+(noScroll?"不":"")+"滑动");


        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioGroup.check(i);

                switch (i) {
                    case R.id.item_btn_1:
                        mViewPage.setCurrentItem(0,true);
                        break;
                    case R.id.item_btn_2:
                        mViewPage.setCurrentItem(1,true);
                        break;
                    case R.id.item_btn_4:
                        mViewPage.setCurrentItem(2,true);
                        break;
                    case R.id.item_btn_5:
                        mViewPage.setCurrentItem(3,true);
                        break;

                }
            }
        });


    }


    private void initBtn(RadioButton btn,int checked,int unchecked ,boolean loadFrom) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_checked},
                getApplicationContext().getResources().getDrawable(checked));
        drawable.addState(new int[]{ - android.R.attr.state_checked},
                getApplicationContext().getResources().getDrawable(unchecked));

        // 生成的Selector 添加到RadioButton 上面
        if (loadFrom) {
            drawable.setBounds(0, 0, AndyUtils.dipToPx(getApplicationContext(), 20), AndyUtils.dipToPx(getApplicationContext(), 20));
        }else {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        btn.setCompoundDrawables(null,drawable,null,null);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mRadioGroup.check(R.id.item_btn_1);
                break;
            case 1:
                mRadioGroup.check(R.id.item_btn_2);
                break;
            case 2:
                mRadioGroup.check(R.id.item_btn_4);
                break;
            case 3:
                mRadioGroup.check(R.id.item_btn_5);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void control(View view) {
        noScroll=!noScroll;
        mViewPage.setNoScroll(noScroll);
        ((TextView) findViewById(R.id.control)).setText("控制ViewPage"+(noScroll?"不":"")+"滑动");
    }

    public void load(View view) {
        loadFrom=!loadFrom;
        ((TextView) findViewById(R.id.net_txt)).setText("加载"+(loadFrom?"网络":"本地")+"图片");
        if (loadFrom){
            String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514539276100&di=96390d57d21826ce17a4c4587b40cef3&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140522%2F0022005746708204_b.jpg";
             String url2="http://img.lanrentuku.com/img/allimg/1506/5-15062FZ937-50.gif";
             String url3="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514539276096&di=9104b99f81bd9dc1c3635ff68a3938bf&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F43%2F74%2F22r58PICw9V_1024.png";
            Glide.with(getApplicationContext()).load(url2).into((ImageView) this.findViewById(R.id.image_view));


            initNetBtn(mItemBtn1,url,url,true);
            initNetBtn(mItemBtn2,url,url,true);
            initNetBtn(mItemBtn3,url3,url3,false);
            initNetBtn(mItemBtn4,url,url,true);
            initNetBtn(mItemBtn5,url,url,true);

        }else {//本地
            initBtn(mItemBtn1,R.mipmap.comui_tab_home_selected,R.mipmap.comui_tab_home_clicked,true);
            initBtn(mItemBtn2,R.mipmap.comui_tab_pond_selected,R.mipmap.comui_tab_pond,true);
            initBtn(mItemBtn3,R.mipmap.comui_tab_post,R.mipmap.comui_tab_post,false);
            initBtn(mItemBtn4,R.mipmap.comui_tab_message_selected,R.mipmap.comui_tab_message_clicked,true);
            initBtn(mItemBtn5,R.mipmap.comui_tab_person_selected,R.mipmap.comui_tab_person_clicked,true);
        }

    }



    public void centerClick(View view) {


    }


    private void initNetBtn(final RadioButton btn, String comui_tab_home_selected, String comui_tab_home_clicked, final boolean loadFrom) {

        Glide.with(this).load(comui_tab_home_selected).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                StateListDrawable drawable = new StateListDrawable();
                drawable.addState(new int[]{android.R.attr.state_checked},
                        resource);
                drawable.addState(new int[]{ - android.R.attr.state_checked},
                        resource);
                if (loadFrom) {

                    drawable.setBounds(0, 0, AndyUtils.dipToPx(getApplicationContext(), 20), AndyUtils.dipToPx(getApplicationContext(), 20));
                }else {
                    drawable.setBounds(0, 0,90 , 90);
                }

                btn.setCompoundDrawables(null,drawable,null,null);
            }
        });
    }


}

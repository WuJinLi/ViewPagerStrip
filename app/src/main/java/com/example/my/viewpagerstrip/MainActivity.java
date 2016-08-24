package com.example.my.viewpagerstrip;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager_main;
    private PagerTabStrip pagerTabStrip_main;
    private List<Fragment> list = new ArrayList<>();
    private String[] title;
    private FPGAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //调用初始化UI控件的方法
        initView();
        //调用初始化数据的方法
        initData();
    }

    //初始化数据
    private void initData() {
        //获取字符数组
        title = getResources().getStringArray(R.array.arrTabTitles);
        //初始化数据源
        for (int i = 0; i < title.length; i++) {
            DummaryFragment dummaryFragment = DummaryFragment.newInstance(i);
            list.add(dummaryFragment);
        }
        //初始化适配器
        adapter = new FPGAdapter(getSupportFragmentManager(), list, title);
        //viewpager设置适配器
        viewPager_main.setAdapter(adapter);
    }

    //初始化UI控件
    private void initView() {
        viewPager_main = (ViewPager) findViewById(R.id.viewPager_main);
        pagerTabStrip_main = (PagerTabStrip) findViewById(R.id.pagerTabStrip_main);

    }
}

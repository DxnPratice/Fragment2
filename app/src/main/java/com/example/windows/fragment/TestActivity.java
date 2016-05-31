package com.example.windows.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
//设置活动没有actionBar
// 布局文件中只有TabLayout和ViewPager

    TabLayout tabLayout1;
    ViewPager viewPagerTest;
    TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        viewPagerTest = (ViewPager) findViewById(R.id.viewPagerTest);
        tabAdapter =new TabAdapter(getSupportFragmentManager());
        viewPagerTest.setAdapter(tabAdapter);

        tabLayout1 = (TabLayout) findViewById(R.id.tabLayout1);
        // TabLayout和ViewPager双向、交互联动。
        tabLayout1.setupWithViewPager(viewPagerTest);
//        //滚动模式
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置下面线条的高度
//        tabLayout.setSelectedTabIndicatorHeight(8);
//        //设置线条的颜色
//        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);

        tabLayout1.addTab(tabLayout1.newTab().setText("娱乐"));
        tabLayout1.addTab(tabLayout1.newTab().setText("体育"));
        tabLayout1.addTab(tabLayout1.newTab().setText("军事"));


    }
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next,menu);
        return super.onCreateOptionsMenu(menu);
    }
    class TabAdapter extends FragmentPagerAdapter {


        List<Fragment> fragmentList =new ArrayList<>();
        String[] title ={"新闻","游戏","科技"};

        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new NewsFragment());
            fragmentList.add(new GameFragment());
            fragmentList.add(new TechFragment());
        }

    @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}

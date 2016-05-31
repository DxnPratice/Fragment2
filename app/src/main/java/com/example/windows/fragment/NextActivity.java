package com.example.windows.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 *1,使用单纯的TabLayout和ViewPager的时候，布局文件应该设置为线性布局，不然TabLayout中添加的标签无法显示出来
 1.1，设置活动无ACTIONBAR的时候，就会直接显示TabLayout和ViewPager的Fragment
 （参考TestActivity和它的布局文件)
 1.2,设置活动有ACTIONBAR的时候，就显示ACTIONBAR和TabLayout和ViewPager的Fragment，即使设置ACTIONBAR的背景色和TabLayout的背景色一致，中间还是会显示一条阴影线
 （参考TestActivity和它的布局文件)
 1.3.所以很多时候用TOOLBAR代替ACTIONBAR；（参考NextActivity和它的布局文件）
 2,几个布局文件中的各个组件的属性参考NextActivity的注释；
 *
 *
 *
 *
 *
 *
 *
 * 明确这个类的清单文件里面设置没有actionBar,然后在类中用toolbar代替actionBar,
 * 在该类的xml文件中，在toolbar里面放了textView和菜单选项
 * 在toolbar下面放了TabsLayout 和ViewPager
 *  tabLayout.setupWithViewPager(viewPagerNext); TabLayout和ViewPager双向、交互联动。
 * 之所以用toolbar代替actionBar,因为即使actionBar的背景色和页面下部分的背景色设置一样，还是会产生阴影，导致上下之间会产生一条阴影线
 * 而toolbar则不会，通过设置它的背景色和下面的背景色一致，不会产生阴影线条
 * xml文件
 *   <android.support.design.widget.AppBarLayout
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:background="@color/colorPrimary"//设置这个布局中的背景色
 android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">//设置AppBarLayout的主题背景为暗色，那么在整个AppBarLayout布局中显示的内容都为亮色

 <android.support.v7.widget.Toolbar
 android:id="@+id/toolbar"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 app:popupTheme="@style/Theme.AppCompat.Light">//设置Toolbar里面菜单的弹出主题为亮色

 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:gravity="center"
 android:text="标题" />

 </android.support.v7.widget.Toolbar>

 <android.support.design.widget.TabLayout
 android:id="@+id/tabLayout"
 android:layout_width="match_parent"
 android:layout_height="30dp"//高度
 app:tabBackground="@android:color/holo_red_light"//背景色，可以设置为@color/colorPrimary，则就和上面toolbar的背景色一致，中间不会产生阴影线条
 app:tabGravity="fill"
 app:tabIndicatorColor="#000000"
 app:tabIndicatorHeight="5dp"
 app:tabMode="scrollable"
 app:tabSelectedTextColor="#0000ff"
 app:tabTextColor="#ffffff" />

 </android.support.design.widget.AppBarLayout>

 <android.support.v4.view.ViewPager
 android:id="@+id/viewPagerNext"
 android:layout_width="match_parent"
 android:layout_height="wrap_content">

 </android.support.v4.view.ViewPager>


 </RelativeLayout>

 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class NextActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPagerNext;
    TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        viewPagerNext = (ViewPager) findViewById(R.id.viewPagerNext);
        tabAdapter =new TabAdapter(getSupportFragmentManager());
        viewPagerNext.setAdapter(tabAdapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //使用Toolbar 代替actionbar
        setSupportActionBar(toolbar);
      /*  getActionBar().setDisplayHomeAsUpEnabled(true);
        *//*getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_face_24dp);*/
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // TabLayout和ViewPager双向、交互联动。
        tabLayout.setupWithViewPager(viewPagerNext);
//        //滚动模式
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置下面线条的高度
//        tabLayout.setSelectedTabIndicatorHeight(8);
//        //设置线条的颜色
//        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        tabLayout.addTab(tabLayout.newTab().setText("新闻"));
        tabLayout.addTab(tabLayout.newTab().setText("游戏"));
        tabLayout.addTab(tabLayout.newTab().setText("科技"));
        tabLayout.addTab(tabLayout.newTab().setText("娱乐"));
       tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("军事"));


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

package com.example.windows.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  ViewPager viewPager;//视图
  TabAdapter adapter;//适配器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        adapter=new TabAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_next){
            startActivity(new Intent(this,TestActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    class TabAdapter extends FragmentPagerAdapter{


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

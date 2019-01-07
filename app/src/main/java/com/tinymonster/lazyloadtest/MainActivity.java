package com.tinymonster.lazyloadtest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MyAdapter myAdapter;
    List<Fragment> list=new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        list.add(new MyFragment("Fragment_1"));
        list.add(new MyFragment("Fragment_2"));
        list.add(new MyFragment("Fragment_3"));
        list.add(new MyFragment("Fragment_4"));
        list.add(new MyFragment("Fragment_5"));
        myAdapter=new MyAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(2);
    }
}

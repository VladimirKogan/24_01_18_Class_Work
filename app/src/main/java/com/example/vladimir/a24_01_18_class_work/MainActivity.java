package com.example.vladimir.a24_01_18_class_work;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager myPager;
    private MyAdapter adapter;
    private Button prevBtn, nextBtn, addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPager = findViewById(R.id.my_view_pager);
        adapter = new MyAdapter(getSupportFragmentManager());
        myPager.setAdapter(adapter);
        prevBtn = findViewById(R.id.prev_btn);
        nextBtn = findViewById(R.id.next_btn);
        addBtn = findViewById(R.id.add_btn);
        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);

        myPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("SCROLLED", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.prev_btn){
            int current = myPager.getCurrentItem();
            if (current > 0) {
                myPager.setCurrentItem(current - 1);
//                myPager.setCurrentItem(1, false);
            }
        }else if(view.getId() == R.id.next_btn){
            int current = myPager.getCurrentItem();
            if(current < adapter.getCount() -1 ){
                myPager.setCurrentItem(current + 1);
//                myPager.setCurrentItem(18);
            }
        }
        else if(view.getId() == R.id.add_btn){
            adapter.names.add("Petya");
            adapter.notifyDataSetChanged();
        }
    }

    class MyAdapter extends FragmentStatePagerAdapter{

        ArrayList<String> names = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
            fillNames();
        }

        private void fillNames(){
            for (int i = 0; i < 20; i++) {
                names.add("Name" + i);
            }
        }

        @Override
        public Fragment getItem(int position) {
            return MyPage.newInstance(names.get(position));
        }

        @Override
        public int getCount() {
            return names.size();
        }
    }


}

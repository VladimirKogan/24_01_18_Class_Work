package com.example.vladimir.a24_01_18_class_work;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by vladimir on 24/01/2018.
 */

public class MyPage extends Fragment {
    private int count;
    private String title;


    public static MyPage newInstance(String title){
        MyPage page = new MyPage();
        page.title = title;
        return page;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d("MY_TAG", "onAttache" + title);
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("MY_TAG", "on CreateView: " + title);
        View view = inflater.inflate(R.layout.my_page, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView titleTxt = view.findViewById(R.id.title_txt);
        Random rnd = new Random();
        int color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        titleTxt.setText(title + count);
        view.setBackgroundColor(color);
    }

    @Override
    public void onDestroyView() {
        Log.d("MY_TAG", "onDestroyView: "+ title);
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.d("MY_TAG", "onDetach: "+ title);

        super.onDetach();
    }
}

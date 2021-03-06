package com.hjg.hjgtools.activity.mvvm;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class ScalePageTransformer implements ViewPager.PageTransformer {
    public static final float MAX_SCALE = 1f;//1是不放大，原来的大小
    public static final float MIN_SCALE = 0.6f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        //一个公式
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
    }
}

package com.hjg.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by hjg on 2017-8-21 10:24:27.
 * 中间放大 两边缩小的ViewPager
 * 博客地址：http://www.jcodecraeer.com/a/anzhuokaifa/2015/0928/3525.html
 */
public class ClipViewPager extends ViewPager {

    public ClipViewPager(Context context) {
        super(context);
    }

    public ClipViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_UP) {
            View view = viewOfClickOnScreen(ev);
            if (view != null) {
                int index = indexOfChild(view);
                if (getCurrentItem() != index) {
                    setCurrentItem(indexOfChild(view));
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * viewpager中view点击位置的的判定
     *
     * @param ev
     * @return
     */
    private View viewOfClickOnScreen(MotionEvent ev) {
        int childCount = getChildCount();
        int[] location = new int[2];
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            v.getLocationOnScreen(location);
            int minX = location[0] + v.getWidth();
            int minY = getTop() + v.getWidth();

            int maxX = location[0] + v.getWidth();
            int maxY = getBottom();

            float x = ev.getX();
            float y = ev.getY();

            if ((x > minX && x < maxX) && (y > minY && y < maxY)) {
                return v;
            }
        }
        return null;
    }
}

package com.hjg.hjgtools.activity.conflict;

import com.hjg.hjgtools.activity.widget.recyclerVIew.HorizontalRecyclerViewActivity;
import com.hjg.hjgtools.base.HJGBaseRecyclerMulItemActivity;
import com.hjg.hjgtools.entity.RecyclerListBean;

import java.util.ArrayList;

public class ConflictActivity extends HJGBaseRecyclerMulItemActivity {

    @Override
    public ArrayList<RecyclerListBean> structureData() {
        ArrayList<RecyclerListBean> recyclerListBeans = new ArrayList<>();
        recyclerListBeans.add(new RecyclerListBean("ScrollView与recyclerView", ScrollViewRecyclerViewActivity.class, "recyclerView在其中无法自适应高度问题的解决"));
        recyclerListBeans.add(new RecyclerListBean("HorizontalScrollView与横向recyclerView", HorizontalRecyclerViewActivity.class, "recyclerView在其中无法展示所有item的问题"));
        return recyclerListBeans;
    }

}
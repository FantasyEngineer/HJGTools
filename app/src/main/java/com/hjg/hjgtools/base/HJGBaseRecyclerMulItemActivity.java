package com.hjg.hjgtools.base;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjg.base.base.HTitleActivity;
import com.hjg.base.listener.OnEasyItemClickListener;
import com.hjg.base.util.ActivityUtils;
import com.hjg.base.util.EmptyUtils;
import com.hjg.base.util.StrUtil;
import com.hjg.base.view.MyDividerItemDecoration;
import com.hjg.base.view.faq.FloatingActionButton;
import com.hjg.hjgtools.R;
import com.hjg.hjgtools.adapter.MulRecyclerViewAdapter;
import com.hjg.hjgtools.entity.RecyclerListBean;

import java.util.ArrayList;

//recyclerView布局activity基类（多个布局承载）
public abstract class HJGBaseRecyclerMulItemActivity extends HTitleActivity {

    protected RecyclerView recyclerView;
    protected TextView tvDes;
    private ArrayList<RecyclerListBean> recyclerListBeans;
    protected LinearLayoutManager linearLayoutManager;
    protected FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview);


        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.recyclerView);
        tvDes = findViewById(R.id.tv_des);
        tvDes.setText(setDesString());
        tvDes.setMovementMethod(LinkMovementMethod.getInstance());
        tvDes.setVisibility(StrUtil.isEmpty(setDesString().toString()) ? View.GONE : View.VISIBLE);

        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration());
        if (EmptyUtils.isEmpty(structureData())) {
            recyclerListBeans = buildData();
        } else {
            recyclerListBeans = structureData();
        }
        MulRecyclerViewAdapter mulRecyclerViewAdapter = new MulRecyclerViewAdapter(activity, recyclerListBeans);
        mulRecyclerViewAdapter.setOnItemClickListener((OnEasyItemClickListener<RecyclerListBean>) (view, recyclerListBean, position) -> {
            onActivityItemClick(position, recyclerListBean);
            if (recyclerListBean.getaClass() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(TITLE, recyclerListBean.getTitle());
                ActivityUtils.startActivity(recyclerListBean.getaClass(), bundle);
            }
        });
        recyclerView.setAdapter(mulRecyclerViewAdapter);
    }

    /**
     * 初始化页面的描述语句
     *
     * @return
     */
    protected CharSequence setDesString() {
        return "null";
    }

    /**
     * 获取描述文字
     *
     * @return
     */
    protected String getDesString() {
        return tvDes.getText().toString();
    }

    protected void onActivityItemClick(int position, RecyclerListBean recyclerListBean) {

    }

    public abstract ArrayList<RecyclerListBean> structureData();

    public ArrayList<RecyclerListBean> buildData() {
        ArrayList<RecyclerListBean> recyclerListBeans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            recyclerListBeans.add(new RecyclerListBean("测试数据CECE" + i));
        }
        return recyclerListBeans;
    }

}

package com.hjg.hjgtools.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjg.base.adapter.BaseAdapter;
import com.hjg.base.adapter.BaseViewHolder;
import com.hjg.base.base.HBaseActivity;
import com.hjg.base.listener.OnEasyItemClickListener;
import com.hjg.base.util.ResUtils;
import com.hjg.base.util.StrUtil;
import com.hjg.base.view.MyDividerItemDecoration;
import com.hjg.hjgtools.R;
import com.hjg.hjgtools.adapter.MulRecyclerViewAdapter;
import com.hjg.hjgtools.entity.RecyclerListBean;

import java.util.ArrayList;

//recyclerView布局activity基类（单个布局承载）
public abstract class HJGBaseRecyclerActivity extends HBaseActivity {


    private RecyclerView recyclerView;
    private BaseAdapter<RecyclerListBean> recyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview);


        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MyDividerItemDecoration());
        recyclerView.setAdapter(recyclerViewAdapter = new BaseAdapter<RecyclerListBean>(activity, R.layout.item_title, structureData()) {

            @Override
            public void convert(BaseViewHolder holder, RecyclerListBean recyclerListBean, int position) {
                if (recyclerListBean.getIntDrawable() != 0) {
                    holder.setImageDrawable(R.id.tvIcon, ResUtils.getDrawable(recyclerListBean.getIntDrawable()));
                }
                holder.setVisible(R.id.tvIcon, recyclerListBean.getIntDrawable() != 0);

                holder.setText(R.id.tvTitle, recyclerListBean.getTitle());


                holder.setText(R.id.tvContent, recyclerListBean.getContent());
                holder.setVisible(R.id.tvContent, StrUtil.isNotEmpty(recyclerListBean.getContent()));
                holder.setOnClickListener(R.id.llFunction, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onActivityItemClick(position, recyclerListBean);
                    }
                });
            }
        });


    }

    protected abstract void onActivityItemClick(int position, RecyclerListBean recyclerListBean);

    public abstract ArrayList<RecyclerListBean> structureData();


}

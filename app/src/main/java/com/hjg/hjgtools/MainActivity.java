package com.hjg.hjgtools;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.hjg.base.util.ActivityUtils;
import com.hjg.base.util.P;
import com.hjg.base.util.StrUtil;
import com.hjg.hjgtools.activity.bound.ElasticActivity;
import com.hjg.hjgtools.activity.dialog.DialogActivity;
import com.hjg.hjgtools.activity.widget.EdittextActivity;
import com.hjg.hjgtools.activity.encrytion.EncryptionActivity;
import com.hjg.hjgtools.activity.file.FileActivity;
import com.hjg.hjgtools.activity.notification.NotificationActivity;
import com.hjg.hjgtools.activity.share.ShareActivity;
import com.hjg.hjgtools.base.HJGBaseRecyclerActivity;
import com.hjg.hjgtools.base.HJGBaseRecyclerMulItemActivity;
import com.hjg.hjgtools.entity.RecyclerListBean;
import com.hjg.hjgtools.receiver.ReceiverActivity;

import java.util.ArrayList;


public class MainActivity extends HJGBaseRecyclerMulItemActivity {

    @Override
    protected void onActivityItemClick(int position, RecyclerListBean recyclerListBean) {
        ActivityUtils.startActivity(recyclerListBean.getaClass());
    }

    @Override
    public ArrayList<RecyclerListBean> structureData() {
        ArrayList<RecyclerListBean> listBeans = new ArrayList<>();
        listBeans.add(new RecyclerListBean("弹窗", DialogActivity.class, "各种已经实现的弹窗方案", R.drawable.ic_icon_dialog));
        listBeans.add(new RecyclerListBean("广播测试", ReceiverActivity.class, "静态与动态广播", R.drawable.ic_icon_broadcast));
        listBeans.add(new RecyclerListBean("通知测试", NotificationActivity.class, "适配了低版本和高版本的通知", R.drawable.ic_icon_notification));
        listBeans.add(new RecyclerListBean("加解密", EncryptionActivity.class, "base64，RSA非对称加密", R.drawable.ic_icon_encryption));
        listBeans.add(new RecyclerListBean("控件", EdittextActivity.class, "各种控件的展示方案", R.drawable.ic_icon_view));
        listBeans.add(new RecyclerListBean("分享功能", ShareActivity.class, "集成了各种平台的分享", R.drawable.ic_icon_share));
        listBeans.add(new RecyclerListBean("文件操作", FileActivity.class, "", R.drawable.ic_icon_file));
        listBeans.add(new RecyclerListBean("弹性布局", ElasticActivity.class, "", R.drawable.ic_icon_file));
        return listBeans;
    }

}
package com.hjg.hjgtools.activity.jetpack.task;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;

import com.hjg.base.util.D;
import com.hjg.base.util.DateUtils;
import com.hjg.base.util.NotificationUtils;
import com.hjg.base.util.RandomUtils;
import com.hjg.base.util.log.androidlog.L;
import com.hjg.hjgtools.MainActivity;
import com.hjg.hjgtools.R;

import java.util.Date;


/**
 * job任务
 */
public class JobSchedulerService extends JobService {
    /**
     * 满足Job预设置条件下回调
     * 可以在任务过程中取消当前的任务
     * JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
     * scheduler.cancelAll();
     */
    @Override
    public boolean onStartJob(JobParameters params) {
//        一般我们的逻辑都是在这里面操作的，但是这个是主线程的，所以我们最好在子线程里面执行耗时操作。
//        返回false的话，jobfinish()中的true属性不在有用，也就是不再重试。
        //返回false，没有调用jobfinish，直接会调用ondestory方法结束
//        只有返回true,  jobfinish(true)才会有用。如果没有调用jobfinish  Service会直接destory掉
        //一般都是返回true,表示还有任务要做。
        D.showShort("执行job");
        L.d("执行job");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int notificationID = params.getExtras().getInt("jobId");
                PendingIntent pendingIntent = PendingIntent.getActivity(JobSchedulerService.this, 1, new Intent(getBaseContext(), MainActivity.class), PendingIntent.FLAG_ONE_SHOT);
                NotificationUtils.sendNotification(getBaseContext(), "HOUJIGUO", Integer.parseInt(RandomUtils.generateNumberString(7)),
                        "JobScheduler" + DateUtils.getStringByFormat(new Date(), DateUtils.dateFormatYMDHMS), "job任务" + notificationID + "正在执行中", R.mipmap.ic_launcher, "", "", pendingIntent);

                jobFinished(params, false);

            }
        }, 3000);

        return false;//说明任务立即结束，直接调用destroy销毁，相应线程的销毁工作应该在destroy中写明。
        //如果上面采用线程的方式，这里应该是true，说明任务不应该立即结束，是否结束应该由jobFinished来判定。

//        jobFinished(params, true);//如果使用了这两行代码，说明该任务会一次又一次的执行。但是会使周期失效。并且重启手机该任务不会继续执行。
//        return true;
    }
//    1 finalvoid  jobFinished(JobParameters params,boolean needsReschedule)
//    告诉JobManager 已经完成了工作，如果第二个参数为false，就是不需要重试这个jobinfo，


    /**
     * 1.被CancleAll的时候回调
     * 2.不满足预设置条件的情况下回调
     */
    @Override
    public boolean onStopJob(JobParameters params) {
//        这个方法的回调很奇怪，我只验证了一种情况，就是onstartjob()中没有调用jobfinish()，然后把网络关掉，这时候就会回调这个方法。其他的我没去发现，贴上原话！！
//        一般都返回false.
        D.showShort("关闭job");
        L.d("关闭job");
        return false;
    }

    @Override
    public void onDestroy() {
        L.d("onDestroy");
        super.onDestroy();
    }
}


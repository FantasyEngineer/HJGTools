package com.hjg.base.view.dialog;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.hjg.base.R;
import com.hjg.base.view.flyco.animation.BaseAnimatorSet;
import com.hjg.base.view.flyco.dialog.widget.base.BottomBaseDialog;


public class IOSTaoBaoDialog extends BottomBaseDialog<IOSTaoBaoDialog> {
    LinearLayout mLlWechatFriendCircle;
    LinearLayout mLlWechatFriend;
    LinearLayout mLlQq;
    LinearLayout mLlSms;

    public IOSTaoBaoDialog(Context context, View animateView) {
        super(context, animateView);
    }

    public IOSTaoBaoDialog(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        View inflate = View.inflate(getContext(), R.layout.dialog_ios_taobao, null);
        mLlWechatFriendCircle = inflate.findViewById(R.id.ll_wechat_friend_circle);
        mLlWechatFriend = inflate.findViewById(R.id.ll_wechat_friend);
        mLlQq = inflate.findViewById(R.id.ll_qq);
        mLlSms = inflate.findViewById(R.id.ll_sms);

        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        mLlWechatFriendCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mLlWechatFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mLlQq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mLlSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private BaseAnimatorSet mWindowInAs;
    private BaseAnimatorSet mWindowOutAs;

//    @Override
//    protected BaseAnimatorSet getWindowInAs() {
//        if (mWindowInAs == null) {
//            mWindowInAs = new WindowsInAs();
//        }
//        return mWindowInAs;
//    }
//
//    @Override
//    protected BaseAnimatorSet getWindowOutAs() {
//        if (mWindowOutAs == null) {
//            mWindowOutAs = new WindowsOutAs();
//        }
//        return mWindowOutAs;
//    }

    class WindowsInAs extends BaseAnimatorSet {
        @Override
        public void setAnimation(View view) {
            ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "rotationX", 10, 0f).setDuration(150);
            rotationX.setStartDelay(200);
            animatorSet.playTogether(
                    ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f).setDuration(350),
                    ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f).setDuration(350),
//                    ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f).setDuration(350),
                    ObjectAnimator.ofFloat(view, "rotationX", 0f, 10).setDuration(200),
                    rotationX,
                    ObjectAnimator.ofFloat(view, "translationY", 0, -0.1f * mDisplayMetrics.heightPixels).setDuration(350)
            );
        }
    }

    class WindowsOutAs extends BaseAnimatorSet {
        @Override
        public void setAnimation(View view) {
            ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "rotationX", 10, 0f).setDuration(150);
            rotationX.setStartDelay(200);
            animatorSet.playTogether(
                    ObjectAnimator.ofFloat(view, "scaleX", 0.8f, 1.0f).setDuration(350),
                    ObjectAnimator.ofFloat(view, "scaleY", 0.8f, 1.0f).setDuration(350),
//                    ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f).setDuration(350),
                    ObjectAnimator.ofFloat(view, "rotationX", 0f, 10).setDuration(200),
                    rotationX,
                    ObjectAnimator.ofFloat(view, "translationY", -0.1f * mDisplayMetrics.heightPixels, 0).setDuration(350)
            );
        }
    }
}

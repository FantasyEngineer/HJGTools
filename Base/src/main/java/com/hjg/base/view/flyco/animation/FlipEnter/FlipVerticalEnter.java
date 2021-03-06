package com.hjg.base.view.flyco.animation.FlipEnter;

import android.animation.ObjectAnimator;
import android.view.View;

import com.hjg.base.view.flyco.animation.BaseAnimatorSet;

public class FlipVerticalEnter extends BaseAnimatorSet {
	@Override
	public void setAnimation(View view) {
		animatorSet.playTogether(//
				// ObjectAnimator.ofFloat(view, "rotationX", -90, 0));
				ObjectAnimator.ofFloat(view, "rotationX", 90, 0));
	}
}

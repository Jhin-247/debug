package com.tuan.debugassisgnment.custom_ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.tuan.debugassisgnment.R;
import com.tuan.debugassisgnment.databinding.LayoutType2Binding;

public class ViewType2 extends ConstraintLayout {
    private final int TOP = 0;
    private final int BOTTOM = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;
    LayoutType2Binding binding;


    public ViewType2(Context context) {
        super(context);
        initView(context);
    }

    public ViewType2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ViewType2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ViewType2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = LayoutType2Binding.inflate(layoutInflater, this, true);
        Glide.with(this).load(R.drawable.avatar).centerCrop().into(binding.ivAvatar);
    }

    private int convertDP(int num) {
        Resources r = getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                num,
                r.getDisplayMetrics()
        );
    }

    private void resetLayoutParams(int position, View view, int num, boolean isLinearLayout) {
        if (!isLinearLayout) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (position == TOP) {
                layoutParams.setMargins(layoutParams.leftMargin, num, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else if (position == RIGHT) {
                layoutParams.setMarginEnd(num);
            }
            view.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (position == TOP) {
                layoutParams.setMargins(layoutParams.leftMargin, num, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else if (position == RIGHT) {
                layoutParams.setMarginEnd(num);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public void setType(int type) {
        if (type == 1) {
            setType1();
        }
        if (type == 2) {
            setType2();
        }
        if (type == 3) {
            setType3();
        }
    }

    private void setType1() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32), false);
        resetLayoutParams(RIGHT, binding.layoutAppName, convertDP(32), false);
        binding.cvAvatar.setVisibility(View.GONE);
    }

    private void setType2() {
        binding.mainLayout.setMinHeight(convertDP(224));
        resetLayoutParams(TOP, binding.tvContent, convertDP(16), false);
        binding.tvTitle.setVisibility(View.GONE);
    }

    private void setType3() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32), false);
        resetLayoutParams(RIGHT, binding.layoutAppName, convertDP(32), false);
        resetLayoutParams(TOP, binding.tvContent, convertDP(16), false);
        binding.cvAvatar.setVisibility(View.GONE);
        binding.tvTitle.setVisibility(View.GONE);
    }


}

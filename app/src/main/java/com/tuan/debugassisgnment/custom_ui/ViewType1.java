package com.tuan.debugassisgnment.custom_ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.tuan.debugassisgnment.R;
import com.tuan.debugassisgnment.databinding.LayoutType1Binding;

public class ViewType1 extends ConstraintLayout {
    private final int TOP = 0;
    private final int BOTTOM = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;
    private LayoutType1Binding binding;


    public ViewType1(Context context) {
        super(context);
        initView(context);
    }

    public ViewType1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ViewType1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ViewType1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = LayoutType1Binding.inflate(layoutInflater, this, true);
        Glide.with(this).load(R.drawable.avatar).centerCrop().into(binding.ivAvatar);
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
        if (type == 4) {
            setType4();
        }
    }

    private int convertDP(int num) {
        Resources r = getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                num,
                r.getDisplayMetrics()
        );
    }

    private void resetLayoutParams(int position, View view, int num) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (position == TOP) {
            layoutParams.setMargins(layoutParams.leftMargin, num, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else if (position == RIGHT) {
            layoutParams.setMarginEnd(num);
        }
        view.setLayoutParams(layoutParams);
    }

    private void setType1() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32));
        binding.cvAvatar.setVisibility(View.GONE);
    }

    private void setType2() {
        binding.mainLayout.setMinHeight(convertDP(224));
    }

    private void setType3() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32));
        resetLayoutParams(TOP, binding.layoutContent, convertDP(48));
        binding.tvTitle.setVisibility(GONE);
        binding.cvAvatar.setVisibility(GONE);
    }

    private void setType4() {
        resetLayoutParams(TOP, binding.layoutContent, convertDP(48));
        binding.mainLayout.setMinHeight(convertDP(224));
        binding.tvTitle.setVisibility(GONE);
    }
}

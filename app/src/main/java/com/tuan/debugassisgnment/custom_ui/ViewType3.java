package com.tuan.debugassisgnment.custom_ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.tuan.debugassisgnment.databinding.LayoutType3Binding;

public class ViewType3 extends ConstraintLayout {
    private final int TOP = 0;
    private final int BOTTOM = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;
    LayoutType3Binding binding;

    public ViewType3(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public ViewType3(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ViewType3(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ViewType3(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = LayoutType3Binding.inflate(layoutInflater, this, true);
    }

    public void setType(int type) {
        switch (type) {
            case 1:
                setType1();
                break;
            case 2:
                setType2();
                break;
            case 3:
                setType3();
                break;
            case 4:
                setType4();
                break;
            case 5:
                setType5();
                break;
            case 6:
                setType6();
                break;
            default:
                setType7();
                break;

        }
    }

    private void setType1() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32), false);
        resetLayoutParams(RIGHT, binding.layoutAppName, convertDP(32), false);
        binding.cvAvatar.setVisibility(GONE);
    }

    private void setType2() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32), false);
        resetLayoutParams(RIGHT, binding.layoutAppName, convertDP(32), false);
        binding.cvAvatar.setVisibility(GONE);
    }

    private void setType3() {

        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32), false);
        resetLayoutParams(RIGHT, binding.layoutAppName, convertDP(32), false);
        resetLayoutParams(TOP, binding.tvContent, convertDP(48), false);
        binding.cvAvatar.setVisibility(GONE);
        binding.layoutAppName.setVisibility(GONE);
        binding.tvTitle.setVisibility(GONE);
    }

    private void setType4() {
        resetLayoutParams(RIGHT, binding.layoutContent, convertDP(32), false);
        resetLayoutParams(RIGHT, binding.layoutAppName, convertDP(32), false);

        resetLayoutParams(TOP, binding.tvContent, convertDP(16), false);
        binding.cvAvatar.setVisibility(GONE);
        binding.tvTitle.setVisibility(GONE);
    }

    private void setType5() {
        binding.layoutAppName.setVisibility(GONE);
        resetLayoutParams(TOP, binding.tvTitle, convertDP(32), false);
    }

    private void setType6() {
        binding.tvTitle.setVisibility(GONE);
        resetLayoutParams(TOP, binding.tvContent, convertDP(16), false);
    }

    private void setType7() {
        binding.layoutAppName.setVisibility(GONE);
        binding.tvTitle.setVisibility(GONE);
        resetLayoutParams(TOP, binding.tvTitle, convertDP(32), false);
        resetLayoutParams(TOP, binding.tvContent, convertDP(16), false);
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
}

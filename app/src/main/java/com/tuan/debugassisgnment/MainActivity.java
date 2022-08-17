package com.tuan.debugassisgnment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tuan.debugassisgnment.custom_ui.ViewType1;
import com.tuan.debugassisgnment.custom_ui.ViewType2;
import com.tuan.debugassisgnment.custom_ui.ViewType3;
import com.tuan.debugassisgnment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonAdapter.ButtonClick {
    ActivityMainBinding mBinding;
    ButtonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initData();
    }

    private void initData() {
        List<Button> mButtonType1 = new ArrayList<>();
        mButtonType1.add(new Button(1, 1));
        mButtonType1.add(new Button(1, 2));
        mButtonType1.add(new Button(1, 3));
        mButtonType1.add(new Button(1, 4));

        List<Button> mButtonType2 = new ArrayList<>();
        mButtonType2.add(new Button(2, 1));
        mButtonType2.add(new Button(2, 2));
        mButtonType2.add(new Button(2, 3));

        List<Button> mButtonType3 = new ArrayList<>();
        mButtonType3.add(new Button(3, 1));
        mButtonType3.add(new Button(3, 2));
        mButtonType3.add(new Button(3, 3));
        mButtonType3.add(new Button(3, 4));
        mButtonType3.add(new Button(3, 5));
        mButtonType3.add(new Button(3, 6));
        mButtonType3.add(new Button(3, 7));

        adapter = new ButtonAdapter(mButtonType1, mButtonType2, mButtonType3, this);
        mBinding.rcvBtnControl.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rcvBtnControl.setAdapter(adapter);

    }

    @Override
    public void onButtonClick(int type, int subType) {
        mBinding.layout.removeAllViews();
        if (type == 1) {
            ViewType1 viewType1 = new ViewType1(this);
            viewType1.setType(subType);
            mBinding.layout.addView(viewType1);
        }
        if (type == 2) {
            ViewType2 viewType2 = new ViewType2(this);
            viewType2.setType(subType);
            mBinding.layout.addView(viewType2);
        }
        if (type == 3) {
            ViewType3 viewType3 = new ViewType3(this);
            viewType3.setType(subType);
            mBinding.layout.addView(viewType3);
        }
    }
}
package com.tuan.debugassisgnment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuan.debugassisgnment.databinding.ItemHolderBinding;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonHolder> {
    private final List<Button> mListType1Buttons;
    private final List<Button> mListType2Buttons;
    private final List<Button> mListType3Buttons;

    private final ButtonClick mButtonClick;

    public ButtonAdapter(List<Button> mListType1Buttons, List<Button> mListType2Buttons, List<Button> mListType3Buttons, ButtonClick buttonClick) {
        this.mListType1Buttons = mListType1Buttons;
        this.mListType2Buttons = mListType2Buttons;
        this.mListType3Buttons = mListType3Buttons;
        this.mButtonClick = buttonClick;
    }

    @NonNull
    @Override
    public ButtonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ButtonHolder(ItemHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonHolder holder, int position) {
        InnerButtonAdapter adapter;
        if (position == 0) {
            adapter = new InnerButtonAdapter(mListType1Buttons, mButtonClick);
            holder.binding.rcvBtnList.setLayoutManager(new GridLayoutManager(holder.binding.getRoot().getContext(), mListType1Buttons.size(), RecyclerView.VERTICAL, false));
        } else if (position == 1) {
            adapter = new InnerButtonAdapter(mListType2Buttons, mButtonClick);
            holder.binding.rcvBtnList.setLayoutManager(new GridLayoutManager(holder.binding.getRoot().getContext(), mListType2Buttons.size(), RecyclerView.VERTICAL, false));
        } else {
            adapter = new InnerButtonAdapter(mListType3Buttons, mButtonClick);
            holder.binding.rcvBtnList.setLayoutManager(new GridLayoutManager(holder.binding.getRoot().getContext(), mListType3Buttons.size(), RecyclerView.VERTICAL, false));
        }
        holder.binding.rcvBtnList.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    interface ButtonClick {
        void onButtonClick(int type, int subType);
    }

    public static class ButtonHolder extends RecyclerView.ViewHolder {
        ItemHolderBinding binding;

        public ButtonHolder(@NonNull ItemHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

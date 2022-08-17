package com.tuan.debugassisgnment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuan.debugassisgnment.databinding.ItemButtonBinding;

import java.util.List;

public class InnerButtonAdapter extends RecyclerView.Adapter<InnerButtonAdapter.InnerButtonHolder> {
    private final List<Button> buttons;
    private final ButtonAdapter.ButtonClick mButtonClick;

    public InnerButtonAdapter(List<Button> buttons, ButtonAdapter.ButtonClick mButtonClick) {
        this.buttons = buttons;
        this.mButtonClick = mButtonClick;
    }

    @NonNull
    @Override
    public InnerButtonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerButtonHolder(ItemButtonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull InnerButtonHolder holder, int position) {
        Button button = buttons.get(position);
        holder.binding.btnChange.setText(button.getType() + "." + button.getSubType());
        holder.binding.btnChange.setOnClickListener(v -> mButtonClick.onButtonClick(button.getType(), button.getSubType()));
    }

    @Override
    public int getItemCount() {
        return buttons == null ? 0 : buttons.size();
    }

    public static class InnerButtonHolder extends RecyclerView.ViewHolder {
        ItemButtonBinding binding;

        public InnerButtonHolder(@NonNull ItemButtonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

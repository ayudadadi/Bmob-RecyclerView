package com.example.yls.demoa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


class StudentViewHolder extends RecyclerView.ViewHolder {
    ImageView ivHead;
    TextView nameView;
    TextView ageView;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        ivHead = itemView.findViewById(R.id.iv_head);
        nameView = itemView.findViewById(R.id.tv_name);
        ageView = itemView.findViewById(R.id.tv_age);
    }
}

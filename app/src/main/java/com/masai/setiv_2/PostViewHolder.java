package com.masai.setiv_2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvHospitalizedCurrently;
    private TextView mTvOnVentilatorCurrently;
    private TextView mTvPositive;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }


    private void initViews() {
        mTvHospitalizedCurrently = itemView.findViewById(R.id.tvHospitalizedCurrently);
        mTvOnVentilatorCurrently = itemView.findViewById(R.id.tvOnVentilatorCurrently);
        mTvPositive = itemView.findViewById(R.id.tvPositive);
    }

    void setData(ResponseModel responseModel) {
        mTvHospitalizedCurrently.setText(responseModel.getHospitalizedCurrently());
        mTvOnVentilatorCurrently.setText(responseModel.getOnVentilatorCurrently());
        mTvPositive.setText(responseModel.getPositive());
    }

}

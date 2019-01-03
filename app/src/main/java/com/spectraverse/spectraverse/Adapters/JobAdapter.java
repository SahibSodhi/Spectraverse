package com.spectraverse.spectraverse.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spectraverse.spectraverse.R;
import com.spectraverse.spectraverse.models.JobsResponseModel;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<JobsResponseModel.JobsDataModel> List;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mTextView3 = itemView.findViewById(R.id.textView3);
            mTextView4 = itemView.findViewById(R.id.textView4);


        }
    }

    public JobAdapter(Context context) {
        mContext = context;

    }

    public void setDataValue(ArrayList<JobsResponseModel.JobsDataModel> list){
        this.List=list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_job, viewGroup, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        JobsResponseModel.JobsDataModel currentItem = List.get(i);

        exampleViewHolder.mTextView1.setText(currentItem.getContent().getTitle());
        exampleViewHolder.mTextView2.setText("Job Status: Open");
        exampleViewHolder.mTextView3.setText("Description: " +currentItem.getContent().getDescription());
        exampleViewHolder.mTextView4.setText("Company: " + currentItem.getContent().getCompany());
    }

    @Override
    public int getItemCount() {
        return List==null ? 0 : List.size();
    }
}

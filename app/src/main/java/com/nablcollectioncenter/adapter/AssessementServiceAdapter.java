package com.nablcollectioncenter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nablcollectioncenter.R;
import com.nablcollectioncenter.activity.GeneralActivity;
import com.nablcollectioncenter.activity.QuestionsActivity;
import com.nablcollectioncenter.pojo.Categories;

import java.util.ArrayList;

/**
 * Created by raj on 3/19/2018.
 */

public class AssessementServiceAdapter extends RecyclerView.Adapter<AssessementServiceAdapter.ViewHolder> {

    private ArrayList<Categories> list;
    private Context context;


   public AssessementServiceAdapter(Context context, ArrayList<Categories> list){

        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assessement_service_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       holder.tv_assesement_service.setText(list.get(position).getCat_name());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_assesement_service;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_assesement_service = (TextView) itemView.findViewById(R.id.tv_assesement_service);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, GeneralActivity.class);
                    i.putExtra("Question",list.get(getAdapterPosition()));
                    context.startActivity(i);
                }
            });
        }
    }

}

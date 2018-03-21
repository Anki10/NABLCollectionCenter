package com.nablcollectioncenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nablcollectioncenter.MainActivity;
import com.nablcollectioncenter.R;
import com.nablcollectioncenter.pojo.LabRowResponse;

import java.util.ArrayList;

/**
 * Created by raj on 3/19/2018.
 */

public class AllocatedCenterAdapter extends RecyclerView.Adapter<AllocatedCenterAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LabRowResponse> lablist;

    public AllocatedCenterAdapter(Context context,ArrayList<LabRowResponse>list){
        this.context = context;
        this.lablist = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.allocated_center_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LabRowResponse pojo = lablist.get(position);

        holder.tv_Lab_name.setText(pojo.getLabname());
        holder.tv_lab_place.setText(pojo.getCity() + ","+ pojo.getCity());

        holder.ll_allocated_center.setOnClickListener((MainActivity)context);

    }

    @Override
    public int getItemCount() {
        return lablist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_Lab_name,tv_lab_place;
        private LinearLayout ll_allocated_center;

       public ViewHolder(View itemView) {
           super(itemView);

           tv_Lab_name = (TextView) itemView.findViewById(R.id.tv_Lab_name);
           tv_lab_place = (TextView) itemView.findViewById(R.id.tv_lab_place);

           ll_allocated_center = (LinearLayout) itemView.findViewById(R.id.ll_allocated_center);
       }
   }
}

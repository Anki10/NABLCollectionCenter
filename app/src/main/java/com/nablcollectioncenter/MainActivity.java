package com.nablcollectioncenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nablcollectioncenter.activity.AssessmentServiceActivity;
import com.nablcollectioncenter.activity.BaseActivity;
import com.nablcollectioncenter.adapter.AllocatedCenterAdapter;
import com.nablcollectioncenter.api.APIService;
import com.nablcollectioncenter.api.ApiUtils;
import com.nablcollectioncenter.dialogs.MyDialog;
import com.nablcollectioncenter.pojo.LabResponse;
import com.nablcollectioncenter.pojo.LabRowResponse;
import com.nablcollectioncenter.util.AppConstant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AllocatedCenterAdapter adapter;
    private MyDialog dialog;
    private APIService mAPIService;
    private ArrayList<LabRowResponse>lablist;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = (TextView) findViewById(R.id.tv_title);

        tv_title.setText("Allocated center");

        mAPIService = ApiUtils.getAPIService();

        mRecyclerView = (RecyclerView) findViewById(R.id.allocatedCenter_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        lablist = new ArrayList<LabRowResponse>();

        dialog = new MyDialog(this);

        LabList();
    }

    private void LabList(){

        dialog.ShowProgressDialog();

        mAPIService.labrequest("application/json", "Bearer "+getFromPrefs(AppConstant.accessToken)).enqueue(new Callback<LabResponse>() {
            @Override
            public void onResponse(Call<LabResponse> call, Response<LabResponse> response) {

                System.out.println("xxx success");

                dialog.CancelProgressDialog();

                lablist.addAll(response.body().getRows());

                adapter = new AllocatedCenterAdapter(MainActivity.this,lablist);
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<LabResponse> call, Throwable t) {
                System.out.println("xxx failler");

                dialog.CancelProgressDialog();
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_allocated_center:

                Intent intent = new Intent(MainActivity.this, AssessmentServiceActivity.class);
                startActivity(intent);
        }
    }
}

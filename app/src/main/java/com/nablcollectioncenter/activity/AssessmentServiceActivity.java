package com.nablcollectioncenter.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.nablcollectioncenter.R;
import com.nablcollectioncenter.adapter.AssessementServiceAdapter;
import com.nablcollectioncenter.pojo.Categories;
import com.nablcollectioncenter.pojo.Question;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by raj on 3/19/2018.
 */

public class AssessmentServiceActivity extends BaseActivity {

    private ArrayList<String> list;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AssessementServiceAdapter adapter;
    private TextView tv_title;

    private String cat_name;
    private ArrayList<Categories> assemmentlist;
    private ArrayList<String> question_text_list;
    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_assessement_service);

        tv_title = (TextView) findViewById(R.id.tv_title);

        tv_title.setText("Assessement Sections");

        String[] Assessement_Service = getResources().getStringArray(R.array.assessement_service);

        list = new ArrayList<>(Arrays.asList(Assessement_Service));
        questionList = new ArrayList<>();
        assemmentlist = new ArrayList<>();

        for (int i=0; i< list.size();i++){
            Categories pojo = new Categories();
            pojo.setCat_name(list.get(i));
           /* String [] q_array = AppConstant.QUESTIONS[i];
            question_text_list = new ArrayList<>(Arrays.asList(q_array));
             for (int j=0; j< question_text_list.size();j++){
                 Question question = new Question();
                 question.setQName(question_text_list.get(j));
                 question.setOptions(Arrays.asList(OPTIONS[i][j]));
                 questionList.add(question);
             }*/
            pojo.setList(questionList);
            assemmentlist.add(pojo);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.allocatedCenter_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(AssessmentServiceActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new AssessementServiceAdapter(AssessmentServiceActivity.this, assemmentlist);
        mRecyclerView.setAdapter(adapter);


    }
}

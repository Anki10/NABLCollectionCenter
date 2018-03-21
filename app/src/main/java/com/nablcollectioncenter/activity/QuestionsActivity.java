package com.nablcollectioncenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nablcollectioncenter.R;
import com.nablcollectioncenter.pojo.Categories;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Categories category = getIntent().getParcelableExtra("Question");

        category.getList();
    }
}

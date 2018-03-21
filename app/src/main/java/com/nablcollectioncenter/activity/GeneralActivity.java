package com.nablcollectioncenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.nablcollectioncenter.R;
import com.nablcollectioncenter.db.DataBaseHandler;
import com.nablcollectioncenter.pojo.GeneralInfoPojo;

/**
 * Created by raj on 3/21/2018.
 */

public class GeneralActivity extends BaseActivity {

    private DataBaseHandler databaseHandler;
    private Button btnSubmit;
    private String Q1 = "", Q2= "";
    private GeneralInfoPojo pojolist;
    private RadioButton radio_owned,radio_managed,radio_franchise,radio_categgorized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_general);

        init();


    }

    private void init(){

        radio_owned = (RadioButton) findViewById(R.id.radio_owned);
        radio_managed = (RadioButton) findViewById(R.id.radio_managed);
        radio_franchise = (RadioButton) findViewById(R.id.radio_franchise);
        radio_categgorized = (RadioButton) findViewById(R.id.radio_categgorized);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        databaseHandler = DataBaseHandler.getInstance(this);

        pojolist = new GeneralInfoPojo();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneralInfoPojo pojo = new GeneralInfoPojo();
                pojo.setCenter_name("General");
                pojo.setCollection_center(Q1);
                pojo.setSize_of_premises(Q2);

                boolean status = databaseHandler.INSERT_GENERALINFO(pojo);

                System.out.println(status);

            }
        });


        pojolist = databaseHandler.getGeneralInfoPojo("General");

        if (pojolist.getCollection_center().equalsIgnoreCase("Owned")){
            radio_owned.setChecked(true);

        } else if (pojolist.getCollection_center().equalsIgnoreCase("Managed")){
            radio_managed.setChecked(true);

        } else if (pojolist.getCollection_center().equalsIgnoreCase("Franchise")){
            radio_franchise.setChecked(true);

        }else if (pojolist.getCollection_center().equalsIgnoreCase("categorized")){
            radio_categgorized.setChecked(true);

        }


        System.out.println("pojo result"+pojolist);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_owned:
                if (checked)
                    Q1 = "Owned";
                    // Pirates are the best
                    break;
            case R.id.radio_managed:
                if (checked)
                    Q1 = "Managed";
                    // Ninjas rule
                    break;
            case R.id.radio_franchise:
                if (checked)
                    Q1 = "Franchise";
                    // Ninjas rule
                    break;
            case R.id.radio_categgorized:
                if (checked)
                    Q1 = "categorized";
                    // Ninjas rule
                    break;

            case R.id.radio_adequate:
                if (checked)
                    Q2 = "Adequate";
                    break;

            case R.id.radio_inadequate:
                if (checked)
                    Q2 = "Inadequate";
                    // Ninjas rule
                    break;
        }
    }
}

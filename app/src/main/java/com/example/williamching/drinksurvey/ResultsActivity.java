package com.example.williamching.drinksurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.Survey;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {

    int[] textViewsTotals = {R.id.textView_11, R.id.textView_12, R.id.textView_13, R.id.textView_14,
            R.id.textView_15, R.id.textView_16};
    int[] textViewsPercentages = {R.id.textView_21, R.id.textView_22, R.id.textView_23, R.id.textView_24,
            R.id.textView_25, R.id.textView_26};
    
    ArrayList<TextView> totals;
    ArrayList<TextView> percentage;
    ArrayList<Survey> surveyList;

    int[] totalsArray = new int[6];
    int[] percentagesArray = new int[6];


    Button buttonReturn;
    int total =0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        initialize();
        
    }

    private void initialize() {

        surveyList = (ArrayList<Survey>) getIntent().getSerializableExtra("surveyList");
        for(int i = 0; i < surveyList.size();i++){
            saveInformation(surveyList.get(i));
        }

        for (int i = 0; i < textViewsTotals.length; i++) {
            TextView txt = findViewById(textViewsTotals[i]);
            txt.setText(String.valueOf(totalsArray[i]));

            txt = findViewById(textViewsPercentages[i]);
            double value = ((double) totalsArray[i]/(double) total) * 100;
            txt.setText(String.valueOf((int) value));
        }

            buttonReturn = findViewById(R.id.button_Return);
            buttonReturn.setOnClickListener(this);
        
    }

    private void saveInformation(Survey survey) {

        switch (survey.getDrink()){

            case "Apple":
                totalsArray[0] = survey.getCupsPerDay();
                total = total + survey.getCupsPerDay();
                break;
            case "Orange":
                totalsArray[1] = survey.getCupsPerDay();
                total = total + survey.getCupsPerDay();
                break;
            case "Mixed":
                totalsArray[2] = survey.getCupsPerDay();
                total = total + survey.getCupsPerDay();
                break;
            case "CocaCola":
                totalsArray[3] = survey.getCupsPerDay();
                total = total + survey.getCupsPerDay();
                break;
            case "Sprite":
                totalsArray[4] = survey.getCupsPerDay();
                total = total + survey.getCupsPerDay();
                break;
            case "Seven-Up":
                totalsArray[5] = survey.getCupsPerDay();
                total = total + survey.getCupsPerDay();
                break;


        }


    }

    @Override
    public void onClick(View v) {
        finish();
    }
}

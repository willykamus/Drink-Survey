package com.example.williamching.drinksurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

import model.Survey;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button button_Add, button_New, button_Results;
    Spinner spinnerDrinks;
    int[] radioButtons = {R.id.radioButton_Option1,R.id.radioButton_Option2,R.id.radioButton_Option3};
    ArrayList<RadioButton> radioButtonsList = new ArrayList<>();
    RadioGroup radioGroup;
    EditText editTex_ClientNumber, editText_nCups;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<Survey> surveyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {

        button_Add = findViewById(R.id.button_Add);
        button_Add.setOnClickListener(this);

        button_New = findViewById(R.id.button_New);
        button_New.setOnClickListener(this);

        button_Results = findViewById(R.id.button_Result);
        button_Results.setOnClickListener(this);

        editTex_ClientNumber = findViewById(R.id.editText_ClientNumber);
        editText_nCups = findViewById(R.id.editText_Cups);

        spinnerDrinks = findViewById(R.id.spinner_DrinkType);
        adapter = ArrayAdapter.createFromResource(this,R.array.drinks,android.R.layout.simple_spinner_dropdown_item);
        spinnerDrinks.setAdapter(adapter);
        spinnerDrinks.setOnItemSelectedListener(this);

        for (int i = 0; i < radioButtons.length; i++){
            RadioButton radioButton = findViewById(radioButtons[i]);
            radioButtonsList.add(radioButton);
        }

        radioGroup = findViewById(R.id.radioGroup);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_Add:

                int drinkClicked = radioGroup.getCheckedRadioButtonId();
                String drinkSelected = "";
                for(int i =0; i < radioButtonsList.size(); i++){
                    if(radioButtonsList.get(i).getId() == drinkClicked){
                        drinkSelected = radioButtonsList.get(i).getText().toString();
                    }
                }

                int clientId = Integer.valueOf(editTex_ClientNumber.getText().toString());
                int cupsPerDay = Integer.valueOf(editText_nCups.getText().toString());
                String drinkType = spinnerDrinks.getSelectedItem().toString();

                Survey survey = new Survey(clientId,drinkType,drinkSelected,cupsPerDay);
                surveyList.add(survey);
                break;

            case R.id.button_New:
                editTex_ClientNumber.setText("");
                editText_nCups.setText("");
                radioGroup.clearCheck();
                break;

            case R.id.button_Result:
                Intent intent = new Intent(this,ResultsActivity.class);
                intent.putExtra("surveyList",surveyList);
                startActivity(intent);
                break;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String str = parent.getItemAtPosition(position).toString().toLowerCase();
        setRadioButton(str);

    }

    private void setRadioButton(String str) {

        String[] items = getResources().getStringArray(R.array.drinks);


        for(int i = 0; i < items.length; i++){
            if(items[i].equalsIgnoreCase(str)){
                //String tmp = "strings/"+str;
                int option = getResources().getIdentifier("array/"+str,null,getPackageName());
                String[] elements = getResources().getStringArray(option);
                for(int j = 0; j < elements.length; j++) {
                    radioButtonsList.get(j).setText(elements[j]);
                }
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

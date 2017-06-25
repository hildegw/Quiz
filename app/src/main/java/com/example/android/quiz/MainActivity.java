package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set text for questions
        TextView question1 = (TextView) findViewById(R.id.question1);
        TextView question2 = (TextView) findViewById(R.id.question2);
        TextView question3 = (TextView) findViewById(R.id.question3);
        TextView question4 = (TextView) findViewById(R.id.question4);
        question1.setText(getResources().getString(R.string.question1));
        question2.setText(getResources().getString(R.string.question2));
        question3.setText(getResources().getString(R.string.question3));
        question4.setText(getResources().getString(R.string.question4));

        //set text for answers
        RadioButton radioButton2a = (RadioButton) findViewById(R.id.rb21);
        RadioButton radioButton2b = (RadioButton) findViewById(R.id.rb22);
        RadioButton radioButton2c = (RadioButton) findViewById(R.id.rb23);
        radioButton2a.setText(getResources().getString(R.string.answer2a));
        radioButton2b.setText(getResources().getString(R.string.answer2b));
        radioButton2c.setText(getResources().getString(R.string.answer2c));

        CheckBox checkBox3a = (CheckBox) findViewById(R.id.cb31);
        CheckBox checkBox3b = (CheckBox) findViewById(R.id.cb32);
        CheckBox checkBox3c = (CheckBox) findViewById(R.id.cb33);
        CheckBox checkBox3d = (CheckBox) findViewById(R.id.cb34);
        checkBox3a.setText(getResources().getString(R.string.answer3a));
        checkBox3b.setText(getResources().getString(R.string.answer3b));
        checkBox3c.setText(getResources().getString(R.string.answer3c));
        checkBox3d.setText(getResources().getString(R.string.answer3d));

        RadioButton radioButton4a = (RadioButton) findViewById(R.id.rb41);
        RadioButton radioButton4b = (RadioButton) findViewById(R.id.rb42);
        RadioButton radioButton4c = (RadioButton) findViewById(R.id.rb43);
        radioButton4a.setText(getResources().getString(R.string.answer4a));
        radioButton4b.setText(getResources().getString(R.string.answer4b));
        radioButton4c.setText(getResources().getString(R.string.answer4c));


        //get and show score when score button is clicked
        Button scoreButton = (Button) findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateScore();
                Toast.makeText(MainActivity.this, getString(R.string.your_score) + " "
                                + Integer.toString(score),
                        Toast.LENGTH_LONG).show();
                score = 0;
            }
        });
    }

    //get and score answers
    private void calculateScore() {
        EditText editText1 = (EditText) findViewById(R.id.edit_text1);
        String answer1 = editText1.getText().toString().toLowerCase().trim();
        if (answer1.equals( getResources().getText(R.string.answer1))) {
            score += 3;
        } else {
            //show false
        }

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio_group2);
        int checkedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == R.id.rb21) {
            score += 1;
        } else {
            //show false
        }

        CheckBox checkBox3b = (CheckBox) findViewById(R.id.cb32);
        CheckBox checkBox3d = (CheckBox) findViewById(R.id.cb34);
        if (checkBox3b.isChecked() && checkBox3d.isChecked()) {
            score += 2;
        } else {
            //show false
        }

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radio_group4);
        int checkedRadioButtonId4 = radioGroup4.getCheckedRadioButtonId();
        if (checkedRadioButtonId4 == R.id.rb41) {
            score += 1;
        } else {
            //show false
        }
    }
}

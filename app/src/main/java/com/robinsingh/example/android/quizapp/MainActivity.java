package com.robinsingh.example.android.quizapp;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int ANSWER_1 = R.id.option_1;
    final String ANSWER_2 = "Narendra Modi";
    final int ANSWER_4 = R.id.radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Checks whether the options chosen by user is correct or not
     * */
    public void checkQuiz(View view) {
        int correctAnswers = 0;
        ArrayList<String> incorrectAnswersList = new ArrayList<>();
//       Checks for Question one
        if (checkQuestionOne()) {
            correctAnswers++;
        } else {
            incorrectAnswersList.add("Q.1.");
        }
//       Checks for Question two
        if (checkQuestionTwo()) {
            correctAnswers++;
        } else {
            incorrectAnswersList.add("Q.2.");
        }
        //       Checks for Question three
        if (checkQuestionThree()) {
            correctAnswers++;
        } else {
            incorrectAnswersList.add("Q.3.");
        }
        //       Checks for Question four
        if (checkQuestionFour()) {
            correctAnswers++;
        } else {
            incorrectAnswersList.add("Q.4.");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + correctAnswers + "/4 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /*
     * Checks if the selected radio button is correct or not
     * */
    private boolean checkQuestionOne() {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radio_group_for_question_1);
        if (radio.getCheckedRadioButtonId() == ANSWER_1) {
            return true;
        }
        return false;
    }

    /*
     * Checks if the selected checkbox is correct or not
     * */
    private boolean checkQuestionTwo() {
        EditText answer = (EditText) findViewById(R.id.name);
        if (answer.getText().toString().equalsIgnoreCase(ANSWER_2)) {

            return true;
        } else {
            return false;
        }
    }
    /*
     * Checks if the selected checkbox is correct or not
     * */

    private boolean checkQuestionThree() {
        CheckBox c1 = (CheckBox) findViewById(R.id.checkbox_1);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkbox_2);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkbox_3);
        CheckBox c4 = (CheckBox) findViewById(R.id.checkbox_4);

        if ((c2.isChecked()) && (c3.isChecked()) && (!c1.isChecked()) && (!c4.isChecked())) {
            return true;
        }
        return false;
    }

    /*
     * Checks if the selected radio button is correct or not
     * */

    private boolean checkQuestionFour() {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radio_group_for_question_4);
        if (radio.getCheckedRadioButtonId() == ANSWER_4) {
            return true;
        }
        return false;
    }


}

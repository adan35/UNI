package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    TextView roll, name, question, mcqNo;
    RadioButton mcq1,mcq2,mcq3,mcq4;
    Button btnNext;
    RadioGroup radioGroup;
    int correct = 0;
    int qNo = 0;
    String[] questions = {
            "How Many Total Emission(makhārij al-ḥurūf) Points Are Present",
            "Which Letters Sound Is Produced from end Of Throat",
            "Which Letters Sound Is Produced from Middle Of Throat",
            "Which Letters Sound Is Produced from Start Of Throat",
            "Which Letters Sound Is Produced from Base of Tongue which is near touching the mouth roof",
            "Which Letters Sound Is Produced from Portion of Tongue near its base touching the roof of mouth ",
            "Which Letters Sound Is Produced from Tongue touching the center of the mouth roof",
            "Which Letters Sound Is Produced from One side of the tongue touching the molar teeth",
            "Which Letters Sound Is Produced from Rounded tip of the tongue touching the base of the Frontal 8 teeth",
            "Which Letters Sound Is Produced from Rounded tip of the tongue touching the base of the frontal teeth "
    };
    String[] answers = {"17","أ ہ","ع ح","غ خ ","ق","ک","ج ش ی","ض","ل","ن"};
    String[] opt = {
            "5","10","15","17",
            "أ ہ","ع ح","غ خ","None Of Above",
            "ع ح","ج ش ی","ق","None Of Above",
            "غ خ","ل","ج ش ی","None Of Above",
            "ق","ل","أ ہ","All of the mentioned",
            "ک","أ ہ","ج ش ی"," None Of Above",
            "ج ش ی","أ ہ","ج ش ی","None of the mentioned",
            "ض","ج ش ی","غ خ","None Of Above",
            "ل","غ خ","أ ہ","None Of Above",
            "ن","أ ہ","غ خ","None Of Above"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        roll = (TextView) findViewById(R.id.rollText);
        name = (TextView) findViewById(R.id.nameText);
        question = (TextView) findViewById(R.id.question);
        mcqNo = (TextView) findViewById(R.id.mcqNo);
        mcq1 = (RadioButton) findViewById(R.id.mcq1);
        mcq2 = (RadioButton) findViewById(R.id.mcq2);
        mcq3 = (RadioButton) findViewById(R.id.mcq3);
        mcq4 = (RadioButton) findViewById(R.id.mcq4);
        btnNext = (Button) findViewById(R.id.btnNext);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        String rollStr = getIntent().getStringExtra("key1");
        String nameStr = getIntent().getStringExtra("key2");
        roll.setText(rollStr);
        name.setText(nameStr);
        fetchMcq();
        qNo++;
    }

    private void fetchMcq() {
        String noOfMcq = Integer.toString(qNo+1) + "/10";
        mcqNo.setText(noOfMcq);
        question.setText(questions[qNo]);
        mcq1.setText(opt[(qNo*4)]);
        mcq2.setText(opt[(qNo*4)+1]);
        mcq3.setText(opt[(qNo*4)+2]);
        mcq4.setText(opt[(qNo*4)+3]);
    }

    private String checkMcq(){
        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            return "";
        }
        else
        {
            if(mcq1.isChecked())
            {
                return mcq1.getText().toString();
            }
            if(mcq2.isChecked())
            {
                return mcq2.getText().toString();
            }
            if(mcq3.isChecked())
            {
                return mcq3.getText().toString();
            }
            if(mcq4.isChecked())
            {
                return mcq4.getText().toString();
            }
        }
        return "";
    }

    public void onClickBtnNext(View view) {
        String answer = checkMcq();
        if (answer.isEmpty())
            Toast.makeText(this, "Please select any option", Toast.LENGTH_SHORT).show();
        else {
            if (answer.equals(answers[qNo-1])) correct++;
            if (qNo > 9) {

            }
            else {
                fetchMcq();
                qNo++;
            }
        }
        radioGroup.clearCheck();
    }
}
package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizCard01 extends AppCompatActivity {

    private int points;
    private int numberOfQuestion;
    private Question[] questions = new Question[5];
    private int maxPoints = questions.length;
    private RadioGroup radioButtonLayout;
    private TextView text;
    private TextView question;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_01);


        points = 0;
        numberOfQuestion = 0;
        radioButtonLayout = findViewById(R.id.radioGroup);
        text = findViewById(R.id.card_text);
        question = findViewById(R.id.card_question);


        makeQuestions();
        showQuestion(numberOfQuestion);
        Button next = findViewById(R.id.button_forward);
        next.setOnClickListener(submitListener);
    }


    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
            submitAnswer(numberOfQuestion);
            if (numberOfQuestion < (questions.length - 1)){
                numberOfQuestion++;
                showQuestion(numberOfQuestion);
            } else {

                Intent i = new Intent(QuizCard01.this, QuizCard01.class);
                String maxPointsString = String.valueOf(maxPoints);
                String pointsString = String.valueOf(points);
                i.putExtra("maxPointsString", maxPointsString);
                i.putExtra("pointsString", pointsString);
                finish();
                startActivity(i);
            }
        }
    };


    public void makeQuestions(){
        questions[0] = new Question(
                R.string.question1,
                R.string.answer11,
                R.string.answer12,
                R.string.answer13,
                R.string.answer14,
                R.string.answer12);

        questions[1] = new Question(
                R.string.question2,
                R.string.answer21,
                R.string.answer22,
                R.string.answer23,
                R.string.answer24,
                R.string.answer24);

        questions[2] = new Question(
                R.string.question3,
                R.string.answer31,
                R.string.answer32,
                R.string.answer33,
                R.string.answer34,
                R.string.answer31
        );
        questions[3] = new Question(
                R.string.question4,
                R.string.answer41,
                R.string.answer42,
                R.string.answer43,
                R.string.answer44,
                R.string.answer42);

        questions[4] = new Question(
                R.string.question5,
                R.string.answer51,
                R.string.answer52,
                R.string.answer53,
                R.string.answer54,
                R.string.answer51);


    }

    public void showQuestion(int numberOfQuestion){


            RadioGroup questionText_radio = findViewById(R.id.radioGroup);
            RadioButton radioButton1 = findViewById(R.id.card_answer1);
            RadioButton radioButton2 = findViewById(R.id.card_answer2);
            RadioButton radioButton3 = findViewById(R.id.card_answer3);
            RadioButton radioButton4 = findViewById(R.id.card_answer4);
            radioButton1.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
            radioButton4.setChecked(false);
            radioButton1.setText(questions[numberOfQuestion].getFirstAnswer());
            radioButton2.setText(questions[numberOfQuestion].getSecondAnswer());
            radioButton3.setText(questions[numberOfQuestion].getThirdAnswer());
            radioButton4.setText(questions[numberOfQuestion].getFourthAnswer());
    }

    public void submitAnswer(int numberOfQuestion){

            String answer = "";
            RadioButton[] radioButtons = new RadioButton[4];
            radioButtons[0] = findViewById(R.id.card_answer1);
            radioButtons[1] = findViewById(R.id.card_answer2);
            radioButtons[2] = findViewById(R.id.card_answer3);
            radioButtons[3] = findViewById(R.id.card_answer4);


            for (int i = 0; i < 4; i++) {
                if(radioButtons[i].isChecked()){
                    answer += String.valueOf(radioButtons[i].getText());
                    questions[numberOfQuestion].setAnswer(answer);
                }
            }
            if (questions[numberOfQuestion].getCorrectAnswer().equals(answer)){
                points++;
            }


        }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("number_of_question", numberOfQuestion);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfQuestion = savedInstanceState.getInt("number_of_question");
        showQuestion(numberOfQuestion);
    }
}

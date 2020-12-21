package com.example.personality_matchmaking_app;
import android.content.res.ColorStateList;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Bot_activity extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewQuestionCount;
    private TextView textviewanswers;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;

    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    //private boolean answered;
    ArrayList<String> answers = new ArrayList<String>();
    StringBuilder builder = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bot_activity);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textviewanswers = findViewById(R.id.textView2);

        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        rb5 = findViewById(R.id.radio_button5);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
  //      textColorDefaultRb = rb1.getTextColors();
        Bot_Database dbHelper = new Bot_Database(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        questionCounter = 0;
        Collections.shuffle(questionList);
        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked() || rb5.isChecked() ) {
                        int id = rbGroup.getCheckedRadioButtonId();
                        RadioButton rb =  findViewById(id);
                        String radioText= (String) rb.getText();
                        answers.add(radioText);



                    }
                else {
                        Toast.makeText(Bot_activity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                showNextQuestion();
            }
        });
    }
    private void showNextQuestion() {
//        rb1.setTextColor(textColorDefaultRb);
//        rb2.setTextColor(textColorDefaultRb);
//        rb3.setTextColor(textColorDefaultRb);
//        rb4.setTextColor(textColorDefaultRb);
//        rb5.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            rb5.setText(currentQuestion.getOption5());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);

            buttonConfirmNext.setText("Confirm");
        } else {
            for (int i=0; i<answers.size();  i++){
                textviewanswers.setText(answers.get(i));

            }
            if (answers[i])

        }
    }
  //  private void checkAnswer() {
   //     answered = true;
   //     RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
   //     int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
   //     if (answerNr == currentQuestion.getAnswerNr()) {
   //         score++;
   //         textViewScore.setText("Score: " + score);
   //     }
   //     showSolution();
   // }
 //   private void showSolution() {
 //       rb1.setTextColor(Color.RED);
 //       rb2.setTextColor(Color.RED);
//        rb3.setTextColor(Color.RED);
//        switch (currentQuestion.getAnswerNr()) {
//            case 1:
//                rb1.setTextColor(Color.GREEN);
//                textViewQuestion.setText("Answer 1 is selected");
//                break;
//            case 2:
//                rb2.setTextColor(Color.GREEN);
//                textViewQuestion.setText("Answer 2 is selected");
//                break;
//            case 3:
//                rb3.setTextColor(Color.GREEN);
//                textViewQuestion.setText("Answer 3 is selected");
//                break;
//        }
//        if (questionCounter < questionCountTotal) {
//            buttonConfirmNext.setText("Next");
//        } else {
//            buttonConfirmNext.setText("Finish");
//        }
//    }
    private void finishQuiz() {
       finish();
   }
}
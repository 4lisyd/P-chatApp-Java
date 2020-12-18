package com.example.personality_matchmaking_app;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChatBot extends AppCompatActivity {

    String UsernameHolder;
    TextView Username;
    Button LogOUT ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot);

        Username = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        UsernameHolder = intent.getStringExtra(MainActivity.UserName);

        // Setting up received email to TextView.
        Username.setText(Username.getText().toString()+ UsernameHolder);

        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(ChatBot.this,"Log Out Successfull", Toast.LENGTH_LONG).show();

            }
        });

    }
}


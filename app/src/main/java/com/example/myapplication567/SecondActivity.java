package com.example.myapplication567;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
TextView text2;
TextView text3;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text2 = findViewById(R.id.textView2);
        text3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);

        Intent I = getIntent();
        String username = I.getStringExtra("Name");

        int randomnum = generaterandom();
        text3.setText(""+randomnum);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(username,randomnum);
            }
        });
    }

    public int generaterandom(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomnumber = random.nextInt(upper_limit);
        return randomnumber;
    }

    public void shareData(String username,int randomnum){
        Intent I = new Intent(Intent.ACTION_SEND);
        I.setType("text/plain");
        I.putExtra(Intent.EXTRA_SUBJECT,username+"You got lucky today");
        I.putExtra(Intent.EXTRA_TEXT,"His lucky number is"+randomnum);
        startActivity(Intent.createChooser(I,"Choose a platform"));
    }
}
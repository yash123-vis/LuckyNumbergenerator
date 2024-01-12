package com.example.myapplication567;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mytext;
    EditText myedittext;
    Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytext = findViewById(R.id.textView);
        myedittext = findViewById(R.id.editText);
        mybutton = findViewById(R.id.button);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = myedittext.getText().toString();
                Intent I = new Intent(MainActivity.this,SecondActivity.class);
                I.putExtra("Name",str);
                startActivity(I);
            }
        });
    }
}
package com.example.classicalquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.classicalquiz.Activities.SetsActivity;

public class MainActivity extends AppCompatActivity {

    CardView python,java,c,cpp,csharp,javaScript;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        python = findViewById(R.id.python);
        java = findViewById(R.id.java);
        c = findViewById(R.id.c);
        cpp = findViewById(R.id.cpp);
        csharp = findViewById(R.id.csharp);
        javaScript = findViewById(R.id.JavaScript);

        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                intent.putExtra("category", "Python");
                startActivity(intent);
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                intent.putExtra("category", "Java");
                startActivity(intent);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                intent.putExtra("category", "C Language");
                startActivity(intent);
            }
        });

        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                intent.putExtra("category", "C++");
                startActivity(intent);
            }
        });

        csharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                intent.putExtra("category", "C-sharp");
                startActivity(intent);
            }
        });

        javaScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                intent.putExtra("category", "JavaScript");
                startActivity(intent);
            }
        });

    }

    // The purpose of the listeners in this code is to handle the click events on different CardView elements (python, java, c, cpp, csharp, javaScript).
    // Each CardView represents a programming language category, and when a user clicks on a specific card, it triggers an onClick event.

}
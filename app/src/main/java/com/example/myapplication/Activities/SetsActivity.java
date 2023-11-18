package com.example.myapplication.Activities;

import static com.example.myapplication.R.drawable.pipo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.Adapters.setAdapter;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.SetModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivitySetsBinding;

import java.util.ArrayList;

public class SetsActivity extends AppCompatActivity {

    ActivitySetsBinding binding;
    ArrayList<SetModel>list;

    TextView pageTitle;
    ConstraintLayout cardBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the selected category from the Intent
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        // Set the category as the page title
        pageTitle = findViewById(R.id.titlePage);
        pageTitle.setText(category);

        // Check for a new title
        String newTitle = intent.getStringExtra("category");
        if (newTitle != null && !newTitle.isEmpty()) {
            pageTitle.setText(category);
        }


        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.setsRecy.setLayoutManager(linearLayoutManager);


        switch (category) {
            case "Python":
                // Get a reference to the cardBackground
                cardBackground = findViewById(R.id.cardBackground);
                // Set the background resource dynamically
                cardBackground.setBackgroundResource(R.drawable.pipo);
                loadPythonQuestions();

                break;
            case "Java":
                // Get a reference to the cardBackground
                cardBackground = findViewById(R.id.cardBackground);
                // Set the background resource dynamically
                cardBackground.setBackgroundResource(R.drawable.javapic);
                loadJavaQuestions();
                break;
            case "C Language":
                // Get a reference to the cardBackground
                cardBackground = findViewById(R.id.cardBackground);
                // Set the background resource dynamically
                cardBackground.setBackgroundResource(R.drawable.cpic);
                loadCQuestions();
                break;
            case "C++":
                // Get a reference to the cardBackground
                cardBackground = findViewById(R.id.cardBackground);
                // Set the background resource dynamically
                cardBackground.setBackgroundResource(R.drawable.cpppic);
                loadCppQuestions();
                break;
            case "C-sharp":
                // Get a reference to the cardBackground
                cardBackground = findViewById(R.id.cardBackground);
                // Set the background resource dynamically
                cardBackground.setBackgroundResource(R.drawable.csharppic);
                loadCsharpQuestions();
                break;
            case "JavaScript":
                // Get a reference to the cardBackground
                cardBackground = findViewById(R.id.cardBackground);
                // Set the background resource dynamically
                cardBackground.setBackgroundResource(R.drawable.jspic);
                loadJavaScriptQuestions();
                break;
            // Add cases for other categories as needed
            default:
                // Handle the case where the category is not recognized
                break;
        }

        setAdapter adapter = new setAdapter(this, list);
        binding.setsRecy.setAdapter(adapter);

        ImageView imageView = findViewById(R.id.backgif);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the image click
                navigateToAnotherActivity();
            }
        });


    }

    private void navigateToAnotherActivity() {
        Intent intent = new Intent(SetsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void loadPythonQuestions() {
        for (int i = 1; i <= 10; i++) {
            list.add(new SetModel("Python Chapter " + i));
        }
    }

    private void loadJavaQuestions() {
        // Customize the Java questions as needed
        for (int i = 1; i <= 10; i++) {
            list.add(new SetModel("Java Chapter " + i));
        }
    }

    private void loadCQuestions() {
        // Customize the Java questions as needed
        for (int i = 1; i <= 10; i++) {
            list.add(new SetModel("C-lang. Chapter " + i));
        }
    }

    private void loadCppQuestions() {
        // Customize the Java questions as needed
        for (int i = 1; i <= 10; i++) {
            list.add(new SetModel("C++ Chapter " + i));
        }
    }

    private void loadCsharpQuestions() {
        // Customize the Java questions as needed
        for (int i = 1; i <= 10; i++) {
            list.add(new SetModel("C-sharp Chapter " + i));
        }
    }

    private void loadJavaScriptQuestions() {
        // Customize the Java questions as needed
        for (int i = 1; i <= 10; i++) {
            list.add(new SetModel("JavaScript Chapter " + i));
        }
    }

}
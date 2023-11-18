package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityFinalScoreBinding;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;
import pl.droidsonroids.gif.GifImageView;

public class FinalScore extends AppCompatActivity {

    ActivityFinalScoreBinding binding;

    private KonfettiView konfettiView = null;
    private Shape.DrawableShape drawableShape = null;

    ImageView imageView;
    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize drawableShape with a heart drawable
        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        drawableShape = new Shape.DrawableShape(drawable, true, true);

        // Initialize KonfettiView
        konfettiView = findViewById(R.id.konfettiView);

        // Check if it's a retry
        boolean isRetry = getIntent().getBooleanExtra("retry", false);

        // Get scores from the intent
        int totalScore = getIntent().getIntExtra("total", 0);
        int correct = getIntent().getIntExtra("score", 0);
        int wrong = totalScore - correct;

        // Initialize UI elements
        textView = findViewById(R.id.winText);
        imageView = findViewById(R.id.sadOrGift);

        // Check the condition for changing the text and image
        if (correct < 3) {
            imageView.setImageResource(R.drawable.sad_walking);
            textView.setText("IDIOT!");
        } else {
            imageView.setImageResource(R.drawable.winner);
            textView.setText("WINNER!");
            // Trigger confetti animation for winners
            rain();
        }

        // Set scores in the UI
        binding.questions.setText(String.valueOf(totalScore));
        binding.correctAns.setText(String.valueOf(correct));
        binding.wrongAns.setText(String.valueOf(wrong));

        // Reset the score if it's a retry
        if (isRetry) {
            binding.questions.setText(String.valueOf(totalScore = 0));
        }

        // Set listeners for buttons
        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalScore.this, MainActivity.class);
                finishAffinity();
            }
        });
    }

    // Method to trigger confetti animation
    public void rain() {
        EmitterConfig emitterConfig = new Emitter(5, TimeUnit.SECONDS).perSecond(100);
        konfettiView.start(
                new PartyFactory(emitterConfig)
                        .angle(Angle.BOTTOM)
                        .spread(Spread.ROUND)
                        .shapes(Arrays.asList(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape))
                        .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                        .setSpeedBetween(0f, 15f)
                        .position(new Position.Relative(0.0, 0.0).between(new Position.Relative(1.0, 0.0)))
                        .build()
        );
    }

    // Override method to handle back button press
    @Override
    public void onBackPressed() {
        try {
            finish();
            System.exit(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
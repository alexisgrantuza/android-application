package com.example.myapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.QuestionModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ArrayList<QuestionModel> list = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int score = 0;
    CountDownTimer timer;
    ActivityQuizBinding binding;

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());


        timeOut();
        timer.start();

        String setName = getIntent().getStringExtra("Chapter");
        if (setName.equals("Python Chapter 1")){
            setOne();
        } else if (setName.equals("Python Chapter 2")) {
            setTwo();
        } else if (setName.equals("Python Chapter 3")) {
            setThree();
        } else if (setName.equals("Python Chapter 4")) {
            setFour();
        } else if (setName.equals("Python Chapter 5")) {
            setFive();
        } else if (setName.equals("Python Chapter 6")) {
            setSix();
        } else if (setName.equals("Python Chapter 7")) {
            setSeven();
        } else if (setName.equals("Python Chapter 8")) {
            setEight();
        } else if (setName.equals("Python Chapter 9")) {
            setNine();
        } else if (setName.equals("Python Chapter 10")) {
            setTen();
        } else if (setName.equals("Java Chapter 1")) {
            setEleven();
        } else if (setName.equals("Java Chapter 2")) {
            setTwelve();
        } else if (setName.equals("Java Chapter 3")) {
            setThirteen();
        } else if (setName.equals("Java Chapter 4")) {
            setFourteen();
        } else if (setName.equals("Java Chapter 5")) {
            setFifteen();
        } else if (setName.equals("Java Chapter 6")) {
            setSixteen();
        } else if (setName.equals("Java Chapter 7")) {
            setSeventeen();
        } else if (setName.equals("Java Chapter 8")) {
            setEighteen();
        } else if (setName.equals("Java Chapter 9")) {
            setNineteen();
        } else if (setName.equals("Java Chapter 10")) {
            setTwenty();
        } else if (setName.equals("C-lang. Chapter 1")) {
            setTwentyOne();
        } else if (setName.equals("C-lang. Chapter 2")) {
            setTwentyTwo();
        } else if (setName.equals("C-lang. Chapter 3")) {
            setTwentyThree();
        } else if (setName.equals("C-lang. Chapter 4")) {
            setTwentyFour();
        } else if (setName.equals("C-lang. Chapter 5")) {
            setTwentyFive();
        } else if (setName.equals("C-lang. Chapter 6")) {
            setTwentySix();
        } else if (setName.equals("C-lang. Chapter 7")) {
            setTwentySeven();
        } else if (setName.equals("C-lang. Chapter 8")) {
            setTwentyEight();
        } else if (setName.equals("C-lang. Chapter 9")) {
            setTwentyNine();
        } else if (setName.equals("C-lang. Chapter 10")) {
            setThirty();
        } else if (setName.equals("C++ Chapter 1")) {
            setThirtyOne();
        } else if (setName.equals("C++ Chapter 2")) {
            setThirtyTwo();
        } else if (setName.equals("C++ Chapter 3")) {
            setThirtyThree();
        } else if (setName.equals("C++ Chapter 4")) {
            setThirtyFour();
        } else if (setName.equals("C++ Chapter 5")) {
            setThirtyFive();
        } else if (setName.equals("C++ Chapter 6")) {
            setThirtySix();
        } else if (setName.equals("C++ Chapter 7")) {
            setThirtySeven();
        } else if (setName.equals("C++ Chapter 8")) {
            setThirtyEight();
        } else if (setName.equals("C++ Chapter 9")) {
            setThirtyNine();
        } else if (setName.equals("C++ Chapter 10")) {
            setFourty();
        } else if (setName.equals("C-sharp Chapter 1")) {
            setFourtyOne();
        } else if (setName.equals("C-sharp Chapter 2")) {
            setFourtyTwo();
        } else if (setName.equals("C-sharp Chapter 3")) {
            setFourtyThree();
        } else if (setName.equals("C-sharp Chapter 4")) {
            setFourtyFour();
        } else if (setName.equals("C-sharp Chapter 5")) {
            setFourtyFive();
        } else if (setName.equals("C-sharp Chapter 6")) {
            setFourtySix();
        } else if (setName.equals("C-sharp Chapter 7")) {
            setFourtySeven();
        } else if (setName.equals("C-sharp Chapter 8")) {
            setFourtyEight();
        } else if (setName.equals("C-sharp Chapter 9")) {
            setFourtyNine();
        } else if (setName.equals("C-sharp Chapter 10")) {
            setFifty();
        } else if (setName.equals("JavaScript Chapter 1")) {
            setFiftyOne();
        } else if (setName.equals("JavaScript Chapter 2")) {
            setFiftyTwo();
        } else if (setName.equals("JavaScript Chapter 3")) {
            setFiftyThree();
        } else if (setName.equals("JavaScript Chapter 4")) {
            setFiftyFour();
        } else if (setName.equals("JavaScript Chapter 5")) {
            setFiftyFive();
        } else if (setName.equals("JavaScript Chapter 6")) {
            setFiftySix();
        } else if (setName.equals("JavaScript Chapter 7")) {
            setFiftySeven();
        } else if (setName.equals("JavaScript Chapter 8")) {
            setFiftyEight();
        } else if (setName.equals("JavaScript Chapter 9")) {
            setFiftyNine();
        } else if (setName.equals("JavaScript Chapter 10")) {
            setSixty();
        }





        for (int i = 0; i < 4; i++) {
            binding.optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    checkAnswer((Button) v);
                }
            });
        }

        playAnimation(binding.question, 0, list.get(position).getQuestion());

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer != null) {
                    timer.cancel();
                }

                timer.start();

                binding.btnNext.setEnabled(false);
                binding.btnNext.setAlpha((float) 0.3);
                enableOption(true);

                // Assuming imageView5 is an ImageView
                ImageView imageView5 = binding.imageView5;

                imageView5.setImageResource(R.drawable.nextquestion);

                position++;

                if (position == list.size()) {
                    Intent i = new Intent(QuizActivity.this, FinalScore.class);
                    i.putExtra("score", score);
                    i.putExtra("total", list.size());
                    startActivity(i);
                    return;
                }

                count = 0;

                playAnimation(binding.question, 0, list.get(position).getQuestion());

            }
        });
    }


    private void timeOut() {
        timer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Dialog d = new Dialog(QuizActivity.this);
                d.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                d.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                d.setCancelable(false);
                d.setContentView(R.layout.talo_layout);
                d.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Navigate back to SetsActivity
                        getOnBackPressedDispatcher();
                        finish(); // Optional: finish the QuizActivity to clear it from the stack
                    }
                });

                d.findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(QuizActivity.this, MainActivity.class);
                        startActivity(i);
                        finish(); // Optional: finish the QuizActivity to clear it from the stack
                    }
                });

                d.show();
            }
        };
    }


    private void playAnimation(View question, int i, String question_data) {
        question.animate().alpha(i).scaleX(i).scaleY(i).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {
                if (i == 0 && count < 4) {
                    String option = "";

                    if (count == 0) {
                        option = list.get(position).getOption1();
                    } else if (count == 1) {
                        option = list.get(position).getOption2();
                    } else if (count == 2) {
                        option = list.get(position).getOption3();
                    } else if (count == 3) {
                        option = list.get(position).getOption4();
                    }

                    playAnimation(binding.optionContainer.getChildAt(count), 0, option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                if (i == 0) {
                    try {
                        ((TextView) question).setText(question_data);
                        binding.totalQuestion.setText(position + 1 + "/" + list.size());

                    } catch (Exception e) {
                        ((Button) question).setText(question_data);
                    }

                    question.setTag(question_data);
                    playAnimation(question, 1, question_data);

                }

            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {

            }
        });
    }

    private void enableOption(boolean b) {
        for (int i = 0; i < 4; i++) {
            binding.optionContainer.getChildAt(i).setEnabled(b);

            if (b) {
                binding.optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_background);
            }
        }

    }


    private void checkAnswer(Button selectedOption) {

        if (timer != null) {
            timer.cancel();
        }

        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        String correctAnswer = list.get(position).getCorrectAnswer();


        if (selectedOption.getText().toString().equals(correctAnswer)) {
            score++;
            selectedOption.setBackgroundResource(R.drawable.correctanswer);
        } else {
            // The selected option is already updated in the loop above
            for (int i = 0; i < binding.optionContainer.getChildCount(); i++) {
                Button optionButton = (Button) binding.optionContainer.getChildAt(i);

                if (!optionButton.getText().toString().equals(correctAnswer)) {
                    // Set background resource for wrong options
                    optionButton.setBackgroundResource(R.drawable.wronganswer);
                }
            }

            Button correctOption = (Button) binding.optionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundResource(R.drawable.correctanswer);
        }
    }



    private void setOne() {
        list.add(new QuestionModel("Who developed Python Programming Language?", "Wick van Rossum", "Rasmus Lerdorf", "Guido van Rossum", "Niene Stom", "Guido van Rossum"));
        list.add(new QuestionModel("Which of the following is the correct extension of the Python file?e?", ".python", ".pl", ".py", ".p", ".py"));
        list.add(new QuestionModel("Python supports the creation of anonymous functions at runtime, using a construct called ________", "pi", "anonymous", "lambda", "none of the mentioned", "lambda"));
        list.add(new QuestionModel("Which keyword is used for function in Python language?", "Function", "def", "fun", "Define", "def"));
        list.add(new QuestionModel("Which of the following character is used to give single-line comments in Python?", "//", "#", "!", "/*", "#"));
    }

    private void setTwo() {
        list.add(new QuestionModel("All keywords in Python are in _________", "Capitalized", "lower case", "UPPER CASE", "None of the mentioned", "None of the mentioned"));
        list.add(new QuestionModel("Which type of Programming does Python support?", "object-oriented programming", "structured programming", "functional programming", "all of the mentioned", "all of the mentioned"));
        list.add(new QuestionModel("Is Python case sensitive when dealing with identifiers?", "yes", "no", "machine dependent", "none of the mentioned", "yes"));
        list.add(new QuestionModel("Is Python code compiled or interpreted?", "Python code is both compiled and interpreted", "Python code is neither compiled nor interpreted", "Python code is only compiled", "Python code is only interpreted", "Python code is both compiled and interpreted"));
        list.add(new QuestionModel("What will be the value of the following Python expression?", "7", "2", "4", "1", "7"));
    }

    private void setThree() {
        // Python Chapter 1
        list.add(new QuestionModel(
                "What is the purpose of a variable in Python?",
                "To store data and values",
                "To perform mathematical operations",
                "To define functions",
                "To create loops",
                "To store data and values"
        ));

// Python Chapter 2
        list.add(new QuestionModel(
                "Which symbol is used for single-line comments in Python?",
                "//",
                "#",
                "--",
                "/* */",
                "#"
        ));

// Python Chapter 3
        list.add(new QuestionModel(
                "How do you declare a variable in Python?",
                "var x;",
                "x = 5",
                "int x = 5",
                "$x = 5",
                "x = 5"
        ));

// Python Chapter 4
        list.add(new QuestionModel(
                "Which of the following is not a valid variable name in Python?",
                "my_variable",
                "_variable",
                "1variable",
                "variable123",
                "1variable"
        ));

// Python Chapter 5
        list.add(new QuestionModel(
                "What is the purpose of using triple-quoted strings in Python?",
                "To represent multi-line strings",
                "To define a tuple",
                "To create a comment block",
                "To specify a dictionary",
                "To represent multi-line strings"
        ));
    }

    private void setFour() {
        // Python Chapter 6
        list.add(new QuestionModel(
                "What is the data type of the value 3.14 in Python?",
                "Integer",
                "Float",
                "String",
                "Boolean",
                "Float"
        ));

// Python Chapter 7
        list.add(new QuestionModel(
                "Which data type is used to store a sequence of characters in Python?",
                "Integer",
                "Float",
                "List",
                "String",
                "String"
        ));

// Python Chapter 8
        list.add(new QuestionModel(
                "What is the result of the expression '5' + '2' in Python?",
                "52",
                "7",
                "Error",
                "None of the above",
                "52"
        ));

// Python Chapter 9
        list.add(new QuestionModel(
                "Which keyword is used to check the data type of a variable in Python?",
                "check",
                "type",
                "typeof",
                "datatype",
                "type"
        ));

// Python Chapter 10
        list.add(new QuestionModel(
                "In Python, how do you convert the variable 'num' to a floating-point number?",
                "float(num)",
                "str(num)",
                "int(num)",
                "bool(num)",
                "float(num)"
        ));
    }

    private void setFive() {
        // Python Chapter 11
        list.add(new QuestionModel(
                "What is the result of the expression 'Hello' + 'World' in Python?",
                "HelloWorld",
                "Hello World",
                "Hello + World",
                "Error",
                "HelloWorld"
        ));

// Python Chapter 12
        list.add(new QuestionModel(
                "How do you find the length of a string in Python?",
                "len()",
                "length()",
                "size()",
                "count()",
                "len()"
        ));

// Python Chapter 13
        list.add(new QuestionModel(
                "What is the correct way to represent the integer 15 in Python?",
                "15",
                "'15'",
                "int('15')",
                "float(15)",
                "15"
        ));

// Python Chapter 14
        list.add(new QuestionModel(
                "In Python, how do you convert the string '25' to an integer?",
                "int('25')",
                "str(25)",
                "float('25')",
                "bool('25')",
                "int('25')"
        ));

// Python Chapter 15
        list.add(new QuestionModel(
                "Which operator is used for string concatenation in Python?",
                "+",
                "-",
                "*",
                "/",
                "+"
        ));
    }

    private void setSix() {
        // Python Chapter 16
        list.add(new QuestionModel(
                "In Python, what is the correct boolean value for 'True'?",
                "True",
                "true",
                "1",
                "Yes",
                "True"
        ));

// Python Chapter 17
        list.add(new QuestionModel(
                "What is the result of the expression 5 > 3 in Python?",
                "True",
                "False",
                "Error",
                "None",
                "True"
        ));

// Python Chapter 18
        list.add(new QuestionModel(
                "Which logical operator is used for 'AND' in Python?",
                "and",
                "&&",
                "&",
                "||",
                "and"
        ));

// Python Chapter 19
        list.add(new QuestionModel(
                "What is the correct way to check if a variable x is not equal to 10 in Python?",
                "x != 10",
                "x <> 10",
                "x !== 10",
                "x not 10",
                "x != 10"
        ));

// Python Chapter 20
        list.add(new QuestionModel(
                "In Python, how do you write 'not equal to' in a boolean expression?",
                "!=",
                "<>",
                "==",
                "not",
                "!="
        ));
    }

    private void setSeven() {
        // Python Chapter 22
        list.add(new QuestionModel(
                "How do you access the third element of a list named 'myList' in Python?",
                "myList[2]",
                "myList[3]",
                "myList(2)",
                "myList.get(3)",
                "myList[2]"
        ));
        // Python Chapter 24
        list.add(new QuestionModel(
                "What is the correct syntax for creating an empty tuple in Python?",
                "myTuple = ()",
                "myTuple = {}",
                "myTuple = []",
                "myTuple = (empty)",
                "myTuple = ()"
        ));
        // Python Chapter 21
        list.add(new QuestionModel(
                "Which of the following data types in Python is mutable?",
                "Tuple",
                "String",
                "List",
                "Set",
                "List"
        ));
        // Python Chapter 22
        list.add(new QuestionModel(
                "What is the correct syntax for creating an empty list in Python?",
                "empty_list = []",
                "empty_list = {}",
                "empty_list = null",
                "empty_list = new List()",
                "empty_list = []"
        ));
        // Python Chapter 24
        list.add(new QuestionModel(
                "Which of the following statements is true about tuples in Python?",
                "Tuples are mutable",
                "Tuples can be resized",
                "Tuples can contain different data types",
                "Tuples are immutable",
                "Tuples are immutable"
        ));
    }

    private void setEight() {
        // Python Chapter 27
        list.add(new QuestionModel(
                "In Python, how do you remove an element from a set?",
                "remove()",
                "discard()",
                "pop()",
                "delete()",
                "discard()"
        ));
        // Python Chapter 28
        list.add(new QuestionModel(
                "Which data type is used to create a dictionary in Python?",
                "dict",
                "map",
                "set",
                "tuple",
                "dict"
        ));
        // Python Chapter 30
        list.add(new QuestionModel(
                "How do you check if a key exists in a Python dictionary?",
                "key in dictionary",
                "containsKey(key)",
                "isKeyPresent(key)",
                "hasKey(key)",
                "key in dictionary"
        ));
        // Python Chapter 29
        list.add(new QuestionModel(
                "What happens if you try to access a key that does not exist in a Python dictionary?",
                "It returns None",
                "It raises a KeyError",
                "It adds the key with a default value",
                "It returns False",
                "It raises a KeyError"
        ));
        // Python Chapter 26
        list.add(new QuestionModel(
                "Which of the following data types in Python is used to store an unordered collection of unique elements?",
                "List",
                "Tuple",
                "Set",
                "Dictionary",
                "Set"
        ));
    }

    private void setNine() {
        // Python Chapter 33
        list.add(new QuestionModel(
                "Which keyword is used to define the 'else' block in Python?",
                "elseif",
                "then",
                "else",
                "endif",
                "else"
        ));
        // Python Chapter 34
        list.add(new QuestionModel(
                "How many 'elif' blocks can you have following an 'if' statement?",
                "Only one",
                "As many as needed",
                "None",
                "Up to three",
                "As many as needed"
        ));
        // Python Chapter 31
        list.add(new QuestionModel(
                "In Python, which keyword is used for introducing a decision-making statement?",
                "choose",
                "choice",
                "if",
                "decide",
                "if"
        ));
        // Python Chapter 33
        list.add(new QuestionModel(
                "Which operator is used for 'greater than or equal to' in Python?",
                ">=",
                "==",
                "<=",
                "<>",
                ">="
        ));
        // Python Chapter 31
        list.add(new QuestionModel(
                "In Python, what is the purpose of the 'if' statement?",
                "To declare a variable",
                "To define a function",
                "To create a loop",
                "To make a decision",
                "To make a decision"
        ));
    }

    private void setTen() {
        // Python Chapter 41
        list.add(new QuestionModel(
                "Which loop is used for iterating over a sequence (that is either a list, a tuple, a dictionary, a set, or a string)?",
                "for loop",
                "while loop",
                "do-while loop",
                "foreach loop",
                "for loop"
        ));
        // Python Chapter 43
        list.add(new QuestionModel(
                "In Python, how do you exit a loop prematurely?",
                "Using 'break'",
                "Using 'continue'",
                "Using 'exit'",
                "By changing the loop condition to False",
                "Using 'break'"
        ));
        // Python Chapter 45
        list.add(new QuestionModel(
                "Which statement is used for skipping the rest of the code inside a loop for the current iteration?",
                "pass",
                "skip",
                "continue",
                "exit",
                "continue"
        ));
        // Python Chapter 39
        list.add(new QuestionModel(
                "Which 'while' loop statement is used for skipping the rest of the code inside the loop and move to the next iteration?",
                "skip",
                "break",
                "pass",
                "continue",
                "continue"
        ));
        // Python Chapter 37
        list.add(new QuestionModel(
                "What does the 'range()' function do in a 'for' loop?",
                "Generates a random number",
                "Creates a list of numbers",
                "Calculates the average",
                "Checks the equality of two values",
                "Creates a list of numbers"
        ));
    }

    private void setEleven() {
        list.add(new QuestionModel(
                "What is the main purpose of Java?",
                "Web development",
                "Mobile app development",
                "Game development",
                "Platform-independent programming",
                "Platform-independent programming"
        ));
        list.add(new QuestionModel(
                "Which keyword is used for memory allocation in Java?",
                "alloc",
                "new",
                "malloc",
                "allocate",
                "new"
        ));
        // Java Chapter 1
        list.add(new QuestionModel(
                "Which of the following is a superclass of every class in Java?",
                "ArrayList",
                "Abstract class",
                "Object class",
                "String",
                "Object class"
        ));

// Java Chapter 1
        list.add(new QuestionModel(
                "Which of these are selection statements in Java?",
                "break",
                "continue",
                "for()",
                "if()",
                "if()"
        ));

// Java Chapter 1
        list.add(new QuestionModel(
                "Which of the below is not a Java Profiler?",
                "JProfiler",
                "Eclipse Profiler",
                "JVM",
                "JConsole",
                "JVM"
        ));
    }

    private void setTwelve() {
        // Java Chapter 11
        list.add(new QuestionModel(
                "What is the purpose of a variable in Java?",
                "To store and manage data",
                "To perform mathematical operations",
                "To define methods",
                "To create loops",
                "To store and manage data"
        ));
        // Java Chapter 12
        list.add(new QuestionModel(
                "Which of the following is a valid Java variable name?",
                "123variable",
                "_myVariable",
                "variable-name",
                "2ndVariable",
                "_myVariable"
        ));
        // Java Chapter 13
        list.add(new QuestionModel(
                "How do you comment a single line in Java?",
                "// This is a comment",
                "/* This is a comment */",
                "<!-- This is a comment -->",
                "-- This is a comment",
                "// This is a comment"
        ));
        // Java Chapter 15
        list.add(new QuestionModel(
                "Which data type is used to store a single character in Java?",
                "char",
                "String",
                "int",
                "float",
                "char"
        ));
        // Java Chapter 14
        list.add(new QuestionModel(
                "What is the default value of an uninitialized integer variable in Java?",
                "0",
                "1",
                "null",
                "Undefined",
                "0"
        ));


    }

    private void setThirteen() {
        // Java Chapter 11
        list.add(new QuestionModel(
                "What is a variable in Java?",
                "A reserved keyword",
                "A container for storing data values",
                "A method for performing calculations",
                "A conditional statement",
                "A container for storing data values"
        ));
        // Java Chapter 12
        list.add(new QuestionModel(
                "How do you declare a variable in Java?",
                "var myVariable;",
                "variable myVariable;",
                "int myVariable;",
                "String myVariable;",
                "int myVariable;"
        ));
        // Java Chapter 13
        list.add(new QuestionModel(
                "Which of the following is a valid Java comment?",
                "// This is a comment",
                "# This is a comment",
                "/* This is a comment */",
                "' This is a comment",
                "// This is a comment"
        ));
        // Java Chapter 12
        list.add(new QuestionModel(
                "Which of the following is a valid variable name in Java?",
                "123variable",
                "_myVariable",
                "variable-name",
                "my Variable",
                "_myVariable"
        ));
        // Java Chapter 13
        list.add(new QuestionModel(
                "What is the correct way to declare a constant in Java?",
                "final int PI = 3.14;",
                "const PI = 3.14;",
                "int PI = 3.14;",
                "static final PI = 3.14;",
                "static final PI = 3.14;"
        ));

    }

    private void setFourteen() {
        // Java Chapter 16
        list.add(new QuestionModel(
                "What is the size of the 'int' data type in Java?",
                "8 bits",
                "16 bits",
                "32 bits",
                "64 bits",
                "32 bits"
        ));

// Java Chapter 17
        list.add(new QuestionModel(
                "Which of the following is a primitive data type in Java?",
                "String",
                "Double",
                "Boolean",
                "Object",
                "Boolean"
        ));

// Java Chapter 18
        list.add(new QuestionModel(
                "What is the range of the 'byte' data type in Java?",
                "-128 to 127",
                "0 to 255",
                "1.7e +/- 308 (~15 digits)",
                "-2^63 to 2^63-1",
                "-128 to 127"
        ));

// Java Chapter 19
        list.add(new QuestionModel(
                "Which data type is used to store floating-point numbers with single precision in Java?",
                "float",
                "double",
                "decimal",
                "real",
                "float"
        ));

// Java Chapter 20
        list.add(new QuestionModel(
                "What is the default value of the 'boolean' data type in Java?",
                "true",
                "false",
                "0",
                "null",
                "false"
        ));
    }

    private void setFifteen() {
        // Java Chapter 21
        list.add(new QuestionModel(
                "What is the result of the expression '5 + 3 * 2' in Java?",
                "16",
                "26",
                "11",
                "13",
                "11"
        ));

// Java Chapter 22
        list.add(new QuestionModel(
                "Which operator is used for exponentiation in Java?",
                "^",
                "**",
                "^^",
                "//",
                "**"
        ));

// Java Chapter 23
        list.add(new QuestionModel(
                "What is the result of the expression '10 / 3' in Java?",
                "3.3333",
                "3.0",
                "3",
                "4",
                "3"
        ));

// Java Chapter 24
        list.add(new QuestionModel(
                "Which logical operator in Java is known as the short-circuit AND?",
                "&&",
                "&",
                "||",
                "|",
                "&&"
        ));

// Java Chapter 25
        list.add(new QuestionModel(
                "What is the purpose of the '++' operator in Java?",
                "Increment by 1",
                "Decrement by 1",
                "Add 1 to the current value",
                "Multiply the current value by 2",
                "Increment by 1"
        ));

    }

    private void setSixteen() {
        // Java Chapter 31
        list.add(new QuestionModel(
                "Which method is used to find the maximum of two numbers in the Math class?",
                "maxValue",
                "max",
                "maximum",
                "largest",
                "max"
        ));
        // Java Chapter 33
        list.add(new QuestionModel(
                "Which method is used to calculate the square root in the Math class?",
                "sqrt",
                "squareRoot",
                "root",
                "squared",
                "sqrt"
        ));
        // Java Chapter 34
        list.add(new QuestionModel(
                "What is the result of 'Math.pow(2, 3)' in Java?",
                "6",
                "8",
                "16",
                "32",
                "8"
        ));
        // Java Chapter 35
        list.add(new QuestionModel(
                "Which constant in the Math class represents the mathematical constant π (pi)?",
                "Math.PI",
                "Math.E",
                "Math.PI/2",
                "Math.LN10",
                "Math.PI"
        ));
        // Java Chapter 26
        list.add(new QuestionModel(
                "Which class in Java is used for generating random numbers?",
                "Random",
                "Math.randomizer",
                "RandomGenerator",
                "Math.random",
                "Random"
        ));
    }

    private void setSeventeen() {
        // Java Chapter 31
        list.add(new QuestionModel(
                "What is the result of the expression (true && false) in Java?",
                "false",
                "true",
                "null",
                "Compile error",
                "false"
        ));

// Java Chapter 32
        list.add(new QuestionModel(
                "Which operator is used for logical OR in Java?",
                "||",
                "&",
                "|",
                "^",
                "||"
        ));

// Java Chapter 33
        list.add(new QuestionModel(
                "What will be the result of the expression (5 > 3) in Java?",
                "true",
                "false",
                "null",
                "Compile error",
                "true"
        ));

// Java Chapter 34
        list.add(new QuestionModel(
                "In Java, what is the result of the expression (10 != 5)?",
                "true",
                "false",
                "null",
                "Compile error",
                "true"
        ));

// Java Chapter 35
        list.add(new QuestionModel(
                "Which method is used to compare two strings for equality in Java?",
                "equals()",
                "compareTo()",
                "compare()",
                "equalsIgnoreCase()",
                "equals()"
        ));

    }

    private void setEighteen() {
        // Java Chapter 37
        list.add(new QuestionModel(
                "Which keyword is used to define the 'else' part of an 'if...else' statement in Java?",
                "else",
                "elseif",
                "otherwise",
                "or",
                "else"
        ));
        // Java Chapter 44
        list.add(new QuestionModel(
                "Which keyword is used to terminate the 'if' statement in Java?",
                "No specific keyword is required.",
                "terminate",
                "end",
                "fi",
                "No specific keyword is required."
        ));
        // Java Chapter 36
        list.add(new QuestionModel(
                "What keyword is used to define an 'if' statement in Java?",
                "if",
                "then",
                "when",
                "do",
                "if"
        ));
        // Java Chapter 39
        list.add(new QuestionModel(
                "How do you denote a block of code in Java for the 'if' statement?",
                "Enclose it within curly braces {}",
                "Indent it with spaces",
                "Use parentheses ()",
                "End it with a semicolon ;",
                "Enclose it within curly braces {}"
        ));
        // Java Chapter 38
        list.add(new QuestionModel(
                "Which keyword is used to start an 'else if' block in Java?",
                "else if",
                "elseif",
                "elif",
                "elsif",
                "else if"
        ));
    }

    private void setNineteen() {
        // Java Chapter 41
        list.add(new QuestionModel(
                "Which loop is guaranteed to execute at least once in Java?",
                "do-while loop",
                "for loop",
                "while loop",
                "enhanced for loop",
                "do-while loop"
        ));
        // Java Chapter 43
        list.add(new QuestionModel(
                "Which loop is suitable when the number of iterations is known in advance?",
                "for loop",
                "while loop",
                "do-while loop",
                "enhanced for loop",
                "for loop"
        ));
        // Java Chapter 44
        list.add(new QuestionModel(
                "How do you exit a loop prematurely in Java?",
                "Using the 'break' statement.",
                "Using the 'continue' statement.",
                "By setting the loop condition to false.",
                "By throwing an exception.",
                "Using the 'break' statement."
        ));
        // Java Chapter 45
        list.add(new QuestionModel(
                "Which keyword is used to skip the rest of the code inside a loop and start the next iteration?",
                "continue",
                "skip",
                "next",
                "break",
                "continue"
        ));
        // Java Chapter 41
        list.add(new QuestionModel(
                "Which loop in Java is used to iterate over a collection of elements?",
                "for loop",
                "while loop",
                "do-while loop",
                "enhanced for loop",
                "enhanced for loop"
        ));
    }

    private void setTwenty() {
        // Java Chapter 47
        list.add(new QuestionModel(
                "How do you declare an array in Java?",
                "int[] numbers;",
                "array numbers;",
                "Array numbers = new Array();",
                "numbers = int[];",
                "int[] numbers;"
        ));

// Java Chapter 48
        list.add(new QuestionModel(
                "What is the index of the first element in an array?",
                "0",
                "1",
                "-1",
                "Depends on the size of the array.",
                "0"
        ));

// Java Chapter 49
        list.add(new QuestionModel(
                "How do you access the third element in an array named 'myArray'?",
                "myArray[2]",
                "myArray[3]",
                "myArray(2)",
                "myArray.get(3)",
                "myArray[2]"
        ));
        // Java Chapter 50
        list.add(new QuestionModel(
                "Can the size of an array be changed once it is initialized?",
                "Yes",
                "No",
                "Depends on the type of array",
                "Only for one-dimensional arrays",
                "No"
        ));
        // Java Chapter 47
        list.add(new QuestionModel(
                "How do you declare a one-dimensional array in Java?",
                "int[] myArray;",
                "int myArray();",
                "int myArray{};",
                "int myArray[]();",
                "int[] myArray;"
        ));

    }

    private void setTwentyOne() {
        // C Chapter 1
        list.add(new QuestionModel(
                "Which keyword is used to declare a variable in C?",
                "var",
                "int",
                "float",
                "variable",
                "int"
        ));

// C Chapter 2
        list.add(new QuestionModel(
                "What is the purpose of a semicolon at the end of a statement in C?",
                "To indicate a comment",
                "To terminate a statement",
                "To declare a variable",
                "To create a loop",
                "To terminate a statement"
        ));

// C Chapter 3
        list.add(new QuestionModel(
                "How do you comment a single-line in C?",
                "// This is a comment",
                "/* This is a comment */",
                "-- This is a comment",
                "!! This is a comment",
                "// This is a comment"
        ));

// C Chapter 4
        list.add(new QuestionModel(
                "Which data type is used for storing whole numbers in C?",
                "float",
                "double",
                "int",
                "char",
                "int"
        ));

// C Chapter 5
        list.add(new QuestionModel(
                "What is the size of the 'int' data type in C?",
                "4 bytes",
                "2 bytes",
                "8 bytes",
                "Depends on the compiler",
                "4 bytes"
        ));


    }

    private void setTwentyTwo() {
        // C Chapter 6
        list.add(new QuestionModel(
                "Which data type is used for storing characters in C?",
                "char",
                "int",
                "float",
                "double",
                "char"
        ));

// C Chapter 7
        list.add(new QuestionModel(
                "What is the maximum value that can be stored in an 'unsigned int'?",
                "32767",
                "65535",
                "2147483647",
                "4294967295",
                "4294967295"
        ));

// C Chapter 8
        list.add(new QuestionModel(
                "Which data type is used for storing decimal numbers in C?",
                "float",
                "double",
                "int",
                "long",
                "float"
        ));

// C Chapter 9
        list.add(new QuestionModel(
                "What is the size of the 'double' data type in C?",
                "2 bytes",
                "4 bytes",
                "8 bytes",
                "Depends on the compiler",
                "8 bytes"
        ));

// C Chapter 10
        list.add(new QuestionModel(
                "What is the purpose of the 'void' data type in C?",
                "To declare an empty variable",
                "To indicate a null value",
                "To specify no return type",
                "To declare a constant",
                "To specify no return type"
        ));


    }

    private void setTwentyThree() {
        // C Chapter 16
        list.add(new QuestionModel(
                "How do you declare a string in C?",
                "char str[50];",
                "string str = \"Hello\";",
                "str = \"Hello\";",
                "String str = new String();",
                "char str[50];"
        ));

// C Chapter 17
        list.add(new QuestionModel(
                "Which function is used to input a string in C?",
                "scanf()",
                "gets()",
                "readline()",
                "input()",
                "gets()"
        ));

// C Chapter 18
        list.add(new QuestionModel(
                "What is the correct way to concatenate two strings in C?",
                "strcat(str1, str2);",
                "str1 + str2;",
                "concat(str1, str2);",
                "str1.concat(str2);",
                "strcat(str1, str2);"
        ));

// C Chapter 19
        list.add(new QuestionModel(
                "How do you compare two strings in C?",
                "strcmp(str1, str2)",
                "str1.equals(str2)",
                "str1 == str2",
                "compare(str1, str2)",
                "strcmp(str1, str2)"
        ));

// C Chapter 20
        list.add(new QuestionModel(
                "What does the 'strlen' function in C do?",
                "Returns the length of a string",
                "Compares two strings",
                "Converts a string to uppercase",
                "Checks if a string is empty",
                "Returns the length of a string"
        ));


    }

    private void setTwentyFour() {
        // Java Chapter 47
        list.add(new QuestionModel(
                "How do you declare an array in Java?",
                "int[] numbers;",
                "array numbers;",
                "Array numbers = new Array();",
                "numbers = int[];",
                "int[] numbers;"
        ));

// Java Chapter 48
        list.add(new QuestionModel(
                "What is the index of the first element in an array?",
                "0",
                "1",
                "-1",
                "Depends on the size of the array.",
                "0"
        ));

// Java Chapter 49
        list.add(new QuestionModel(
                "How do you access the third element in an array named 'myArray'?",
                "myArray[2]",
                "myArray[3]",
                "myArray(2)",
                "myArray.get(3)",
                "myArray[2]"
        ));
        // Java Chapter 50
        list.add(new QuestionModel(
                "Can the size of an array be changed once it is initialized?",
                "Yes",
                "No",
                "Depends on the type of array",
                "Only for one-dimensional arrays",
                "No"
        ));
        // Java Chapter 47
        list.add(new QuestionModel(
                "How do you declare a one-dimensional array in Java?",
                "int[] myArray;",
                "int myArray();",
                "int myArray{};",
                "int myArray[]();",
                "int[] myArray;"
        ));

    }

    private void setTwentyFive() {
        // C Chapter 21
        list.add(new QuestionModel(
                "What is the modulus operator in C?",
                "%",
                "&",
                "/",
                "**",
                "%"
        ));

// C Chapter 22
        list.add(new QuestionModel(
                "Which operator is used for logical AND in C?",
                "&&",
                "&",
                "||",
                "&|",
                "&&"
        ));

// C Chapter 23
        list.add(new QuestionModel(
                "What does the '++' operator do in C?",
                "Increments a variable by 1",
                "Decrements a variable by 1",
                "Raises a variable to the power of 2",
                "Negates a variable",
                "Increments a variable by 1"
        ));

// C Chapter 24
        list.add(new QuestionModel(
                "Which operator is used for pointer dereferencing in C?",
                "*",
                "&",
                "->",
                ".",
                "*"
        ));

// C Chapter 25
        list.add(new QuestionModel(
                "What is the result of the expression '5 / 2' in C?",
                "2",
                "2.5",
                "3",
                "0.5",
                "2"
        ));


    }

    private void setTwentySix() {
        // C Chapter 26
        list.add(new QuestionModel(
                "Which value represents 'true' in C?",
                "0",
                "1",
                "-1",
                "2",
                "1"
        ));

// C Chapter 27
        list.add(new QuestionModel(
                "What is the result of the expression '5 > 3' in C?",
                "true",
                "false",
                "0",
                "1",
                "true"
        ));

// C Chapter 28
        list.add(new QuestionModel(
                "Which logical operator is used for 'logical OR' in C?",
                "&&",
                "&",
                "||",
                "&|",
                "||"
        ));

// C Chapter 29
        list.add(new QuestionModel(
                "In C, what does the '!' operator do?",
                "Logical NOT",
                "Logical AND",
                "Logical OR",
                "Bitwise NOT",
                "Logical NOT"
        ));

// C Chapter 30
        list.add(new QuestionModel(
                "What is the result of the expression '0 && 1' in C?",
                "true",
                "false",
                "0",
                "1",
                "false"
        ));


    }

    private void setTwentySeven() {
        // C Chapter 34
        list.add(new QuestionModel(
                "In C, can an 'if' statement exist without an 'else' statement?",
                "Yes",
                "No",
                "It depends on the condition",
                "Don't know",
                "Yes"
        ));

// C Chapter 31
        list.add(new QuestionModel(
                "In C, how do you start an 'if' statement?",
                "if()",
                "if{}",
                "if <> then",
                "if:",
                "if()"
        ));

/// C Chapter 35
        list.add(new QuestionModel(
                "How do you write an 'if' statement with multiple conditions in C?",
                "if(condition1 && condition2)",
                "if(condition1 || condition2)",
                "if(condition1 and condition2)",
                "if(condition1 or condition2)",
                "if(condition1 && condition2)"
        ));
        // C Chapter 33
        list.add(new QuestionModel(
                "How can you represent 'else if' in C?",
                "elseif",
                "elif",
                "else if",
                "elseif condition",
                "else if"
        ));

// C Chapter 34
        list.add(new QuestionModel(
                "In C, what is the syntax for an 'if' statement without an 'else' statement?",
                "if x {}",
                "if (x) {}",
                "if (x) then {}",
                "if x then {}",
                "if (x) {}"
        ));

    }

    private void setTwentyEight() {
        // C Chapter 36
        list.add(new QuestionModel(
                "What is the syntax for a 'while' loop in C?",
                "while (condition) { }",
                "loop while (condition) { }",
                "if (condition) then { }",
                "if (condition) { }",
                "while (condition) { }"
        ));

// C Chapter 38
        list.add(new QuestionModel(
                "Which loop is suitable when the number of iterations is unknown in advance?",
                "for loop",
                "while loop",
                "do-while loop",
                "All loops are suitable",
                "while loop"
        ));

// C Chapter 40
        list.add(new QuestionModel(
                "Which loop in C is best suited for situations where the loop body must execute at least once?",
                "for loop",
                "while loop",
                "do-while loop",
                "All loops behave the same way",
                "do-while loop"
        ));
        // C Chapter 37
        list.add(new QuestionModel(
                "How is an 'infinite loop' created in C?",
                "for ( ; ; )",
                "while (true)",
                "do-while loop without a condition",
                "for ( ; ; )",
                "for ( ; ; )"
        ));
        // C Chapter 40
        list.add(new QuestionModel(
                "How is an infinite loop created in C?",
                "while (true) {}",
                "for (;;) {}",
                "do {} while (1)",
                "All of the above",
                "All of the above"
        ));

    }

    private void setTwentyNine() {
        // C Chapter 43
        list.add(new QuestionModel(
                "In C, array indices start from:",
                "0",
                "1",
                "10",
                "Depends on the array",
                "0"
        ));

// C Chapter 44
        list.add(new QuestionModel(
                "What is the syntax to access an element in an array in C?",
                "array(index)",
                "array.index",
                "array[index]",
                "array-element",
                "array[index]"
        ));

// C Chapter 45
        list.add(new QuestionModel(
                "Can the size of an array be changed once it is declared in C?",
                "Yes",
                "No",
                "Depends on the compiler",
                "Depends on the data type",
                "No"
        ));
        // C Chapter 44
        list.add(new QuestionModel(
                "How do you access the third element in an array named 'numbers'?",
                "numbers[2]",
                "numbers[3]",
                "numbers(3)",
                "numbers.third()",
                "numbers[2]"
        ));
        // C Chapter 42
        list.add(new QuestionModel(
                "How do you declare an array in C?",
                "int array()",
                "array int[]",
                "int[] array",
                "Array = int[]",
                "int[] array"
        ));

    }

    private void setThirty() {
        // C Chapter 50
        list.add(new QuestionModel(
                "Which function is used to read a character from the console in C?",
                "getchar()",
                "readChar()",
                "scanf(\"%c\", &ch)",
                "inputChar()",
                "getchar()"
        ));

// C Chapter 49
        list.add(new QuestionModel(
                "What is the purpose of the 'fflush' function in C?",
                "For flushing the console output",
                "For clearing the input buffer",
                "For formatting text output",
                "For flushing the input buffer",
                "For clearing the input buffer"
        ));

// C Chapter 48
        list.add(new QuestionModel(
                "How can you read an integer input from the user in C?",
                "readInteger()",
                "getInt()",
                "scanf(\"%d\", &num)",
                "inputInt()",
                "scanf(\"%d\", &num)"
        ));
        // C Chapter 46
        list.add(new QuestionModel(
                "How do you prompt the user for input in C?",
                "getInput()",
                "readConsole()",
                "input()",
                "scanf()",
                "scanf()"
        ));
        // C Chapter 48
        list.add(new QuestionModel(
                "Which header file is needed for input and output functions in C?",
                "#include <stdio.h>",
                "#include <input.h>",
                "#include <stdlib.h>",
                "#include <iostream>",
                "#include <stdio.h>"
        ));

    }

    private void setThirtyOne() {
        // C++ Chapter 1
        list.add(new QuestionModel(
                "How do you start a single-line comment in C++?",
                "//",
                "/*",
                "#",
                "--",
                "//"
        ));

// C++ Chapter 2
        list.add(new QuestionModel(
                "Which of the following is a valid C++ variable name?",
                "123variable",
                "_myVariable",
                "variable-name",
                "my Variable",
                "_myVariable"
        ));

// C++ Chapter 3
        list.add(new QuestionModel(
                "What is the purpose of a multi-line comment in C++?",
                "To declare a variable",
                "To comment out a block of code",
                "To print output to the console",
                "To define a function",
                "To comment out a block of code"
        ));

// C++ Chapter 4
        list.add(new QuestionModel(
                "How do you declare a variable in C++?",
                "variable x;",
                "x = 5;",
                "int x = 5;",
                "float x = 5.0;",
                "int x = 5;"
        ));

// C++ Chapter 5
        list.add(new QuestionModel(
                "Which data type is used for whole numbers in C++?",
                "float",
                "double",
                "int",
                "char",
                "int"
        ));


    }

    private void setThirtyTwo() {
        // C++ Output Chapter 1
        list.add(new QuestionModel(
                "What is the function to output text to the console in C++?",
                "print()",
                "log()",
                "display()",
                "cout <<",
                "cout <<"
        ));

// C++ Output Chapter 2
        list.add(new QuestionModel(
                "How do you insert a newline character in a C++ output?",
                "\\n",
                "/n",
                "newline()",
                "endl",
                "\\n"
        ));

// C++ Output Chapter 3
        list.add(new QuestionModel(
                "What is the correct syntax to output the value of a variable x in C++?",
                "print(x);",
                "console.log(x);",
                "display(x);",
                "cout << x;",
                "cout << x;"
        ));

// C++ Output Chapter 4
        list.add(new QuestionModel(
                "What does the 'endl' manipulator do in C++ output?",
                "Inserts a tab space",
                "Ends the program",
                "Inserts a newline and flushes the buffer",
                "Skips a line",
                "Inserts a newline and flushes the buffer"
        ));

// C++ Output Chapter 5
        list.add(new QuestionModel(
                "Which header file is required for C++ output operations?",
                "<input.h>",
                "<output.h>",
                "<iostream>",
                "<stdio.h>",
                "<iostream>"
        ));

    }

    private void setThirtyThree() {
        // C++ User Input Chapter 1
        list.add(new QuestionModel(
                "Which function is used to receive user input in C++?",
                "get()",
                "input()",
                "cin >>",
                "read()",
                "cin >>"
        ));

// C++ User Input Chapter 2
        list.add(new QuestionModel(
                "What is the purpose of the '>>' operator in C++ input?",
                "Shifts bits to the right",
                "Concatenates strings",
                "Indicates the end of input",
                "Extracts data into variables",
                "Extracts data into variables"
        ));

// C++ User Input Chapter 3
        list.add(new QuestionModel(
                "How can you prompt the user for input in C++?",
                "prompt()",
                "system.in()",
                "cout <<",
                "printf()",
                "cout <<"
        ));

// C++ User Input Chapter 4
        list.add(new QuestionModel(
                "Which data type is commonly used for storing user input in C++?",
                "int",
                "string",
                "float",
                "char",
                "string"
        ));
        // C++ User Input Chapter 5
        list.add(new QuestionModel(
                "Which operator is used to take multiple inputs in a single line in C++?",
                ">>",
                "<<",
                "&&",
                "||",
                ">>"
        ));
    }

    private void setThirtyFour() {
        // C++ Data Types Chapter 1
        list.add(new QuestionModel(
                "What is the size of the 'int' data type in C++?",
                "4 bytes",
                "2 bytes",
                "8 bytes",
                "Depends on the system",
                "4 bytes"
        ));

// C++ Data Types Chapter 2
        list.add(new QuestionModel(
                "Which data type is used to store decimal numbers in C++?",
                "int",
                "float",
                "double",
                "char",
                "double"
        ));

// C++ Data Types Chapter 3
        list.add(new QuestionModel(
                "What is the keyword for the boolean data type in C++?",
                "bool",
                "boolean",
                "bit",
                "byte",
                "bool"
        ));

// C++ Data Types Chapter 4
        list.add(new QuestionModel(
                "Which data type is used to store single characters in C++?",
                "int",
                "char",
                "string",
                "float",
                "char"
        ));

// C++ Data Types Chapter 5
        list.add(new QuestionModel(
                "What is the size of the 'double' data type in C++?",
                "2 bytes",
                "4 bytes",
                "8 bytes",
                "Depends on the system",
                "8 bytes"
        ));

    }

    private void setThirtyFive() {
        // C++ Operators Chapter 1
        list.add(new QuestionModel(
                "What is the result of the expression 5 + 3 in C++?",
                "15",
                "8",
                "53",
                "Error",
                "8"
        ));

// C++ Operators Chapter 2
        list.add(new QuestionModel(
                "Which operator is used for finding the remainder of a division in C++?",
                "/",
                "*",
                "%",
                "+",
                "%"
        ));

// C++ Operators Chapter 3
        list.add(new QuestionModel(
                "What does the operator '==' represent in C++?",
                "Assignment",
                "Greater than",
                "Equal to",
                "Logical AND",
                "Equal to"
        ));

// C++ Operators Chapter 4
        list.add(new QuestionModel(
                "What is the result of the expression 10 / 3 in C++?",
                "3",
                "3.33",
                "3.0",
                "Error",
                "3"
        ));

// C++ Operators Chapter 5
        list.add(new QuestionModel(
                "Which operator is used to access the value stored at a memory address in C++?",
                "*",
                "&",
                "->",
                ".",
                "*"
        ));

    }

    private void setThirtySix() {
        // C++ Booleans Chapter 1
        list.add(new QuestionModel(
                "In C++, what is the result of the expression 'true && false'?",
                "true",
                "false",
                "Error",
                "1",
                "false"
        ));

// C++ Booleans Chapter 2
        list.add(new QuestionModel(
                "Which relational operator is used to check if two values are not equal in C++?",
                "==",
                "!=",
                ">=",
                "<>",
                "!="
        ));

// C++ Booleans Chapter 3
        list.add(new QuestionModel(
                "What will be the result of the expression '!(5 > 3)' in C++?",
                "true",
                "false",
                "Error",
                "1",
                "false"
        ));

// C++ Booleans Chapter 4
        list.add(new QuestionModel(
                "Which logical operator is used for the 'OR' operation in C++?",
                "&&",
                "||",
                "!",
                "&",
                "||"
        ));

// C++ Booleans Chapter 5
        list.add(new QuestionModel(
                "What is the value of 'boolVar' if declared as 'bool boolVar = (10 > 5)' in C++?",
                "1",
                "true",
                "false",
                "Error",
                "true"
        ));

    }

    private void setThirtySeven() {
        // C++ Math Chapter 1
        list.add(new QuestionModel(
                "What is the result of the expression '5 + 3' in C++?",
                "8",
                "15",
                "53",
                "Error",
                "8"
        ));

// C++ Math Chapter 2
        list.add(new QuestionModel(
                "Which operator is used for exponentiation in C++?",
                "^",
                "**",
                "^^",
                "None of the above",
                "None of the above"
        ));

// C++ Math Chapter 3
        list.add(new QuestionModel(
                "If 'x' is 10 and 'y' is 3, what is the result of 'x % y' in C++?",
                "3",
                "1",
                "0",
                "Error",
                "1"
        ));

// C++ Math Chapter 4
        list.add(new QuestionModel(
                "What is the value of 'sqrt(25)' in C++?",
                "5",
                "25",
                "Error",
                "0",
                "5"
        ));

// C++ Math Chapter 5
        list.add(new QuestionModel(
                "If 'a' is 4 and 'b' is 2, what is the result of 'a / b' in C++?",
                "2.0",
                "2",
                "Error",
                "0",
                "2"
        ));

    }

    private void setThirtyEight() {
        // C++ Conditions Chapter 4
        list.add(new QuestionModel(
                "In C++, how can you represent 'greater than or equal to'?",
                ">=",
                "=<",
                "=>",
                "=<=",
                ">="
        ));

// C++ Conditions Chapter 5
        list.add(new QuestionModel(
                "What does the '&&' operator represent in C++?",
                "Logical AND",
                "Bitwise AND",
                "Logical OR",
                "Bitwise OR",
                "Logical AND"
        ));
        // C++ Conditions Chapter 2
        list.add(new QuestionModel(
                "Which operator is used to check if two values are equal in C++?",
                "==",
                "=",
                "!=",
                "<>",
                "=="
        ));
        // C++ Conditions Chapter 2
        list.add(new QuestionModel(
                "How do you represent 'not equal' in C++?",
                "==",
                "<=",
                ">=",
                "!=",
                "!="
        ));
        // C++ Conditions Chapter 5
        list.add(new QuestionModel(
                "How many conditions can you have in a single 'if-else' statement in C++?",
                "Only one",
                "Two",
                "Three",
                "Unlimited",
                "Two"
        ));
    }

    private void setThirtyNine() {
        // C++ Loops Chapter 2
        list.add(new QuestionModel(
                "Which loop in C++ is ideal when the number of iterations is known?",
                "for loop",
                "while loop",
                "do-while loop",
                "if-else loop",
                "for loop"
        ));
        // C++ Loops Chapter 4
        list.add(new QuestionModel(
                "How do you exit a 'for' loop prematurely in C++?",
                "Using the 'break' statement",
                "Using the 'continue' statement",
                "Using the 'return' statement",
                "None of the above",
                "Using the 'break' statement"
        ));
        // C++ Loops Chapter 1
        list.add(new QuestionModel(
                "Which loop in C++ is used for executing a block of code repeatedly as long as a condition is true?",
                "for loop",
                "while loop",
                "do-while loop",
                "switch loop",
                "while loop"
        ));
        // C++ Loops Chapter 4
        list.add(new QuestionModel(
                "Which loop is guaranteed to execute the loop body at least once in C++?",
                "for loop",
                "while loop",
                "do-while loop",
                "if-else loop",
                "do-while loop"
        ));
        // C++ Loops Chapter 3
        list.add(new QuestionModel(
                "In a 'for' loop, what does the third expression control?",
                "Initialization",
                "Condition",
                "Iteration",
                "Exit",
                "Iteration"
        ));

    }

    private void setFourty() {
        // C++ Arrays Chapter 2
        list.add(new QuestionModel(
                "How is the size of an array determined in C++?",
                "By the number of elements",
                "By the sum of elements",
                "By the average of elements",
                "By the maximum element",
                "By the number of elements"
        ));

// C++ Arrays Chapter 3
        list.add(new QuestionModel(
                "In C++, array indices start at which number?",
                "0",
                "1",
                "-1",
                "10",
                "0"
        ));

// C++ Arrays Chapter 4
        list.add(new QuestionModel(
                "What is the purpose of a two-dimensional array in C++?",
                "To store characters",
                "To store numbers",
                "To store multiple values",
                "To store a table of values",
                "To store a table of values"
        ));

// C++ Arrays Chapter 5
        list.add(new QuestionModel(
                "Which keyword is used to declare an array in C++?",
                "array",
                "list",
                "var",
                "int",
                "int"
        ));
        // C++ Arrays Chapter 3
        list.add(new QuestionModel(
                "How do you access the third element in a C++ array named 'numbers'?",
                "numbers[3]",
                "numbers(3)",
                "numbers.at(3)",
                "numbers{3}",
                "numbers[3]"
        ));
    }

    private void setFourtyOne() {
        // C# Basics Chapter 1
        list.add(new QuestionModel(
                "What does C# stand for?",
                "C-Sharp",
                "Computer",
                "Coding",
                "Creative",
                "C-Sharp"
        ));

// C# Basics Chapter 2
        list.add(new QuestionModel(
                "Which keyword is used to declare a constant in C#?",
                "const",
                "final",
                "let",
                "static",
                "const"
        ));

// C# Basics Chapter 3
        list.add(new QuestionModel(
                "How do you declare a variable in C#?",
                "var",
                "variable",
                "v",
                "$",
                "var"
        ));

// C# Basics Chapter 4
        list.add(new QuestionModel(
                "What is the entry point of every C# program?",
                "main",
                "start",
                "begin",
                "execute",
                "main"
        ));

// C# Basics Chapter 5
        list.add(new QuestionModel(
                "Which data type is used to store whole numbers in C#?",
                "int",
                "float",
                "char",
                "string",
                "int"
        ));

    }

    private void setFourtyTwo() {
        // C# Basics Chapter 2
        list.add(new QuestionModel(
                "How do you declare a single-line comment in C#?",
                "// This is a comment",
                "# This is a comment",
                "/* This is a comment */",
                "-- This is a comment",
                "// This is a comment"
        ));

// C# Basics Chapter 3
        list.add(new QuestionModel(
                "Which data type is used to store decimal numbers in C#?",
                "decimal",
                "double",
                "float",
                "int",
                "decimal"
        ));

// C# Basics Chapter 4
        list.add(new QuestionModel(
                "What is the purpose of declaring variables in C#?",
                "To store and manipulate data",
                "To execute a program",
                "To create loops",
                "To define comments",
                "To store and manipulate data"
        ));

// C# Basics Chapter 5
        list.add(new QuestionModel(
                "Can you declare multiple variables of the same type in a single line in C#?",
                "Yes",
                "No",
                "Depends on the data type",
                "Only for integers",
                "Yes"
        ));
        // C# Variables and Comments Chapter 1
        list.add(new QuestionModel(
                "How do you declare a variable in C# with an explicit type?",
                "int x;",
                "x = 5;",
                "var x = 5;",
                "variable x = 5;",
                "int x;"
        ));
    }

    private void setFourtyThree() {
        // C# Data Types Chapter 1
        list.add(new QuestionModel(
                "What is the data type used to store whole numbers in C#?",
                "int",
                "float",
                "double",
                "char",
                "int"
        ));

// C# Data Types Chapter 2
        list.add(new QuestionModel(
                "Which data type is used to store characters in C#?",
                "char",
                "string",
                "boolean",
                "int",
                "char"
        ));

// C# Data Types Chapter 3
        list.add(new QuestionModel(
                "What is the data type for storing decimal numbers with high precision in C#?",
                "decimal",
                "double",
                "float",
                "int",
                "decimal"
        ));

// C# Data Types Chapter 4
        list.add(new QuestionModel(
                "Which data type is used to store true or false values in C#?",
                "bool",
                "int",
                "double",
                "string",
                "bool"
        ));

// C# Data Types Chapter 5
        list.add(new QuestionModel(
                "What is the data type used to store text in C#?",
                "string",
                "char",
                "int",
                "float",
                "string"
        ));

    }

    private void setFourtyFour() {
        // C# Strings Chapter 1
        list.add(new QuestionModel(
                "Which method is used to find the length of a string in C#?",
                "Length",
                "Size",
                "Count",
                "SizeOf",
                "Length"
        ));

// C# Strings Chapter 2
        list.add(new QuestionModel(
                "What is the correct way to concatenate two strings in C#?",
                "str1 + str2",
                "str1 .concat(str2)",
                "str1.append(str2)",
                "str1.join(str2)",
                "str1 + str2"
        ));

// C# Strings Chapter 3
        list.add(new QuestionModel(
                "Which character is used as the escape character in C# strings?",
                "\\",
                "/",
                "@",
                "#",
                "\\"
        ));
        // C# Strings Chapter 5
        list.add(new QuestionModel(
                "Which method is used to convert a string to uppercase in C#?",
                "ToUpper()",
                "UpperCase()",
                "ConvertToUpper()",
                "ToUpperCase()",
                "ToUpper()"
        ));
        // C# Strings Chapter 3
        list.add(new QuestionModel(
                "Which escape sequence is used for a newline character in a string?",
                "\\n",
                "\\t",
                "\\r",
                "\\b",
                "\\n"
        ));
    }

    private void setFourtyFive() {
        // C# Output and Input Chapter 3
        list.add(new QuestionModel(
                "How can you convert a string to an integer in C#?",
                "int.Parse()",
                "Convert.ToInt32()",
                "ParseInt()",
                "ToInteger()",
                "int.Parse()"
        ));

// C# Output and Input Chapter 4
        list.add(new QuestionModel(
                "Which class is used to get user input from the console in C#?",
                "System.Input",
                "ConsoleReader",
                "StreamReader",
                "Console",
                "Console"
        ));
        // C# Output and Input Chapter 1
        list.add(new QuestionModel(
                "Which method is used to display text on the console in C#?",
                "Print()",
                "Write()",
                "Display()",
                "Show()",
                "Write()"
        ));
        // C# Input/Output Chapter 2
        list.add(new QuestionModel(
                "What method is used to read a line of text from the console in C#?",
                "ReadLine()",
                "NextLine()",
                "ReadString()",
                "GetLine()",
                "ReadLine()"
        ));

// C# Input/Output Chapter 3
        list.add(new QuestionModel(
                "Which class is used for console output in C#?",
                "Console.Out",
                "System.Output",
                "StreamWriter",
                "PrintWriter",
                "Console.Out"
        ));
    }

    private void setFourtySix() {
        // C# Booleans Chapter 1
        list.add(new QuestionModel(
                "Which data type is used to represent boolean values in C#?",
                "bool",
                "boolean",
                "Boolean",
                "bit",
                "bool"
        ));

// C# Booleans Chapter 2
        list.add(new QuestionModel(
                "What will be the result of the expression: (5 > 3) && (4 < 7)?",
                "True",
                "False",
                "Error",
                "Undefined",
                "True"
        ));

// C# Booleans Chapter 3
        list.add(new QuestionModel(
                "In C#, which operator is used for logical AND?",
                "&&",
                "||",
                "&",
                "|",
                "&&"
        ));

// C# Booleans Chapter 4
        list.add(new QuestionModel(
                "What is the default value of a boolean variable in C#?",
                "False",
                "True",
                "0",
                "1",
                "False"
        ));

// C# Booleans Chapter 5
        list.add(new QuestionModel(
                "Which keyword is used to declare a constant in C#?",
                "const",
                "constant",
                "final",
                "static",
                "const"
        ));

    }

    private void setFourtySeven() {
        // C# Operators Chapter 1
        list.add(new QuestionModel(
                "What is the remainder when dividing 10 by 3 in C#?",
                "1",
                "2",
                "3",
                "0",
                "1"
        ));

// C# Operators Chapter 2
        list.add(new QuestionModel(
                "Which operator is used for exponentiation in C#?",
                "^",
                "**",
                "^^",
                "//",
                "**"
        ));

// C# Operators Chapter 3
        list.add(new QuestionModel(
                "What will be the result of the expression: 7 / 2 in C#?",
                "3.5",
                "3",
                "4",
                "2.5",
                "3.5"
        ));

// C# Operators Chapter 4
        list.add(new QuestionModel(
                "Which operator is used for string concatenation in C#?",
                "+",
                "&",
                "|",
                ",",
                "+"
        ));

// C# Operators Chapter 5
        list.add(new QuestionModel(
                "What is the purpose of the '++' operator in C#?",
                "Increment by 1",
                "Decrement by 1",
                "Multiply by 2",
                "Divide by 2",
                "Increment by 1"
        ));

    }

    private void setFourtyEight() {
        // C# Conditionals Chapter 4
        list.add(new QuestionModel(
                "What is the result of the expression (x > 5) ? \"Greater\" : \"Less\"; when x is 8?",
                "Greater",
                "Less",
                "True",
                "False",
                "Greater"
        ));

// C# Conditionals Chapter 5
        list.add(new QuestionModel(
                "How do you write a comment in C# within a conditional statement?",
                "// This is a comment",
                "/* This is a comment */",
                "# This is a comment",
                "-- This is a comment",
                "// This is a comment"
        ));
        // C# Conditionals Chapter 4
        list.add(new QuestionModel(
                "What will be the result of the expression: (5 > 3) ? 1 : 0 in C#?",
                "1",
                "0",
                "true",
                "false",
                "1"
        ));

// C# Conditionals Chapter 5
        list.add(new QuestionModel(
                "How do you write a 'switch' statement in C#?",
                "switch (expression) { }",
                "if (expression) { }",
                "for (int i=0;i<0;i++) { }",
                "while (condition) { }",
                "switch (expression) { }"
        ));
        // C# Conditionals Chapter 1
        list.add(new QuestionModel(
                "Which keyword is used to start an 'if' statement in C#?",
                "if",
                "case",
                "when",
                "switch",
                "if"
        ));
    }

    private void setFourtyNine() {
        // C# Loops Chapter 4
        list.add(new QuestionModel(
                "Which loop is suitable when you want the loop body to execute at least once in C#?",
                "while loop",
                "do-while loop",
                "for loop",
                "foreach loop",
                "do-while loop"
        ));
        // C# Loops Chapter 1
        list.add(new QuestionModel(
                "Which loop in C# is used to iterate a specific number of times?",
                "while loop",
                "do-while loop",
                "for loop",
                "foreach loop",
                "for loop"
        ));

// C# Loops Chapter 2
        list.add(new QuestionModel(
                "How do you exit a loop prematurely in C#?",
                "break",
                "continue",
                "return",
                "exit",
                "break"
        ));
        // C# Loops Chapter 4
        list.add(new QuestionModel(
                "In a 'for' loop, what does the initialization statement typically represent?",
                "Loop condition",
                "Loop body",
                "Loop counter",
                "Loop exit condition",
                "Loop counter"
        ));

// C# Loops Chapter 5
        list.add(new QuestionModel(
                "What does the 'foreach' loop iterate over in C#?",
                "Array elements",
                "Loop counter",
                "Iterator object",
                "Collection or array elements",
                "Collection or array elements"
        ));
    }

    private void setFifty() {
        // C# Arrays and Methods Chapter 1
        list.add(new QuestionModel(
                "How do you declare a one-dimensional array in C#?",
                "int[] numbers;",
                "array numbers[];",
                "numbers[] int;",
                "Array numbers[];",
                "int[] numbers;"
        ));
        // C# Arrays and Methods Chapter 3
        list.add(new QuestionModel(
                "How do you pass an array to a method in C#?",
                "By using the 'this' keyword",
                "By passing each element separately",
                "By using the 'ref' keyword",
                "By passing the array as a parameter",
                "By passing the array as a parameter"
        ));
        // C# Arrays and Methods Chapter 5
        list.add(new QuestionModel(
                "Which method is used to sort the elements of an array in ascending order in C#?",
                "Array.Sort()",
                "SortArray()",
                "AscendingSort()",
                "Array.Arrange()",
                "Array.Sort()"
        ));
        // C# Arrays and Methods Chapter 1
        list.add(new QuestionModel(
                "How do you declare a one-dimensional array in C#?",
                "int[] array;",
                "array<int> numbers;",
                "Array array = new Array();",
                "int array = [5];",
                "int[] array;"
        ));
        // C# Arrays and Methods Chapter 5
        list.add(new QuestionModel(
                "Which method is used to find the index of a specific element in an array in C#?",
                "FindIndex()",
                "IndexOf()",
                "SearchIndex()",
                "Array.IndexOf()",
                "Array.IndexOf()"
        ));

    }

    private void setFiftyOne() {
        // JavaScript Chapter 1
        list.add(new QuestionModel(
                "What is JavaScript primarily used for?",
                "Styling web pages",
                "Building databases",
                "interactivity to web pages",
                "server-side applications",
                "interactivity to web pages"
        ));

// JavaScript Chapter 2
        list.add(new QuestionModel(
                "Which keyword is used to declare a variable in JavaScript?",
                "var",
                "let",
                "const",
                "variable",
                "var"
        ));

// JavaScript Chapter 4
        list.add(new QuestionModel(
                "What does the '=== ' operator in JavaScript check for?",
                "Equality in value and type",
                "Equality in value only",
                "Greater than or equal to",
                "Not equal to",
                "Equality in value and type"
        ));

// JavaScript Chapter 5
        list.add(new QuestionModel(
                "What is an 'event' in JavaScript?",
                "A built-in function",
                "A variable declaration",
                "A user action or occurrence",
                "An array of elements",
                "A user action or occurrence"
        ));

// JavaScript Chapter 4
        list.add(new QuestionModel(
                "Which function is used to print content to the browser console in JavaScript?",
                "console.print()",
                "print()",
                "log()",
                "write()",
                "console.log()"
        ));

    }

    private void setFiftyTwo() {
        // JavaScript Variables and Comments Chapter 1
        list.add(new QuestionModel(
                "How do you declare a variable in JavaScript?",
                "var myVariable;",
                "variable myVariable;",
                "myVariable = var;",
                "declare myVariable;",
                "var myVariable;"
        ));

// JavaScript Variables and Comments Chapter 3
        list.add(new QuestionModel(
                "Which symbol is used for single-line comments in JavaScript?",
                "//",
                "/*",
                "--",
                "%%",
                "//"
        ));

// JavaScript Variables and Comments Chapter 5
        list.add(new QuestionModel(
                "What is the purpose of using variables in JavaScript?",
                "To store and manipulate data",
                "To display images on a web page",
                "To define styles for HTML elements",
                "To create functions",
                "To store and manipulate data"
        ));

// Question 5
        list.add(new QuestionModel(
                "How do you assign a value to a variable in JavaScript?",
                "equal sign (=)",
                "colon (:)",
                "plus sign (+)",
                "ampersand (&)",
                "equal sign (=)"
        ));
        // JavaScript Variables and Comments Chapter 3
        list.add(new QuestionModel(
                "Which of the following is a valid JavaScript comment?",
                "// This is a comment",
                "' This is a comment",
                "# This is a comment",
                "/* This is a comment */",
                "// This is a comment"
        ));
    }

    private void setFiftyThree() {
        // JavaScript Strings Chapter
        list.add(new QuestionModel(
                "How do you access the character at a specific index in a string?",
                "charAt(index)",
                "char(index)",
                "getChar(index)",
                "charAtIndex(index)",
                "charAt(index)"
        ));

// JavaScript Strings Chapter
        list.add(new QuestionModel(
                "What method is used to find the length of a string in JavaScript?",
                ".size()",
                ".length()",
                ".count()",
                ".sizeof()",
                ".length()"
        ));

// JavaScript Strings Chapter
        list.add(new QuestionModel(
                "How can you concatenate two strings in JavaScript?",
                "string1.concat(string2)",
                "string1 + string2",
                "concat(string1, string2)",
                "string1.combine(string2)",
                "string1 + string2"
        ));

// JavaScript Strings Chapter 4
        list.add(new QuestionModel(
                "What method is used to convert a string to lowercase in JavaScript?",
                "string.lowerCase()",
                "string.toLower()",
                "string.toLowerCase()",
                "string.caseLower()",
                "string.toLowerCase()"
        ));

// JavaScript Strings Chapter 2
        list.add(new QuestionModel(
                "What is the result of the expression 'Hello' + ' ' + 'World'?",
                "'Hello World'",
                "'HelloWorld'",
                "Error: Cannot concatenate strings this way",
                "'Hello' + ' ' + 'World'",
                "'Hello World'"
        ));

    }

    private void setFiftyFour() {
        // JavaScript Data Types Chapter 1
        list.add(new QuestionModel(
                "What is the primary data type to represent whole numbers in JavaScript?",
                "Integer",
                "Float",
                "Double",
                "Number",
                "Number"
        ));

// JavaScript Data Types Chapter 2
        list.add(new QuestionModel(
                "How do you check the type of a variable in JavaScript?",
                "typeof variable",
                "variable.type",
                "variable.getType()",
                "typeof(variable)",
                "typeof variable"
        ));

// JavaScript Data Types Chapter 3
        list.add(new QuestionModel(
                "Which keyword is used to declare a constant in JavaScript?",
                "var",
                "let",
                "const",
                "final",
                "const"
        ));

// JavaScript Data Types Chapter 4
        list.add(new QuestionModel(
                "What is the data type of 'true' in JavaScript?",
                "Boolean",
                "String",
                "Number",
                "Object",
                "Boolean"
        ));

// JavaScript Data Types Chapter 5
        list.add(new QuestionModel(
                "How do you represent a decimal number in JavaScript?",
                "decimal",
                "double",
                "float",
                "number",
                "number"
        ));

    }

    private void setFiftyFive() {
        // JavaScript Operators Chapter 1
        list.add(new QuestionModel(
                "What is the remainder when you divide 17 by 5 in JavaScript?",
                "2",
                "3",
                "4",
                "1",
                "2"
        ));

// JavaScript Operators Chapter 2
        list.add(new QuestionModel(
                "What does the '===' operator check for in JavaScript?",
                "Equality and type",
                "Greater than",
                "Less than",
                "Not equal",
                "Equality and type"
        ));

// JavaScript Operators Chapter 3
        list.add(new QuestionModel(
                "What operator is used for string concatenation in JavaScript?",
                "+",
                "-",
                "*",
                "/",
                "+"
        ));

// JavaScript Operators Chapter 4
        list.add(new QuestionModel(
                "What does the '!' (exclamation mark) operator do in JavaScript?",
                "Logical NOT",
                "Logical AND",
                "Logical OR",
                "Bitwise NOT",
                "Logical NOT"
        ));

// JavaScript Operators Chapter 5
        list.add(new QuestionModel(
                "Which operator is used to find the type of a variable in JavaScript?",
                "typeof",
                "instanceof",
                "isType",
                "type",
                "typeof"
        ));

    }

    private void setFiftySix() {
        // JavaScript Numbers and Arithmetic Chapter 1
        list.add(new QuestionModel(
                "What is the result of the expression 5 + 7 in JavaScript?",
                "12",
                "57",
                "57",
                "35",
                "12"
        ));

// JavaScript Numbers and Arithmetic Chapter 2
        list.add(new QuestionModel(
                "How can you round a number to the nearest integer in JavaScript?",
                "Math.round()",
                "Math.floor()",
                "Math.ceil()",
                "Math.trunc()",
                "Math.round()"
        ));

// JavaScript Numbers and Arithmetic Chapter 2
        list.add(new QuestionModel(
                "What is the value of Math.pow(2, 3) in JavaScript?",
                "6",
                "8",
                "16",
                "64",
                "8"
        ));

// JavaScript Numbers and Arithmetic Chapter 3
        list.add(new QuestionModel(
                "What is the result of the expression 15 / 2 in JavaScript?",
                "7.5",
                "8",
                "7",
                "15",
                "7.5"
        ));

// JavaScript Numbers and Arithmetic Chapter 4
        list.add(new QuestionModel(
                "What is the remainder when you divide 20 by 7 in JavaScript?",
                "6",
                "1",
                "2",
                "5",
                "6"
        ));
    }

    private void setFiftySeven() {
        // JavaScript Booleans Chapter 1
        list.add(new QuestionModel(
                "What will the expression (5 > 3) return in JavaScript?",
                "true",
                "false",
                "undefined",
                "null",
                "true"
        ));

// JavaScript Booleans Chapter 2
        list.add(new QuestionModel(
                "Which of the following is a valid way to represent 'false' in JavaScript?",
                "0",
                "1",
                "'true'",
                "'false'",
                "0"
        ));

// JavaScript Booleans Chapter 3
        list.add(new QuestionModel(
                "What is the result of the expression (true && false) in JavaScript?",
                "true",
                "false",
                "null",
                "undefined",
                "false"
        ));

// JavaScript Booleans Chapter 4
        list.add(new QuestionModel(
                "Which comparison operator checks for both value and type equality in JavaScript?",
                "==",
                "===",
                "!=",
                "!==",
                "==="
        ));

// JavaScript Booleans Chapter 5
        list.add(new QuestionModel(
                "What will the expression (10 <= 5) return in JavaScript?",
                "true",
                "false",
                "null",
                "undefined",
                "false"
        ));


    }

    private void setFiftyEight() {
        // JavaScript Conditionals Chapter 3
        list.add(new QuestionModel(
                "Which statement is used to stop the execution of a JavaScript program?",
                "stop",
                "return",
                "break",
                "exit",
                "return"
        ));

// JavaScript Conditionals Chapter 5
        list.add(new QuestionModel(
                "How can you comment out multiple lines of code in JavaScript?",
                "// This is a comment",
                "/* This is a comment */",
                "-- This is a comment --",
                "' This is a comment",
                "/* This is a comment */"
        ));
        // JavaScript Conditionals Chapter 1
        list.add(new QuestionModel(
                "Which keyword is used for creating an 'if' statement in JavaScript?",
                "if",
                "case",
                "switch",
                "else",
                "if"
        ));

// JavaScript Conditionals Chapter 5
        list.add(new QuestionModel(
                "Which operator can be used as a shortcut for a simple 'if-else' statement?",
                "||",
                "&&",
                "?:",
                "==",
                "?:"
        ));
        // JavaScript Conditionals Chapter 2
        list.add(new QuestionModel(
                "Which statement is used to execute code when a condition is NOT true?",
                "if-else",
                "while",
                "switch",
                "do-while",
                "if-else"
        ));
    }

    private void setFiftyNine() {
        // JavaScript Loops Chapter 5
        list.add(new QuestionModel(
                "Which loop executes a block of code as long as a specified condition is true?",
                "while loop",
                "do-while loop",
                "for loop",
                "for...in loop",
                "while loop"
        ));
        // JavaScript Loops Chapter 3
        list.add(new QuestionModel(
                "Which loop is guaranteed to execute at least once?",
                "do-while loop",
                "while loop",
                "for loop",
                "for...in loop",
                "do-while loop"
        ));

// JavaScript Loops Chapter 1
        list.add(new QuestionModel(
                "Which loop in JavaScript is used to iterate over the properties of an object?",
                "for...in loop",
                "while loop",
                "do-while loop",
                "for loop",
                "for...in loop"
        ));
        // JavaScript Loops Chapter 4
        list.add(new QuestionModel(
                "How do you terminate a loop prematurely in JavaScript?",
                "Using the 'end' statement",
                "Using the 'terminate' keyword",
                "Using the 'break' statement",
                "Using the 'stop' keyword",
                "Using the 'break' statement"
        ));

// JavaScript Loops Chapter 3
        list.add(new QuestionModel(
                "What is the purpose of the 'break' statement in a loop?",
                "To exit the loop prematurely.",
                "To continue to the next iteration",
                "To initialize the loop.",
                "To restart the loop.",
                "To exit the loop prematurely."
        ));
    }

    private void setSixty() {
        // JavaScript Functions and Methods Chapter 1
        list.add(new QuestionModel(
                "What keyword is used to declare a function in JavaScript?",
                "method",
                "func",
                "declare",
                "function",
                "function"
        ));

// JavaScript Functions and Methods Chapter 2
        list.add(new QuestionModel(
                "How do you call a function named 'myFunction' in JavaScript?",
                "call myFunction();",
                "invoke myFunction();",
                "myFunction();",
                "execute myFunction();",
                "myFunction();"
        ));
        // JavaScript Functions and Methods Chapter 4
        list.add(new QuestionModel(
                "How can you call a method on an object in JavaScript?",
                "objectName.methodName();",
                "objectName:methodName();",
                "methodName(objectName);",
                "method(objectName);",
                "objectName.methodName();"
        ));
        // JavaScript Functions and Methods Chapter 5
        list.add(new QuestionModel(
                "What is the purpose of the 'return' statement in a function?",
                "To specify the data type of the function.",
                "To execute the function.",
                "To return a value",
                "To restart the function.",
                "To return a value"
        ));
        // Functions/Methods Chapter 2
        list.add(new QuestionModel(
                "How do you define a function/method in most programming languages?",
                "Using the 'define' keyword.",
                "Using the 'function' keyword.",
                "Using the 'var' keyword.",
                "Using the 'execute' keyword.",
                "Using the 'function' keyword."
        ));

    }


}
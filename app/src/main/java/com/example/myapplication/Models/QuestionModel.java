package com.example.myapplication.Models;

// Model class representing a quiz question
public class QuestionModel {

    // Variables to store question details: question, options, and correct answer
    private String question, option1, option2, option3, option4, correctAnswer;

    // Parameterized constructor to initialize question details
    public QuestionModel(String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    // Default constructor (empty constructor)
    public QuestionModel() {
    }

    // Getter method to retrieve the question
    public String getQuestion() {
        return question;
    }

    // Setter method to set the question
    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter method to retrieve option1
    public String getOption1() {
        return option1;
    }

    // Setter method to set option1
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    // Getter method to retrieve option2
    public String getOption2() {
        return option2;
    }

    // Setter method to set option2
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    // Getter method to retrieve option3
    public String getOption3() {
        return option3;
    }

    // Setter method to set option3
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    // Getter method to retrieve option4
    public String getOption4() {
        return option4;
    }

    // Setter method to set option4
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    // Getter method to retrieve the correct answer
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Setter method to set the correct answer
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

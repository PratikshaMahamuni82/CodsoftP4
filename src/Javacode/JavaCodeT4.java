package Javacode;

import java.util.Timer;

import java.util.TimerTask;

import java.util.Scanner;

import java.util.Collections;
class QuizQuestion {
 
  private String question;
  private String[] options;
  private String answer;

  public QuizQuestion(String question, String[] options, String answer) {
    this.question = question;
    this.options = options;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public String[] getOptions() {
    return options;
  }

  public String getAnswer() {
    return answer;
  }
}

public class JavaCodeT4{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    QuizQuestion[] quiz = {
      new QuizQuestion("What is the capital of India?", new String[]{"New Delhi", "Mumbai", "Kolkata", "Chennai"}, "New Delhi"),
      new QuizQuestion("Who is the current Prime Minister of India?", new String[]{"Narendra Modi", "Rahul Gandhi", "Arvind Kejriwal", "Mamata Banerjee"}, "Narendra Modi"),
      new QuizQuestion("Which of these is a programming language?", new String[]{"Python", "Cobra", "Anaconda", "Viper"}, "Python"),
      new QuizQuestion("Which of these is a unit of length?", new String[]{"Gram", "Litre", "Metre", "Newton"}, "Metre"),
      new QuizQuestion("Which of these is a planet in the solar system?", new String[]{"Pluto", "Jupiter", "Naboo", "Alderaan"}, "Jupiter")
    };

    int numQuestions = quiz.length;

    int timeLimit = 10;
    int score = 0;

    Collections.shuffle(java.util.Arrays.asList(quiz));
    for (QuizQuestion q : quiz) {
      Collections.shuffle(java.util.Arrays.asList(q.getOptions()));
    }
    for (int i = 0; i < numQuestions; i++) {
      System.out.println("Question " + (i + 1) + ": " + quiz[i].getQuestion());

      for (int j = 0; j < 4; j++) {
        System.out.println((char)(65 + j) + ". " + quiz[i].getOptions()[j]);
      }

      Timer timer = new Timer();

      TimerTask task = new TimerTask() {
        public void run() {
          System.out.println("Time is up!");
          timer.cancel();
        }
      };
      timer.schedule(task, timeLimit * 1000);
      System.out.println("Enter your answer (A, B, C, or D) within " + timeLimit + " seconds:");
      String userInput = "";
      while (true) {
        if (sc.hasNextLine()) {
        userInput = sc.nextLine().toUpperCase();

          if (userInput.matches("[A-D]")) {
           
            task.cancel();
            break;
          } else {
           
            System.out.println("Invalid input. Please enter A, B, C, or D:");
          }
        }
      }

      if (userInput.equals(quiz[i].getAnswer().substring(0, 1))) {
        score++;

        System.out.println("Correct!");
      } else {
      
        System.out.println("Incorrect! The correct answer is " + quiz[i].getAnswer());
      }
    }

    System.out.println("Your final score is " + score + " out of " + numQuestions);
    System.out.println("You answered " + score + " questions correctly and " + (numQuestions - score) + " questions incorrectly");
  }
}
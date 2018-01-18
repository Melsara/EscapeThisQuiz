package com.sardegnaisoladicavalli.escapethisquiz;

/**
 * Created by Sara on 18/01/2018.
 */

public class Question {

        private String questionText;
        private String firstAnswer, secondAnswer, thirdAnswer, fourthAnswer;
        private String answer;
        private String correctAnswer;


        public Question(
                int questionText,
                int firstAnswer,
                int secondAnswer,
                int thirdAnswer,
                int fourthAnswer,
                int correctAnswer) {

            this.questionText = questionText;
            this.firstAnswer = firstAnswer;
            this.secondAnswer = secondAnswer;
            this.thirdAnswer = thirdAnswer;
            this.fourthAnswer = fourthAnswer;
            this.correctAnswer = correctAnswer;
        }

        public Question(int question1, String earth, String pluto, String sun, String questionText, String correctAnswer) {
            this.questionText = questionText;
            this.answer = "";
            this.correctAnswer = correctAnswer;
        }

        public String getAnswer() {

            return answer;
        }

        public void setAnswer(String answer) {

            this.answer = answer;
        }


        public String getQuestionText() {

            return questionText;
        }

        public void setQuestionText(String questionText) {

            this.questionText = questionText;
        }

        public String getFirstAnswer() {

            return firstAnswer;
        }

        public void setFirstAnswer(String firstAnswer) {

            this.firstAnswer = firstAnswer;
        }

        public String getSecondAnswer() {

            return secondAnswer;
        }

        public void setSecondAnswer(String secondAnswer) {

            this.secondAnswer = secondAnswer;
        }

        public String getThirdAnswer() {

            return thirdAnswer;
        }

        public void setThirdAnswer(String thirdAnswer) {

            this.thirdAnswer = thirdAnswer;
        }

        public String getFourthAnswer() {

            return fourthAnswer;
        }

        public void setFourthAnswer(String fourthAnswer) {

            this.fourthAnswer = fourthAnswer;
        }

        public String getCorrectAnswer() {

            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {

            this.correctAnswer = correctAnswer;
        }

    }

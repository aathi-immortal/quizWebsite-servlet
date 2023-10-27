package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Question;

public class QuizDao {

    Connection connection;

    public ArrayList<Question> getQuiz() {

        getConnection();
        ArrayList<Question> questions = new ArrayList<>();

        // query to get the questions
        String query = "SELECT q.question_text, o.option_text, q.answer_option_id " +
                "FROM questions q " +
                "JOIN options o ON q.question_id = o.question_id";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String questionText = resultSet.getString("question_text");
                String questionOption = resultSet.getString("option_text");
                int questionAnswer = resultSet.getInt("answer_option_id");
                System.out.println(questionAnswer);
                Question existingQuestion = questions.stream()
                        .filter(q -> q.getQuestion().equals(questionText))
                        .findFirst()
                        .orElse(null);

                // if questoin is already present in the questions array
                // just add the option and solution
                if (existingQuestion != null) {
                    existingQuestion.getOptions().add(questionOption);
                    existingQuestion.setAnswer(questionAnswer);
                } else {
                    ArrayList<String> optioStrings = new ArrayList<>();
                    optioStrings.add(questionOption);

                    Question question = new Question();
                    question.setAnswer(questionAnswer);
                    question.setOptions(optioStrings);
                    question.setQuestion(questionText);
                    questions.add(question);
                }

            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return questions;

    }

    public void getConnection() {
        String JDBC_URL = "jdbc:postgresql://localhost:5432/quizWeb";
        String JDBC_USER = "postgres";
        String JDBC_PASSWORD = "password";
        try {

            Class.forName("org.postgresql.Driver");

            // Create a database connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("connected");
            // Execute a SQL query

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="model.Question" %>
            <%@ page import="database.QuizDao" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                        crossorigin="anonymous">
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&family=Roboto:wght@500&display=swap"
                        rel="stylesheet">
                    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
                        rel="stylesheet">
                    <link rel="stylesheet" href="style.css">
                    <script type="text/javascript">
                        src = ""   
                    </script>
                </head>

                <body>
                    <% QuizDao dao=new QuizDao(); ArrayList<Question> questions = dao.getQuiz();

                        int id = 1;


                        %>


                        <div class="app">
                            <h1> Quiz Time</h1>
                            <div class="quiz">
                                <% for (Question question : questions) { %>
                                    <div id="question-<%= id %>" class="question">
                                        <h4>
                                            <%= question.getQuestion() %>
                                        </h4>
                                        <div class="question-option">
                                            <% for (String option : question.getOptions()) { int opId=1; %>
                                                <button id="<%= id %>-op-<%= opId %>">
                                                    <%= option %>
                                                </button>
                                                <% opId++;} %>
                                        </div>
                                    </div>
                                    <% id++; %>
                                        <% } %>








                            </div>
                        </div>


                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                            crossorigin="anonymous"></script>


                </body>


                </html>
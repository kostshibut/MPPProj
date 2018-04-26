<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
    </head>
    <body>
    <style>
        body{
            background-color: gainsboro;
        }
        <%@include file="../_css/bootstrap.min.css"%>
        <%@include file="../_css/justified-nav.css"%>
        <%@include file="../js/bootstrap.min.js"%>
    </style>

    <div class="container">

        <div class="masthead">
            <h3 class="text-muted">Центр подготовки к ЦТ</h3>


            <ul class="nav nav-justified">
                <li> <a href="${contextPath}/start">Home</a> <br>
                    <c:if test="${loggedAdmin != null}">
                        admin ${loggedAdmin.userByUserUserId.login} <br>
                        <a href="${contextPath}/personalArea">Personal Area</a> <br>
                        <a href="/userControll">ControllUser</a>
                    </c:if></li>
                <li><a href="${contextPath}/subjectList">Subjects</a></li>
                <li><a href="${contextPath}/teacherList">Teachers</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="${contextPath}/signIn">Sign in</a></li>
            </ul>
        </div>

        <div class="jumbotron">
            <h1>Добро пожаловать к нам в центр подготовки к ЦТ</h1>
            <p class="lead">Мы готовим к ЦТ по русскому языку, белорусскому языку, английскому языку, математике, физике, химии, биоологии, обществоведению</p>
            <p><a class="btn btn-lg btn-success" href="signIn" role="button">Записаться на курс</a></p>
        </div>

        <!-- Example row of columns -->
        <div class="row">
            <div class="col-lg-4">
                <h2><img src="https://static.tildacdn.com/tild3666-3036-4630-a563-336337303461/11.svg" height="40px" width="40px">  Преподователи</h2>
                <p>Вас обучают опытные и профессиональные преподаватели. Стаж подготовки к ЦТ от 8 лет. Каждый преподаватель эксперт по своему предмету. Более 60% преподавателей - репетиторы </p>
                <p><a class="btn btn-primary" href="${contextPath}/teacherList" role="button">Список преподователей &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2><img src="https://static.tildacdn.com/tild3933-3538-4335-a436-326630353036/Tilda_Icons_1ed_brain.svg" height="40px" width="40px"> Качественные знания</h2>
                <p>Кто обучается в нашем центре в течение года набирают в среднем более 70 баллов на ЦТ.Мы гарантируем результат</p>
                <p><a class="btn btn-primary" href="#" role="button">Отзывы &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2><img src="https://static.tildacdn.com/tild3165-3332-4262-b162-623064306437/9.svg" height="40px" width="40px"> Удобное время и расположение</h2>
                <p>Занятия проходят по адресам Фабрициуса 9а и Притыцкого 34 и 29. Это в четырёх минутах от ст. метро Институт Культуры, Пушкинская и Спортивная. Также рядом ходит много автобусов и троллейбусов</p>
                <p><a class="btn btn-primary" href="${contextPath}/subjectList" role="button">Список предметов &raquo;</a></p>
            </div>
        </div>

        <!-- Site footer -->
        <div class="footer">
            <p>&copy; Якубович, Дудков , Шибут <br>
                БГУИР - ПОИТ, 2018</p>
        </div>

    </div> <!-- /container -->





    <a href="${contextPath}/start">back to start page</a> <br>
        <c:if test="${loggedAdmin != null}">
            admin ${loggedAdmin.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
            <a href="/userControll">ControllUser</a>
        </c:if>

        <c:if test="${loggedTeacher != null}">
             teacher ${loggedTeacher.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
            exclusive teacher content
        </c:if>

        <c:if test="${loggedScholar != null}">
            scholar ${loggedScholar.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
        </c:if>

        <c:if test="${loggedAdmin == null and loggedTeacher == null and loggedScholar == null or param.logout eq true}">
            <a href="${contextPath}/signUp">Sign Up</a> <br>
            <a href="${contextPath}/signIn">Sign In</a> <br>
        </c:if>

        <c:if test="${error != null}">
            ${error.name} <br>
            ${error.description} <br>
        </c:if>

        <br>
        <br>

     <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    </body>
</html>

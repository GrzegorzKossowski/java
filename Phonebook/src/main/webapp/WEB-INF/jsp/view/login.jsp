<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="../reuse/_header.jsp"></jsp:include>
            <form action="login" method="POST">
                <fieldset>
                    <legend>Login to Phonebook</legend>
                    <div class="error-msg">${errorMsg}</div>
                <label>Login</label><br/>
                <!--<input type="text" name="login" value="${login}" placeholder="mickey"><br>-->
                <input type="text" name="login" value="mickey" placeholder="mickey"><br>
                <label>Password</label><br/>
                <!--<input type="password" name="password" value="${password}" placeholder="mouse123">-->
                <input type="password" name="password" value="mouse123" placeholder="mouse123">
                <br><br>
                <input type="submit" value="Login">
            </fieldset>
        </form>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>
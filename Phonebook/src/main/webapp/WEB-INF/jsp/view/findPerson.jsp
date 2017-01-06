<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <title>Find Person</title>
    </head>
    <body>
        <jsp:include page="../reuse/_header.jsp"></jsp:include>
        <jsp:include page="../reuse/_topMenu.jsp"></jsp:include>        
            <form action="doFindPerson" method="POST">
                <fieldset>
                    <legend>Find Person in Phonebook</legend>
                    <label>First name</label><br/>
                    <input type="text" name="firstname" value="" placeholder="John"><br>
                    <label>Last name</label><br/>
                    <input type="text" name="lastname" value="" placeholder="Doe"><br>
                    <br><br>
                    <input type="submit" value="Seach" disabled="">
                </fieldset>
            </form>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>

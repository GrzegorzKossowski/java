<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <title>Add Person</title>
    </head>
    <body>
        <jsp:include page="../reuse/_header.jsp"></jsp:include>
        <jsp:include page="../reuse/_topMenu.jsp"></jsp:include>        
            <form action="doAddPerson" method="POST">
                <fieldset>
                    <legend>Add new Person to Phonebook</legend>
                    <label>First name</label><br/>
                    <input type="text" name="firstname" value="John"><br>
                    <label>Last name</label><br/>
                    <input type="text" name="lastname" value="Doe"><br>
                    <label>Phone</label><br/>
                    <input type="text" name="phone" value="48 228-789-654"><br>
                    <label>Mobile</label><br/>
                    <input type="text" name="mobile" value="48 792-258-852"><br>
                    <label>Email</label><br/>
                    <input type="email" name="email" value="johndoe@gamecon.com"><br>
                    <br><br>
                    <input type="submit" value="Submit">
                </fieldset>
            </form>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>

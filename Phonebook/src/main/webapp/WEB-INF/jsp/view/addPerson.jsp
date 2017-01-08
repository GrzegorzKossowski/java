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
                    <div class="error-msg">${errorMsg}</div>
                    <label>First name</label><br/>
                    <input type="text" name="firstname" value="" placeholder="John"><br>
                    <label>Last name</label><br/>
                    <input type="text" name="lastname" value="" placeholder="Doe"><br>
                    <label>Phone</label><br/>
                    <input type="text" name="phone" value="" placeholder="48 22 878965411"><br>
                    <label>Mobile</label><br/>
                    <input type="text" name="mobile" value="" placeholder="48 79 225885261"><br>
                    <label>Email</label><br/>
                    <input type="email" name="email" value="" placeholder="johndoe@gamecon.com"><br>
                    <br><br>
                    <input type="submit" value="Submit">
                </fieldset>
            </form>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>

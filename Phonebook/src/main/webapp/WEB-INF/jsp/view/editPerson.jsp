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
            <form action="doEditPerson" method="POST">
                <fieldset>
                    <legend>Add new Person to Phonebook</legend>
                    <input type="hidden" name="id" value="${person.id}" />
                    <label>First name</label><br/>
                    <input type="text" name="firstname" value="${person.firstname}"><br>
                    <label>Last name</label><br/>
                    <input type="text" name="lastname" value="${person.lastname}"><br>
                    <label>Phone</label><br/>
                    <input type="text" name="phone" value="${person.phone}"><br>
                    <label>Mobile</label><br/>
                    <input type="text" name="mobile" value="${person.mobile}"><br>
                    <label>Email</label><br/>
                    <input type="email" name="email" value="${person.email}"><br>
                    <br><br>
                    <input type="submit" value="Update">
                </fieldset>
            </form>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>
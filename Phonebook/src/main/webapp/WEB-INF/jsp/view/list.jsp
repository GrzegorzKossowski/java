<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <title>List</title>
    </head>
    <body>
        <jsp:include page="../reuse/_header.jsp"></jsp:include>
        <jsp:include page="../reuse/_topMenu.jsp"></jsp:include>

            <h1>List!</h1>

            <table>
                <tr>
                    <th>Contact</th>
                    <th>Action</th>                    
                </tr>
                <tr>
                    <td><a href="#">Adam Słodowy</a></td>
                    <td><a href="#" >Edit</a> | <a href="#" >Delete</a></td>
                </tr>
                <tr>
                    <td><a href="#">Cecylia Słaba</a></td>
                    <td><a href="#" >Edit</a> | <a href="#" >Delete</a></td>
                </tr>
            </table>



        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>

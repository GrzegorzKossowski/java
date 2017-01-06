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
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/showDetails?id=${person.id}">
                            <c:out default="error" value="${person.firstname} "/>
                            <c:out default="error" value="${person.lastname}"/>
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/editPerson?id=${person.id}" >Edit</a>
                        |
<!--                        <a href="${pageContext.request.contextPath}/deletePerson?id=${person.id}"
                           onclick="if (!(confirm('Delete?'))) return false">Delete</a></td>                           -->
                        <a href="${pageContext.request.contextPath}/deletePerson?id=${person.id}">Delete</a></td>                           
                </tr>                
            </c:forEach>            
        </table>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>
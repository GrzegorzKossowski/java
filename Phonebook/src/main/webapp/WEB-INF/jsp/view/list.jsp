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

        <c:choose>
            <c:when test="${empty persons}">
                There's no data to present.
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>Contact</th>
                        <th>Action</th>                    
                    </tr>
                    <c:forEach var="person" items="${persons}">
                        <tr>
                            <td>
                                <a href="${pageContext.request.contextPath}/showDetails?id=${person.id}">
                                    <c:out default="empty" value="${person.lastname} "/>
                                    <c:out default="empty" value="${person.firstname} "/>
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
            </c:otherwise>
        </c:choose>
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>
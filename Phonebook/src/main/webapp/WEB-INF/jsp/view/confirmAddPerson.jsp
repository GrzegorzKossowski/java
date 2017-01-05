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
        
        <h3>Person Added</h3>
        
        <a href="${pageContext.request.contextPath}/addPerson">Add new</a>
        
        <jsp:include page="../reuse/_footer.jsp"></jsp:include>
    </body>
</html>

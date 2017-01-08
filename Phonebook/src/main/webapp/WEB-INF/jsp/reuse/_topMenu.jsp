<div id="menu-bar">
    <a href="${pageContext.request.contextPath}/listPerson">List all</a>
    |
    <a href="${pageContext.request.contextPath}/addPerson">Add new</a>
    |
    <a href="${pageContext.request.contextPath}/findPerson">Find</a>
    <c:if test="${sessionScope.menu == true}">
    |
    <a href="${pageContext.request.contextPath}/doFindPerson?search=">Last search</a>        
    [<a href="${pageContext.request.contextPath}/doFindPerson?search=false">x</a>]
    </c:if>
</div>

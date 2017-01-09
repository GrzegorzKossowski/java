<jsp:include page="../reuse/_header.jsp"></jsp:include>
<jsp:include page="../reuse/_topMenu.jsp"></jsp:include>
    <h1>Show details!</h1>
    <table>
        <tr>
            <th>Person</th>
            <th>Phone</th>                    
            <th>Mobile</th>                    
            <th>Email</th>                    
        </tr>
        <tr>
            <td>
            <c:out default="empty" value="${person.firstname} "/>
            <c:out default="empty" value="${person.lastname}"/>
        </td>
        <td>
            <c:out default="empty" value="${person.phone}"/>
        </td>
        <td>
            <c:out default="empty" value="${person.mobile}"/>                        
        </td>
        <td>
            <c:out default="empty" value="${person.email}"/>                       
        </td>                
    </tr>                
</table>
<jsp:include page="../reuse/_footer.jsp"></jsp:include>
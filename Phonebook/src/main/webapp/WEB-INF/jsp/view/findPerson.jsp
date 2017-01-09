<jsp:include page="../reuse/_header.jsp"></jsp:include>
<jsp:include page="../reuse/_topMenu.jsp"></jsp:include>        
    <form action="doFindPerson" method="POST">
        <fieldset>
            <legend>Find Person in Phonebook</legend>
            <label>First name</label><br/>
            <input type="hidden" name="search" value="true">
            <input type="text" name="firstname" value="" placeholder="John"><br>
            <label>Last name</label><br/>
            <input type="text" name="lastname" value="" placeholder="Doe"><br>
            <br><br>
            <input type="submit" value="Seach" >
        </fieldset>
    </form>
<jsp:include page="../reuse/_footer.jsp"></jsp:include>
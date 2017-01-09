<jsp:include page="../reuse/_header.jsp"></jsp:include>
    <form action="login" method="POST">
        <fieldset>
            <legend>Login to Phonebook</legend>
            <div class="error-msg">${errorMsg}</div>
        <label>Login</label><br/>
        <!--<input type="text" name="login" value="tom" placeholder="tom" pattern="([A-Za-z0-9])\w+" title="Ex: mickey" autofocus required><br>-->
        <input type="text" name="login" value="${login}" placeholder="tom" pattern="([A-Za-z0-9])\w+" title="Ex: mickey" autofocus required><br>
        <label>Password</label><br/>
        <!--<input type="password" name="password" value="tom001" placeholder="tom001">-->
        <input type="password" name="password" value="${password}" placeholder="tom001">
        <br><br>
        <input type="submit" value="Login">
    </fieldset>
</form>    
<div id="comments">
    Avaiable logins: tom (tom001), jerry (jerry001), mickey (mouse123)</div>
<jsp:include page="../reuse/_footer.jsp"></jsp:include>

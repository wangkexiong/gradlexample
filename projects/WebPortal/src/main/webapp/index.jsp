<!DOCTYPE HTML>
<html>
    <FORM METHOD=POST ACTION="submit">
        What's your name? <INPUT TYPE=TEXT NAME=username SIZE=20><BR>
        What's your  age? <INPUT TYPE=TEXT NAME=age SIZE=4><P>
        <INPUT TYPE=SUBMIT>
    </FORM>

    <% String info = (String)session.getAttribute("info"); %>
    <% if (info != null) {%>
        <%= info %>
    <% } %>
</html>

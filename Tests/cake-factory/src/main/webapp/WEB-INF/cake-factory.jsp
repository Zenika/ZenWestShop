<%@ page import="com.zenika.cakefactory.produits.sousproduits.Gateau" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cake Factory Control Center</title>
</head>
<body>

<h1>Cake Factory Control Center</h1>

<div>
    <form id="zeForm" action="/" method="POST">
        <input type="submit" value="Gogo gadget au gateau !"/>
    </form>

    <br/>
    Gateau : <br/>

    <div id="zeCake">
        <%
            Gateau gateau = (Gateau) request.getAttribute("gateau");
            if (gateau != null) {
                String gateauAsStr = gateau.toString().replaceAll("\n", "<br/>");
                out.print(gateauAsStr);
            }
        %>
    </div>
</div>

</body>
</html>

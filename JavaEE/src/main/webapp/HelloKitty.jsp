<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*"
%>

<html>
<head>
    <title>Hello Kitty</title>
</head>
<body style="font-size: 30px;">

    time:<%
        Date date = new Date();
        out.print(date);
    %>

    <%
        for(int i = 0; i < 100; i++) {
            out.println("第" + i + "次的Hello Kitty!");
        }
    %>
</body>
</html>
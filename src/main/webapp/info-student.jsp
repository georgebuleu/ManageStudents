<html xmlns:jsp="http://java.sun.com/JSP/Page">
    <head>
        <title>Informatii student</title>
    </head>
    <body>
        <h3>Informatii student</h3>
        <!-- populare bean cu informatii din cererea HTTP -->
        <jsp:useBean id="studentBean" class="beans.StudentBean"/>
        <jsp:setProperty name="studentBean" property="name" value='<%=request.getAttribute("nume") %>'/>
        <jsp:setProperty name="studentBean" property="surname" value='<%=request.getAttribute("prenume") %>'/>
        <jsp:setProperty name="studentBean" property="age" value='<%=request.getAttribute("varsta") %>'/>

        <jsp:setProperty name="studentBean" property="id" value='<%=request.getAttribute("nr-matricol") %>'/>
        <jsp:setProperty name="studentBean" property="year" value='<%=request.getAttribute("an-studiu") %>'/>
        <jsp:setProperty name="studentBean" property="college" value='<%=request.getAttribute("facultate") %>'/>

        <!-- folosirea bean-ului pentru afisarea informatiilor -->
        <p>Urmatoarele informatii au fost introduse:</p>

        <ul type="bullet">

            <li>Numar matricol: <jsp:getProperty name="studentBean" property="id" /></li>
            <li>Facultate: <jsp:getProperty name="studentBean" property="college" /></li>
                        <li>Anul de studiu: <jsp:getProperty name="studentBean" property="year" /></li>

            <li>Nume: <jsp:getProperty name="studentBean" property="name" /></li>
            <li>Prenume: <jsp:getProperty name="studentBean" property="surname" /></li>
            <li>Varsta: <jsp:getProperty name="studentBean" property="age" /></li>
            <li>Anul nasterii: <%
            Object anNastere = request.getAttribute("anNastere");
                if (anNastere != null) {
                 out.print(anNastere);
                } else {
                 out.print("necunoscut");
            }
            %> </li>


        </ul>
    </body>
</html>
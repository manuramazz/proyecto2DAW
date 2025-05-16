<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Página de Error</title>
    </head>
    <body>
        <h2>Error</h2>
        <p>Ha ocurrido un error al procesar su solicitud.</p>
        <p><a href="checkout.jsp">Volver</a></p>

        <c:if test="${not empty error}">
            <p>Error: ${error}</p>
        </c:if>

        <c:if test="${not empty exception}">
            <p>Detalles del error: ${exception.message}</p>
        </c:if>
    </body>
</html>
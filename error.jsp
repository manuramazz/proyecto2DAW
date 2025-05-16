<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Página de Error</title>
  <style>
    body { font-family: Arial, sans-serif; background: #fee; color: #900; }
    main { max-width: 500px; margin: 2rem auto; background: #fff; padding: 1.5rem; border: 1px solid #f99; border-radius: 6px; }
    h2 { margin-top: 0; }
    p { line-height: 1.4; }
    a { color: #900; text-decoration: none; font-weight: bold; }
    a:hover { text-decoration: underline; }
  </style>
</head>
<body>
  <main>
    <h2>Error</h2>
    <p>Ha ocurrido un error al procesar su solicitud.</p>
    <c:if test="${not empty error}">
      <p><strong>Error:</strong> ${error}</p>
    </c:if>
    <c:if test="${not empty exception}">
      <p><strong>Detalles:</strong> ${exception.message}</p>
    </c:if>
    <p><a href="checkout.jsp">Volver</a></p>
  </main>
</body>
</html>

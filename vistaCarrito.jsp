<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Carrito</title></head>
<body>
  <h2>Tu Carrito</h2>
  <c:choose>
    <c:when test="${empty sessionScope.carrito.items}">
      <p>El carrito está vacío.</p>
      <p>
        <a href="index.html">Volver a comprar</a>
      </p>
    </c:when>
    <c:otherwise>
      <table border="1" cellpadding="5">
        <tr>
          <th>Titulo</th><th>Artista</th><th>Pais</th>
          <th>Precio U.</th><th>Cantidad</th><th>Importe</th><th>Quitar</th>
        </tr>
        <c:forEach var="item" items="${sessionScope.carrito.items}">
          <tr>
            <td>${item.titulo}</td>
            <td>${item.artista}</td>
            <td>${item.pais}</td>
            <td>${item.precio}</td>
            <td>${item.cantidad}</td>
            <td>${item.importeFormateado}</td>
            <td>
              <form action="EliminarItem" method="post" style="margin:0">
                <input type="hidden" name="titulo" value="${item.titulo}">
                <input type="submit" value="X">
              </form>
            </td>
          </tr>
        </c:forEach>
        <tr>
          <td colspan="5" align="right"><strong>Total:</strong></td>
          <td colspan="2">${sessionScope.carrito.totalFormateado}</td>
        </tr>
      </table>
      <p>
        <a href="checkout.jsp">Pagar</a> |
        <a href="index.html">Seguir comprando</a>
      </p>
    </c:otherwise>
  </c:choose>
</body>
</html>
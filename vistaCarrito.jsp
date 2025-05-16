<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Tu Carrito</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f9f9f9; color: #333; }
    main { max-width: 800px; margin: 2rem auto; background: #fff; padding: 1.5rem; box-shadow: 0 0 8px rgba(0,0,0,0.1); border-radius: 6px; }
    h2 { margin-top: 0; }
    table { width: 100%; border-collapse: collapse; margin: 1rem 0; }
    th, td { padding: .75rem; border: 1px solid #ddd; text-align: left; }
    th { background: #0077cc; color: #fff; }
    a.button {
      display: inline-block;
      padding: .5rem 1rem;
      margin: .5rem 0;
      background: #0077cc;
      color: white;
      text-decoration: none;
      border-radius: 4px;
    }
    a.button:hover { background: #005fa3; }
  </style>
</head>
<body>
  <main>
    <h2>Tu Carrito</h2>
    <c:choose>
      <c:when test="${empty sessionScope.carrito.items}">
        <p>El carrito está vacío.</p>
        <p><a href="index.html" class="button">Volver a comprar</a></p>
      </c:when>
      <c:otherwise>
        <table>
          <tr>
            <th>Título</th><th>Artista</th><th>País</th>
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
                  <input type="submit" value="X" style="background:#e74c3c;color:white;border:none;padding:.25rem .5rem;border-radius:4px;cursor:pointer;">
                </form>
              </td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="5" style="text-align:right;font-weight:bold">Total:</td>
            <td colspan="2">${sessionScope.carrito.totalFormateado}</td>
          </tr>
        </table>
        <p>
          <a href="checkout.jsp" class="button">Pagar</a>
          <a href="index.html" class="button">Seguir comprando</a>
        </p>
      </c:otherwise>
    </c:choose>
  </main>
</body>
</html>

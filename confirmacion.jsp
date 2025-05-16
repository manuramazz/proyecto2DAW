<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Confirmación de pedido realizado</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f9f9f9; color: #333; }
    main { max-width: 700px; margin: 2rem auto; background: #fff; padding: 1.5rem; box-shadow: 0 0 8px rgba(0,0,0,0.1); border-radius: 6px; }
    h2 { margin-top: 0; }
    p { line-height: 1.4; }
    table { width: 100%; border-collapse: collapse; margin: 1rem 0; }
    th, td { padding: .75rem; border: 1px solid #ddd; }
    th { background: #0077cc; color: #fff; }
    a.button {
      display: inline-block;
      margin-top: 1rem;
      padding: .5rem 1rem;
      background: #0077cc;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
    }
  </style>
</head>
<body>
  <main>
    <h2>Pedido realizado</h2>
    <p>Gracias por su compra. Su pedido con código <strong>${pedido.id}</strong> se ha enviado a <strong>${pedido.email}</strong>.</p>
    <p>Método de pago: <strong>Tarjeta ${usuario.tarjeta_tipo}</strong> (**** **** **** ${usuario.tarjeta_numero.substring(usuario.tarjeta_numero.length()-4)})</p>

    <p>Detalles del pedido:</p>
    <table>
      <tr>
        <th>Título</th><th>Artista</th><th>País</th>
        <th>Precio U.</th><th>Cantidad</th><th>Importe</th>
      </tr>
      <c:forEach var="item" items="${sessionScope.carrito.items}">
        <tr>
          <td>${item.titulo}</td><td>${item.artista}</td><td>${item.pais}</td>
          <td>${item.precio}</td><td>${item.cantidad}</td><td>${item.importeFormateado}</td>
        </tr>
      </c:forEach>
      <tr>
        <td colspan="5" style="text-align:right;font-weight:bold">Total:</td>
        <td>${sessionScope.carrito.totalFormateado}</td>
      </tr>
    </table>

    <c:if test="${not empty sessionScope.carrito}">
      <c:remove var="carrito" scope="session"/>
    </c:if>

    <p><a href="index.html" class="button">Volver a la página principal</a></p>
  </main>
</body>
</html>

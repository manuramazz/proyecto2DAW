<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Confirmación de pedido realizado</title>
</head>
<body>
    <h2>Pedido realizado</h2>
    <p>Gracias por su compra. Su pedido con código <strong>${pedido.id}</strong> se ha enviado a <strong>${pedido.email}</strong>.</p>
    <p>Método de pago utilizado: tarjeta ${usuario.tarjeta_tipo} con número ${usuario.tarjeta_numero}</p>
    <p>Detalles del pedido:</p>
    <table border="1" cellpadding="5">
        <tr>
            <th>Título</th><th>Artista</th><th>País</th>
            <th>Precio U.</th><th>Cantidad</th><th>Importe</th>
        </tr>

        <c:forEach var="item" items="${sessionScope.carrito.items}">
            <tr>
                <td>${item.titulo}</td>
                <td>${item.artista}</td>
                <td>${item.pais}</td>
                <td>${item.precio}</td>
                <td>${item.cantidad}</td>
                <td>${item.importeFormateado}</td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="5" align="right"><strong>Total:</strong></td>
            <td>${sessionScope.carrito.totalFormateado}</td>
        </tr>
    </table>

    <c:if test="${not empty sessionScope.carrito}">
        <c:remove var="carrito" scope="session"/>
    </c:if>

    <p><a href="index.html">Volver a la página principal</a></p>

</body>
</html>

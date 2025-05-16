<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Confirmar Compra</title>
</head>
<body>
  <h2>Confirmar compra</h2>

  <form method="post" action="Confirmacion">
    <label for="email">Correo electrónico:</label><br>
    <input type="email" name="email" required><br><br>

    <label for="contrasena">Contraseña:</label><br>
    <input type="password" name="contrasena" required><br><br>

    <div id="registro" style="display:none;">
        <label for="tarjeta_tipo">Tipo de tarjeta:</label><br>
        <input class="tarjeta" type="text" name="tarjeta_tipo"><br><br>
        <label for="tarjeta_numero">Número de tarjeta:</label><br>
        <input class="tarjeta" type="text" name="tarjeta_numero"><br><br>
    </div>

    <button type="button" id="botonRegistro" onclick="mostrarRegistro()">Registrarse</button>
    <button type="button" id="botonInicioSesion" style="display:none;" onclick="mostrarInicioSesion()">Ya estás registrado? Inicia sesión</button>
    <br><br>
    <p>Importe total a pagar: <strong>${sessionScope.carrito.totalFormateado}</strong></p>
    <input type="submit" value="Confirmar Compra">
    
  </form>
  <p><a href="vistaCarrito.jsp">Cancelar</a></p>
  
</body>
<script>
    function mostrarRegistro() {
      document.getElementById("registro").style.display = "block";
      document.getElementById("botonRegistro").style.display = "none";
      document.getElementById("botonInicioSesion").style.display = "block";
      //hacer los campos de tarjeta obligatorios
      var tarjeta = document.getElementsByClassName("tarjeta");
      for (var i = 0; i < tarjeta.length; i++) {
        tarjeta[i].setAttribute("required", "required");
      }
    }
    function mostrarInicioSesion() {
      document.getElementById("registro").style.display = "none";
      document.getElementById("botonRegistro").style.display = "block";
      document.getElementById("botonInicioSesion").style.display = "none";
      //hacer los campos de tarjeta no obligatorios
      var tarjeta = document.getElementsByClassName("tarjeta");
      for (var i = 0; i < tarjeta.length; i++) {
        tarjeta[i].removeAttribute("required");
      }
    }
  </script>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Confirmar Compra</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f2f2f2; color: #333; }
    main { max-width: 500px; margin: 2rem auto; background: #fff; padding: 1.5rem; box-shadow: 0 0 8px rgba(0,0,0,0.1); border-radius: 6px; }
    h2 { margin-top: 0; }
    label { display: block; margin-top: 1rem; font-weight: bold; }
    input[type="email"], input[type="password"], input[type="text"] {
      width: 100%; padding: .5rem; margin-top: .5rem; border: 1px solid #ccc; border-radius: 4px;
    }
    .tarjeta { width: calc(50% - .5rem); display: inline-block; }
    button, input[type="submit"] {
      margin-top: 1rem; padding: .75rem 1.5rem; border: none; border-radius: 4px; cursor: pointer;
    }
    button { background: #999; color: #fff; }
    button:hover { background: #777; }
    input[type="submit"] { background: #0077cc; color: #fff; }
    input[type="submit"]:hover { background: #005fa3; }
    .actions { display: flex; justify-content: space-between; align-items: center; }
    .actions p { margin: 1rem 0 0; }
    #cancelar:link { text-align: center; color: black;}
    #cancelar:visited { text-align: center; color: black;}
  </style>
</head>
<body>
  <main>
    <h2>Confirmar compra</h2>

    <form method="post" action="Confirmacion">
      <label for="email">Correo electrónico:</label>
      <input type="email" name="email" required>

      <label for="contrasena">Contraseña:</label>
      <input type="password" name="contrasena" required>

      <div id="registro" style="display:none; margin-top:1rem;">
        <label for="tarjeta_tipo">Tipo de tarjeta:</label>
        <input class="tarjeta" type="text" name="tarjeta_tipo">

        <label for="tarjeta_numero">Número de tarjeta:</label>
        <input class="tarjeta" type="text" name="tarjeta_numero">
      </div>

      <div class="actions">
        <button type="button" id="botonRegistro" onclick="mostrarRegistro()">Registrarse</button>
        <button type="button" id="botonInicioSesion" style="display:none;" onclick="mostrarInicioSesion()">Iniciar sesión</button>
        <p>Importe: <strong>${sessionScope.carrito.totalFormateado}</strong></p>
        <input type="submit" value="Confirmar Compra">
      </div>
    </form>

    <p id="cancelar" style="text-align:center;"><a href="vistaCarrito.jsp">Cancelar</a></p>
  </main>

  <script>
    function mostrarRegistro() {
      document.getElementById("registro").style.display = "block";
      document.getElementById("botonRegistro").style.display = "none";
      document.getElementById("botonInicioSesion").style.display = "inline-block";
      document.querySelectorAll(".tarjeta").forEach(i => i.setAttribute("required","required"));
    }
    function mostrarInicioSesion() {
      document.getElementById("registro").style.display = "none";
      document.getElementById("botonRegistro").style.display = "inline-block";
      document.getElementById("botonInicioSesion").style.display = "none";
      document.querySelectorAll(".tarjeta").forEach(i => i.removeAttribute("required"));
    }
  </script>
</body>
</html>

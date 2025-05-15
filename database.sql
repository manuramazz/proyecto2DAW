CREATE DATABASE minitienda;
USE minitienda;
CREATE TABLE usuarios (
  email VARCHAR(100) PRIMARY KEY,
  contrasena VARCHAR(100) NOT NULL,
  tarjeta_tipo VARCHAR(50),
  tarjeta_numero VARCHAR(50)
);
-- Tabla de pedidos con email como clave foránea
CREATE TABLE pedidos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_email VARCHAR(100),
  total DECIMAL(10,2),
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (usuario_email) REFERENCES usuarios(email)
);
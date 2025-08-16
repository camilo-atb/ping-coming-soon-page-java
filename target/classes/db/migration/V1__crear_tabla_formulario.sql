CREATE TABLE IF NOT EXISTS formulario (
    id BIGSERIAL PRIMARY KEY,
    correo VARCHAR(50) NOT NULL,
    fecha_de_ingreso TIMESTAMP NOT NULL
);

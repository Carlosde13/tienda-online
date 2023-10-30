CREATE TABLE cliente(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR (50),
    telefono VARCHAR (10),
    email VARCHAR (55),
    fecha_ingreso DATE
);
CREATE TABLE producto(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descripcion VARCHAR (100),
    cantidad NUMBER,
    fecha_ingreso DATE
);

CREATE TABLE estado(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descripcion VARCHAR(75)
);
CREATE TABLE pedido(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    cliente_id NUMBER,
    estado_id NUMBER,
    fecha DATE,
    
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (estado_id) REFERENCES estado(id)
);

CREATE TABLE descripcion_pedido(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    pedido_id NUMBER,
    producto_id NUMBER,
    
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (producto_id) REFERENCES producto(id)
);

SELECT * FROM producto WHERE cantidad > 0;


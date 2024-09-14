use firstroom;
CREATE TABLE usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50),
  email VARCHAR(50) UNIQUE,
  senha VARCHAR(100)
);

CREATE TABLE sala (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50),
  capacidade INT
);

CREATE TABLE reserva (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  sala_id INT,
  data_reserva DATE,
  hora_inicio TIME,
  hora_fim TIME,
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  FOREIGN KEY (sala_id) REFERENCES sala(id)
);

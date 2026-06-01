CREATE TABLE regiao_monitorada (
                                   id_regiao INT PRIMARY KEY,
                                   nome VARCHAR(100) NOT NULL,
                                   cidade VARCHAR(100) NOT NULL,
                                   estado CHAR(2) NOT NULL,
                                   tipo_risco VARCHAR(50) NOT NULL,
                                   nivel_risco VARCHAR(20) NOT NULL
);

CREATE TABLE satelite (
                          id_satelite INT PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          agencia VARCHAR(100) NOT NULL,
                          tipo_monitoramento VARCHAR(100) NOT NULL,
                          ativo CHAR(1) NOT NULL
);

CREATE TABLE alerta (
                        id_alerta INT PRIMARY KEY,
                        id_regiao INT NOT NULL,
                        id_satelite INT NOT NULL,
                        tipo_alerta VARCHAR(100) NOT NULL,
                        descricao VARCHAR(255) NOT NULL,
                        data_alerta DATE NOT NULL,
                        status VARCHAR(30) NOT NULL,

                        CONSTRAINT fk_alerta_regiao
                            FOREIGN KEY (id_regiao)
                                REFERENCES regiao_monitorada(id_regiao),

                        CONSTRAINT fk_alerta_satelite
                            FOREIGN KEY (id_satelite)
                                REFERENCES satelite(id_satelite)
);
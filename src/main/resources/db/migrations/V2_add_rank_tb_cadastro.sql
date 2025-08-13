-- Migration para adicionar a coluna rank

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
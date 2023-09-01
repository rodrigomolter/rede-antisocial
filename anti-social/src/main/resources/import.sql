INSERT INTO Instrutor (idInstrutor, nome) VALUES (INSTRUTOR_SEQ.NEXTVAL, 'Marlon Bernardes');

INSERT INTO Instrutor (idInstrutor, nome) VALUES (INSTRUTOR_SEQ.NEXTVAL, 'Marlon Bernardes');
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 9, 'JDBC', INSTRUTOR_SEQ.CURRVAL);
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 7, 'Spring', INSTRUTOR_SEQ.CURRVAL);
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 9, 'Java Web', INSTRUTOR_SEQ.CURRVAL);

INSERT INTO Instrutor (idInstrutor, nome) VALUES (INSTRUTOR_SEQ.NEXTVAL, 'André Nunes');
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 9, 'SQL', INSTRUTOR_SEQ.CURRVAL);
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 7, 'DDL', INSTRUTOR_SEQ.CURRVAL);
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 8, 'Oracle', INSTRUTOR_SEQ.CURRVAL);

INSERT INTO Instrutor (idInstrutor, nome) VALUES (INSTRUTOR_SEQ.NEXTVAL, 'Bernardo Rezende');
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 8, 'jQuery', INSTRUTOR_SEQ.CURRVAL);
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 3, 'HTML', INSTRUTOR_SEQ.CURRVAL);
INSERT INTO Disciplina (idDisciplina, dificuldade, nome, idInstrutor) values (DISCIPLINA_SEQ.NEXTVAL, 5, 'CSS', INSTRUTOR_SEQ.CURRVAL);

INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (1,'00/00/0000','teste','teste','teste','teste','teste', '/resources/img/teste.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (2,'06/06/1937','carneiro@emai.com','Masculino','Campinas','Carneiro Eletrico','senha123', '/resources/img/carneiro.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (3,'10/03/1960','aecio@email.com','Masculino','Belo Horizonte','Aecio Neves','senha123', '/resources/img/aecio.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (4,'14/12/1947','dilma@email.com','Feminino','Porto Alegre','Dilma Rousseff','senha123', '/resources/img/dilma.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (5,'27/12/1951','levy@email.com','Masculino','Aerotrem','Levy Fidelix','senha123', '/resources/img/levy.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (6,'5/11/1938','eneas@email.com','Masculino','Rio Branco','Eneas','senha123', '/resources/img/eneas.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (7,'19/12/1988','marlon@email.com','Masculino','Porto Alegre','Marlon Bernardes','senha123', '/resources/img/marlon.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (8,'17/10/1982','andre@email.com','Masculino','Parobe','Andre Nunes','senha123', '/resources/img/andre.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (9,'12/10/1987','bernardo@email.com','Masculino','Porto Alegre','Bernardo Rezende','senha123', '/resources/img/bernardo.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (10,'27/10/1945','lula@email.com','Masculino','Brasilia','Luis Inacio Lula da Silva','senha123', '/resources/img/lula.jpg');
INSERT INTO Usuario (idUsuario, datanascimento, email, genero, localizacao, nome, senha, avatar) values (11,'12/09/1990','dollynho@email.com','Transexual','Dollyland','Dollynho','senha123', '/resources/img/dollynho.png');


INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (1,2,1);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (2,2,11);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (3,11,2);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (4,3,4);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (5,4,3);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (6,6,2);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (7,6,2);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (8,6,2);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (9,6,2);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (10,6,11);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (11,2,6);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (12,11,6);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (13,9,7);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (14,9,8);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (15,7,9);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (16,7,8);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (17,8,7);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (18,8,9);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (19,5,4);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (20,5,3);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (21,10,4);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (22,10,3);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (23,11,9);
INSERT INTO UsuarioAmigo (id, idUsuario, idUsuarioAmigo) values (23,9,11);

INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (1,11,'Nao sejam levianas candidatas #BornToBeLeviana', 3);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (2,5,'Chora pro #Pronatec',4);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (3,3,'Essas levianas com proposta igual as ja criadas no meu governo #imitona', 3);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (4,34,'Aeromtrem is life, aerotrem is love #aerotrem', 5);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (5,0,'zzzzzzz',2);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (6,0,'/\ MEU NOME',6);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (7,2,'Ahhh meeeeeeeeeeeo',7);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (8,0,'A mascada, o louva deus, o bom jesus,o carpinejar #illuminati',9);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (9,0,'Meeeeeeeeeeeu',7);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (10,4,'oi, eu sou o dollynho, o seu amiguinho #dollyndo',11);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (11,0,'quero um #dollyndo',10);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (12,2,'#CERVEJA > #DOLLYNHO',9);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (13,0,'Ahh meeeeeeeu....',7);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (14,25,'Ah pessoal, sql vai ser facil',8);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (15,2,'Cerveja illuminati > all',9);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (16,1,'Camigol',9);
INSERT INTO Postagem (idPostagem, descurtidas, mensagem, idusuario) values (17,1,'Companheiros e companheiras',10);


INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (1,1,4);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (2,2,3);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (3,3,4);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (4,4,3);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (5,4,4);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (6,4,10);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (7,10,9);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (9,12,11);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (10,12,10);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (11,15,10);
INSERT INTO DescurtidaUsuario (iddescurtidausuario, idpostagem, idusuario) values (12,8,7);

INSERT INTO Hashtag (idHashtag, nome) values (1, '#BornToBeLeviana');
INSERT INTO Hashtag (idHashtag, nome) values (2, '#Pronatec');
INSERT INTO Hashtag (idHashtag, nome) values (3, '#imitona');
INSERT INTO Hashtag (idHashtag, nome) values (4, '#aerotrem');
INSERT INTO Hashtag (idHashtag, nome) values (5, '#illuminati');
INSERT INTO Hashtag (idHashtag, nome) values (6, '#dollyndo');
INSERT INTO Hashtag (idHashtag, nome) values (7, '#CERVEJA');
INSERT INTO Hashtag (idHashtag, nome) values (8, '#DOLLYNHO');

INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (1, 1, 4);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (2, 2, 3);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (3, 3, 4);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (4, 4, 3);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (5, 4, 4);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (6, 4, 10);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (7, 6, 9);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (8, 7, 11);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (9, 8, 11);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (10, 7, 10);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (11, 8, 10);
INSERT INTO HashtagProibida (idHashtagProibida, idHashtag, idUsuario) values (12, 5, 7);

INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (1, 1, 1);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (2, 2, 2);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (3, 3, 3);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (4, 4, 4);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (5, 5, 8);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (6, 6, 10);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (6, 6, 11);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (7, 7, 12);
INSERT INTO HashtagPostagem (idHashtagPostagem, idHashtag, idPostagem) values (8, 8, 12);

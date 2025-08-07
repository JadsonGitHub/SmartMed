-- =============================
-- FORMAS DE PAGAMENTO (5)
-- =============================
INSERT INTO forma_pagamento (id, descricao)
VALUES (1, 'Dinheiro');
INSERT INTO forma_pagamento (id, descricao)
VALUES (2, 'Cartão de Débito');
INSERT INTO forma_pagamento (id, descricao)
VALUES (3, 'Cartão de Crédito');
INSERT INTO forma_pagamento (id, descricao)
VALUES (4, 'PIX');
INSERT INTO forma_pagamento (id, descricao)
VALUES (5, 'Convênio Médico');

-- =============================
-- ESPECIALIDADES MÉDICAS (12)
-- =============================
INSERT INTO especialidade (id, nome, descricao)
VALUES (1, 'Cardiologia',
        'Especialidade médica que se ocupa do diagnóstico e tratamento das doenças que acometem o coração');
INSERT INTO especialidade (id, nome, descricao)
VALUES (2, 'Dermatologia',
        'Especialidade médica que se ocupa do diagnóstico, tratamento e prevenção de doenças da pele');
INSERT INTO especialidade (id, nome, descricao)
VALUES (3, 'Ginecologia', 'Especialidade médica que trata da saúde do aparelho reprodutor feminino');
INSERT INTO especialidade (id, nome, descricao)
VALUES (4, 'Neurologia', 'Especialidade médica que trata dos distúrbios estruturais do sistema nervoso');
INSERT INTO especialidade (id, nome, descricao)
VALUES (5, 'Ortopedia',
        'Especialidade médica que cuida do aparelho locomotor: ossos, músculos, ligamentos e articulações');
INSERT INTO especialidade (id, nome, descricao)
VALUES (6, 'Pediatria', 'Especialidade médica dedicada à assistência à criança e ao adolescente');
INSERT INTO especialidade (id, nome, descricao)
VALUES (7, 'Psiquiatria',
        'Especialidade médica que lida com a prevenção, diagnóstico e tratamento de transtornos mentais');
INSERT INTO especialidade (id, nome, descricao)
VALUES (8, 'Urologia',
        'Especialidade médica que trata do trato urinário de homens e mulheres e do sistema reprodutor masculino');
INSERT INTO especialidade (id, nome, descricao)
VALUES (9, 'Oftalmologia', 'Especialidade médica que investiga e trata as doenças relacionadas aos olhos');
INSERT INTO especialidade (id, nome, descricao)
VALUES (10, 'Otorrinolaringologia',
        'Especialidade médica que cuida dos ouvidos, nariz, seios paranasais, faringe e laringe');
INSERT INTO especialidade (id, nome, descricao)
VALUES (11, 'Endocrinologia', 'Especialidade médica que cuida dos transtornos das glândulas endócrinas');
INSERT INTO especialidade (id, nome, descricao)
VALUES (12, 'Clínica Geral',
        'Especialidade médica que proporciona atenção contínua e abrangente ao indivíduo e família');

-- =============================
-- CONVÊNIOS (10)
-- =============================
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Unimed', '12345678000195', '11987654321', 'contato@unimed.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Bradesco Saúde', '23456789000186', '11876543210', 'atendimento@bradescosaude.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('SulAmérica Saúde', '34567890000177', '11765432109', 'sac@sulamerica.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Amil', '45678901000168', '11654321098', 'central@amil.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('NotreDame Intermédica', '56789012000159', '11543210987', 'relacionamento@gndi.com.br', FALSE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Hapvida', '67890123000140', '11432109876', 'atendimento@hapvida.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Golden Cross', '78901234000131', '11321098765', 'sac@goldencross.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Prevent Senior', '89012345000122', '11210987654', 'central@preventsenior.com.br', FALSE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('São Cristóvão Saúde', '90123456000113', '11109876543', 'relacionamento@saocristovao.com.br', TRUE);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo)
VALUES ('Cassi', '01234567000104', '11098765432', 'ouvidoria@cassi.com.br', TRUE);

-- =============================
-- MÉDICOS (15)
-- =============================
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Carlos Silva', '12345-SP', '11987654321', 'carlos.silva@email.com', 250.00, TRUE, 1);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Ana Santos', '23456-RJ', '21876543210', 'ana.santos@email.com', 200.00, TRUE, 2);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Maria Oliveira', '34567-MG', '31765432109', 'maria.oliveira@email.com', 180.00, TRUE, 3);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. João Pereira', '45678-RS', '51654321098', 'joao.pereira@email.com', 300.00, TRUE, 4);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Pedro Costa', '56789-PR', '41543210987', 'pedro.costa@email.com', 220.00, TRUE, 5);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Julia Lima', '67890-SC', '47432109876', 'julia.lima@email.com', 160.00, TRUE, 6);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Rafael Souza', '78901-BA', '71321098765', 'rafael.souza@email.com', 280.00, TRUE, 7);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Lucas Alves', '89012-PE', '81210987654', 'lucas.alves@email.com', 240.00, TRUE, 8);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Fernanda Rocha', '90123-GO', '62109876543', 'fernanda.rocha@email.com', 190.00, TRUE, 9);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Ricardo Dias', '01234-DF', '61098765432', 'ricardo.dias@email.com', 210.00, TRUE, 10);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Camila Martins', '11111-CE', '85987654321', 'camila.martins@email.com', 200.00, TRUE, 11);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Bruno Ferreira', '22222-ES', '27876543210', 'bruno.ferreira@email.com', 150.00, TRUE, 12);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Leticia Gomes', '33333-SP', '11765432100', 'leticia.gomes@email.com', 220.00, FALSE, 1);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dr. Gabriel Ribeiro', '44444-RJ', '21654321000', 'gabriel.ribeiro@email.com', 270.00, TRUE, 4);
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeid)
VALUES ('Dra. Beatriz Nunes', '55555-MG', '31543210000', 'beatriz.nunes@email.com', 180.00, TRUE, 6);

-- =============================
-- RECEPCIONISTAS (10)
-- =============================
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Amanda Silva', '12345678901', '1995-03-15', '2022-01-10', NULL, '11987654321', 'amanda.silva@smartmed.com.br',
        TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Carla Santos', '23456789012', '1988-07-22', '2021-05-20', NULL, '11876543210', 'carla.santos@smartmed.com.br',
        TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Fernanda Costa', '34567890123', '1992-11-08', '2023-02-14', NULL, '11765432109',
        'fernanda.costa@smartmed.com.br', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Juliana Oliveira', '45678901234', '1990-01-30', '2020-08-05', '2024-06-15', '11654321098',
        'juliana.oliveira@smartmed.com.br', FALSE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Patrícia Lima', '56789012345', '1987-09-12', '2022-03-18', NULL, '11543210987',
        'patricia.lima@smartmed.com.br', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Roberta Souza', '67890123456', '1994-05-25', '2023-07-01', NULL, '11432109876',
        'roberta.souza@smartmed.com.br', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Vanessa Pereira', '78901234567', '1991-12-03', '2021-11-22', '2024-01-10', '11321098765',
        'vanessa.pereira@smartmed.com.br', FALSE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Tatiane Alves', '89012345678', '1989-04-17', '2022-09-30', NULL, '11210987654',
        'tatiane.alves@smartmed.com.br', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Cristina Rocha', '90123456789', '1993-08-14', '2023-04-12', NULL, '11109876543',
        'cristina.rocha@smartmed.com.br', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Mônica Dias', '01234567890', '1986-06-28', '2020-12-07', NULL, '11098765432', 'monica.dias@smartmed.com.br',
        TRUE);

-- =============================
-- PACIENTES (60)
-- =============================
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ana Silva', '12345678901', '1985-03-15', '11987654321', 'ana.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Carlos Santos', '23456789012', '1990-07-22', '11876543210', 'carlos.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Maria Oliveira', '34567890123', '1978-11-08', '11765432109', 'maria.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('João Pereira', '45678901234', '1995-01-30', '11654321098', 'joao.pereira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fernanda Costa', '56789012345', '1987-09-12', '11543210987', 'fernanda.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ricardo Lima', '67890123456', '1992-05-25', '11432109876', 'ricardo.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Juliana Souza', '78901234567', '1980-12-03', '11321098765', 'juliana.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Pedro Alves', '89012345678', '1975-04-17', '11210987654', 'pedro.alves@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Camila Rocha', '90123456789', '1993-08-14', '11109876543', 'camila.rocha@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Lucas Dias', '01234567890', '1988-06-28', '11098765432', 'lucas.dias@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Amanda Ferreira', '11234567890', '1991-02-10', '21987654321', 'amanda.ferreira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Bruno Gomes', '21234567890', '1984-09-18', '21876543210', 'bruno.gomes@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Leticia Martins', '31234567890', '1996-12-05', '21765432109', 'leticia.martins@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Rafael Ribeiro', '41234567890', '1982-03-22', '21654321098', 'rafael.ribeiro@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Beatriz Nunes', '51234567890', '1989-10-11', '21543210987', 'beatriz.nunes@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Gabriel Cardoso', '61234567890', '1977-07-29', '21432109876', 'gabriel.cardoso@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Roberta Mendes', '71234567890', '1994-01-16', '21321098765', 'roberta.mendes@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Diego Torres', '81234567890', '1986-05-04', '21210987654', 'diego.torres@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Vanessa Barbosa', '91234567890', '1979-11-21', '21109876543', 'vanessa.barbosa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Thiago Morais', '02345678901', '1983-08-07', '21098765432', 'thiago.morais@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Patricia Campos', '12345678902', '1990-04-14', '31987654321', 'patricia.campos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Rodrigo Araujo', '22345678901', '1985-12-01', '31876543210', 'rodrigo.araujo@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Cristina Pinto', '32345678901', '1976-06-19', '31765432109', 'cristina.pinto@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Marcelo Castro', '42345678901', '1997-02-26', '31654321098', 'marcelo.castro@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Tatiane Freitas', '52345678901', '1981-09-13', '31543210987', 'tatiane.freitas@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Felipe Moreira', '62345678901', '1998-01-08', '31432109876', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Monica Correia', '72345678901', '1974-10-25', '31321098765', 'monica.correia@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Vinicius Azevedo', '82345678901', '1987-07-12', '31210987654', 'vinicius.azevedo@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Sandra Vieira', '92345678901', '1992-03-30', '31109876543', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Eduardo Lopes', '03456789012', '1989-11-17', '31098765432', 'eduardo.lopes@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Carla Ramos', '13456789012', '1984-05-24', '41987654321', 'carla.ramos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Andre Cunha', '23456789013', '1995-01-11', '41876543210', 'andre.cunha@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Priscila Macedo', '33456789012', '1978-08-28', '41765432109', 'priscila.macedo@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fabio Teixeira', '43456789012', '1993-12-15', '41654321098', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Daniela Nogueira', '53456789012', '1980-04-02', '41543210987', 'daniela.nogueira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Henrique Bastos', '63456789012', '1986-09-20', '41432109876', 'henrique.bastos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Simone Guedes', '73456789012', '1991-06-07', '41321098765', 'simone.guedes@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Gustavo Franco', '83456789012', '1977-02-23', '41210987654', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Claudia Batista', '93456789012', '1999-10-10', '41109876543', 'claudia.batista@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Leonardo Silva', '04567890123', '1985-07-27', '41098765432', 'leonardo.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Renata Nascimento', '14567890123', '1982-03-14', '51987654321', 'renata.nascimento@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Alexandre Reis', '24567890123', '1996-11-01', '51876543210', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Larissa Melo', '34567890124', '1973-05-18', '51765432109', 'larissa.melo@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Roberto Fonseca', '44567890123', '1988-01-25', '51654321098', 'roberto.fonseca@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Isabel Andrade', '54567890123', '1994-08-12', '51543210987', 'isabel.andrade@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Sergio Monteiro', '64567890123', '1979-12-29', '51432109876', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Elaine Cavalcanti', '74567890123', '1987-04-16', '51321098765', 'elaine.cavalcanti@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Marcio Duarte', '84567890123', '1975-09-03', '51210987654', 'marcio.duarte@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Vera Xavier', '94567890123', '1992-06-20', '51109876543', 'vera.xavier@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Paulo Machado', '05678901234', '1983-02-07', '51098765432', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Adriana Siqueira', '15678901234', '1990-10-24', '61987654321', 'adriana.siqueira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Daniel Coelho', '25678901234', '1986-07-11', '61876543210', 'daniel.coelho@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Silvia Borges', '35678901234', '1978-03-28', '61765432109', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Guilherme Santana', '45678901235', '1995-11-15', '61654321098', 'guilherme.santana@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Mariana Paiva', '55678901234', '1981-05-02', '61543210987', 'mariana.paiva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Hugo Resende', '65678901234', '1989-01-19', '61432109876', 'hugo.resende@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Bianca Pereira', '75678901234', '1974-08-06', '61321098765', NULL);
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Leandro Farias', '85678901234', '1997-12-23', '61210987654', 'leandro.farias@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Luciana Vasconcelos', '95678901234', '1984-04-10', '61109876543', 'luciana.vasconcelos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Mateus Tavares', '06789012345', '1993-09-27', '61098765432', 'mateus.tavares@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Sabrina Miranda', '16789012345', '1976-06-14', '71987654321', NULL);

-- =============================
-- CONSULTAS (110)
-- =============================
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-15', 'Realizada', 250.00, 'Consulta de rotina', 1, 1, 1, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-16', 'Realizada', 0.00, 'Consulta coberta pelo convênio', 2, 2, NULL, 1, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-17', 'Agendada', 180.00, NULL, 3, 3, 4, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-18', 'Realizada', 0.00, 'Acompanhamento ginecológico', 4, 3, NULL, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-19', 'Cancelada', 300.00, 'Paciente não compareceu', 5, 4, 2, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-20', 'Realizada', 220.00, 'Consulta ortopédica', 6, 5, 3, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-22', 'Realizada', 0.00, 'Consulta pediátrica', 7, 6, NULL, 3, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-23', 'Agendada', 280.00, NULL, 8, 7, 4, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-24', 'Realizada', 240.00, 'Consulta urológica', 9, 8, 1, NULL, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-25', 'Realizada', 0.00, 'Oftalmologia - exame de rotina', 10, 9, NULL, 4, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-26', 'Retorno', 105.00, 'Retorno cardiologia', 1, 1, 2, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-29', 'Realizada', 210.00, 'Otorrinolaringologia', 11, 10, 3, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-30', 'Realizada', 0.00, 'Endocrinologia', 12, 11, NULL, 6, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-01-31', 'Agendada', 150.00, NULL, 13, 12, 4, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-01', 'Realizada', 270.00, 'Neurologia', 14, 14, 1, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-02', 'Cancelada', 180.00, 'Reagendamento solicitado', 15, 15, 2, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-05', 'Realizada', 0.00, 'Pediatria', 16, 6, NULL, 7, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-06', 'Realizada', 250.00, 'Cardiologia', 17, 1, 3, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-07', 'Agendada', 200.00, NULL, 18, 2, 4, NULL, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-08', 'Realizada', 0.00, 'Ginecologia preventiva', 19, 3, NULL, 8, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-09', 'Realizada', 300.00, 'Neurologia', 20, 4, 1, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-12', 'Retorno', 110.00, 'Retorno ortopedia', 6, 5, 2, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-13', 'Realizada', 0.00, 'Psiquiatria', 21, 7, NULL, 9, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-14', 'Agendada', 240.00, NULL, 22, 8, 3, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-15', 'Realizada', 190.00, 'Oftalmologia', 23, 9, 4, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-16', 'Realizada', 0.00, 'Otorrinolaringologia', 24, 10, NULL, 10, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-19', 'Cancelada', 200.00, 'Emergência familiar', 25, 11, 1, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-20', 'Realizada', 150.00, 'Clínica geral', 26, 12, 2, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-21', 'Agendada', 0.00, 'Consulta por convênio', 27, 14, NULL, 1, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-22', 'Realizada', 180.00, 'Pediatria', 28, 15, 3, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-23', 'Realizada', 250.00, 'Cardiologia check-up', 29, 1, 4, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-26', 'Realizada', 0.00, 'Dermatologia', 30, 2, NULL, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-27', 'Retorno', 90.00, 'Retorno ginecologia', 3, 3, 1, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-02-28', 'Agendada', 300.00, NULL, 31, 4, 2, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-01', 'Realizada', 220.00, 'Ortopedia', 32, 5, 3, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-04', 'Realizada', 0.00, 'Pediatria vacinação', 33, 6, NULL, 3, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-05', 'Cancelada', 280.00, 'Paciente doente', 34, 7, 4, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-06', 'Realizada', 240.00, 'Urologia', 35, 8, 1, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-07', 'Agendada', 0.00, 'Oftalmologia convênio', 36, 9, NULL, 4, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-08', 'Realizada', 210.00, 'Otorrinolaringologia', 37, 10, 2, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-11', 'Realizada', 200.00, 'Endocrinologia diabetes', 38, 11, 3, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-12', 'Realizada', 0.00, 'Clínica geral', 39, 12, NULL, 6, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-13', 'Retorno', 135.00, 'Retorno neurologia', 14, 14, 4, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-14', 'Agendada', 180.00, NULL, 40, 15, 1, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-15', 'Realizada', 250.00, 'Cardiologia', 41, 1, 2, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-18', 'Realizada', 0.00, 'Dermatologia', 42, 2, NULL, 7, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-19', 'Cancelada', 180.00, 'Conflito de horário', 43, 3, 3, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-20', 'Realizada', 300.00, 'Neurologia', 44, 4, 4, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-21', 'Agendada', 0.00, 'Ortopedia convênio', 45, 5, NULL, 8, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-22', 'Realizada', 160.00, 'Pediatria', 46, 6, 1, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-25', 'Realizada', 280.00, 'Psiquiatria', 47, 7, 2, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-26', 'Realizada', 0.00, 'Urologia', 48, 8, NULL, 9, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-27', 'Retorno', 95.00, 'Retorno oftalmologia', 23, 9, 3, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-28', 'Agendada', 210.00, NULL, 49, 10, 4, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-03-29', 'Realizada', 0.00, 'Endocrinologia', 50, 11, NULL, 10, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-01', 'Realizada', 150.00, 'Clínica geral', 51, 12, 1, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-02', 'Cancelada', 270.00, 'Viagem imprevista', 52, 14, 2, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-03', 'Realizada', 180.00, 'Pediatria', 53, 15, 3, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-04', 'Agendada', 0.00, 'Cardiologia convênio', 54, 1, NULL, 1, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-05', 'Realizada', 200.00, 'Dermatologia', 55, 2, 4, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-08', 'Realizada', 180.00, 'Ginecologia', 56, 3, 1, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-09', 'Realizada', 0.00, 'Neurologia', 57, 4, NULL, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-10', 'Retorno', 110.00, 'Retorno ortopedia', 32, 5, 2, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-11', 'Agendada', 160.00, NULL, 58, 6, 3, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-12', 'Realizada', 0.00, 'Psiquiatria', 59, 7, NULL, 3, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-15', 'Realizada', 240.00, 'Urologia', 60, 8, 4, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-16', 'Cancelada', 190.00, 'Paciente gripado', 1, 9, 1, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-17', 'Realizada', 210.00, 'Otorrinolaringologia', 2, 10, 2, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-18', 'Agendada', 0.00, 'Endocrinologia convênio', 3, 11, NULL, 4, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-19', 'Realizada', 150.00, 'Clínica geral', 4, 12, 3, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-22', 'Realizada', 270.00, 'Neurologia', 5, 14, 4, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-23', 'Realizada', 0.00, 'Pediatria', 6, 15, NULL, 6, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-24', 'Retorno', 125.00, 'Retorno cardiologia', 29, 1, 1, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-25', 'Agendada', 200.00, NULL, 7, 2, 2, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-26', 'Realizada', 0.00, 'Ginecologia', 8, 3, NULL, 7, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-29', 'Cancelada', 300.00, 'Emergência médica', 9, 4, 3, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-04-30', 'Realizada', 220.00, 'Ortopedia', 10, 5, 4, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-01', 'Agendada', 0.00, 'Pediatria convênio', 11, 6, NULL, 8, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-02', 'Realizada', 280.00, 'Psiquiatria', 12, 7, 1, NULL, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-03', 'Realizada', 240.00, 'Urologia', 13, 8, 2, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-06', 'Realizada', 0.00, 'Oftalmologia', 14, 9, NULL, 9, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-07', 'Retorno', 105.00, 'Retorno otorrino', 37, 10, 3, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-08', 'Agendada', 200.00, NULL, 15, 11, 4, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-09', 'Realizada', 0.00, 'Clínica geral', 16, 12, NULL, 10, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-10', 'Cancelada', 270.00, 'Paciente internado', 17, 14, 1, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-13', 'Realizada', 180.00, 'Pediatria', 18, 15, 2, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-14', 'Agendada', 0.00, 'Cardiologia convênio', 19, 1, NULL, 1, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-15', 'Realizada', 200.00, 'Dermatologia', 20, 2, 3, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-16', 'Realizada', 180.00, 'Ginecologia', 21, 3, 4, NULL, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-17', 'Realizada', 0.00, 'Neurologia', 22, 4, NULL, 2, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-20', 'Retorno', 110.00, 'Retorno ortopedia', 45, 5, 1, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-21', 'Agendada', 160.00, NULL, 23, 6, 2, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-22', 'Realizada', 0.00, 'Psiquiatria', 24, 7, NULL, 3, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-23', 'Cancelada', 240.00, 'Chuva forte', 25, 8, 3, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-24', 'Realizada', 190.00, 'Oftalmologia', 26, 9, 4, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-27', 'Agendada', 0.00, 'Otorrinolaringologia convênio', 27, 10, NULL, 4, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-28', 'Realizada', 200.00, 'Endocrinologia', 28, 11, 1, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-29', 'Realizada', 150.00, 'Clínica geral check-up', 29, 12, 2, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-30', 'Realizada', 0.00, 'Neurologia', 30, 14, NULL, 6, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-05-31', 'Retorno', 90.00, 'Retorno pediatria', 53, 15, 3, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-03', 'Agendada', 250.00, NULL, 31, 1, 4, NULL, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-04', 'Realizada', 0.00, 'Dermatologia', 32, 2, NULL, 7, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-05', 'Cancelada', 180.00, 'Trabalho urgente', 33, 3, 1, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-06', 'Realizada', 300.00, 'Neurologia especializada', 34, 4, 2, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-07', 'Agendada', 0.00, 'Ortopedia convênio', 35, 5, NULL, 8, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-10', 'Realizada', 160.00, 'Pediatria vacinação', 36, 6, 3, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-11', 'Realizada', 280.00, 'Psiquiatria acompanhamento', 37, 7, 4, NULL, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-12', 'Realizada', 0.00, 'Urologia', 38, 8, NULL, 9, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-13', 'Retorno', 95.00, 'Retorno oftalmologia', 26, 9, 1, NULL, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-14', 'Agendada', 210.00, NULL, 39, 10, 2, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-17', 'Realizada', 0.00, 'Endocrinologia diabetes', 40, 11, NULL, 10, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-18', 'Cancelada', 150.00, 'Férias antecipadas', 41, 12, 3, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-19', 'Realizada', 270.00, 'Neurologia', 42, 14, 4, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteID, medicoID, formaPagamentoID, convenioID,
                      recepcionistaID)
VALUES ('2024-06-20', 'Agendada', 0.00, 'Pediatria convênio', 43, 15, NULL, 1, 3);
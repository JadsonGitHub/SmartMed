-- ========================================
-- INSERIR ESPECIALIDADES (20)
-- ========================================
INSERT INTO especialidade (nome, descricao)
VALUES ('Cardiologia', 'Especialidade médica que trata do coração e sistema cardiovascular');
INSERT INTO especialidade (nome, descricao)
VALUES ('Dermatologia', 'Especialidade médica que trata da pele e seus anexos');
INSERT INTO especialidade (nome, descricao)
VALUES ('Neurologia', 'Especialidade médica que trata do sistema nervoso');
INSERT INTO especialidade (nome, descricao)
VALUES ('Ortopedia', 'Especialidade médica que trata do sistema locomotor');
INSERT INTO especialidade (nome, descricao)
VALUES ('Pediatria', 'Especialidade médica que trata de crianças e adolescentes');
INSERT INTO especialidade (nome, descricao)
VALUES ('Ginecologia', 'Especialidade médica que trata do sistema reprodutor feminino');
INSERT INTO especialidade (nome, descricao)
VALUES ('Urologia', 'Especialidade médica que trata do sistema urinário');
INSERT INTO especialidade (nome, descricao)
VALUES ('Oftalmologia', 'Especialidade médica que trata dos olhos');
INSERT INTO especialidade (nome, descricao)
VALUES ('Otorrinolaringologia', 'Especialidade médica que trata de ouvido, nariz e garganta');
INSERT INTO especialidade (nome, descricao)
VALUES ('Psiquiatria', 'Especialidade médica que trata de transtornos mentais');
INSERT INTO especialidade (nome, descricao)
VALUES ('Endocrinologia', 'Especialidade médica que trata das glândulas endócrinas');
INSERT INTO especialidade (nome, descricao)
VALUES ('Gastroenterologia', 'Especialidade médica que trata do sistema digestivo');
INSERT INTO especialidade (nome, descricao)
VALUES ('Pneumologia', 'Especialidade médica que trata do sistema respiratório');
INSERT INTO especialidade (nome, descricao)
VALUES ('Reumatologia', 'Especialidade médica que trata de doenças reumáticas');
INSERT INTO especialidade (nome, descricao)
VALUES ('Oncologia', 'Especialidade médica que trata de tumores');
INSERT INTO especialidade (nome, descricao)
VALUES ('Hematologia', 'Especialidade médica que trata do sangue');
INSERT INTO especialidade (nome, descricao)
VALUES ('Infectologia', 'Especialidade médica que trata de doenças infecciosas');
INSERT INTO especialidade (nome, descricao)
VALUES ('Geriatria', 'Especialidade médica que trata de idosos');
INSERT INTO especialidade (nome, descricao)
VALUES ('Medicina do Trabalho', 'Especialidade médica voltada para saúde ocupacional');
INSERT INTO especialidade (nome, descricao)
VALUES ('Anestesiologia', 'Especialidade médica focada em anestesia e controle da dor');

-- ========================================
-- INSERIR FORMAS DE PAGAMENTO (5)
-- ========================================
INSERT INTO formaPagamento (descricao)
VALUES ('Dinheiro');
INSERT INTO formaPagamento (descricao)
VALUES ('Cartão de Crédito');
INSERT INTO formaPagamento (descricao)
VALUES ('Cartão de Débito');
INSERT INTO formaPagamento (descricao)
VALUES ('PIX');
INSERT INTO formaPagamento (descricao)
VALUES ('Convênio');

-- ========================================
-- INSERIR CONVÊNIOS (5)
-- ========================================
INSERT INTO convenio (nome, cnpj, telefone, email, ativo, porcentagemDesconto)
VALUES ('Unimed', '12345678000199', '11999998888', 'contato@unimed.com.br', TRUE, 0.50);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo, porcentagemDesconto)
VALUES ('Amil', '98765432000199', '21988887777', 'atendimento@amil.com.br', TRUE, 0.70);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo, porcentagemDesconto)
VALUES ('Bradesco Saúde', '56789012000199', '11977776666', 'sac@bradescosaude.com.br', TRUE, 0.60);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo, porcentagemDesconto)
VALUES ('SulAmérica', '34567890000199', '11966665555', 'contato@sulamerica.com.br', TRUE, 0.55);
INSERT INTO convenio (nome, cnpj, telefone, email, ativo, porcentagemDesconto)
VALUES ('Golden Cross', '78901234000199', '21955554444', 'atendimento@goldencross.com.br', TRUE, 0.65);

-- ========================================
-- INSERIR RECEPCIONISTAS (11)
-- ========================================
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Carlos Andrade', '45678912301', '1990-02-10', '2020-01-15', NULL, '11977773333', 'carlos@teste.com', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Ana Paula Silva', '39053344705', '1992-05-14', '2020-03-10', NULL, '11912345678', 'ana.silva@example.com',
        TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Carlos Eduardo Lima', '52998224725', '1988-11-22', '2019-08-01', '2024-06-30', '21998765432',
        'carlos.lima@example.com', FALSE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Juliana Moura', '93541134780', '1995-03-09', '2021-01-15', NULL, '31933211234', 'juliana.moura@example.com',
        TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Rodrigo Santos', '11144477735', '1990-07-01', '2018-09-20', NULL, '41999887766', 'rodrigo.santos@example.com',
        TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Fernanda Oliveira', '12345678909', '1998-12-30', '2023-04-03', NULL, '85911223344',
        'fernanda.oliveira@example.com', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Marcelo Andrade', '98765432100', '1985-01-17', '2015-07-10', '2022-12-31', '61998812233',
        'marcelo.andrade@example.com', FALSE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Patrícia Martins', '16899535009', '1991-09-12', '2022-02-20', NULL, '21987654321',
        'patricia.martins@example.com', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Eduardo Ferreira', '02546288423', '1983-06-25', '2017-11-05', NULL, '31999887766',
        'eduardo.ferreira@example.com', FALSE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Carla Souza', '99156352573', '1997-04-17', '2020-10-01', NULL, '41991234567', 'carla.souza@example.com', TRUE);
INSERT INTO recepcionista (nome, cpf, dataNascimento, dataAdmissao, dataDemissao, telefone, email, ativo)
VALUES ('Rafael Almeida', '29779383972', '1990-06-25', '2018-09-10', NULL, '41998765432', 'rafael.almeida@example.com',
        TRUE);

-- ========================================
-- INSERIR MÉDICOS (10)
-- ========================================
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dr. Roberto Santos', '123456-SP', '11966664444', 'roberto.santos@clinica.com', 300.00, TRUE, 1, 30, '08:00:00',
        '18:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dra. Ana Paula Silva', '234567-RJ', '21955553333', 'ana.silva@clinica.com', 350.00, TRUE, 2, 30, '08:00:00',
        '17:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dr. Carlos Eduardo', '345678-MG', '31944442222', 'carlos.eduardo@clinica.com', 280.00, TRUE, 3, 45, '09:00:00',
        '18:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dra. Marina Costa', '456789-RS', '51933331111', 'marina.costa@clinica.com', 320.00, TRUE, 4, 30, '08:30:00',
        '16:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dr. Fernando Lima', '567890-PR', '41922220000', 'fernando.lima@clinica.com', 250.00, TRUE, 5, 30, '07:00:00',
        '17:30:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dra. Juliana Moura', '678901-SC', '48911119999', 'juliana.moura@clinica.com', 380.00, TRUE, 6, 30, '08:00:00',
        '18:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dr. Rafael Almeida', '789012-BA', '71900008888', 'rafael.almeida@clinica.com', 290.00, TRUE, 7, 30, '09:00:00',
        '16:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dra. Patrícia Martins', '890123-GO', '62999997777', 'patricia.martins@clinica.com', 310.00, TRUE, 8, 30,
        '08:30:00', '17:30:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dr. Eduardo Ferreira', '901234-PE', '81988886666', 'eduardo.ferreira@clinica.com', 270.00, TRUE, 9, 40,
        '08:00:00', '16:00:00');
INSERT INTO medico (nome, crm, telefone, email, valorConsultaReferencia, ativo, especialidadeId, duracaoPadraoConsulta,
                    horaInicioExpediente, horaFimExpediente)
VALUES ('Dra. Carla Souza', '012345-CE', '85977775555', 'carla.souza@clinica.com', 340.00, TRUE, 10, 30, '07:30:00',
        '16:30:00');

-- ========================================
-- INSERIR PACIENTES (100)
-- ========================================
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('João Silva', '12345678901', '1980-01-15', '11999991111', 'joao.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Maria Souza', '98765432109', '1975-05-20', '11988882222', 'maria.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Pedro Santos', '11122233344', '1992-03-10', '11977773333', 'pedro.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ana Costa', '55566677788', '1985-07-25', '11966664444', 'ana.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Carlos Lima', '99988877766', '1978-12-08', '11955555555', 'carlos.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fernanda Oliveira', '12312312312', '1990-09-14', '11944446666', 'fernanda.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Roberto Almeida', '32132132132', '1983-02-28', '11933337777', 'roberto.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Juliana Moura', '45645645645', '1995-11-03', '11922228888', 'juliana.moura@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Eduardo Ferreira', '78978978978', '1987-06-17', '11911119999', 'eduardo.ferreira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Patrícia Martins', '65465465465', '1982-04-22', '11900000000', 'patricia.martins@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Marcos Rodrigues', '14725836901', '1979-08-12', '21999991111', 'marcos.rodrigues@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Luciana Pereira', '25836914702', '1988-01-05', '21988882222', 'luciana.pereira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Gabriel Santos', '36914725803', '1993-10-18', '21977773333', 'gabriel.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Camila Costa', '47025836904', '1986-03-27', '21966664444', 'camila.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Rafael Oliveira', '58136947205', '1981-12-14', '21955555555', 'rafael.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Tatiana Silva', '69247058306', '1994-07-09', '31999991111', 'tatiana.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Leonardo Souza', '70358169407', '1989-02-16', '31988882222', 'leonardo.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Bianca Lima', '81469270508', '1984-09-23', '31977773333', 'bianca.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Rodrigo Almeida', '92570381609', '1991-04-30', '31966664444', 'rodrigo.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Vanessa Moura', '03681492710', '1987-11-07', '31955555555', 'vanessa.moura@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Felipe Santos', '14792503811', '1980-06-14', '41999991111', 'felipe.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Larissa Costa', '25803614912', '1995-01-21', '41988882222', 'larissa.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Bruno Oliveira', '36914725013', '1983-08-28', '41977773333', 'bruno.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Priscila Silva', '47025836114', '1992-03-05', '41966664444', 'priscila.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Diego Souza', '58136947215', '1988-10-12', '41955555555', 'diego.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Amanda Lima', '69247058316', '1985-05-19', '51999991111', 'amanda.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Thiago Almeida', '70358169417', '1990-12-26', '51988882222', 'thiago.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Renata Moura', '81469270518', '1986-07-03', '51977773333', 'renata.moura@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Gustavo Santos', '92570381619', '1993-02-10', '51966664444', 'gustavo.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Daniela Costa', '03681492720', '1989-09-17', '51955555555', 'daniela.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Vinicius Silva', '14792503821', '1982-04-24', '48999991111', 'vinicius.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Cristina Souza', '25803614922', '1991-11-01', '48988882222', 'cristina.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Marcelo Lima', '36914725023', '1987-06-08', '48977773333', 'marcelo.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fabiana Oliveira', '47025836124', '1984-01-15', '48966664444', 'fabiana.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('André Santos', '58136947225', '1996-08-22', '48955555555', 'andre.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Carla Costa', '69247058326', '1983-03-29', '71999991111', 'carla.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Henrique Silva', '70358169427', '1992-10-06', '71988882222', 'henrique.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Natália Souza', '81469270528', '1988-05-13', '71977773333', 'natalia.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Lucas Lima', '92570381629', '1985-12-20', '71966664444', 'lucas.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Adriana Almeida', '03681492730', '1994-07-27', '71955555555', 'adriana.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Paulo Santos', '14792503831', '1981-02-03', '62999991111', 'paulo.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Mônica Costa', '25803614932', '1990-09-10', '62988882222', 'monica.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Sergio Silva', '36914725033', '1986-04-17', '62977773333', 'sergio.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Silvia Souza', '47025836134', '1993-11-24', '62966664444', 'silvia.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Alex Lima', '58136947235', '1989-06-01', '62955555555', 'alex.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Roberta Oliveira', '69247058336', '1984-01-08', '81999991111', 'roberta.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Igor Santos', '70358169437', '1995-08-15', '81988882222', 'igor.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Leticia Costa', '81469270538', '1987-03-22', '81977773333', 'leticia.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Márcio Silva', '92570381639', '1982-10-29', '81966664444', 'marcio.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Sabrina Souza', '03681492740', '1991-05-06', '81955555555', 'sabrina.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Leandro Lima', '14792503841', '1988-12-13', '85999991111', 'leandro.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Cláudia Almeida', '25803614942', '1985-07-20', '85988882222', 'claudia.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fábio Santos', '36914725043', '1994-02-27', '85977773333', 'fabio.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Viviane Costa', '47025836144', '1990-09-04', '85966664444', 'viviane.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Daniel Silva', '58136947245', '1983-04-11', '85955555555', 'daniel.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Kelly Souza', '69247058346', '1992-11-18', '11987654321', 'kelly.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ricardo Lima', '70358169447', '1989-06-25', '21987654321', 'ricardo.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Aline Oliveira', '81469270548', '1986-01-02', '31987654321', 'aline.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Murilo Santos', '92570381649', '1995-08-09', '41987654321', 'murilo.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Caroline Costa', '03681492750', '1987-03-16', '51987654321', 'caroline.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Wellington Silva', '14792503851', '1984-10-23', '48987654321', 'wellington.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Jéssica Souza', '25803614952', '1993-05-30', '71987654321', 'jessica.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Everton Lima', '36914725053', '1990-12-07', '62987654321', 'everton.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Michelle Almeida', '47025836154', '1987-07-14', '81987654321', 'michelle.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Alexandre Santos', '58136947255', '1982-02-21', '85987654321', 'alexandre.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Débora Costa', '69247058356', '1991-09-28', '11876543210', 'debora.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Joaquim Silva', '70358169457', '1988-04-05', '21876543210', 'joaquim.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Raquel Souza', '81469270558', '1985-11-12', '31876543210', 'raquel.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Anderson Lima', '92570381659', '1994-06-19', '41876543210', 'anderson.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Bárbara Oliveira', '03681492760', '1991-01-26', '51876543210', 'barbara.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Cleber Santos', '14792503861', '1986-08-03', '48876543210', 'cleber.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fernanda Costa', '25803614962', '1993-03-10', '71876543210', 'fernanda.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Guilherme Silva', '36914725063', '1990-10-17', '62876543210', 'guilherme.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Helen Souza', '47025836164', '1987-05-24', '81876543210', 'helen.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ivan Lima', '58136947265', '1984-12-01', '85876543210', 'ivan.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Karina Almeida', '69247058366', '1995-07-08', '11765432109', 'karina.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Luis Santos', '70358169467', '1989-02-15', '21765432109', 'luis.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Márcia Costa', '81469270568', '1986-09-22', '31765432109', 'marcia.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Nelson Silva', '92570381669', '1993-04-29', '41765432109', 'nelson.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Olívia Souza', '03681492770', '1990-11-06', '51765432109', 'olivia.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Pedro Lima', '14792503871', '1987-06-13', '48765432109', 'pedro.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Quésia Oliveira', '25803614972', '1984-01-20', '71765432109', 'quesia.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ronaldo Santos', '36914725073', '1995-08-27', '62765432109', 'ronaldo.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Sandra Costa', '47025836174', '1988-03-06', '81765432109', 'sandra.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Tales Silva', '58136947275', '1985-10-13', '85765432109', 'tales.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Úrsula Souza', '69247058376', '1994-05-20', '11654321098', 'ursula.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Victor Lima', '70358169477', '1991-12-27', '21654321098', 'victor.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Wanda Almeida', '81469270578', '1988-07-04', '31654321098', 'wanda.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Xavier Santos', '92570381679', '1983-02-11', '41654321098', 'xavier.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Yasmin Costa', '03681492780', '1992-09-18', '51654321098', 'yasmin.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Zeca Silva', '14792503881', '1989-04-25', '48654321098', 'zeca.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Adriano Souza', '25803614982', '1986-11-02', '71654321098', 'adriano.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Beatriz Lima', '36914725083', '1995-06-09', '62654321098', 'beatriz.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Cezar Oliveira', '47025836184', '1990-01-16', '81654321098', 'cezar.oliveira@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Denise Santos', '58136947285', '1987-08-23', '85654321098', 'denise.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Elias Costa', '69247058386', '1984-03-30', '11543210987', 'elias.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Fátima Silva', '70358169487', '1993-10-07', '21543210987', 'fatima.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Geraldo Souza', '81469270588', '1990-05-14', '31543210987', 'geraldo.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Heloísa Lima', '92570381689', '1987-12-21', '41543210987', 'heloisa.lima@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Ícaro Almeida', '03681492790', '1982-07-28', '51543210987', 'icaro.almeida@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Joana Santos', '14792503891', '1991-02-05', '48543210987', 'joana.santos@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Klaus Costa', '25803614992', '1988-09-12', '71543210987', 'klaus.costa@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Luana Silva', '36914725093', '1985-04-19', '62543210987', 'luana.silva@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Milton Souza', '47025836194', '1994-11-26', '81543210987', 'milton.souza@email.com');
INSERT INTO paciente (nome, cpf, dataNascimento, telefone, email)
VALUES ('Noemi Lima', '58136947295', '1991-06-03', '85543210987', 'noemi.lima@email.com');

-- ========================================
-- INSERIR CONSULTAS (80)
-- ========================================
-- Consultas REALIZADAS (60 consultas)
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-10 09:00:00', 'REALIZADA', 150.00, 'Consulta de rotina - paciente apresentou melhora', 1, 1, 5, 1, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-10 10:00:00', 'REALIZADA', 245.00, 'Acompanhamento dermatológico', 2, 2, 5, 2, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-10 11:00:00', 'REALIZADA', 280.00, 'Primeira consulta neurológica', 3, 3, 1, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-11 08:30:00', 'REALIZADA', 192.00, 'Consulta ortopédica - dor no joelho', 4, 4, 5, 3, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-11 09:30:00', 'REALIZADA', 250.00, 'Consulta pediátrica de rotina', 5, 5, 2, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-11 14:00:00', 'REALIZADA', 266.00, 'Consulta ginecológica preventiva', 6, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-12 10:00:00', 'REALIZADA', 290.00, 'Consulta urológica', 7, 7, 3, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-12 15:00:00', 'REALIZADA', 217.00, 'Exame oftalmológico completo', 8, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-13 09:15:00', 'REALIZADA', 270.00, 'Consulta otorrinolaringológica', 9, 9, 4, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-13 16:00:00', 'REALIZADA', 238.00, 'Consulta psiquiátrica inicial', 10, 10, 5, 1, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-15 08:00:00', 'REALIZADA', 150.00, 'Retorno cardiológico', 11, 1, 5, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-15 14:30:00', 'REALIZADA', 350.00, 'Consulta dermatológica estética', 12, 2, 1, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-16 10:45:00', 'REALIZADA', 126.00, 'Acompanhamento neurológico', 13, 3, 5, 3, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-16 15:15:00', 'REALIZADA', 320.00, 'Consulta ortopédica especializada', 14, 4, 2, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-17 07:30:00', 'REALIZADA', 250.00, 'Consulta pediátrica - vacinação', 15, 5, 3, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-17 11:00:00', 'REALIZADA', 171.00, 'Consulta ginecológica de rotina', 16, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-18 09:30:00', 'REALIZADA', 290.00, 'Consulta urológica de acompanhamento', 17, 7, 4, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-18 14:00:00', 'REALIZADA', 108.50, 'Consulta oftalmológica - miopia', 18, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-20 08:45:00', 'REALIZADA', 270.00, 'Consulta otorrino - sinusite', 19, 9, 1, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-20 16:30:00', 'REALIZADA', 119.00, 'Consulta psiquiátrica de acompanhamento', 20, 10, 5, 1, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-22 09:00:00', 'REALIZADA', 300.00, 'Consulta cardiológica - hipertensão', 21, 1, 2, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-22 15:00:00', 'REALIZADA', 245.00, 'Consulta dermatológica - acne', 22, 2, 5, 2, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-23 10:30:00', 'REALIZADA', 280.00, 'Consulta neurológica - enxaqueca', 23, 3, 3, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-23 14:15:00', 'REALIZADA', 176.00, 'Consulta ortopédica - lombalgia', 24, 4, 5, 3, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-24 08:00:00', 'REALIZADA', 250.00, 'Consulta pediátrica - crescimento', 25, 5, 4, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-24 11:30:00', 'REALIZADA', 247.00, 'Consulta ginecológica - menopausa', 26, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-25 09:45:00', 'REALIZADA', 290.00, 'Consulta urológica - próstata', 27, 7, 1, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-25 16:00:00', 'REALIZADA', 186.00, 'Consulta oftalmológica - catarata', 28, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-27 10:00:00', 'REALIZADA', 270.00, 'Consulta otorrino - perda auditiva', 29, 9, 2, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-27 15:30:00', 'REALIZADA', 170.00, 'Consulta psiquiátrica - ansiedade', 30, 10, 5, 1, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-29 08:30:00', 'REALIZADA', 150.00, 'Consulta cardiológica preventiva', 31, 1, 5, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-29 14:00:00', 'REALIZADA', 350.00, 'Consulta dermatológica - melanoma', 32, 2, 3, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-30 11:15:00', 'REALIZADA', 168.00, 'Consulta neurológica - AVC', 33, 3, 5, 3, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-30 16:45:00', 'REALIZADA', 320.00, 'Consulta ortopédica - artrose', 34, 4, 4, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-01 07:45:00', 'REALIZADA', 250.00, 'Consulta pediátrica - asma', 35, 5, 1, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-01 13:00:00', 'REALIZADA', 209.00, 'Consulta ginecológica - endometriose', 36, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-03 09:15:00', 'REALIZADA', 290.00, 'Consulta urológica - pedra nos rins', 37, 7, 2, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-03 15:45:00', 'REALIZADA', 155.00, 'Consulta oftalmológica - glaucoma', 38, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-05 08:00:00', 'REALIZADA', 270.00, 'Consulta otorrino - desvio de septo', 39, 9, 3, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-05 14:30:00', 'REALIZADA', 204.00, 'Consulta psiquiátrica - depressão', 40, 10, 5, 1, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-07 10:30:00', 'REALIZADA', 300.00, 'Consulta cardiológica - arritmia', 41, 1, 4, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-07 16:00:00', 'REALIZADA', 175.00, 'Consulta dermatológica - psoríase', 42, 2, 5, 2, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-10 09:45:00', 'REALIZADA', 280.00, 'Consulta neurológica - epilepsia', 43, 3, 1, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-10 15:15:00', 'REALIZADA', 144.00, 'Consulta ortopédica - tendinite', 44, 4, 5, 3, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-12 08:15:00', 'REALIZADA', 250.00, 'Consulta pediátrica - desenvolvimento', 45, 5, 2, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-12 14:45:00', 'REALIZADA', 171.00, 'Consulta ginecológica - mioma', 46, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-14 11:00:00', 'REALIZADA', 290.00, 'Consulta urológica - incontinência', 47, 7, 3, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-14 16:30:00', 'REALIZADA', 217.00, 'Consulta oftalmológica - retina', 48, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-17 09:30:00', 'REALIZADA', 270.00, 'Consulta otorrino - zumbido', 49, 9, 4, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-17 15:00:00', 'REALIZADA', 136.00, 'Consulta psiquiátrica - bipolaridade', 50, 10, 5, 1, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-19 08:45:00', 'REALIZADA', 150.00, 'Consulta cardiológica - colesterol', 51, 1, 5, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-19 14:15:00', 'REALIZADA', 350.00, 'Consulta dermatológica - rosácea', 52, 2, 1, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-21 10:00:00', 'REALIZADA', 196.00, 'Consulta neurológica - alzheimer', 53, 3, 5, 3, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-21 16:00:00', 'REALIZADA', 320.00, 'Consulta ortopédica - escoliose', 54, 4, 2, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-24 07:30:00', 'REALIZADA', 250.00, 'Consulta pediátrica - obesidade', 55, 5, 3, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-24 13:30:00', 'REALIZADA', 228.00, 'Consulta ginecológica - SOP', 56, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-26 09:00:00', 'REALIZADA', 290.00, 'Consulta urológica - disfunção', 57, 7, 4, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-26 15:30:00', 'REALIZADA', 124.00, 'Consulta oftalmológica - conjuntivite', 58, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-28 10:45:00', 'REALIZADA', 270.00, 'Consulta otorrino - faringite', 59, 9, 1, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-28 16:15:00', 'REALIZADA', 238.00, 'Consulta psiquiátrica - insônia', 60, 10, 5, 1, 10);

-- Consultas AGENDADAS (15 consultas)
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-01 08:00:00', 'AGENDADA', 300.00, 'Consulta de rotina agendada', 61, 1, 1, NULL, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-01 08:30:00', 'AGENDADA', 245.00, 'Acompanhamento dermatológico', 62, 2, 5, 2, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-01 10:00:00', 'AGENDADA', 168.00, 'Consulta neurológica', 63, 3, 5, 3, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-01 11:30:00', 'AGENDADA', 320.00, 'Consulta ortopédica', 64, 4, 2, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-02 09:00:00', 'AGENDADA', 250.00, 'Consulta pediátrica', 65, 5, 3, NULL, 5);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-02 14:00:00', 'AGENDADA', 266.00, 'Consulta ginecológica', 66, 6, 5, 4, 6);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-03 10:30:00', 'AGENDADA', 290.00, 'Consulta urológica', 67, 7, 4, NULL, 7);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-03 15:00:00', 'AGENDADA', 186.00, 'Consulta oftalmológica', 68, 8, 5, 5, 8);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-05 09:15:00', 'AGENDADA', 270.00, 'Consulta otorrinolaringológica', 69, 9, 1, NULL, 9);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-05 16:00:00', 'AGENDADA', 204.00, 'Consulta psiquiátrica', 70, 10, 5, 1, 10);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-07 08:30:00', 'AGENDADA', 150.00, 'Retorno cardiológico', 71, 1, 5, 2, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-07 14:30:00', 'AGENDADA', 350.00, 'Consulta dermatológica', 72, 2, 2, NULL, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-10 11:00:00', 'AGENDADA', 196.00, 'Consulta neurológica', 73, 3, 5, 3, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-10 15:30:00', 'AGENDADA', 176.00, 'Consulta ortopédica', 74, 4, 5, 3, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-08-12 10:00:00', 'AGENDADA', 250.00, 'Consulta pediátrica', 75, 5, 4, NULL, 5);

-- Consultas CANCELADAS (5 consultas)
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-12 09:00:00', 'CANCELADA', 150.00, 'Paciente cancelou por motivos pessoais', 76, 1, 5, 1, 1);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-01-18 10:00:00', 'CANCELADA', 245.00, 'Médico cancelou por emergência', 77, 2, 5, 2, 2);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-05 14:00:00', 'CANCELADA', 280.00, 'Reagendamento solicitado pelo paciente', 78, 3, 1, NULL, 3);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-15 16:00:00', 'CANCELADA', 320.00, 'Consulta cancelada por problema de saúde', 79, 4, 2, NULL, 4);
INSERT INTO consulta (dataHoraConsulta, status, valor, observacoes, pacienteId, medicoId, formaPagamentoId, convenioId,
                      recepcionistaId)
VALUES ('2025-02-25 11:00:00', 'CANCELADA', 250.00, 'Paciente não compareceu', 80, 5, 3, NULL, 5);
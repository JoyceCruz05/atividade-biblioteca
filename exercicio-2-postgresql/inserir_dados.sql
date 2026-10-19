-- 4. Cadastro de itens
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
    ('L001', 'Dom Casmurro', 'livro', 'Machado de Assis', NULL, FALSE),
    ('L002', 'O Pequeno Príncipe', 'livro', 'Antoine de Saint-Exupéry', NULL, TRUE),
    ('R001', 'Ciência Hoje', 'revista', NULL, 'Edicao 350', TRUE),
    ('R002', 'Superinteressante', 'revista', NULL, 'Edicao 480', TRUE);

-- 5. Cadastro de usuários
INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
    ('Ana Souza', 'aluno', 3),
    ('Carlos Oliveira', 'professor', 5);

-- 6. Cadastro de empréstimos
INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES
    -- Empréstimo em aberto: o livro ainda não foi devolvido
    (1, 1, '2026-10-10', '2026-10-24', NULL, 0.00),

    -- Empréstimo já devolvido
    (2, 2, '2026-09-01', '2026-09-15', '2026-09-14', 0.00);

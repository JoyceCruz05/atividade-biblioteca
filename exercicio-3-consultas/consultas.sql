SELECT
    e.id AS emprestimo,
    i.titulo AS item,
    u.nome AS usuario,
    e.data_retirada,
    e.data_devolucao_prevista,
    e.data_devolucao,
    e.valor_multa,
    CASE
        WHEN e.data_devolucao IS NULL THEN 'Em aberto'
        ELSE 'Devolvido'
    END AS situacao
FROM emprestimo e
JOIN item i ON e.item_id = i.id
JOIN usuario u ON e.usuario_id = u.id
ORDER BY e.id;

package exercicio_biblioteca.modelo;

public abstract class Usuario {

    private final String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "Nome do usuário inválido"
            );
        }

        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public abstract int getLimiteEmprestimos();

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public boolean podeEmprestar() {
        return quantidadeEmprestada < getLimiteEmprestimos();
    }

    public void registrarEmprestimo() {
        if (!podeEmprestar()) {
            throw new IllegalStateException(
                    "Limite de empréstimos atingido"
            );
        }

        quantidadeEmprestada++;
    }

    public void registrarDevolucao() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }
}

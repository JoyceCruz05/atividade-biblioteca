package exercicio_biblioteca.modelo;

import exercicio_biblioteca.contrato.Emprestavel;

public abstract class ItemEmprestavel extends ItemAcervo
        implements Emprestavel {

    private Usuario usuarioAtual;

    protected ItemEmprestavel(
            String codigo, String titulo, int ano) {
        super(codigo, titulo, ano);
        this.usuarioAtual = null;
    }

    @Override
    public boolean emprestar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuario não pode ser nulo"
            );
        }

        if (!isDisponivel()) {
            System.out.println("Item indisponível.");
            return false;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println(
                    "Limite de empréstimos atingido."
            );
            return false;
        }

        marcarComoEmprestado();
        this.usuarioAtual = usuario;
        usuario.registrarEmprestimo();

        return true;
    }

    @Override
    public boolean devolver() {
        if (isDisponivel() || usuarioAtual == null) {
            System.out.println(
                    "Este item não possui empréstimo ativo."
            );
            return false;
        }

        usuarioAtual.registrarDevolucao();
        usuarioAtual = null;
        marcarComoDisponivel();

        return true;
    }
}

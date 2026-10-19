package exercicio_biblioteca.modelo;

public class Revista extends ItemEmprestavel {

    private final String editora;
    private final int numeroEdicao;

    public Revista(
            String codigo,
            String titulo,
            int ano,
            String editora,
            int numeroEdicao) {

        super(codigo, titulo, ano);

        if (editora == null || editora.isBlank()) {
            throw new IllegalArgumentException(
                    "Editora inválida"
            );
        }

        if (numeroEdicao <= 0) {
            throw new IllegalArgumentException(
                    "Número da edição inválido"
            );
        }

        this.editora = editora;
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 7;
    }

    @Override
    public double getMultaPorDia() {
        return 1.00;
    }

    @Override
    public String getCategoria() {
        return "Revista";
    }

    @Override
    public String getDescricao() {
        return "Revista: " + getTitulo()
                + " | Editora: " + editora
                + " | Edição: " + numeroEdicao;
    }
}


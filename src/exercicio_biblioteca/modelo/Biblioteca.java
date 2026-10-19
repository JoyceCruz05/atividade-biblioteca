package exercicio_biblioteca.modelo;

public class Biblioteca {

    private ItemAcervo[] acervo = new ItemAcervo[10];
    private Usuario[] usuarios = new Usuario[10];

    private int totalItens = 0;
    private int totalUsuarios = 0;

    public void cadastrarItem(ItemAcervo item) {
        if (item == null) {
            System.out.println("Item inválido.");
            return;
        }

        if (totalItens >= acervo.length) {
            System.out.println("Acervo cheio.");
            return;
        }

        acervo[totalItens] = item;
        totalItens++;

        System.out.println("Item cadastrado: " + item.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            System.out.println("Usuário inválido.");
            return;
        }

        if (totalUsuarios >= usuarios.length) {
            System.out.println("Limite de usuários atingido.");
            return;
        }

        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;

        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    public void emprestar(Usuario usuario, ItemEmprestavel item) {
        if (usuario == null || item == null) {
            System.out.println("Usuário ou item inválido.");
            return;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println(
                    "Empréstimo recusado: limite de itens atingido."
            );
            return;
        }

        if (item.emprestar(usuario)) {
            System.out.println(
                    "Empréstimo realizado: " + item.getTitulo()
            );
        }
    }

    public void devolver(Usuario usuario, ItemEmprestavel item) {
        if (usuario == null || item == null) {
            System.out.println("Usuário ou item inválido.");
            return;
        }

        if (item.devolver()) {
            System.out.println(
                    "Devolução realizada: " + item.getTitulo()
            );
        }
    }

    public void listarAcervo() {
        System.out.println("\n--- ACERVO DA BIBLIOTECA ---");

        for (int i = 0; i < totalItens; i++) {
            ItemAcervo item = acervo[i];

            System.out.println(
                    "Código: " + item.getCodigo()
                            + " | Título: " + item.getTitulo()
                            + " | Categoria: " + item.getCategoria()
                            + " | Disponível: " + item.isDisponivel()
                            + " | Prazo: " + item.getPrazoEmprestimoDias()
                            + " dias | Multa diária: R$ "
                            + String.format("%.2f", item.getMultaPorDia())
            );
        }
    }
}

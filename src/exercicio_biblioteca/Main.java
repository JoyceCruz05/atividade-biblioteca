
package exercicio_biblioteca;

import exercicio_biblioteca.modelo.Biblioteca;
import exercicio_biblioteca.modelo.Aluno;
import exercicio_biblioteca.modelo.Professor;
import exercicio_biblioteca.modelo.Livro;
import exercicio_biblioteca.modelo.Revista;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Aluno aluno = new Aluno("João");
        Professor professor = new Professor("Maria");

        Livro livro1 = new Livro(
                "L001", "Dom Casmurro", 1899,
                "Machado de Assis", "9780000000001"
        );

        Livro livro2 = new Livro(
                "L002", "O Pequeno Príncipe", 1943,
                "Antoine de Saint-Exupéry", "9780000000002"
        );

        Revista revista1 = new Revista(
                "R001", "Ciência Hoje", 2024,
                "SBPC", 350
        );

        Revista revista2 = new Revista(
                "R002", "Superinteressante", 2025,
                "Abril", 480
        );

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        biblioteca.emprestar(aluno, livro1);
        biblioteca.emprestar(aluno, livro2);
        biblioteca.emprestar(aluno, revista1);

        // Deve ser recusado: o aluno já pegou 3 itens.
        biblioteca.emprestar(aluno, revista2);

        biblioteca.listarAcervo();
    }
}


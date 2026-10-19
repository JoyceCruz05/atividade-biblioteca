package exercicio_biblioteca.modelo;

import exercicio_biblioteca.contrato.Reservavel;

public class Livro extends ItemEmprestavel implements Reservavel {
    private final String autor;
    private final String isbn;
    private int renovacaoUtilizadas;
    private String nomeReservante;
    
    private static final int MAXIMO_RENOVACOES = 2;
    
    public Livro(String codigo, String titulo, int ano, String autor, String isbn){
        super(codigo, titulo, ano);
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor Inválido");
        }

        this.autor = autor;
        this.isbn = isbn;
        this.renovacaoUtilizadas = 0;
        this.nomeReservante = null;
    }

    @Override
    public int getPrazoEmprestimoDias(){
        return 14;
    }

    @Override
    public double getMultaPorDia(){
        return 0.50;
    }

    @Override
    public String getCategoria() {
        return "Livro";
    }

    @Override
    public String getDescricao() {
        return "Livro: " + getTitulo()
                + " | Autor: " + autor
                + " | ISBN: " + isbn;
    }

    @Override
    public String getReservante() {
        return nomeReservante;
    }


    @Override
    public void reservar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuário não pode ser nulo"
            );
        }

        if (!isDisponivel()) {
            System.out.println("Livro indisponível para reserva.");
            return;
        }

        if (nomeReservante != null) {
            System.out.println("Livro já reservado.");
            return;
        }

        nomeReservante = usuario.getNome();
    }

    @Override
    public boolean temReserva() {
        return nomeReservante != null;
    }

    @Override
    public void cancelarReserva() {
        nomeReservante = null;
    }


}























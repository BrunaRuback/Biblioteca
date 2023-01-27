import java.util.*;

public class Livro {
    private String autor;
    private String editora;
    private String titulo;
    private Date dataPublicacao;
    private int codigo;
    private boolean disponibilidade;

    public String getTitulo() {
        return titulo;
    }

    public Livro(String autor, String editora, String titulo, Date dataPublicacao, int codigo) {
        this.autor = autor;
        this.editora = editora;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.codigo = codigo;
        this.disponibilidade = true;
    }

    public boolean isAlugado() {
        return this.disponibilidade == false;
    }

    public void serAlugado() {

        // se o livro ja esta em um aluguel, nao pode ser alugado novamente
        if (this.isAlugado()) return;

        this.disponibilidade = false;
    }

    public void serDevolvido() {

        // se o livro nao esta em um aluguel, nao pode ser devolvido
        if (!this.isAlugado()) return;

        this.disponibilidade = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Livro livro = (Livro) o;
        return codigo == livro.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Autor: " + autor + "\n" +
                "Editora: " + editora + "\n" +
                "Titulo: " + titulo + "\n" +
                "Data de publicacao" + dataPublicacao + "\n" +
                "Codigo: " + codigo + "\n" +
                "-------" + "\n";
    }
}

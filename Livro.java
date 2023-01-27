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


    public boolean devolucao(){
        return false;
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

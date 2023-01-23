import java.util.*;

public class Livro {
    private String autor;
    private String editora;
    private String titulo;
    private Date dataPublicacao;
    private int codigo;
    private ArrayList<Aluguel> alugueis;

    public Livro(String autor, String editora, String titulo, Date dataPublicacao, int codigo) {
        this.autor = autor;
        this.editora = editora;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.codigo = codigo;
    }

    public boolean isAlugado() {
        if (this.alugueis.size() == 0)
            return false;
        return this.alugueis.get(alugueis.size() - 1).estaAtivo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Livro livro = (Livro) o;
        return titulo == livro.titulo;
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
                "-------";
    }
}

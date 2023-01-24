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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
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
                "-------" + "\n";
    }
}

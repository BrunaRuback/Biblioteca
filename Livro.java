import java.util.*;

public class Livro {

    private String autor;
    private String editora;
    private String titulo;
    private Date dataPublicacao;
    private boolean disponivel;

    public Livro(String autor, String editora, String titulo, Date dataPublicacao, boolean disponivel) {
        this.autor = autor;
        this.editora = editora;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.disponivel = disponivel;
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
    
    public boolean isAtivo(){
        return true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Livro livro = (Livro) o;
        return titulo.equals(livro.titulo);
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + 
                " , autor: " + autor + 
                " , editora: " + editora +
                " , data de publicacao: " + dataPublicacao;
    }

}


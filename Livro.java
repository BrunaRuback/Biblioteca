import java.util.Date;

public class Livro 
{
    private String titulo;
    private String editora;
    private String autor;
    private Date dataPublicaçao;
    
    public Livro(String titulo, String editora, String autor, Date dataPublicaçao) {
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
        this.dataPublicaçao = dataPublicaçao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDataPublicaçao() {
        return dataPublicaçao;
    }

    public void setDataPublicaçao(Date dataPublicaçao) {
        this.dataPublicaçao = dataPublicaçao;
    }
}

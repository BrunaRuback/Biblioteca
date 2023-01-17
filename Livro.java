import java.util.*;

public class Livro {
    
    private String autor;
    private String editora;
    private String titulo;
    private Date dataPublicacao;

    public Livro(String autor, String editora, String titulo, Date dataPublicacao) {
        this.autor = autor;
        this.editora = editora;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isAtivo(){
        return true;
    }
}


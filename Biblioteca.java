import java.util.ArrayList;

public class Biblioteca 
{
    private ArrayList<Livro> livros;

    public Biblioteca()
    {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro)
    {
        this.livros.add(livro);
    }
}

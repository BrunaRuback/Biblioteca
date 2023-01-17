import java.util.*;

public class Biblioteca {
    private ArrayList<Cliente> clientes;
    private ArrayList<Livro> livros;
    private ArrayList<Aluguel> alugueis;

    public Biblioteca(){
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public boolean adiconaCliente(Cliente cliente){
        if(clientes.contains(cliente))
            return false;
        clientes.add(cliente);
        return true;
    }

    public boolean removeCliente(Cliente cliente){
        if (clientes.contains(cliente) && !cliente.estaAtivo()) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public boolean removeLivro(Livro livro){
        if (livros.contains(livro) && !livro.isAtivo()) {
            livros.remove(livro);
            return true;
        }
        return false;
    }

    public boolean fazAluguel(Livro livro, Cliente cliente, Date inicio, Date retorno){
        return true;
    }

    public void listarClientes(){
        System.out.printf("\n----- Lista de clientes ----- \n");
        for(Cliente cliente : getClientes())
        {
            System.out.print(cliente);
        }
    }

    public void listarAlugueis(){
        System.out.printf("Lista de alugueis: ");
        for(Aluguel aluguel : getAlugueis())
        {
            System.out.print(aluguel);
        }
    }

    public void listarLivros(){
        System.out.printf("Lista de livros: ");
        for(Livro livro : getLivros())
        {
            System.out.print(livro);
        }
    }
}

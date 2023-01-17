import java.lang.reflect.Array;
import java.util.*;
import java.util.Objects;

public class Biblioteca {
    private ArrayList<Cliente> clientes;
    private ArrayList<Livro> livros;
    private ArrayList<Aluguel> alugueis;

    public Biblioteca(){
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alugueis = new ArrayList<>();
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

    public boolean fazAluguel(Livro livro, Cliente cliente, Date inicio, Date retorno){
        return true;
    }

}

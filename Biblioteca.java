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
    
    public ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    public boolean adiconaCliente(Cliente cliente){
        if(clientes.contains(cliente))
            return false;
        clientes.add(cliente);
        return true;
    }

    public boolean removeCliente(Cliente cliente, String cpf){
        Cliente clienteEscolhido = acharClientePeloCPF(cpf);
            if(!clienteEscolhido.temAlugueisAtivos()){
                clientes.remove(clienteEscolhido);
                return true;
            }
        return false;
    }

    public boolean adicionaLivro(Livro livro){
        if(livros.contains(livro))
            return false;
        livros.add(livro);
        return true;
    }

    public boolean removeLivro(String titulo) {
        Livro livroRemovido = acharLivroPeloTitulo(titulo);
            if(livros.contains(livroRemovido)){
                livros.remove(livroRemovido);
                return true;
            }
            return false;
    }

    public boolean fazAluguel(String tituloLivro, String cpfCliente){
        //verificar se o cliente pode alugar mais um
        Livro livro = this.acharLivroPeloTitulo(tituloLivro);

        // verifica se o livro existe
        if (livro == null) {
            return false;
        }

        if (livro.isAlugado()) return false;

        Cliente cliente = this.acharClientePeloCPF(cpfCliente);

        // verifica se cliente existe
        if (cliente == null) {
            return false;
        }

        if (cliente.estaTresUltimosAlugados(livro)) {
            return false;
        }

        if (cliente.qtdAlugueisAtivos == 2) {
            return false;
        }

        Aluguel aluguel = new Aluguel(livro, cliente);

        this.alugueis.add(aluguel);
        
        return true; //todo: remover quando completar o codigo

    }

    public boolean encerrarAluguel(Livro livro, Cliente cliente) {


        for(Aluguel aluguel: this.alugueis){

            Cliente clienteAluguel = aluguel.getCliente();
            Livro livroAluguel = aluguel.getLivro();

            if (clienteAluguel.equals(cliente) && livroAluguel.equals(livro) && aluguel.estaAtivo()) {
                aluguel.encerrar();
                return true;
            } 

        }
        return false;
    }

    public Livro acharLivroPeloTitulo(String titulo) {
        for (Livro livroEscolhido : this.livros) {
            if (titulo.equals(livroEscolhido.getTitulo())) {
                return livroEscolhido;
            }
        }
        return null;
    }

    public Cliente acharClientePeloCPF(String cpf) {
        for (Cliente clienteEscolhido : this.clientes) {
            if (cpf.equals(clienteEscolhido.getCpf())) {
                return clienteEscolhido;
            }
        }
        return null;
    }

    public void listarClientes() {
        System.out.printf("\n----- Lista de clientes ----- \n");
        for (Cliente cliente : this.clientes) {
            System.out.print(cliente);
        }
    }

    public void listarAlugueis() {
        System.out.printf("\n----- Lista de alugueis: -----\n");
        for (Aluguel aluguel : this.alugueis) {
            System.out.print(aluguel);
        }
    }

    public void listarLivros() {
        System.out.printf("\n----- Lista de livros: -----\n");
        for (Livro livro : this.livros) {
            System.out.print(livro);
        }
    }

}

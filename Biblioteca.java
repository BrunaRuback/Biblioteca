import java.util.*;

public class Biblioteca {
    private ArrayList<Cliente> clientes;
    private ArrayList<Livro> livros;
    private ArrayList<Aluguel> alugueis;

    public Biblioteca() {
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

    public boolean adiconaCliente(Cliente cliente) {
        if (clientes.contains(cliente))
            return false;
        clientes.add(cliente);
        return true;
    }

    public boolean removeCliente(Cliente cliente, String cpf) {
        for(Cliente clienteRemovido: this.clientes){
                if(cliente.getCpf() == cpf){
                    clientes.remove(clienteRemovido);
                    return true;
                }  
            }
        return false;
    }

    public boolean adicionaLivro(Livro livro) {
        if (livros.contains(livro))
            return false;
        livros.add(livro);
        return true;
    }

    public boolean removeLivro(Livro livro, String titulo) {
        for(Livro livroRemovido: this.livros){
            if(livro.getTitulo() == titulo){
                livros.remove(livroRemovido);
                return true;
            }  
        }
        return false;
    }

    public boolean fazAluguel(Livro livro, Cliente cliente) {
        // verificar se o livro existe
        // verificar se o livro não está alugado
        // verificar se o cliente pode alugar mais um
        // verificar se o cliente não pegou eles (3 ultimos)
        if (!livro.isAlugado() &&
                cliente.verificaSeLimiteDeAlugueisEstaRespeitado() &&
                !cliente.estaTresUltimosAlugados(livro)) {
            Date hoje = new Date();
            Date dataHojeSemHora = new Date(hoje.getDate(), hoje.getMonth(), hoje.getYear());

            Aluguel aluguel = new Aluguel(livro, cliente, hoje);

            // setar livro como alugado
            livro.isAlugado();
            // adcioinar aluguel nos ativos
            cliente.adicionarAluguel(aluguel);
            // adcionar no historico
            cliente.adicionarHistorico(aluguel);
            // adcionar na lista de alugueis de biblioteca
            alugueis.add(aluguel);

            return true;
        }
        return false;
    }

    public boolean desfazerAluguel(Aluguel aluguel, Cliente cliente) {
        for(Aluguel aluguelRemovido: this.alugueis){
            if(aluguel.estaAtivo() && cliente.estaAtivo()){
                cliente.removerAluguel(aluguelRemovido);
                cliente.removerHistorico(aluguelRemovido);
                alugueis.remove(aluguelRemovido);
                return true;
            }  
        }
        return false;
    }

    public void listarClientes() {
        System.out.printf("\n----- Lista de clientes ----- \n");
        for (Cliente cliente : getClientes()) {
            System.out.print(cliente);
        }
    }

    public void listarAlugueis() {
        System.out.printf("\n----- Lista de alugueis: -----\n");
        for (Aluguel aluguel : getAlugueis()) {
            System.out.print(aluguel);
        }
    }

    public void listarLivros() {
        System.out.printf("\n----- Lista de livros: -----\n");
        for (Livro livro : getLivros()) {
            System.out.print(livro);
        }
    }

}

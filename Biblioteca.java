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
        Cliente clienteEscolhido = acharClientePeloCPF(cliente, cpf);
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

    public boolean removeLivro(Livro livro, String titulo) {
        Livro livroRemovido = acharLivroPeloTitulo(livro, titulo);
            if(livros.contains(livroRemovido)){
                livros.remove(livroRemovido);
                return true;
            }
            return false;
    }

    public boolean fazAluguel(Livro livro, Cliente cliente){
        //verificar se o livro existe
        //verificar se o livro não está alugado
        //verificar se o cliente pode alugar mais um
        //verificar se o cliente não pegou eles (3 ultimos)
        if (!livro.isAlugado() &&
                cliente.temLimiteParaAlugar() &&
                !cliente.estaTresUltimosAlugados(livro)){
            Date hoje = new Date();
            Date dataHojeSemHora = new Date(hoje.getDate(),hoje.getMonth(),hoje.getYear() );

            Aluguel aluguel = new Aluguel(livro, cliente, hoje);

//            cliente.adicionarAluguelNoHistoricoTresUltimos(aluguel);
            //todo: adicionar no historico de alugueis do Livro
            Livro livroAlugado = new Livro(null, null, null, dataHojeSemHora, 0);
            livroAlugado.adicionaListaAlugueis(aluguel);

            cliente.adicionarAluguelAtivo(aluguel);
            //todo: adicionar no historico da biblioteca tambem
            alugueis.add(aluguel);
        }

        return false; //todo: remover quando completar o codigo

    }

    public boolean desfazerAluguel(Aluguel aluguel, Cliente cliente) {
        for(Aluguel aluguelRemovido: this.alugueis){
            if(aluguel.estaAtivo() && cliente.temAlugueisAtivos()){
                cliente.getAlugueis().remove(aluguelRemovido);
                alugueis.remove(aluguelRemovido);
                return true;
            }     
        }
        return false;
    }

    public Livro acharLivroPeloTitulo(Livro livro, String titulo) {
        for (Livro livroEscolhido : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livroEscolhido;
            }
        }
        return null;
    }

    public Cliente acharClientePeloCPF(Cliente cliente, String cpf) {
        for (Cliente clienteEscolhido : clientes) {
            if (cliente.getCpf().equals(cpf)) {
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

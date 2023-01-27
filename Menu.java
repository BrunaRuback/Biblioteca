import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    private Biblioteca biblioteca;

    public Menu() {
        biblioteca = new Biblioteca();

    }

    public void apresentaMenu() {

        int opcoes = 0;

        do {
            this.escreveOpcoes();
            opcoes = leInt();
            switch (opcoes) {
                case 1: // criar cliente

                    // usuario digitar as informações
                    Cliente cliente = criaCliente();
                    // chamar biblioteca.adcionaCliente
                    biblioteca.adiconaCliente(cliente);
                    break;
                case 2: // remover cliente

                    System.out.println("Digite o cpf do cliente que deseja remover: ");
                    String cpf = leString();
                    // chama a função
                    Cliente clienteEscolhido = removeCliente(cpf);
                    biblioteca.removeCliente(clienteEscolhido, cpf);
                    break;
                case 3: // criar livro

                    Livro livro = criaLivro();
                    biblioteca.adicionaLivro(livro);
                    break;
                case 4: // remover livro

                    System.out.println("Digite o título do livro: ");
                    String titulo = leString();

                    biblioteca.removeLivro(titulo);
                    break;
                case 5: //TODO: fazer aluguel

                    Aluguel aluguel = fazAluguel();
                    break;
                case 6: // devolver livro

                    break;
                case 7: // listar clientes
                    biblioteca.listarClientes();
                    break;
                case 8: // listar livros
                    biblioteca.listarLivros();
                    break;
                case 9: // TODO: relatorio alugueis 
                    System.out.println("Filtrar relatorio por: \n a- Data \n b- Livro \n c- Cliente");
                    String escolha = leString();

                    switch (escolha) {
                        case "a":
                            break;
                        case "b":
                            break;
                        case "c":
                            break;
                    }
                    break;
                case 0:
                    break;
            }
        } while (opcoes != 0);

    }

    public Cliente criaCliente() {
        System.out.println("Nome: ");
        String nome = leString();
        System.out.println("CPF: ");
        String cpf = leString();
        Cliente c = new Cliente(nome, cpf);
        return c;
    }

    public Cliente removeCliente(String cpf) {
        Cliente cliente = new Cliente("nome", cpf);
        return cliente;
    }

    //TODO: consertar a data
    public Livro criaLivro() {
        System.out.println("Digite o autor do livro: ");
        String autor = leString();
        System.out.println("Digita editora do livro: ");
        String editora = leString();
        System.out.println("Digite o titulo do livro: ");
        String titulo = leString();
        System.out.println("Digite a data de publicacao do livro: ");
        String data = leString();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YY");
        // Date dapaPublicacao = formato.parse(data);
        System.out.println("Digita o codigo do livro: ");
        int codigo = leInt();

        Livro livro = new Livro(autor, editora, titulo, null, codigo);
        return livro;
    }

    public Livro removeLivro(String titulo) {
        Livro livro = new Livro("autor", "editora", titulo, null, 0);
        biblioteca.removeLivro(titulo);

        return livro;
    }

    //TODO:
    public Aluguel fazAluguel() {
        System.out.println("Digite o título do livro: ");
        String tituloLivro = leString();
        System.out.println("Digite o cpf do cliente que deseja alugar o livro: ");
        String cpfAluguel = leString();
        Date hoje = new Date();

        Livro livroAlugado = new Livro("a", "a", tituloLivro, null, '0');
        Cliente clienteAluguel = new Cliente("nome", cpfAluguel);
        Aluguel novoAluguel = new Aluguel(livroAlugado, clienteAluguel, hoje);

        biblioteca.fazAluguel(livroAlugado, clienteAluguel);
        return novoAluguel;
    }

    //TODO: revisar
    private void devolverLivro() 
    {
        System.out.println("Titulo do livro a ser devolvido: ");
        String titulo = leString();
        Livro livro = new Livro("a", "a", titulo, null, 0);
        livro = biblioteca.acharLivroPeloTitulo(titulo);

        System.out.println("CPF do cliente que realizou o aluguel: ");
        String cpf = leString();
        Cliente clienteEscolhido = new Cliente("nome", cpf);
        clienteEscolhido = biblioteca.acharClientePeloCPF(clienteEscolhido, cpf);

        Aluguel aluguelRemovido = new Aluguel(livro, clienteEscolhido, null);
        biblioteca.desfazerAluguel(aluguelRemovido, clienteEscolhido);
    }

    public String leString() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }

    public int leInt() {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        return i;
    }

    public void escreveOpcoes() {
        System.out.println(
                "\n---- menu ---- \n(1) Cadastrar cliente\n(2) Remover cliente\n(3) Adicionar livro\n(4) Remover livro\n(5) Fazer aluguel\n(6) Devolver livro\n(7) Listar clientes\n(8) Listar livros\n(9) Emitir relatorio de alugueis\n(0) Sair");
    }
}

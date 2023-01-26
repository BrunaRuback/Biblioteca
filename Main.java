/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {

            System.out.println("----- Menu da Biblioteca -----");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Adicionar livro");
            System.out.println("3. Remover cliente");
            System.out.println("4. Remover livro");
            System.out.println("5. Fazer aluguel");
            System.out.println("6. Devolver livro");
            System.out.println("7. Listar clientes");
            System.out.println("8. Listar livros");
            System.out.println("9. Listar alugueis");
            System.out.println("10. Emitir relatorio de alugueis");
            System.out.println("0. Sair");
            System.out.print("Selecione uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // cadastrar cliente
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cpf: ");
                    String cpf = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nome, cpf);
                    biblioteca.adiconaCliente(novoCliente);
                    break;
                case 2: // cadastrar livro

                    System.out.println("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.println("Digita editora do livro: ");
                    String editora = scanner.nextLine();
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Digita o codigo do livro: ");
                    int codigo = scanner.nextInt();

                    Livro livro = new Livro(autor, editora, titulo, null, codigo);
                    biblioteca.adicionaLivro(livro);
                    break;
                case 3: // remover cliente
                    System.out.println("Digite o cpf do cliente que deseja remover: ");
                    String cpfEscolhido = scanner.nextLine();

                    Cliente clienteRemovido = new Cliente("a", cpfEscolhido);
                    biblioteca.removeCliente(clienteRemovido, cpfEscolhido);

                    if (clienteRemovido != null)
                        System.out.println("Cliente removido!");
                    else 
                    {
                        System.out.println("Cliente nao pode ser removido!");
                    }
                    break;
                case 4: // remover livro
                    System.out.println("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();

                    Livro livroRemovido = new Livro("autor", "editora", tituloLivro, null, 0);
                    biblioteca.removeLivro(livroRemovido, tituloLivro);

                    if (livroRemovido != null)
                        System.out.println("Livro removido!");
                    else 
                    {
                        System.out.println("Livro nao pode ser removido!");
                    }
                    break;
                case 5: // fazer aluguel
                    System.out.println("Digite o título do livro: ");
                    tituloLivro = scanner.nextLine();
                    System.out.println("Digite o cpf do cliente que deseja alugar o livro: ");
                    String cpfAluguel = scanner.nextLine();

                    Livro livroAlugado = new Livro("a", "a", tituloLivro, null, '0');
                    Cliente clienteAluguel = new Cliente("nome", cpfAluguel);
                    
                    biblioteca.fazAluguel(livroAlugado, clienteAluguel);
                    break;
                case 6: // devolver livro
                    System.out.println("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.println("Digite o título do livro: ");
                    String tituloRemover = scanner.nextLine();

                    Livro livroDevolver = new Livro("autor", "editora", tituloRemover, null, 0);
                    Cliente cliente = new Cliente("a", cpfCliente);
                    Aluguel aluguelDesfazer = new Aluguel(livroDevolver, cliente, null);
                    
                    biblioteca.desfazerAluguel(aluguelDesfazer, cliente);
                    break;
                case 7: // listar clientes
                    biblioteca.listarClientes();
                    break;
                case 8: // listar livros
                    biblioteca.listarLivros();
                    break;
                case 9: // listar alugueis
                    biblioteca.listarAlugueis();
                    break;
                case 10: // relatorio de alugueis
                    System.out.println("Filtrar relatorio por: \n a- Data \n b- Livro \n c- Cliente");
                    String escolha = scanner.nextLine();

                    switch (escolha) {
                        case "a":
                            break;
                        case "b":
                            break;
                        case "c":
                            break;
                    }
                    break;
                case 0: // sair
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.apresentaMenu();
    }



}

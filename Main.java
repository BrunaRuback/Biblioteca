import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        
        while(true){

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
            System.out.println("0. Sair");
            System.out.print("Selecione uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao)
            {
                case 1: //cadastrar cliente
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cpf: ");
                    String cpf = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nome, cpf);
                    biblioteca.adiconaCliente(novoCliente);
                    break;
                case 2: //cadastrar livro ---- COM PROBLEMA ----
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.println("Digita editora do livro: ");
                    String editora = scanner.nextLine();
                    System.out.println("Digite a data de publicacao do livro: ");
                    Date dataPublicacao;

                    Livro livro = new Livro(autor, editora, titulo, null, true);
                    biblioteca.adicionaLivro(livro);
                    break;
                case 3: // remover cliente
                        System.out.println("Digite o cpf do cliente que deseja remover: ");
                        String cpfEscolhido = scanner.nextLine();

                        Cliente clienteRemovido = biblioteca.getClientePorCpf(cpfEscolhido);
                        biblioteca.removeCliente(clienteRemovido);

                        if (clienteRemovido != null) {
                        System.out.println("Cliente removido com sucesso!");
                        } else {
                        System.out.println("Cliente não encontrado");
                        }
                        break;
                case 4: //remover livro
                    System.out.println("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();

                    Livro livroRemovido = biblioteca.getLivroPorTitulo(tituloLivro);
                    biblioteca.removeLivro(livroRemovido);

                    if (livroRemovido == null) {
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado");
                    }
                    break;
                case 5: //fazer aluguel
                System.out.println("Digite o título do livro: ");
                tituloLivro = scanner.nextLine();
                System.out.println("Digite o cpf do cliente que deseja alugar o livro: ");
                String cpfAluguel = scanner.nextLine();

                Livro livroAluguel = biblioteca.getLivroPorTitulo(tituloLivro);
                Cliente clienteAluguel = biblioteca.getClientePorCpf(cpfAluguel);

                if (livroAluguel != null && clienteAluguel != null) {
                    if (livroAluguel.isDisponivel()) {
                        Aluguel aluguel = new Aluguel(livroAluguel, clienteAluguel, null);
                        biblioteca.adicionaAluguel(aluguel);
                        livroAluguel.setDisponivel(false);
                        System.out.println("Aluguel realizado com sucesso!");
                    } else {
                        System.out.println("Livro não está disponível para aluguel");
                    }
                } else {
                    System.out.println("Cliente ou livro não encontrado");
                }
                    break;
                case 6: // devolver livro
                    System.out.println("Digite o título do livro: ");
                    tituloLivro = scanner.nextLine();

                    livroAluguel = biblioteca.getLivroPorTitulo(tituloLivro);

                    if (livroAluguel != null) {
                        if (!livroAluguel.isDisponivel()) {
                            Aluguel aluguelDevolucao = biblioteca.getAluguelPorLivro(livroAluguel);
                            biblioteca.removeAluguel(aluguelDevolucao);
                            livroAluguel.setDisponivel(true);
                            System.out.println("Devolução realizada com sucesso!");
                        }
                    } 
                    else {
                        System.out.println("Livro já está disponível para aluguel");
                    }
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
                case 0: // sair
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
} 
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
        Livro livro = new Livro(null, null, null, null);

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
                    System.out.println("Digite o autor do livro: ");
                    String dataPublicacao = scanner.nextLine();

                    livro = new Livro(autor, editora, titulo, null);
                    break;
                case 3: // remover cliente ---- COM PROBLEMA ----
                    System.out.println("Digite o cpf do cliente que deseja remover: ");
                    String cpfEscolhido = scanner.nextLine();

                    for(Cliente cliente: biblioteca.getClientes())
                    {
                        if(cpfEscolhido == cliente.getCpf()) 
                        {
                            biblioteca.removeCliente(cliente);
                            System.out.printf("Cliente foi removido com sucesso!");
                        } 
                        else
                        {
                            System.out.printf("Cliente não pode ser removido");
                        }
                    }
                    break;
                case 4: //remover livro
                System.out.println("Digite o titulo do livro: ");
                titulo = scanner.nextLine();

                for(Livro livros: biblioteca.getLivros())
                {
                    if (titulo == livro.getTitulo())
                    {
                    biblioteca.removeLivro(livro);
                    System.out.printf("Livro foi removido com sucesso!");
                    }
                    else{
                        System.out.printf("Livro nao pode ser removido.");
                    }
                }
                    break;
                case 5: //fazer aluguel ---- COM PROBLEMA ----
                    System.out.println("Digite o titulo do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.println("Digite o cpf do cliente que deseja alugar o livro: ");
                    String cpfAluguel = scanner.nextLine();
                    System.out.println("Digite a data de inicio do aluguel: ");
                    String dataE = scanner.nextLine();
                    DateFormat dataEmp = new SimpleDateFormat();
                    //Date dataEmprestimo = dataEmp.parse(dataE);
                    System.out.println("Digite a data de fim do aluguel: ");
                    //biblioteca.fazAluguel(null, cliente, null, null);
                    break;
                case 6: // devolver livro ---- TIRAR DA LISTA DE 3 ULTIMOS ----
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
            }
        }
    }
} 
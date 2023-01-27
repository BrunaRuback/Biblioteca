import java.util.*;

public class Aluguel {
    private Livro livro;
    private Cliente cliente;
    private Date dataEmprestimo;
    private Date dataRetorno;


    public Aluguel(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = Calendar.getInstance().getTime();
        this.dataRetorno = null;

        cliente.alugar(this);
        livro.serAlugado();
    }
    
    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean estaAtivo(){
        return dataRetorno == null;
    }

    public void encerrar() {
        Date dataRetorno = Calendar.getInstance().getTime();
        this.dataRetorno = dataRetorno;

        this.cliente.devolver();
        this.livro.serDevolvido();
    }

    @Override
    public String toString() {
        return "Livro alugado" + livro + "\n" +
                "Cliente: " + cliente + "\n" +
                "Data de emprestimo" + dataEmprestimo + "\n" +
                "Data de retorno" + dataRetorno + "\n" +
                "-------" + "\n";
    }
}

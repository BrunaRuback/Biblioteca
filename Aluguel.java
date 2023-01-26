import java.util.*;

public class Aluguel {
    private Livro livro;
    private Cliente cliente;
    private Date dataEmprestimo;
    private Date dataRetorno;


    public Aluguel(Livro livro, Cliente cliente, Date dataEmprestimo) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetorno = null;
        cliente.adicionarAluguelAtivo(this);
    }
    
    public Livro getLivro() {
        return livro;
    }

    public boolean estaAtivo(){
        return dataRetorno == null;
    }

    public void devolver() {
        Date dataRetorno = Calendar.getInstance().getTime();
        this.dataRetorno = dataRetorno;
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

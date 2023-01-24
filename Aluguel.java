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
    }

    public boolean estaAtivo() {
        return dataRetorno == null;
    }

    public Livro getLivro() {
        return livro;
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

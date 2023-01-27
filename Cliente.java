import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private String nome, cpf;
    private ArrayList<Aluguel> historicoAlugueis;
    int qtdAlugueisAtivos;
    
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.historicoAlugueis = new ArrayList<>();
        this.qtdAlugueisAtivos = 0;
    }
    
    public ArrayList<Aluguel> getHistoricoAlugueis() {
        return historicoAlugueis;
    }

    public int qtdAlugueisAtivos() {
        return this.qtdAlugueisAtivos;
    }

    public void alugar(Aluguel aluguel) {
        this.qtdAlugueisAtivos++;
        this.historicoAlugueis.add(aluguel);
    }

    public void devolver() {
        this.qtdAlugueisAtivos--;
    }

    public boolean estaTresUltimosAlugados(Livro livro) {
        int posicaoDoUltimoLivroAlugado = historicoAlugueis.size() - 1;
        int posicaoDoAntiPenultimoLivroAlugado = posicaoDoUltimoLivroAlugado - 2;

        for (int i = posicaoDoUltimoLivroAlugado; i >= 0 && i >= posicaoDoAntiPenultimoLivroAlugado; i --){
            if (historicoAlugueis.get(i).getLivro().equals(livro))
                return true;
        }
        return false;
    }

    // private int qtdAlugueisAtivos(){
    //     int qtd = 0;
    //     for (Aluguel a : alugueis)
    //         if (a.estaAtivo())
    //             qtd ++;
    //     return qtd;
    // }

    public boolean temAlugueisAtivos() {
        return qtdAlugueisAtivos() != 0;
    }

    public boolean temLimiteParaAlugar() {
        return qtdAlugueisAtivos() < 2;
    }

  
    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Nome do cliente: " + nome + "\n" +
                "CPF: " + cpf + "\n";
    }

}

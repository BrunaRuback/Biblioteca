import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

    private String nome, cpf;
    private ArrayList<Aluguel> alugueisAtivos;
    private ArrayList<Aluguel> historico3Ultimos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.alugueisAtivos = new ArrayList<>();
        this.historico3Ultimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Aluguel> getAlugueisAtivos() {
        return alugueisAtivos;
    }

    public void setAlugueisAtivos(ArrayList<Aluguel> alugueisAtivos) {
        this.alugueisAtivos = alugueisAtivos;
    }

    public ArrayList<Aluguel> getHistorico3Ultimos() {
        return historico3Ultimos;
    }

    public void setHistorico3Ultimos(ArrayList<Aluguel> historico3Ultimos) {
        this.historico3Ultimos = historico3Ultimos;
    }

    // ---------- TODO: PROVAVELMENTE ESSAS DUAS FUNÇÕES NO DOJO? ---------- //
    private ArrayList<Aluguel> tresUltimos() {
        if (alugueisAtivos.size() < 3)
            return null;

        ArrayList<Aluguel> historico3Ultimos = new ArrayList<>();

        for (int i = alugueisAtivos.size() - 1; i < alugueisAtivos.size() - 4; i--) {
            historico3Ultimos.add(alugueisAtivos.get(i));
        }
        return historico3Ultimos;
    }

    public boolean tresUltimosLivros(Livro livro) {
        for (Aluguel aluguel : tresUltimos()) {
            if (aluguel.getLivro().equals(livro))
                return true;
        }
        return false;
    } // ----------------------------------------------------------------------------
      // //

    public boolean verificaSeLimiteDeAlugueisEstaRespeitado() {
        if (alugueisAtivos.size() < 2)
            return true;
        return false;
    }

    public boolean estaAtivo() {
        if (alugueisAtivos.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " , cpf: " + cpf + "\n";
    }
    
}

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

    public boolean estaTresUltimosAlugados(Livro livro) {
        for (Aluguel a : historico3Ultimos) {
            if (a.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Aluguel> adiciona3Ultimos() {
        for (int i = alugueisAtivos.size(); i < alugueisAtivos.size() - 4; i--) {
            historico3Ultimos = new ArrayList<>();
            // historico3Ultimos.add(alugueisAtivos(i));
        }
        return historico3Ultimos;
    }

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

    public boolean adicionarAluguel(Aluguel aluguel) {
        if (this.alugueisAtivos.contains(aluguel)) {
            return false;
        }
        return this.alugueisAtivos.add(aluguel);
    }

    public boolean removerAluguel(Aluguel aluguel) {
        if (this.alugueisAtivos.contains(aluguel)) {
            return this.alugueisAtivos.remove(aluguel);
        }
        return false;
    }

    public boolean adicionarHistorico(Aluguel aluguel) {
        if (this.historico3Ultimos.contains(aluguel)) {
            return false;
        }
        return this.historico3Ultimos.add(aluguel);
    }

    public boolean removerHistorico(Aluguel aluguel) {
        if (this.historico3Ultimos.contains(aluguel)) {
            return this.historico3Ultimos.remove(aluguel);
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
        return "Nome do cliente: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Alugueis ativos: " + alugueisAtivos + "\n" +
                "Historico de 3 ultimos alugueis: " + historico3Ultimos + "\n" +
                "-------" + "\n";
    }

}

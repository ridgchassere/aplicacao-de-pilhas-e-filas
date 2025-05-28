package doc;

import java.time.LocalDateTime;
import java.time.Duration;
public class Documento {
    private String nomeArquivo;
    private String nomeUsuario;
    private LocalDateTime horarioSolicitacao;
    private LocalDateTime horarioImpressao;

    public Documento(String nomeArquivo, String nomeUsuario) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = LocalDateTime.now();
    }

    public void setHorarioImpressao() {
        this.horarioImpressao = LocalDateTime.now();
    }

    public long getTempoEsperaSegundos() {
        if (horarioImpressao == null) return -1;
        return Duration.between(horarioSolicitacao, horarioImpressao).getSeconds();
    }

    public String getNomeArquivo() {return nomeArquivo;}
    public String getNomeUsuario() {return nomeUsuario;}
    public LocalDateTime getHorarioSolicitacao() {return horarioSolicitacao;}
    public LocalDateTime getHorarioImpressao() {return horarioImpressao;}

    @Override
    public String toString() {
        return "Arquivo: " + nomeArquivo + ", Usuário: " + nomeUsuario +
                ", Solicitação: " + horarioSolicitacao +
                (horarioImpressao != null ? ", finalização: " + horarioImpressao +
                        ", Tempo decorrido: " + getTempoEsperaSegundos() + "s" : "");
    }
}

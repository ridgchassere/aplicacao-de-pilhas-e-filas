package exercicioFila;
import java.util.Scanner;
import doc.Documento;
public class SimuladorImpressora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila(5);

        int opcao;
        do {
            System.out.println("\n1 - Adicionar documento");
            System.out.println("2 - Imprimir documento");
            System.out.println("3 - Consultar documento");
            System.out.println("4 - Mostrar fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (fila.filaCheia()) {
                        System.out.println("Fila cheia, Não é possível adicionar mais documentos");
                    } else {
                        System.out.print("Nome do arquivo: ");
                        String nomeArquivo = scanner.nextLine();
                        System.out.print("Nome do usuário: ");
                        String nomeUsuario = scanner.nextLine();
                        Documento doc = new Documento(nomeArquivo, nomeUsuario);
                        fila.enfileira(doc);
                        System.out.println("Documento: "+nomeArquivo+" adicionado com sucesso");
                    }
                    break;
                case 2:
                    if (fila.filaVazia()) {
                        System.out.println("Fila vazia");
                    } else {
                        Documento doc = (Documento) fila.desenfileira();
                        doc.setHorarioImpressao();
                        System.out.println("Documento impresso:");
                        System.out.println(doc);
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do arquivo para consultar: ");
                    String nomeConsulta = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < fila.total(); i++) {
                        Documento d = (Documento) fila.elementos(i);
                        if (d.getNomeArquivo().equalsIgnoreCase(nomeConsulta)) {
                            System.out.println("Documento: "+nomeConsulta+" encontrado na posição " + (i+1));
                            System.out.println("Horário de solicitação: " + d.getHorarioSolicitacao());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("O documento: "+nomeConsulta+" não está na fila");
                    break;
                case 4:
                    if (fila.filaVazia()) {
                        System.out.println("Fila vazia");
                    } else {
                        System.out.println("Fila de impressão:");
                        for (int i = 0; i < fila.total(); i++) {
                            System.out.println((i+1) + " - " + fila.elementos(i));
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
        scanner.close();
    }
}

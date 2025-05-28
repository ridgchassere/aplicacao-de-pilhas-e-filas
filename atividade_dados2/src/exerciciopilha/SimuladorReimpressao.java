package exerciciopilha;
import java.util.Scanner;
import doc.Documento;
public class SimuladorReimpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha(5);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Solicitar reimpressão");
            System.out.println("2 - Executar reimpressão");
            System.out.println("3 - Consultar documento");
            System.out.println("4 - Mostrar todos os documentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (pilha.estaCheio()) {
                        System.out.println("A pilha está cheia. Não é possível adicionar novos documentos.");
                    } else {
                        System.out.print("Nome do arquivo: ");
                        String nomeArquivo = scanner.nextLine();
                        System.out.print("Nome do usuário: ");
                        String nomeUsuario = scanner.nextLine();
                        Documento doc = new Documento(nomeArquivo, nomeUsuario);
                        pilha.push(doc);
                        System.out.println("Documento adicionado à pilha.");
                    }
                    break;
                case 2:
                    if (pilha.estaVazio()) {
                        System.out.println("Pilha vazia.");
                    } else {
                        Documento doc =(Documento) pilha.pop();
                        doc.setHorarioImpressao();
                        System.out.println("Reimpressão executada:");
                        System.out.println(doc);
                    }
                    break;
                case 3:
                    System.out.print("Nome do arquivo para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = pilha.tamanho() - 1; i >= 0; i--) {
                        Documento d = (Documento) pilha.elementoNaPosicao(i);
                        if (d.getNomeArquivo().equals(nomeBusca)) {
                            System.out.println("Documento encontrado na posição " + (pilha.tamanho() - 1 - i) + " a partir do topo.");
                            System.out.println("Solicitado em: " + d.getHorarioSolicitacao());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Documento não está na pilha.");
                    }
                    break;
                case 4:
                    System.out.println("Documentos na pilha:");
                    for (int i = pilha.tamanho() - 1; i >= 0; i--) {
                        System.out.println((pilha.tamanho() - 1 - i) + ": " + pilha.elementoNaPosicao(i));
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

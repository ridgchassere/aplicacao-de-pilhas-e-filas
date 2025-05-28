package exerciciopilha;

public class Pilha {
    private Object[] vetor;
    private int topo;

    public Pilha(int tamanho) {
        vetor = new Object[tamanho];
        topo = 0;
    }

    public void push(Object elemento) {
        if (estaCheio()) {
            throw new UnsupportedOperationException("erro ao realizar push");
        }
        vetor[topo++] = elemento;
    }
    public Object pop() {
        if (estaVazio()) {
            throw new VetorVazioException("vetor vazio, nao ha o que remover");
        }
        Object elemento = vetor[--topo];
        return elemento;
    }

    public boolean estaVazio() {
        return topo == -1;
    }
    public boolean estaCheio() {
        return topo == vetor.length;
    }
    public int tamanho() { return topo; }
    public Object elementoNaPosicao(int indice) {
        if (indice < 0 || indice > topo) {
            return null;
        }
        return vetor[indice];
    }

    @Override
    public String toString() {
        String s = "-----------\n";
        if (estaVazio())
            s += "esta vazia\n";
        else
            for (int i = topo-1; i >= 0; i--) {
                s += vetor[i] + "\n";
            }
        return s + "-----------\n";
    }
}
class VetorVazioException extends RuntimeException {
    public VetorVazioException(String msg) {
        super(msg);
    }
}
//Minha fila circular utilizando um array estático :(
public class MinhaFila {

    private static class Node {
        Ponto elemento;
        Node proximo;

        Node(Ponto elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private Node inicio;
    private Node fim;

    public MinhaFila() {
        inicio = null;
        fim = null;
    }

    public void enqueue(Ponto p) {
        Node novo = new Node(p);
        if (isEmpty()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public Ponto dequeue() {
        if (isEmpty()) return null;

        Ponto valor = inicio.elemento;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return valor;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}



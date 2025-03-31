//Minha fila circular utilizando um array estático :(
public class MinhaFila {

    private Node<Ponto> inicio;
    private Node<Ponto> fim;

    public MinhaFila() {
        inicio = null;
        fim = null;
    }

    public void enqueue(Ponto p) {
        Node<Ponto> novo = new Node<>(p);
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


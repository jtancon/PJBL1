//Minha fila circular utilizando um array estático :(
public class MinhaFila {
    private Ponto[] elementos;
    private int inicio, fim, tamanho;

    public MinhaFila(int capacidade) {
        elementos = new Ponto[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enqueue(Ponto p) {
        if (tamanho < elementos.length) {
            elementos[fim] = p;
            fim = (fim + 1) % elementos.length;
            tamanho++;
        }
    }

    public Ponto dequeue() {
        if (!isEmpty()) {
            Ponto p = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return p;
        }
        return null;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}

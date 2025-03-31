public class Node<T> {
    T elemento;
    Node<T> proximo;  // Usado na fila
    Node<T> anterior; // Usado na pilha

    Node(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}

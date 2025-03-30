//Minha Pilha aqui usamos o estilo último que entra é o primeiro a sair :p
public class MinhaPilha {

    private static class Node {
        Ponto elemento;
        Node anterior;

        Node(Ponto elemento) {
            this.elemento = elemento;
            this.anterior = null;
        }
    }

    private Node topo;

    public MinhaPilha() {
        topo = null;
    }

    public void push(Ponto p) {
        Node novo = new Node(p);
        novo.anterior = topo;
        topo = novo;
    }

    public Ponto pop() {
        if (isEmpty()) return null;

        Ponto valor = topo.elemento;
        topo = topo.anterior;
        return valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}

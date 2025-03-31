//Minha Pilha aqui usamos o estilo último que entra é o primeiro a sair :p
public class MinhaPilha {

    private Node<Ponto> topo;

    public MinhaPilha() {
        topo = null;
    }

    public void push(Ponto p) {
        Node<Ponto> novo = new Node<>(p);
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


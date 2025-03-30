//Minha Pilha aqui usamos o estilo último que entra é o primeiro a sair :p
public class MinhaPilha {
    private Ponto[] elementos;
    private int topo;
    public MinhaPilha(int capacidade) {
        elementos = new Ponto[capacidade];
        topo = -1;
    }

    public void push(Ponto p) {
        if (topo < elementos.length - 1) //verifica se ainda tem espaco para add algo
        {
            topo++;
            elementos[topo] = p;
        }
    }

    public Ponto pop() {
        if (!isEmpty()) {
            return elementos[topo--];
        }
        return null;
    }

    public boolean isEmpty() {
        return topo == -1;
    }
}

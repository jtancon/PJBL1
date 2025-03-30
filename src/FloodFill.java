//class princioal que escolhe o medoto de fila ou pilha
import java.awt.Color;
public class FloodFill {
    public static void preencherComPilha(Imagem imagem, int x, int y, Color novaCor) {
        int largura = imagem.getLargura();
        int altura = imagem.getAltura();
        Color corOriginal = imagem.getCor(x, y);
        if (corOriginal.equals(novaCor)) return;
        boolean[][] visitado = new boolean[largura][altura]; // controle de pixels visitados
        MinhaPilha pilha = new MinhaPilha(largura * altura);
        pilha.push(new Ponto(x, y));
        int contador = 0; // para nomear os arquivos
        while (!pilha.isEmpty()) {
            Ponto p = pilha.pop();
            if (p.x < 0 || p.y < 0 || p.x >= largura || p.y >= altura) continue;
            if (visitado[p.x][p.y]) continue;
            Color atual = imagem.getCor(p.x, p.y);
            if (!atual.equals(corOriginal)) continue;
            imagem.setCor(p.x, p.y, novaCor);
            visitado[p.x][p.y] = true;
            // Salvar a cada 20 pixels modificados
            if (contador % 1 == 0) {
                try {
                    imagem.salvarSemFechar("pilha_frame_" + String.format("%04d", contador) + ".png");
                } catch (Exception e) {
                    System.out.println("Erro ao salvar frame " + contador);
                }
            }
            contador++;
            pilha.push(new Ponto(p.x + 1, p.y));
            pilha.push(new Ponto(p.x - 1, p.y));
            pilha.push(new Ponto(p.x, p.y + 1));
            pilha.push(new Ponto(p.x, p.y - 1));
        }
        // Salvar imagem final
        try {
            imagem.salvar("saida.png");
        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem final.");
        }
    }
    public static void preencherComFila(Imagem imagem, int x, int y, Color novaCor) {
        int largura = imagem.getLargura();
        int altura = imagem.getAltura();
        Color corOriginal = imagem.getCor(x, y);
        if (corOriginal.equals(novaCor)) return;
        boolean[][] visitado = new boolean[largura][altura];
        MinhaFila fila = new MinhaFila(largura * altura);
        fila.enqueue(new Ponto(x, y));
        int contador = 0;
        while (!fila.isEmpty()) {
            Ponto p = fila.dequeue();
            if (p.x < 0 || p.y < 0 || p.x >= largura || p.y >= altura) continue;
            if (visitado[p.x][p.y]) continue;
            Color atual = imagem.getCor(p.x, p.y);
            if (!atual.equals(corOriginal)) continue;
            imagem.setCor(p.x, p.y, novaCor);
            visitado[p.x][p.y] = true;
            // salva a cada 20 pixels (ou troque para salvar cada um)
            if (contador % 1 == 0) {
                try {
                    imagem.salvarSemFechar("frame_fila_" + String.format("%04d", contador) + ".png");
                } catch (Exception e) {
                    System.out.println("Erro ao salvar frame (fila) " + contador);
                }
            }
            contador++;
            fila.enqueue(new Ponto(p.x + 1, p.y));
            fila.enqueue(new Ponto(p.x - 1, p.y));
            fila.enqueue(new Ponto(p.x, p.y + 1));
            fila.enqueue(new Ponto(p.x, p.y - 1));
        }
        try {
            imagem.salvar("saida_fila.png");
        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem final (fila).");
        }
    }
}




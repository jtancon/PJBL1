import java.awt.Color;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Cria a pasta "img" se ela não existir
            File pastaImg = new File("img");
            if (!pastaImg.exists()) pastaImg.mkdirs();
            Imagem imgPilha = new Imagem("C:\\xampp\\htdocs\\PJBL1\\src\\entrada.png");
            FloodFill.preencherComPilha(imgPilha, 32, 32, Color.blue);
            imgPilha.salvar("img/saida_pilha.png");

            // Versão com FILA
            Imagem imgFila = new Imagem("C:\\xampp\\htdocs\\PJBL1\\src\\entrada.png");
            FloodFill.preencherComFila(imgFila, 32, 32, Color.CYAN);
            imgFila.salvar("img/saida_fila.png");
            GifMaker.gerarGif(".", "img/animacao_pilha.gif", 100, "pilha_frame_");
            GifMaker.gerarGif(".", "img/animacao_fila.gif", 100, "frame_fila_");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
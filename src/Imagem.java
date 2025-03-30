//aqui onde a arte acontece :D
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Imagem {
    private BufferedImage imagem;
    private Graphics2D g2d;

    public Imagem(String caminho) throws Exception {
        imagem = ImageIO.read(new File(caminho));
        g2d = imagem.createGraphics();

        // Cria a pasta img_frame se não existir
        File pastaFrame = new File("img_frame");
        if (!pastaFrame.exists()) pastaFrame.mkdirs();
    }

    public void salvarSemFechar(String caminho) throws Exception {
        if (!caminho.startsWith("img_frame/")) {
            caminho = "img_frame/" + caminho;
        }
        ImageIO.write(imagem, "png", new File(caminho));
    }

    public Color getCor(int x, int y) {
        return new Color(imagem.getRGB(x, y));
    }

    public void setCor(int x, int y, Color cor) {
        g2d.setColor(cor);
        g2d.fillRect(x, y, 1, 1);
    }

    public void salvar(String caminho) throws Exception {
        g2d.dispose();
        ImageIO.write(imagem, "png", new File(caminho));
    }

    public int getLargura() {
        return imagem.getWidth();
    }

    public int getAltura() {
        return imagem.getHeight();
    }
}
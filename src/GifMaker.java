//Class que faz o gif pega os frames e cria o bendito
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import javax.imageio.ImageTypeSpecifier;

public class GifMaker {

    public static void gerarGif(String pastaFrames, String nomeSaida, int delayMs, String prefixo) throws Exception {
        File dir = new File(pastaFrames + "/img_frame");
        File[] frames = dir.listFiles((d, name) -> name.endsWith(".png") && name.startsWith(prefixo));

        if (frames == null || frames.length == 0) {
            System.out.println("Nenhum frame encontrado.");
            return;
        }

        Arrays.sort(frames, Comparator.comparing(File::getName));

        BufferedImage primeiroFrame = ImageIO.read(frames[0]);

        ImageWriter writer = ImageIO.getImageWritersBySuffix("gif").next();
        ImageOutputStream output = ImageIO.createImageOutputStream(new File(nomeSaida));
        writer.setOutput(output);
        writer.prepareWriteSequence(null);

        ImageWriteParam param = writer.getDefaultWriteParam();

        for (int i = 0; i < frames.length; i++) {
            BufferedImage frame = ImageIO.read(frames[i]);
            ImageTypeSpecifier type = ImageTypeSpecifier.createFromBufferedImageType(frame.getType());
            IIOMetadata metadata = writer.getDefaultImageMetadata(type, param);
            String metaFormat = metadata.getNativeMetadataFormatName();

            IIOMetadataNode root = new IIOMetadataNode(metaFormat);
            IIOMetadataNode gce = new IIOMetadataNode("GraphicControlExtension");

            gce.setAttribute("disposalMethod", "none");
            gce.setAttribute("userInputFlag", "FALSE");
            gce.setAttribute("transparentColorFlag", "FALSE");
            gce.setAttribute("delayTime", Integer.toString(delayMs / 10));
            gce.setAttribute("transparentColorIndex", "0");
            root.appendChild(gce);

            if (i == 0) {
                IIOMetadataNode appExtensions = new IIOMetadataNode("ApplicationExtensions");
                IIOMetadataNode appExtension = new IIOMetadataNode("ApplicationExtension");
                appExtension.setAttribute("applicationID", "NETSCAPE");
                appExtension.setAttribute("authenticationCode", "2.0");
                appExtension.setUserObject(new byte[]{0x1, 0x0, 0x0});
                appExtensions.appendChild(appExtension);
                root.appendChild(appExtensions);
            }

            metadata.mergeTree(metaFormat, root);
            writer.writeToSequence(new javax.imageio.IIOImage(frame, null, metadata), null);
        }

        writer.endWriteSequence();
        output.close();

        System.out.println("GIF gerado com sucesso: " + nomeSaida);
        Desktop.getDesktop().open(new File(nomeSaida));
    }
}
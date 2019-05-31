package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

/**
 * The Bitmap Class with all its instance methods
 */
public class Bitmap {

    public Path inputPath;
    public Path outputPath;
    public BufferedImage bufferedImage;
    public String transform;
    BufferedImage img = null;


    public Bitmap(Path inputPath, Path outputPath, String transform){
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.transform = transform;

        try {
            bufferedImage = ImageIO.read(inputPath.toFile());
            this.img = bufferedImage;

        } catch (IOException e) {
            System.out.println("Something went wrong with the file" + e);
        }
    }

    //method to


}

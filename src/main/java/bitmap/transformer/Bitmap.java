package bitmap.transformer;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class Bitmap {

    public Path inputPath;
    public Path outputPath;
    public BufferedImage image;
    public String transform;


    public Bitmap(Path inputPath, Path outputPath, String transform){
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.transform = transform;
    }




}

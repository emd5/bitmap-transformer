package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

/**
 * The Bitmap Class with all its instance methods
 */
public class Bitmap {

    public Path inputPath;
    public Path outputPath;
    public BufferedImage bufferedImage;
    public String transform;
    BufferedImage img = null;
    File imgFile = null;


    public Bitmap(Path inputPath, Path outputPath, String transform){
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.transform = transform;
        // Open and read bitmap
        try {
            imgFile = new File(this.inputPath.toString());
            bufferedImage = ImageIO.read(imgFile);
            this.img = bufferedImage;

        } catch (IOException e) {
            System.out.println("Something went wrong with the file" + e);
        }
    }

    public void saveBitmap(){
        try{
            imgFile = new File(this.outputPath.toString());
            ImageIO.write(img, "jpg", imgFile);
        }catch(IOException e){
            System.out.println("Error: "+e);
        }
    }

    public void grayScale(){
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to grayscale
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = img.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                //replace RGB value with avg
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;

                img.setRGB(x, y, p);
            }
        }
    }

    //method to invert
    public void invert(){
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = img.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;


                //replace RGB value with avg
                p = (a<<24) | ((255-r)<<16) | ((255-g)<<8) | (255-b);

                img.setRGB(x, y, p);
            }
        }

    }

    public void verticalFlip(){
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height / 2; y++){
            for(int x = 0; x < width; x++){
                int top = img.getRGB(x,y);
                int bottom = img.getRGB(x,height - y - 1);
                // Set top to bottom
                img.setRGB(x, y, bottom);
                // Set bottom to top
                img.setRGB(x, height - y - 1, top);
            }
        }
    }

    public void randomize(){
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                Random random =	new Random();
                int p = img.getRGB(x,y);
                int alpha = (p>>24)&0xff;

                //replace RGB value with avg
                p = (alpha<<24) | (random.nextInt(255)<<16) | (random.nextInt(255)<<8) | random.nextInt(255);

                img.setRGB(x, y, p);
            }
        }
    }
}

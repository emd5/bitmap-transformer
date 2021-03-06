/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Please return with the correct parameters");
            System.out.println("./gradlew run --args 'input output transform'");
            return;
        }
        // Get arguments and format
        Path inputPath = Paths.get(args[0]);
        Path outputPath = Paths.get(args[1]);
        // Create bitmap
        Bitmap bitmap = new Bitmap(inputPath, outputPath, args[2]);
        // Do transformation
        //bitmap.grayScale();
        //bitmap.invert();
        //bitmap.verticalFlip();
        bitmap.randomize();
        // Save bitmap when transforms done
        bitmap.saveBitmap();
    }
}

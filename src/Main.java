import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int RECT_WIDTH = 1;
    private static final int RECT_HEIGHT = 1;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("PrimeColorFX");


        // Write custom pixels to create a pattern
        ImageView imageView = new ImageView(writePixels());
        Group root = new Group(imageView);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    private Image writePixels() {
        // Define properties of the image
        int spacing = 0;
        int rows = 1024;
        int columns = 1024;

        WritableImage image = new WritableImage(columns, rows);
        PixelWriter pixelWriter = image.getPixelWriter();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                pixelWriter.setColor(x, y, Color.BLACK);
            }
        }
        return image;
    }
}
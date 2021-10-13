import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("PrimeColorFX");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1001, 1101);
        root.getChildren().add(canvas);

        final List<Integer> Dividends = new ArrayList<>();
        final List<Integer> Divisors = new ArrayList<>();

        for (int i = 0; i < 10000; i++)
            Dividends.add(i);

        for (int z = 2; z < 5000; z++)
            Divisors.add(z);



        Boolean[] IsPrime = new Boolean[10000];
        Arrays.fill(IsPrime, false);

        Rectangle[][] rect = new Rectangle[100][100];
        for (int i = 0; i < 100; i++) {
            for (int z = 0; z < 100; z++) {
                rect[i][z] = new Rectangle(i * 10 + 1, z * 10 + 1, 9, 9);
                root.getChildren().add(rect[i][z]);
            }
        }

        rect[0][0].setFill(Color.BLUE);
        rect[0][1].setFill(Color.RED);

        for (int current : Dividends) {
            for (int divisor : Divisors) {
                if (divisor <= current / 2) {
                    if ((float) current % divisor == 0) {
                        IsPrime[current] = false;
                        break;
                    }
                } else {
                    IsPrime[current] = true;
                    break;
                }
            }
        }

        int rows = 100;
        int columns = 100;
        for (int index = 0;index < 10000; index++) {
            int column = index % columns;
            int row = (index - column) / columns;
            if (IsPrime[index])
                rect[column][row].setFill(Color.RED);
            else
                rect[column][row].setFill(Color.BLUE);
        }

        theStage.show();
    }
}
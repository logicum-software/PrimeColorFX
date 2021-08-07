import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage theStage)
    {
        theStage.setTitle( "PrimeColorFX" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 1024, 1024 );
        root.getChildren().add( canvas );

        //GraphicsContext gc = canvas.getGraphicsContext2D();

        Rectangle[][] rect = new Rectangle[100][100];
        for (int i = 0; i < 100; i++) {
            for (int z = 0; z < 100; z++) {
                rect[i][z] = new Rectangle(i * 10, z * 10, 10, 10);
                /*if (i % 2 > 0.0)
                    rect[i][z].setFill(Color.BISQUE);
                else
                    rect[i][z].setFill(Color.BLACK);*/

                root.getChildren().add(rect[i][z]);
            }
        }

        /*final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                gc.drawImage( earth, x, y );
                gc.drawImage( sun, 196, 196 );
            }
        }.start();*/

        theStage.show();
    }
}
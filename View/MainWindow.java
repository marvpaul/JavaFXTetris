package Tetris.View;

import Tetris.Controller.Movement;
import Tetris.Controller.MovementThread;
import Tetris.Model.Cube;
import Tetris.Model.CubeGroup;
import Tetris.Model.Grid;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Main window class
 */
public class MainWindow extends Application{
    private final double WIDTH = 400;
    private final double HEIGHT = 600;
    public Group group = new Group();  //root node for the play window
    public final Pane pane = new Pane(group);
    public static ArrayList<CubeGroup> cubeGroups;

    public final Scene scene = new Scene(pane, WIDTH, HEIGHT, Color.WHITE);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris");
        //create a pane for a group with all moving objects
        pane.setPrefSize(WIDTH,HEIGHT);
        Grid.setCubesX(10);
        Grid.setCubesY(15);
        Cube.setCubeWidth(WIDTH / Grid.getCubesX());
        Cube.setCubeHeight(HEIGHT / Grid.getCubesY());

        Cube c1 = new Cube(9, 0, Color.GREEN);
        System.out.println(c1.getCubeShape().getX() + " " + c1.getCubeShape().getY());

        Grid.window = this;


        Grid.spawnNew();
        (new Thread(new MovementThread())).start();

        createWindow(primaryStage);

    }

    private void createWindow(Stage prim){
        Movement.applyMovement(scene);
        prim.setScene(scene);


        //set pane autoresisable
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                System.out.println("Width: " + newSceneWidth);
                pane.setPrefWidth(scene.getWidth());
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                System.out.println("Height: " + newSceneHeight);
                pane.setPrefHeight(scene.getHeight());
            }
        });
        prim.show();
    }

}

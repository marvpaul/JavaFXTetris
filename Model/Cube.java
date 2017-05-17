package Tetris.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Cube {
    private static double cubeWidth;
    private static double cubeHeight;
    private Rectangle cubeShape;

    public Cube(int x, int y, Color c) {
        cubeShape = new Rectangle(cubeWidth, cubeHeight);
        cubeShape.setFill(c);
        cubeShape.setStrokeWidth(2);
        cubeShape.setStroke(Color.BLACK);
        cubeShape.setX((double)x*cubeWidth);
        cubeShape.setY((double) y*cubeHeight);
    }

    public Cube(Color c) {
        cubeShape = new Rectangle(cubeWidth, cubeHeight);
        cubeShape.setFill(c);
        cubeShape.setStrokeWidth(2);
        cubeShape.setStroke(Color.BLACK);
    }

    public static double getCubeHeight() {
        return cubeHeight;
    }

    public static void setCubeHeight(double cubeHeight) {
        Cube.cubeHeight = cubeHeight;
    }

    public static double getCubeWidth() {
        return cubeWidth;
    }

    public static void setCubeWidth(double cubeWidth) {
        Cube.cubeWidth = cubeWidth;
    }

    public Rectangle getCubeShape() {
        return cubeShape;
    }

    public void setCubeShape(Rectangle cubeShape) {
        this.cubeShape = cubeShape;
    }

    public void setShapePos(int x, int y){
        cubeShape.setX(x * cubeWidth);
        cubeShape.setY(y * cubeHeight);
    }
}

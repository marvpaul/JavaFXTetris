package Tetris.Controller;

import Tetris.Model.CubeGroup;
import javafx.scene.Scene;

/**
 * Handles user input
 */
public class Movement {
    public static void applyMovement(Scene scene){
        scene.setOnKeyTyped(event -> {
            System.out.println(event.getCharacter());
            if(event.getCharacter().equals("l")){
                CubeGroup.currentInstance.rotateLeft(false);
            } else if(event.getCharacter().equals("r")){
                CubeGroup.currentInstance.rotateRight(false);
            } else if(event.getCharacter().equals("d")){
                CubeGroup.currentInstance.move(1);
            }else if(event.getCharacter().equals("a")){
                CubeGroup.currentInstance.move(-1);
            }
        });
        scene.setOnKeyPressed(event -> {
            System.out.println(event.getText());

            if(event.getText().equals("s")){
                MovementThread.interval = 10;
            }
        });

        scene.setOnKeyReleased(event -> {

            if(event.getText().equals("s")){
                MovementThread.interval = 40;
            }
        });

        /*
        scene.setOnRotate(event ->{
            System.out.println("Rotated");
            CubeGroup.currentInstance.rotateLeft(false);
        });
        scene.setOnSwipeLeft(event ->{
            System.out.println("left");
            CubeGroup.currentInstance.move(-1);
        });
        scene.setOnSwipeRight(event ->{
            System.out.println("right");
            CubeGroup.currentInstance.move(1);
        });*/
    }
}

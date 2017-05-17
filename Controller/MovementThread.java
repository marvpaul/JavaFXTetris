package Tetris.Controller;

import Tetris.Model.Cube;
import Tetris.Model.CubeGroup;
import Tetris.Model.Grid;
import javafx.animation.AnimationTimer;

/**
 * Thread for cube movement
 */
public class MovementThread implements Runnable{
    public static int counter = 0;

    //The interval in which the cubes move down
    public static int interval = 40;

    /**
     * Handles all the animation stuff
     */
    public void run(){
        new AnimationTimer() { //animate all circles
            @Override
            public void handle(long now) {
                counter ++;
                if(counter >= interval){
                    for(Cube c : CubeGroup.currentGroup){
                        c.getCubeShape().setY(c.getCubeShape().getY() + c.getCubeHeight());
                    }
                    if(!Grid.updateArrayBool()){
                        for(Cube c : CubeGroup.currentGroup){
                            c.getCubeShape().setY(c.getCubeShape().getY() - c.getCubeHeight());
                        }
                        Grid.spawnNew();
                    }
                    counter = 0;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }

}

package Tetris.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Class for a group of 4 cubes
 * which represents a piece of blocks in Tetris
 */
public class CubeGroup {
    private boolean isActive = false;
    private Cube[] cubes = new Cube[4];
    private Color groupCol;
    private int[][][] rotationVecs = new int[4][4][2];
    private int rotAngel = 0;
    public static Cube[] currentGroup;
    public static CubeGroup currentInstance;

    public static Random rnd = new Random();

    /**
     * Constructor which creates 4 cubes and get a random formation
     */
    public CubeGroup() {
        String formation = getRandomFormation();

        for(int i = 0; i < 4; i++){
            Cube c = new Cube(groupCol);
            cubes[i] = c;
            Grid.window.group.getChildren().add(c.getCubeShape());
        }

        currentGroup = cubes;
        currentInstance = this;
        isActive = true;

        GroupSettings.applyCubePos(formation, cubes);
        rotationVecs = GroupSettings.getRotationVecs(formation);
    }

    /**
     * Gets a random formation
     * @return the formation as a string
     */
    public String getRandomFormation(){
        switch (rnd.nextInt(5)){
            case 0:
                groupCol = Color.BLUE;
                return "I";
            case 1:
                groupCol = Color.GREEN;
                return "L";
            case 2:
                groupCol = Color.BROWN;
                return "L2";
            case 3:
                groupCol = Color.YELLOW;
                return "O";
            default:
                groupCol = Color.RED;
                return "Z1";
        }
    }

    /**
     * Move the cube group in x direction
     * @param pos movement amount
     */
    public void move(int pos){
        for (int i = 0; i < currentGroup.length; i++) {
            Rectangle re = currentGroup [i].getCubeShape();
            re.setX(re.getX() + pos*Cube.getCubeWidth());
        }
        if (!Grid.updateArrayBool ()) {
            for (int i = 0; i < currentGroup.length; i++) {
                Rectangle re = currentGroup [i].getCubeShape();
                re.setX(re.getX() - pos*Cube.getCubeWidth());
            }
        }
    }

    /**
     * Perform a rotation of the group clockworks
     * @param back true if the last rotation failed and the rotation have to set back to normal
     */
    public void rotateRight(boolean back){
        if (rotAngel == 0) {
            rotate (3);
            rotAngel = 270;
        } else if (rotAngel == 90) {
            rotate (0);
            rotAngel = 0;
        } else if (rotAngel == 180) {
            rotate (1);
            rotAngel = 90;
        } else if (rotAngel == 270) {
            rotate (2);
            rotAngel = 180;
        }
        if (!back && !Grid.updateArrayBool ()) {
            rotateLeft (true);
        }
    }

    /**
     * Perform a rotation of the group against the clock
     * @param back true if the last rotation failed and the rotation have to set back to normal
     */
    public void rotateLeft(boolean back){
        if (rotAngel == 0) {
            rotate (1);
            rotAngel = 90;
        } else if (rotAngel == 90) {
            rotate (2);
            rotAngel = 180;
        }else if (rotAngel == 180) {
            rotate (3);
            rotAngel = 270;
        } else if (rotAngel == 270) {
            rotate (0);
            rotAngel = 0;
        }
        if (!back && !Grid.updateArrayBool()) {
            rotateRight (true);
        }
    }

    /**
     * Rotate the group clockwards
     * @param pos 0 is 0 degrees, 1 is 90 degrees ...
     */
    public void rotate(int pos){
        for (int i = 0; i < currentGroup.length; i++) {
            Rectangle re = currentGroup [i].getCubeShape();
            re.setX(re.getX() + rotationVecs[pos][i][0]*Cube.getCubeWidth());
            re.setY(re.getY() + rotationVecs[pos][i][1]*Cube.getCubeHeight());
        }
    }


}

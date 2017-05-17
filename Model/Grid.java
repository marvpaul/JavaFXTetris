package Tetris.Model;

import Tetris.View.MainWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Grid class for the cube array
 */
public class Grid {
    //Amount of cubes in x and y direction
    private static int cubesX, cubesY;

    //2D Boolean array, true stands for a cube at this position
    private static boolean[][] isCube;

    //All cubes
    private static List<Cube> cubeArray = new ArrayList<Cube>();

    public static MainWindow window;


    public static int getCubesX() {
        return cubesX;
    }

    public static void setCubesX(int cubesX) {
        Grid.cubesX = cubesX;
    }

    public static int getCubesY() {
        return cubesY;
    }

    public static void setCubesY(int cubesY) {
        Grid.cubesY = cubesY;
    }

    /**
     * Update the cube array and return false if there is any intersection between two cubes
     * @return false in case of intersection between cubes
     */
    public static boolean updateArrayBool(){
        isCube = new boolean[10][15];
        boolean withoutIntersection = true;
        for (Cube cube: cubeArray) {
            int x = (int)(cube.getCubeShape().getX() / cube.getCubeShape().getWidth());
            int y = (int)(cube.getCubeShape().getY() / cube.getCubeShape().getHeight());
            if (x >= 0 && x < isCube.length && y >= 0 && y < isCube[0].length) {
                boolean cubeSetted = isCube [x][y];
                if (cubeSetted) {
                    //Position in array is always setted
                    withoutIntersection = false;
                } else {
                    isCube [x][y] = true;
                }
            } else {
                //Position is out of range
                withoutIntersection = false;
            }
        }
        return withoutIntersection;

    }

    /**
     * Spawn new cube group
     */
    public static void spawnNew(){
        CubeGroup c = new CubeGroup();
        for (Cube cube : CubeGroup.currentGroup) {
            cubeArray.add(cube);
            window.pane.getChildren().add(cube.getCubeShape());
        }
        if(!updateArrayBool()){
            System.out.println("GAME OVER");
            System.exit(0);
        };
        checkForFullLine();
    }

    /**
     * Check if there is a full line, in case there is one this one will be deleted
     */
    public static void checkForFullLine(){

        //Check if there is any full line
        ArrayList<Integer> isFullLine = new ArrayList<Integer> ();
        for (int i = 0; i < isCube[0].length; i++) {
            boolean isFull = true;
            for (int j = 0; j < isCube.length; j++) {
                if (!isCube[j][i])
                    isFull = false;

            }
            if (isFull)
                isFullLine.add(i);
        }

        //For each full line
        for(int i = 0; i < isFullLine.size(); i++) {
            ArrayList<Cube> cubestoDelete = new ArrayList<>();
            //Delete all cubes in a row
            System.out.println(cubeArray.size());
            for(int j = 0; j < cubeArray.size(); j++){
                int y = (int) (cubeArray.get(j).getCubeShape().getY() / Cube.getCubeHeight());
                System.out.println(cubeArray.get(j).getCubeShape().getY());
                if (isFullLine.get(i) == y) {
                    Grid.window.pane.getChildren().remove(cubeArray.get(j).getCubeShape());
                    cubestoDelete.add(cubeArray.get(j));
                }
            }
            for(int j = 0; j < cubestoDelete.size(); j++){
                cubeArray.remove(cubestoDelete.get(j));
            }

            //Set down all cubes above the deleted row
            for(int j = 0; j < cubeArray.size(); j++){
                int y = (int) (cubeArray.get(j).getCubeShape().getY() / cubeArray.get(j).getCubeShape().getHeight());
                if(isFullLine.get(i) > y){
                    cubeArray.get(j).getCubeShape().setY(cubeArray.get(j).getCubeShape().getY() + cubeArray.get(j).getCubeHeight());
                }
            }

            for (int d = 0; d < isFullLine.size(); d++) {
                isFullLine.set(d, isFullLine.get(d));
            }
        }



    }

}

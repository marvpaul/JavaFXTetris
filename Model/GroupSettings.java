package Tetris.Model;

/**
 * A class which provides several settings for a cube group
 */
public class GroupSettings {
    /**
     * Apply the rotation vectors depending on the actual formation
     * @param type
     */
    public static int[][][] getRotationVecs(String type){
        if (type == "I") {
            int[][] rot0 = new int[][]{
                    new int[]{-1,1},
                    new int[]{0,0},
                    new int[]{1,2},
                    new int[]{2,3}
            };
            int[][] rot90 = new int[][] {
                    new int[]{1,-1},
                    new int[]{0,0},
                    new int[]{-1,-2},
                    new int[]{-2,-3}
            };
            return new int[][][]{ rot0, rot90, rot0, rot90 };
        }
        else if (type == "T") {
            int[][] rot0 = new int[][]{
                    new int[]{-1,-1},
                    new int[]{-1,0},
                    new int[]{0,-1},
                    new int[]{-1,-1}
            };
            int[][] rot90 = new int[][] {
                    new int[]{1, 1},
                    new int[]{0,0},
                    new int[]{-1, 2},
                    new int[]{1,0}
            };
            int[][] rot180 = new int[][]{
                    new int[]{0,0},
                    new int[]{-1,2},
                    new int[]{0,0},
                    new int[]{0,1}
            };
            int[][] rot270 = new int[][] {
                    new int[]{0,0},
                    new int[]{2,-2},
                    new int[]{1,-1},
                    new int[]{0,0}
            };
            return new int[][][]{ rot0, rot90, rot180, rot270 };
        } else if (type == "L") {
            int[][] rot0 = new int[][]{
                    new int[]{-1,-2},
                    new int[]{-1,-2},
                    new int[]{0,-1},
                    new int[]{0,1}
            };
            int[][] rot90 = new int[][] {
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{-2,1},
                    new int[]{-2,1}
            };
            int[][] rot180 = new int[][]{
                    new int[]{1,2},
                    new int[]{1,2},
                    new int[]{0,0},
                    new int[]{0,0}
            };
            int[][] rot270 = new int[][] {
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{2,0},
                    new int[]{2,-2}
            };
            return new int[][][]{ rot0, rot90, rot180, rot270 };
        }else if (type == "L2") {
            int[][] rot0 = new int[][]{
                    new int[]{-2,-2},
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{-2,0}
            };
            int[][] rot90 = new int[][] {
                    new int[]{0,0},
                    new int[]{0,2},
                    new int[]{-2,2},
                    new int[]{0,0}
            };
            int[][] rot180 = new int[][]{
                    new int[]{2,2},
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{2,0}
            };
            int[][] rot270 = new int[][] {
                    new int[]{0,0},
                    new int[]{0,-2},
                    new int[]{2,-2},
                    new int[]{0,0}
            };
            return new int[][][]{ rot0, rot90, rot180, rot270 };
        } else if (type == "Z1") {
            int[][] rot0 = new int[][]{
                    new int[]{-1,-2},
                    new int[]{-1,-1},
                    new int[]{0,0},
                    new int[]{0,1}
            };
            int[][] rot90 = new int[][] {
                    new int[]{0,2},
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{-2,0}
            };
            int[][] rot180 = new int[][]{
                    new int[]{1,0},
                    new int[]{1,2},
                    new int[]{0,0},
                    new int[]{0,0}
            };
            int[][] rot270 = new int[][] {
                    new int[]{0,0},
                    new int[]{0,-1},
                    new int[]{0,0},
                    new int[]{2,-1}
            };
            return new int[][][]{ rot0, rot90, rot180, rot270 };
        } else if (type == "O") {
            int[][] rot0 = new int[][]{
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{0,0},
                    new int[]{0,0}
            };
            return new int[][][]{ rot0, rot0, rot0, rot0 };
        }
        return null;
    }

    /**
     * Apply the cube positions depending on the certain formation
     * @param formation the given formation
     * @param cubes an array of cubes in this formation
     */
    public static void applyCubePos(String formation, Cube[] cubes){
        switch (formation){
            case "I":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(4, 0);
                cubes[3].setShapePos(5, 0);
                break;
            case "L":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(4, 0);
                cubes[3].setShapePos(4, 1);
                break;
            case "L2":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(4, 0);
                cubes[3].setShapePos(2, 1);
                break;
            case "T":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(4, 0);
                cubes[3].setShapePos(3, 1);
                break;
            case "O":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(2, 1);
                cubes[3].setShapePos(3, 1);
                break;
            case "Z1":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(3, 1);
                cubes[3].setShapePos(4, 1);
                break;
            case "Z2":
                cubes[0].setShapePos(2, 0);
                cubes[1].setShapePos(3, 0);
                cubes[2].setShapePos(2, 1);
                cubes[3].setShapePos(1, 1);
                break;

        }
    }
}

package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

import java.util.ArrayList;
import java.util.List;

public class SquareObstacle implements Obstacle{


    private final Position obstaclePos;

    public SquareObstacle(int x, int y){
        obstaclePos = new Position(x,y);
    }

    /**
     * Get X coordinate of bottom left corner of obstacle.
     *
     * @return x coordinate
     */
    @Override
    public int getBottomLeftX() {
        return obstaclePos.getX();
    }

    /**
     * Get Y coordinate of bottom left corner of obstacle.
     *
     * @return y coordinate
     */
    @Override
    public int getBottomLeftY() {
        return obstaclePos.getY();
    }

    /**
     * Gets the side of an obstacle (assuming square obstacles)
     *
     * @return the length of one side in nr of steps
     */
    @Override
    public int getSize() {
        return 5;
    }

    /**
     * Checks if this obstacle blocks access to the specified position.
     *
     * @param position the position to check
     * @return return `true` if the x,y coordinate falls within the obstacle's area
     */
    @Override
    public boolean blocksPosition(Position position) {

        // checking range
        boolean rangeX =  inRange(getBottomLeftX(), getBottomLeftX()+getSize(), position.getX());
        boolean rangeY = inRange(getBottomLeftY(), getBottomLeftY()+getSize(), position.getY()) ;

        return rangeX && rangeY;
    }

    /**
     * Checks if this obstacle blocks the path that goes from coordinate (x1, y1) to (x2, y2).
     * Since our robot can only move in horizontal or vertical lines (no diagonals yet), we can assume that either x1==x2 or y1==y2.
     *
     * @param a first position
     * @param b second position
     * @return `true` if this obstacle is in the way
     */
    @Override
    public boolean blocksPath(Position a, Position b) {
        int x1 = a.getX() , y1 = a.getY();
        int x2 = b.getX() , y2 = b.getY();

        int diffX = x2 - x1 ;
        int diffY = y2 - y1 ;

        int increment = diffX > 0 || diffY > 0 ? 1: -1;

        if (x2 == x1){
            for(int i = 0 ; i < Math.abs(diffY) ; i++){
                y1  = y1 + increment ;
                if (blocksPosition(new Position(x1,y1))){
                    return true;
                }

            }

        }else if (y2 == y1){
            for (int i = 0 ; i < Math.abs(diffX) ; i ++){
                x1 = x1 + increment ;
                if (blocksPosition(new Position(x1, y1))){
                    return true ;
                }
            }
        }

        return false;
    }

    @Override
    public int getTopRightX() {
        return 0;
    }

    @Override
    public int getTopRightY() {
        return 0;
    }

    public boolean inRange(int inclusive, int exclusive , int num){
        List<Integer> range = new ArrayList<>();
        for(int i = inclusive; i < exclusive; i++){
            range.add(i);
        }
        return range.contains(num);
    }


}

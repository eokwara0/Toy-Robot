package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

import java.util.ArrayList;
import java.util.List;

public class designedMazeSquareObstacle implements Obstacle{
    /**
     * Get X coordinate of bottom left corner of obstacle.
     *
     * @return x coordinate
     */

    private Position positionA;
    private Position positionB;


    public designedMazeSquareObstacle(Position a, Position b){
        this.positionA = a;
        this.positionB = b;

    }


    @Override
    public int getBottomLeftX() {
        return this.positionA.getX();
    }


    @Override
    public int getTopRightX(){
        return this.positionB.getX();
    }


    @Override
    public int getTopRightY(){
        return this.positionB.getY();
    }

    /**
     * Get Y coordinate of bottom left corner of obstacle.
     *
     * @return y coordinate
     */
    @Override
    public int getBottomLeftY() {
        return this.positionA.getY();
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
        List<Integer> xy = List.of(position.getX(),position.getY());

        for (List<List<Integer>> wallPo : rangeList()){
            if (wallPo.contains(xy)){
                return true;
            }
        }
        return false;
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

    public List<List<List<Integer>>> rangeList(){

        List<List<List<Integer>>> rangeList = new ArrayList<>();
        if (this.positionA.getY() == this.positionB.getY()){
            int staticY = this.positionA.getY() ;
            List<List<Integer>> wallList = new ArrayList<>() ;
            if (this.positionA.getX() > this.positionB.getX()){
                for (int x = this.positionB.getX() ; x < this.positionA.getX()+1; x++){
                    wallList.add(List.of(x,staticY));
                }
            }else if (!(this.positionA.getX() > this.positionB.getX())){
                for(int x = this.positionA.getX() ; x < this.positionB.getX()+1; x++){
                    wallList.add(List.of(x,staticY));
                }
            }
            rangeList.add(wallList);
        }else if (this.positionA.getX() == this.positionB.getX()){
            int staticX = this.positionA.getX() ;
            List<List<Integer>> wallList = new ArrayList<>() ;
            if (this.positionA.getY() > this.positionB.getY()){
                for (int y = this.positionB.getY() ; y < this.positionA.getY()+1; y++){
                    wallList.add(List.of(staticX,y));
                }
            }else if (!(this.positionA.getY() > this.positionB.getY())){
                for(int y = this.positionA.getY() ; y < this.positionB.getY()+1; y++){
                    wallList.add(List.of(staticX,y));
                }
            }
            rangeList.add(wallList);
        }
        return rangeList;
    }

    public boolean inRange(int inclusive, int exclusive , int num){
        List<Integer> range = new ArrayList<>();
        for(int i = inclusive; i < exclusive; i++){
            range.add(i);
        }
        return range.contains(num);
    }
}

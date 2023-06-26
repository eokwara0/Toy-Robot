package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.designedMazeSquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class designedMaze extends AbstractMaze{

    private List<Obstacle> obstacles;
    private String name ;

    public designedMaze(){
        this.name = "designed";
        createObstacles();
    }
    @Override
    public void createObstacles() {

        int startX = -100, endX = 100;
        int startY = -200, endY = 200;

        int flag = 5;
        ArrayList<ArrayList<List<Integer>>> cord = new ArrayList<>();
        List<Obstacle> obstacles = new ArrayList<>();
        List<ArrayList<List<Integer>>> newWalls = new ArrayList<>();
        ArrayList<ArrayList<List<Integer>>> Wall1 = new ArrayList<>();
        ArrayList<ArrayList<List<Integer>>> Wall2 = new ArrayList<>();


        for (int y : inRange(startY,(endY+1)-(flag),flag)){
            for (int x : inRange(startX,(endX+1)-(flag),flag)){

                if (Math.round(x/flag) == 9){
                    cord.add(new ArrayList<>(List.of(List.of(x+flag,y+flag),  List.of(x,y+flag))));
                }else if (Math.round(y/flag) == 9){
                    cord.add(new ArrayList<>(List.of(List.of(x+flag, y), List.of(x+flag , y+flag))));
                }else if (!(Math.round(x/flag) == 9)){
                    cord.add(new ArrayList<>(List.of(List.of(x+flag,  y),List.of(x+flag,y+flag), List.of(x,y+flag))));
                }

            }
        }
        /*
         * handling wall
         */

        cord.remove(cord.size()-1)             ;
        Wall1 = handleTwoValues(cord)        ;
        Wall1 = filterCount(Wall1, 1) ;
        Wall2 = handleThreeValues(cord)      ;
        Wall2 = filterCount(Wall2,1)  ;

        /*
         * Creating new  walls.
         */

        newWalls.addAll(Wall2);
        newWalls.addAll(Wall1);
        newWalls = randomDistribution(newWalls, newWalls.size());
        newWalls = newWalls.subList(0,(newWalls.size()-2000));



    /*
    *  creating squareObstacles
    * */
        for(ArrayList<List<Integer>> wall : newWalls){
            // x and y
            int x = wall.get(0).get(0);
            int y = wall.get(0).get(1);

            // x1 and y1
            int x1 = wall.get(1).get(0);
            int y1 = wall.get(1).get(1);
            obstacles.add(new designedMazeSquareObstacle(new Position(x,y) , new Position(x1,y1)));
        }
        this.obstacles = obstacles;
    }

    /**
     * @return the list of obstacles, or an empty list if no obstacles exist.
     */
    @Override
    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

    /**
     * Checks if this maze has at least one obstacle that blocks the path that goes from coordinate (x1, y1) to (x2, y2).
     * Since our robot can only move in horizontal or vertical lines (no diagonals yet), we can assume that either x1==x2 or y1==y2.
     *
     * @param a first position
     * @param b second position
     * @return `true` if there is an obstacle is in the way
     */
    @Override
    public boolean blocksPath(Position a, Position b) {
        for (Obstacle w : obstacles){
            if (w.blocksPath(a,b)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public List<Integer> inRange(int inclusive, int exclusive , int jump){
        List<Integer> range = new ArrayList<>();
        if (jump <= 0){
            jump = 1 ;
        }
        for(int i = inclusive; i < exclusive;){
            range.add(i);
            i+= jump;
        }
        return range;
    }

    public ArrayList<ArrayList<List<Integer>>> handleTwoValues(ArrayList<ArrayList<List<Integer>>> cord){
        ArrayList<ArrayList<List<Integer>>> singleWalls = filter(cord, 2);
        int randomDist = new Random().nextInt(singleWalls.size());
        return randomDistribution(singleWalls,randomDist);

    }
    public ArrayList<ArrayList<List<Integer>>> handleThreeValues(ArrayList<ArrayList<List<Integer>>> cord){
        ArrayList<ArrayList<List<Integer>>> doubleWalls;
        ArrayList<ArrayList<List<Integer>>> newWalls = new ArrayList<>();

        doubleWalls = filter(cord,3);
        for(ArrayList<List<Integer>> wall : doubleWalls){
            int randomWall  = new Random().nextBoolean() ? 0 : 2;
            wall.remove(randomWall) ;
            newWalls.add(wall) ;
        }
        return newWalls ;
    }

    public ArrayList<ArrayList<List<Integer>>> filter(ArrayList<ArrayList<List<Integer>>> cords ,  int value){
        ArrayList<ArrayList<List<Integer>>> valueList = new ArrayList<>();
        for (ArrayList<List<Integer>> cord : cords){
            if (cord.size() == value){
                valueList.add(cord);
            }
        }
        return valueList;
    }
    public ArrayList<ArrayList<List<Integer>>> filterCount(ArrayList<ArrayList<List<Integer>>> cords ,  int value){
        ArrayList<ArrayList<List<Integer>>> valueList = new ArrayList<>();

        for (ArrayList<List<Integer>> cord : cords){
            int count = value ;
            ArrayList<ArrayList<List<Integer>>> newCord = new ArrayList<>(cords);
            newCord.remove(cord);
            for(ArrayList<List<Integer>> cord2 : newCord){
                if (cord.equals(cord2)){
                    count ++;
                }
            }
            if (count == value){
                valueList.add(cord);
            }
        }
        return valueList;
    }



    public ArrayList<ArrayList<List<Integer>>> randomDistribution(List<ArrayList<List<Integer>>> cords, int dist){
        ArrayList<ArrayList<List<Integer>>> newList = new ArrayList<>();
        ArrayList<ArrayList<List<Integer>>> newCord = new ArrayList<>(cords);
        int num = dist;
        while(num != 0){

            int rand = new Random().nextInt(newCord.size());
            newList.add(newCord.get(rand));
            newCord.remove(rand);
            num --;
        }

        return  newList;
    }

}

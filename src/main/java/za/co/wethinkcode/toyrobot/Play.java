package za.co.wethinkcode.toyrobot;




import java.util.Scanner;

public class Play {
    static Scanner scanner;

    public static void main(String[] args) {


        scanner = new Scanner(System.in);
        Robot robot;

        String name = getInput("What do you want to name your robot?");
        boolean greater = args.length > 1;
        robot = greater? new Robot(name,args[0] + " "+args[1]) : new Robot(name);

        System.out.println("Hello " + name + "!") ;
        System.out.println("Loaded "+ (greater ? args[1] +"!" : "DefaultMaze!"));
        robot.getWorld().showObstacles();

        Command command;
        boolean shouldContinue = true;
        do {
            String instruction = getInput(robot.getName() + "> What must I do next?").strip().toLowerCase();
            try {
                command = Command.create(instruction,robot);
                shouldContinue = robot.handleCommand(command);
                AddHistory addHistory = new AddHistory(command);
                addHistory.run(robot);
            } catch (IllegalArgumentException e) {
                robot.setStatus("Sorry, I did not understand '" + instruction + "'.");
                System.out.println(robot);
            }
        } while (shouldContinue);

    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        while (input.isBlank()) {
            System.out.println(prompt);
            input = scanner.nextLine();
        }
        return input;
    }
}

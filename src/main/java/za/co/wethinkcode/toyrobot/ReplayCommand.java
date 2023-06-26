package za.co.wethinkcode.toyrobot;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ReplayCommand extends Command{
    private boolean range;

    public ReplayCommand(){
        super("replay");
    }

    public ReplayCommand(String args){
        super("replay",args);

    }

    @Override
    public boolean execute(Robot target) {

        List<Command> history = target.getHistory();
        List<String> returnValues = handleArguments(history);


        try{

            if (((returnValues.get(0).equals("0")) && !(returnValues.get(1).equalsIgnoreCase("0"))) ||
                    ((!returnValues.get(0).equals("0")) && !(returnValues.get(1).equalsIgnoreCase("0")))){

                int start = Integer.parseInt(returnValues.get(0));
                int end = Integer.parseInt(returnValues.get(1));
                history = history.subList(start,end);

            }

            if (returnValues.get(2).equalsIgnoreCase("true")){
                history =  reverse(history);
            }
        }catch (Exception e){

            throw  new IllegalArgumentException("index out of range Invalid command");

        }

        for (Command command : history) {

            target.handleCommand(command);

        }
        target.setStatus("replayed "+history.size()+" commands.");
        return true;

    }

    public List<String>handleArguments(List<Command> history){

        // initialization
        List<String> args = List.of(getArgument().split(" "));
        List<String> returnValues = new ArrayList<>();
        String reverse = String.valueOf(args.contains("reversed"));



        List<String> returnValues1 = getStrings(history, args, returnValues, reverse);
        if (returnValues1 != null) return returnValues1;
        return returnValues;
    }

    @Nullable
    private List<String> getStrings(List<Command> history, List<String> args, List<String> returnValues, String reverse) {

        if (args.size() == 1 && args.get(0).equals("reversed")){

            returnValues.add("0");
            returnValues.add("0");
            returnValues.add(reverse);
            return returnValues;

        } else if (args.size()==1 && args.get(0).equals("")){

            returnValues.add("0");
            returnValues.add("0");
            returnValues.add(reverse);
            return returnValues;

        }else{
            String[] start = new String[2];
            args.forEach((n) -> {
                try{
                    extracted(history, returnValues, reverse, start, n);
                }   catch (Exception e){

                    throw new IllegalArgumentException("Unsupported command "+ args);

                }
            });

        }
        return null;
    }

    private void extracted(List<Command> history, List<String> returnValues, String reverse, String[] start, String n) {

        if (n.length() == 3 && n.contains("-") ){
            char [] n_characters = n.toCharArray();
            String beginning = String.valueOf(n_characters[0]);
            String ending = String.valueOf(n_characters[2]);

            if (convertToDigit(beginning) && convertToDigit(ending)){

                int i = Integer.parseInt(String.valueOf(n_characters[0]));
                start[0] = String.valueOf(Integer.parseInt(ending) - Integer.parseInt(ending));
                start[1] = String.valueOf(i-Integer.parseInt(ending));
                returnValues.add(start[0]);
                returnValues.add(start[1]);
                returnValues.add(reverse);
//                range = true;


            }


        } else if (convertToDigit(n)){
            start[0] = String.valueOf(history.size()-Integer.parseInt(n));
            start[1] = String.valueOf(history.size());
            returnValues.add(start[0]);
            returnValues.add(start[1]);
            returnValues.add(reverse);
        }

    }

    public boolean convertToDigit(String s){
        try{
            Integer.parseInt(String.valueOf(s));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Command> reverse(List<Command> list){
        List<Command> reversedList = new ArrayList<>();
        for (int i = list.size()-1 ; i >=0; i --){
            reversedList.add(list.get(i)) ;
        }
        return reversedList;
    }

}

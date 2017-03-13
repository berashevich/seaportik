package bsuir.command;

public final class CommandHelper {

    private CommandHelper(){}

    public static Command getCommand(String name){

        Command command = null;
        try {

            if (name == null){ return CommandName.TO_MAIN_PAGE.command; }

            CommandName commandName = CommandName.valueOf(name.toUpperCase());

            command = commandName.command;

        }catch (IllegalArgumentException e){
            System.out.println("Error of command name " + e.getMessage());
        }
        return command;
    }

}

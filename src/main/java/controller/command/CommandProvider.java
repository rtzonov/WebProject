package controller.command;

import java.util.HashMap;
import java.util.Map;

import controller.command.impl.*;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.LOGINATION, new Logination());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());
        commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
        commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.CHANGELANG, new ChangeLanguage());
        commands.put(CommandName.GOTOLOGINPAGE, new GoToLoginPage());
    }


    public Command takeCommand(String name) {
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }

}

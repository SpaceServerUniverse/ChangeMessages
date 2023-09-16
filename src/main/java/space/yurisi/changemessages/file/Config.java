package space.yurisi.changemessages.file;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import space.yurisi.changemessages.ChangeMessages;

public final class Config {

    private final ChangeMessages main;

    private Configuration config = null;

    public Config(ChangeMessages main){
        this.main = main;
        init();
    }

    private void init(){
        main.saveDefaultConfig();
        if (config != null) {
            main.reloadConfig();
        }
        this.config = main.getConfig();
    }

    public Boolean existsCustomJoinMessage(Player player){
        String name = getFormattedPlayerName(player);
        String result = this.config.getString(name);
        return result != null;
    }

    public String getCustomJoinMessage(Player player){
        String name = getFormattedPlayerName(player);
        return this.config.getString(name);
    }

    private String getFormattedPlayerName(Player player){
        String name = player.getName();

        char sep = name.charAt(0);
        if(sep == '.' || sep == '*'){
            return "BE_"+ name.substring(1);
        }

        return name;
    }
}

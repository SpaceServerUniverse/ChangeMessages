package space.yurisi.changemessages.event;

import org.bukkit.Bukkit;
import space.yurisi.changemessages.ChangeMessages;

public class EventManager {

    ChangeMessages main;

    public EventManager(ChangeMessages main){
        this.main = main;
        init();
    }

    private void init(){
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this.main);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this.main);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this.main);
    }
}

package space.yurisi.changemessages.event;

import org.bukkit.Bukkit;
import space.yurisi.changemessages.ChangeMessages;
import space.yurisi.changemessages.event.entity.DamageByEntityEvent;
import space.yurisi.changemessages.event.player.DeathEvent;
import space.yurisi.changemessages.event.player.JoinEvent;
import space.yurisi.changemessages.event.player.QuitEvent;

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
        Bukkit.getPluginManager().registerEvents(new DamageByEntityEvent(), this.main);
    }
}

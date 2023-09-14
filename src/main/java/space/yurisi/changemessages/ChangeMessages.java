package space.yurisi.changemessages;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import space.yurisi.changemessages.event.JoinEvent;
import space.yurisi.changemessages.event.QuitEvent;

public final class ChangeMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

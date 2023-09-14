package space.yurisi.changemessages;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import space.yurisi.changemessages.event.EventManager;

public final class ChangeMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        new EventManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

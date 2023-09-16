package space.yurisi.changemessages;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import space.yurisi.changemessages.event.EventManager;
import space.yurisi.changemessages.file.Config;

import java.io.IOException;

public final class ChangeMessages extends JavaPlugin {

    private Config config;

    @Override
    public void onEnable() {
        this.config = new Config(this);
        new EventManager(this);
    }

    public Config getConfigClass(){
        return config;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

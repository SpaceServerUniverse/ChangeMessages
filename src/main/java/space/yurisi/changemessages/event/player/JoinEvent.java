package space.yurisi.changemessages.event.player;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import space.yurisi.changemessages.ChangeMessages;
import space.yurisi.changemessages.file.Config;

import java.util.List;

public final class JoinEvent implements Listener {

    private final Config config;

    public JoinEvent(Config config){
        this.config = config;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle("§eWelcome to SpaceServer","- Universe -");
        event.joinMessage(getCustomUserMessage(player));
    }

    private Component getCustomUserMessage(Player player){
        Bukkit.getLogger().info(player.getName());
        if(!config.existsCustomJoinMessage(player)){
            return Component.text(
                    "§a[入室] §c" + player.getName() + "§e様が§a§lオンライン§r§eになりました"
            );
        }
        return Component.text(
                "§a[入室] §c" + config.getCustomJoinMessage(player)
        );
    }
}

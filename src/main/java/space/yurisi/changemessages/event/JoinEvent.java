package space.yurisi.changemessages.event;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle("§eWelcome to SpaceServer","- Universe -");
        event.joinMessage(Component.text("§a[入室] §c" + player.getName() + "§e様が§a§lオンライン§r§eになりました"));
    }
}

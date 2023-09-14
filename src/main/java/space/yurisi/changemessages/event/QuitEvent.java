package space.yurisi.changemessages.event;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerQuitEvent.QuitReason reason = event.getReason();
        event.quitMessage(Component.text("§7[退室] §c" + player.getName() + "§e様が§a" + reason + "§eで§7§lオフライン§r§eになりました"));
    }
}

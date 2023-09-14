package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import space.yurisi.changemessages.event.damage.DamageEventManager;

public final class VoidDeathMessage extends DeathMessage{

    public VoidDeathMessage(Player player, DamageEventManager manager) {
        if (player.getName().equals(manager.getKillerPlayer(player).getName())) {
            this.messages = new Component[]{
                    Component.text("§a§l[戦闘型AI] §c" + player.getName()+ "§a は消滅した"),
                    Component.text("§a§l[戦闘型AI] §c" + player.getName()+ "§a は存在がなくなった"),
                    Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a はちりになった"),
                    Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は星になった"),
            };
            return;
        }

        Player killer = manager.getKillerPlayer(player);
        this.messages = new Component[]{
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName()+ "§a によって消滅した"),
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName() + "§a によって存在がなくなった"),
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName() + "§a によってちりになった"),
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName() + "§a によって星になった"),
        };
        manager.removeKillerPlayer(player);
    }
}

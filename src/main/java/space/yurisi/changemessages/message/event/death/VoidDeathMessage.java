package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class VoidDeathMessage extends DeathMessage{

    public VoidDeathMessage(Player player, Player killer) {
        super(player, killer);
    }

    @Override
    protected void init(Player player, Player killer) {
        if (killer == null || player.getName().equals(killer.getName())) {
            this.messages = new Component[]{
                    Component.text("§a§l[戦闘型AI] §c" + player.getName()+ "§a は消滅した"),
                    Component.text("§a§l[戦闘型AI] §c" + player.getName()+ "§a は存在がなくなった"),
                    Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a はちりになった"),
                    Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は星になった"),
            };
            return;
        }

        this.messages = new Component[]{
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName()+ "§a によって消滅した"),
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName() + "§a によって存在がなくなった"),
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName() + "§a によってちりになった"),
                Component.text("§a§l[戦闘型AI] §c" + player.getName() + "§a は §b" + killer.getName() + "§a によって星になった"),
        };
    }
}

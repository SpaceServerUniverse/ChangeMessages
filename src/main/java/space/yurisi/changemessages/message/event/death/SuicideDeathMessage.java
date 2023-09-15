package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class SuicideDeathMessage extends DeathMessage {
    public SuicideDeathMessage(Player player) {
        super(player);
    }

    @Override
    protected void init(Player player) {
        this.messages = new Component[]{
                Component.text("§a §l[死亡管理AI]§b " + player.getName() + "§a は消滅した"),
                Component.text("§a §l[死亡管理AI]§b " + player.getName() + "§a は存在がなくなった"),
                Component.text("§a §l[死亡管理AI]§b " + player.getName() + "§a はちりになった"),
                Component.text("§a §l[死亡管理AI]§b " + player.getName() + "§a は星になった")
        };
    }
}

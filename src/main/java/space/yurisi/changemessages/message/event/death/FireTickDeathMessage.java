package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class FireTickDeathMessage extends DeathMessage {
    public FireTickDeathMessage(Player player) {
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a はケツに火がついた"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は火だるまになった")
        };
    }
}

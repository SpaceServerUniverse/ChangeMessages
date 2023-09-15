package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class LavaDeathMessage extends DeathMessage {
    public LavaDeathMessage(Player player) {
        super(player);
    }

    @Override
    protected void init(Player player) {
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は溶岩の中を泳ごうとした"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は溶けた"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a はどろどろになりました"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は存在がなくなりました")
        };
    }
}

package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class FireDeathMessage extends DeathMessage {
    public FireDeathMessage(Player player) {
        super(player);
    }

    @Override
    protected void init(Player player) {
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + " §aは灰になった"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + " §aは炎を歩こうとして大やけどしました"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + " §aは炎に飛び込みました"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + " §aは炎によってちりになりました"),
        };
    }
}

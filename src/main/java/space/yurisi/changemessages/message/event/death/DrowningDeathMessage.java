package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class DrowningDeathMessage extends DeathMessage {
    public DrowningDeathMessage(Player player) {
        super(player);
    }

    @Override
    protected void init(Player player) {
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は魚たちと眠りについた"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は内臓が水で満たされた"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は溺死しました"),
                Component.text("§a§l[死亡管理AI]§b " + player.getName() + "§a は息ができなくなりました")
        };
    }
}

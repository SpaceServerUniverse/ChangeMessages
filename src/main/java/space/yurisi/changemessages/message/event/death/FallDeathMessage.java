package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class FallDeathMessage extends DeathMessage {
    public FallDeathMessage(Player player) {
        super(player);
    }

    @Override
    protected void init(Player player) {
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は落下してぐちゃぐちゃになった"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は空中浮遊を試みたが落下しました"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は落下で心中を試みました"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は床が外れて落下しました"),
        };
    }
}

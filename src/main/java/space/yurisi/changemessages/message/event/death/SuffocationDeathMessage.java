package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class SuffocationDeathMessage extends DeathMessage{
    public SuffocationDeathMessage(Player player) {
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は窒息しました"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は押しつぶされました"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は押しつぶされてぐちゃぐちゃになりました"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は押しつぶされて息の根が止まりました")
        };
    }
}

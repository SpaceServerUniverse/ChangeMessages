package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class DefaultDeathMessage extends DeathMessage{
    public DefaultDeathMessage(Player player){
        this.messages = new Component[]{
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a はなぞのダメージにより死んだ"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a はなにかの力によって死亡した"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a はなにかの圧力によって死亡した"),
                Component.text("§a§l[死亡管理AI] §b" + player.getName() + "§a は神の力によって消滅した")
        };
    }
}

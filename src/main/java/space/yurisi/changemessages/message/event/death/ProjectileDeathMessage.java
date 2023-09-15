package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class ProjectileDeathMessage extends DeathMessage {
    public ProjectileDeathMessage(Player player, Player killer) {
        super(player, killer);
    }

    @Override
    protected void init(Player player, Player killer) {
        if (killer == null || player.getName().equals(killer.getName())) {
            this.messages = new Component[]{
                    Component.text("§a§l[死亡管理AI] §c" + player.getName() + "§a が 死亡した")
            };
            return;
        }

        String item = getItemName(killer);

        this.messages = new Component[]{
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で射抜きました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で矢を心臓に刺しました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- によって生命活動を停止させました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- の矢が脳を貫きました"),
        };
    }
}

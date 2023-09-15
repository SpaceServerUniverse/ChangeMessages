package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class EntityAttackDeathMessage extends DeathMessage {

    public EntityAttackDeathMessage(Player player, Player killer) {
        super(player, killer);
    }

    @Override
    protected void init(Player player, Player killer) {
        if (killer == null || player.getName().equals(killer.getName())) {
            this.messages = new Component[]{
                    Component.text("§a§l[死亡管理AI] §c" + player.getName() + "§a が死亡した")
            };
            return;
        }

        String item = getItemName(killer);

        this.messages = new Component[]{
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で殺害しました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で刺し殺しました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で殴り倒しました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- でばらばらにしました"),
        };
    }
}

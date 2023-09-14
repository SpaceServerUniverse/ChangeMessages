package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import space.yurisi.changemessages.event.damage.DamageEventManager;

import java.util.Objects;

public final class ProjectileDeathMessage extends DeathMessage {
    public ProjectileDeathMessage(Player player, DamageEventManager manager) {
        if (player.getName().equals(manager.getKillerPlayer(player).getName())) {
            this.messages = new Component[]{
                    Component.text("§a§l[死亡管理AI] §c" + player.getName() + "§a が 死亡した")
            };
            return;
        }

        Player killer = manager.getKillerPlayer(player);
        ItemStack hand_item = killer.getInventory().getItemInMainHand();
        String item;
        if (hand_item.getItemMeta().hasDisplayName()) {
            Component displayName = Objects.requireNonNull(hand_item.getItemMeta().displayName());
            item = PlainTextComponentSerializer.plainText().serialize(displayName);
        } else {
            item = hand_item.getType().name().replace("_", " ").toLowerCase();
        }

        this.messages = new Component[]{
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で射抜きました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- で矢を心臓に刺しました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- によって生命活動を停止させました"),
                Component.text("§a§l[戦闘型AI] §c" + killer.getName() + "§a が §b" + player.getName() + "§a を -§d" + item + "§a- の矢が脳を貫きました"),
        };
        manager.removeKillerPlayer(player);
    }
}

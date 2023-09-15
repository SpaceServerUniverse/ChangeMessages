package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Random;

public class DeathMessage {

    protected Component[] messages;

    public DeathMessage(Player player){
        init(player);
    }

    public DeathMessage(Player player, Player killer){
        init(player, killer);
    }

    private int getRandom(Component[] components){
        Random rnd = new Random();
        return rnd.nextInt(components.length);
    }

    public Component getMessage() {
        int i = this.getRandom(messages);
        return messages[i];
    }

    protected String getItemName(Player killer) {
        ItemStack hand_item = killer.getInventory().getItemInMainHand();
        if (hand_item.getItemMeta().hasDisplayName()) {
            Component displayName = Objects.requireNonNull(hand_item.getItemMeta().displayName());
            return PlainTextComponentSerializer.plainText().serialize(displayName);
        }
        return hand_item.getType().name().replace("_", " ").toLowerCase();
    }

    protected void init(Player player){}

    protected void init(Player player, Player killer){}


}

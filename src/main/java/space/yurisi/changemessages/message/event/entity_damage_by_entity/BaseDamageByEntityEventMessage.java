package space.yurisi.changemessages.message.event.entity_damage_by_entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import space.yurisi.changemessages.message.event.BaseEventMessage;
import space.yurisi.changemessages.message.event.player_death.BasePlayerDeathEventMessage;

public class BaseDamageByEntityEventMessage extends BaseEventMessage {

    public BaseDamageByEntityEventMessage(Player player, Entity killer){
        init(player, killer);
    }

    protected void init(Player player, Entity killer){}
}

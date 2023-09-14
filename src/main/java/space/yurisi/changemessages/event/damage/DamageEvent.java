package space.yurisi.changemessages.event.damage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    DamageEventManager manager;


    public DamageEvent(DamageEventManager manager){
        this.manager = manager;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Entity player = event.getEntity();
        if(player instanceof Player){
            this.manager.setCause((Player) player, event.getCause());
        }
    }
}

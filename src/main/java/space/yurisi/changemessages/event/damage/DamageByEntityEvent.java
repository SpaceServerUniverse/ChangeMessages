package space.yurisi.changemessages.event.damage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;
import space.yurisi.changemessages.ChangeMessages;

public class DamageByEntityEvent implements Listener {

    private final DamageEventManager manager;

    public DamageByEntityEvent(DamageEventManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (!(entity instanceof Player)) {
            return;
        }

        if (damager instanceof Player) {
            this.manager.setKillerPlayer((Player) entity, (Player) damager);
            return;
        }

        if (damager instanceof Arrow) {
            ProjectileSource shooter = ((Arrow) damager).getShooter();
            if (shooter instanceof Player) {
                this.manager.setKillerPlayer((Player) entity, (Player) shooter);
                return;
            }
        }

        this.manager.removeKillerPlayer((Player) entity);
    }
}

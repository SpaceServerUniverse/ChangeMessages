package space.yurisi.changemessages.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import space.yurisi.changemessages.message.event.death.*;

import javax.annotation.Nullable;

public class DeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Player killer = event.getEntity().getKiller();
        EntityDamageEvent.DamageCause cause = event.getEntity().getLastDamageCause().getCause();
        DeathMessage messageClass = getDeathMessageClass(player, killer, cause);
        event.deathMessage(messageClass.getMessage());
    }

    private DeathMessage getDeathMessageClass(Player player, @Nullable Player killer, EntityDamageEvent.DamageCause cause){
        switch (cause) {
            case ENTITY_ATTACK:
                return new EntityAttackDeathMessage(player, killer);
            case PROJECTILE:
                return new ProjectileDeathMessage(player, killer);
            case SUFFOCATION:
                return new SuffocationDeathMessage(player);
            case FALL:
                return new FallDeathMessage(player);
            case FIRE:
                return new FireDeathMessage(player);
            case FIRE_TICK:
                return new FireTickDeathMessage(player);
            case LAVA:
                return new LavaDeathMessage(player);
            case DROWNING:
                return new DrowningDeathMessage(player);
            case BLOCK_EXPLOSION:
            case ENTITY_EXPLOSION:
                return new ExplosionDeathMessage(player);
            case VOID:
                return new VoidDeathMessage(player, killer);
            case SUICIDE:
                return new SuicideDeathMessage(player);
            case MAGIC:
            default:
                return new DefaultDeathMessage(player);
        }
    }
}

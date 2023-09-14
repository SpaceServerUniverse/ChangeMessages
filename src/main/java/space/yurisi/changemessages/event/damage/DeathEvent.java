package space.yurisi.changemessages.event.damage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import space.yurisi.changemessages.message.event.death.*;

public class DeathEvent implements Listener {

    DamageEventManager manager;

    public DeathEvent(DamageEventManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        DeathMessage messageClass = getDeathMessageClass(player);
        event.deathMessage(messageClass.getMessage());
    }

    private DeathMessage getDeathMessageClass(Player player){
        switch (this.manager.getCause(player)) {
            case ENTITY_ATTACK:
                return new EntityAttackDeathMessage(player, this.manager);
            case PROJECTILE:
                return new ProjectileDeathMessage(player, this.manager);
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
                return new VoidDeathMessage(player, this.manager);
            case SUICIDE:
                return new SuicideDeathMessage(player);
            case MAGIC:
            default:
                return new DefaultDeathMessage(player);
        }
    }
}

package space.yurisi.changemessages.event.damage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import space.yurisi.changemessages.ChangeMessages;

import java.util.HashMap;
import java.util.Map;

public class DamageEventManager {

    private final ChangeMessages main;
    private final Map<String, EntityDamageEvent.DamageCause> cause;
    private final Map<String, Player> killerPlayer;

    public DamageEventManager(ChangeMessages main) {
        this.main = main;
        this.cause = new HashMap<>();
        this.killerPlayer = new HashMap<>();
        init();
    }

    private void init() {
        Bukkit.getPluginManager().registerEvents(new DamageEvent(this), this.main);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(this), this.main);
        Bukkit.getPluginManager().registerEvents(new DamageByEntityEvent(this), this.main);
    }

    public void setKillerPlayer(Player diedPlayer, Player killerPlayer) {
        this.killerPlayer.put(diedPlayer.getName(), killerPlayer);
    }

    public Player getKillerPlayer(Player diedPlayer) {
        return this.killerPlayer.getOrDefault(diedPlayer.getName(), diedPlayer);
    }

    public void removeKillerPlayer(Player diedPlayer){
        this.killerPlayer.remove(diedPlayer.getName());
    }

    public void setCause(Player player, EntityDamageEvent.DamageCause cause) {
        this.cause.put(player.getName(), cause);
    }

    public EntityDamageEvent.DamageCause getCause(Player player) {
        return this.cause.getOrDefault(player.getName(), EntityDamageEvent.DamageCause.MAGIC);
    }
}

package uk.g1444332.event_ib_happy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.Bukkit.getPlayer;

public final class Event_Ib_happy extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("event").setExecutor(new Command());
        getLogger().info("RegenPlugin Включен!");
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            Player target = getPlayer("Ib_Happy");
            Player target2 = getPlayer("Mk_48");
            Player target3 = getPlayer("P1ngVin209");
            if (target != null) {
                Location targetLocation = target.getLocation();
                World targetWorld = targetLocation.getWorld();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player != target2 && player != target3 && player != target && player.getLocation().getWorld().equals(targetWorld) && player.getLocation().distance(targetLocation) <= 5) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 1));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 1));
                    }
                    player.spawnParticle(Particle.SMOKE_NORMAL, targetLocation, 500, 4, 4, 4, 0.0);
                }
                target.spawnParticle(Particle.SMOKE_NORMAL, targetLocation, 500, 5, 5, 5, 0.0);
            }
        }, 0L, 60L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}

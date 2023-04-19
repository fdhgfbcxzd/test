package uk.g1444332.event_ib_happy;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("event") || command.getName().equalsIgnoreCase("festnehmen")) {
            if (args.length == 0) {
                Player senderPlayer = (Player) sender;

                for (Entity nearby : senderPlayer.getNearbyEntities(100, 100, 100)) {
                    if (nearby instanceof Player && nearby != senderPlayer) {
                        ((Player) nearby).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 2));
                    }
                }

                sender.sendMessage("Вы применили эффект левитации на всех игроков в радиусе 100 блоков!");
                return true;
            }
        }
        return true;
    }
}
package me.MyzelYam.SuperVanish.hooks;

import me.MyzelYam.SuperVanish.SuperVanish;
import me.libraryaddict.disguise.events.DisguiseEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class LibsDisguisesHook implements Listener {

    public SuperVanish plugin = (SuperVanish) Bukkit.getPluginManager()
            .getPlugin("SuperVanish");

    @EventHandler
    public void onDisguise(DisguiseEvent e) {
        try {
            if (e.getEntity() instanceof Player) {
                Player p = (Player) e.getEntity();
                if (plugin.pd.getStringList("InvisiblePlayers").contains(
                        p.getUniqueId().toString())) {
                    p.sendMessage("�c[SV] You can't disguise yourself at the moment!");
                    e.setCancelled(true);
                }
            }
        } catch (Exception er) {
            plugin.printException(er);
        }
    }
}
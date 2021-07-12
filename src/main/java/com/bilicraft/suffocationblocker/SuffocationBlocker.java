package com.bilicraft.suffocationblocker;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuffocationBlocker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.MONITOR,ignoreCancelled = true)
    public void playerJoin(PlayerJoinEvent event){
        if(event.getPlayer().getLocation().add(0,1,0).getBlock().getType().isSolid()){
            event.getPlayer().teleport(event.getPlayer().getWorld().getHighestBlockAt(event.getPlayer().getLocation()).getLocation(), PlayerTeleportEvent.TeleportCause.PLUGIN);
        }
    }
}

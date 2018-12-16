package com.gmail.seityannmann.loginmessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LoginMessage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        // Plugin startup logic

        saveDefaultConfig();

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String msg;
        if(p.hasPlayedBefore()){
            msg = getConfig().getString("join");
        }else {
             msg = getConfig().getString("first");
        }
        msg = msg.replaceAll("%player", e.getPlayer().getName());
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&' ,msg));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        String msg = getConfig().getString("quit");
        msg = msg.replaceAll("%player", e.getPlayer().getName());
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&' ,msg));
    }
}

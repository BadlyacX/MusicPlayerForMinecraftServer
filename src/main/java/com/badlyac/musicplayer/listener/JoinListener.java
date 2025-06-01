package com.badlyac.musicplayer.listener;

import com.badlyac.musicplayer.MusicPlayerMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (MusicPlayerMain.resourcePackSha1 == null) {
            player.sendMessage("§cresource pack did not load. Please contact the author");
            return;
        }

        player.setResourcePack(MusicPlayerMain.resourcePackUrl, MusicPlayerMain.resourcePackSha1);
        player.sendMessage("§aloading resource pack...🍋");
    }
}

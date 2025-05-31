package com.badlyac.zhlemonmusic.listener;

import com.badlyac.zhlemonmusic.ZhLemonMusic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (ZhLemonMusic.resourcePackSha1 == null) {
            player.sendMessage("§cresource pack did not load. Please contact the author");
            return;
        }

        player.setResourcePack(ZhLemonMusic.resourcePackUrl, ZhLemonMusic.resourcePackSha1);
        player.sendMessage("§aloading resource pack...🍋");
    }
}

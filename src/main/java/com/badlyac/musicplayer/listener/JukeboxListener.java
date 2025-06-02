package com.badlyac.musicplayer.listener;

import com.badlyac.musicplayer.MusicPlayerMain;
import com.badlyac.musicplayer.music.DiscManager;
import com.badlyac.musicplayer.music.IMusicDisc;
import com.badlyac.musicplayer.music.PlayingMusicInfo;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.WeakHashMap;

public class JukeboxListener implements Listener {

    private final Map<Block, PlayingMusicInfo> playingMap = new WeakHashMap<>();

    @EventHandler
    public void onPlayerUseJukebox(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block == null || block.getType() != Material.JUKEBOX) return;

        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null) return;

        IMusicDisc handler = DiscManager.getHandler(item.getType());
        if (handler == null) return;

        long now = System.currentTimeMillis();
        PlayingMusicInfo current = playingMap.get(block);

        if (current != null && now - current.startTime < handler.getCooldownMillis()) {
            player.sendMessage("§eThis song is still playing...");
            event.setCancelled(true);
            return;
        }

        event.setCancelled(true);
        block.getWorld().playSound(
                block.getLocation(),
                handler.getSoundKey(),
                SoundCategory.RECORDS,
                1.3f,
                1.0f
        );

        playingMap.put(block, new PlayingMusicInfo(now, handler));

        Bukkit.getScheduler().runTaskLater(
                MusicPlayerMain.getInstance(),
                () -> playingMap.remove(block),
                handler.getCooldownMillis() / 50
        );

        player.sendMessage("§aNow playing：" + handler.getSoundKey().replace("custom.", "") + " 🎶");
    }

    @EventHandler
    public void onJukeboxBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType() != Material.JUKEBOX) return;

        PlayingMusicInfo info = playingMap.remove(block);
        if (info == null) return;

        for (Player p : block.getWorld().getPlayers()) {
            p.stopSound(info.disc.getSoundKey(), SoundCategory.RECORDS);
        }

        event.getPlayer().sendMessage("§cMusic stopped because the jukebox was broken.");
    }
}

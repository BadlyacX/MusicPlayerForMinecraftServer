package com.badlyac.musicplayer.listener;

import com.badlyac.musicplayer.music.DiscManager;
import com.badlyac.musicplayer.music.IMusicDisc;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.WeakHashMap;

public class JukeboxListener implements Listener {

    private final Map<Block, Long> cooldownMap = new WeakHashMap<>();

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
        Long lastPlay = cooldownMap.get(block);

        if (lastPlay != null && now - lastPlay < handler.getCooldownMillis()) {
            player.sendMessage("§ethis song is still playing...");
            event.setCancelled(true);
            return;
        }

        cooldownMap.put(block, now);

        event.setCancelled(true);
        block.getWorld().playSound(
                block.getLocation(),
                handler.getSoundKey(),
                SoundCategory.RECORDS,
                1.3f,
                1.0f
        );

        player.sendMessage("§aNow playing：" + handler.getSoundKey().replace("custom.", "") + " 🎶");
    }
}
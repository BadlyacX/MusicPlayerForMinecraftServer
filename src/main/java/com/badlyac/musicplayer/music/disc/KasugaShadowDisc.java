package com.badlyac.musicplayer.music.disc;

import com.badlyac.musicplayer.music.AbstractMusicDisc;
import org.bukkit.Material;

public class KasugaShadowDisc extends AbstractMusicDisc {

    @Override
    public Material getDisc() {
        return Material.MUSIC_DISC_MALL;
    }

    @Override
    public String getSoundKey() {
        return "custom.kasuga_shadow";
    }

    @Override
    public long getCooldownMillis() {
        return 1000 * 257;
    }

    @Override
    public String getResourcePackFileName() {
        return "music.zip";
    }
}

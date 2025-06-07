package com.badlyac.musicplayer.music.disc;

import com.badlyac.musicplayer.music.AbstractMusicDisc;
import org.bukkit.Material;

public class GoBigDisc extends AbstractMusicDisc {
    @Override
    public Material getDisc() {
        return Material.MUSIC_DISC_CAT;
    }

    @Override
    public String getSoundKey() {
        return "custom.go_big";
    }

    @Override
    public long getCooldownMillis() {
        return 1000 * 210;
    }

    @Override
    public String getResourcePackFileName() {
        return "music.zip";
    }
}

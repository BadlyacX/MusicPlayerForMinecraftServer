package com.badlyac.musicplayer.music.Disc;

import com.badlyac.musicplayer.music.AbstractMusicDisc;
import org.bukkit.Material;

public class MatsuriDisc extends AbstractMusicDisc {

    @Override
    public Material getDisc() {
        return Material.MUSIC_DISC_FAR;
    }

    @Override
    public String getSoundKey() {
        return "custom.matsuri";
    }

    @Override
    public long getCooldownMillis() {
        return 1000 * 226;
    }

    @Override
    public String getResourcePackFileName() {
        return "music.zip";
    }
}
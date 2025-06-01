package com.badlyac.musicplayer.music.Disc;

import com.badlyac.musicplayer.music.AbstractMusicDisc;
import org.bukkit.Material;

public class ZhLemonDisc extends AbstractMusicDisc {

    @Override
    public Material getDisc() {
        return Material.MUSIC_DISC_13;
    }

    @Override
    public String getSoundKey() {
        return "custom.zh_lemon";
    }

    @Override
    public long getCooldownMillis() {
        int seconds = 144;
        return 1000 * seconds;
    }

    @Override
    public String getResourcePackFileName() {
        return "music.zip";
    }
}
package com.badlyac.musicplayer.music.Disc;

import com.badlyac.musicplayer.music.AbstractMusicDisc;
import org.bukkit.Material;

public class InsideJokeDisc extends AbstractMusicDisc {

    @Override
    public Material getDisc() {
        return Material.MUSIC_DISC_CHIRP;
    }

    @Override
    public String getSoundKey() {
        return "custom.inside_joke";
    }

    @Override
    public long getCooldownMillis() {
        return 1000 * 256;
    }

    @Override
    public String getResourcePackFileName() {
        return "music.zip";
    }
}

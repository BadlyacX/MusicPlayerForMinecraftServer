package com.badlyac.musicplayer.music.Disc;

import com.badlyac.musicplayer.music.AbstractMusicDisc;
import org.bukkit.Material;

public class InemuriEnseitaiDisc extends AbstractMusicDisc {

    @Override
    public Material getDisc() {
        return Material.MUSIC_DISC_BLOCKS;
    }

    @Override
    public String getSoundKey() {
        return "custom.inemuri_enseitai";
    }

    @Override
    public long getCooldownMillis() {
        return 1000 * 219;
    }

    @Override
    public String getResourcePackFileName() {
        return "music.zip";
    }
}

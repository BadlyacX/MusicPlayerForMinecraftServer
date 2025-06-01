package com.badlyac.musicplayer.music;

import org.bukkit.Material;

public interface IMusicDisc {
    Material getDisc();
    String getSoundKey();
    long getCooldownMillis();
    String getResourcePackFileName();
}

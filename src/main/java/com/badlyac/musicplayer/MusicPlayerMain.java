package com.badlyac.musicplayer;

import com.badlyac.musicplayer.listener.JoinListener;
import com.badlyac.musicplayer.listener.JukeboxListener;
import com.badlyac.musicplayer.music.DiscManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MusicPlayerMain extends JavaPlugin {

    public static byte[] resourcePackSha1;
    public static String resourcePackUrl = "https://raw.githubusercontent.com/BadlyacX/MusicPlayerForMinecraftServer/master/src/main/resources/music.zip";
    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        DiscManager.prepareAllResourcePacks(this);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new JukeboxListener(), this);
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
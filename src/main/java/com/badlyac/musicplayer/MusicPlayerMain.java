package com.badlyac.musicplayer;

import com.badlyac.musicplayer.listener.JoinListener;
import com.badlyac.musicplayer.listener.JukeboxListener;
import com.badlyac.musicplayer.music.DiscManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MusicPlayerMain extends JavaPlugin {

    public static byte[] resourcePackSha1;
    public static String resourcePackUrl = "https://raw.githubusercontent.com/BadlyacX/zh_lemon/main/music.zip";

    @Override
    public void onEnable() {
        DiscManager.prepareAllResourcePacks(this);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new JukeboxListener(), this);}
}
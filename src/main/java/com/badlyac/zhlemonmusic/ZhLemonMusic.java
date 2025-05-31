package com.badlyac.zhlemonmusic;

import com.badlyac.zhlemonmusic.listener.JoinListener;
import com.badlyac.zhlemonmusic.listener.JukeboxListener;
import com.badlyac.zhlemonmusic.music.DiscManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ZhLemonMusic extends JavaPlugin {

    public static byte[] resourcePackSha1;
    public static String resourcePackUrl = "https://raw.githubusercontent.com/BadlyacX/zh_lemon/main/zh_lemon.zip";

    @Override
    public void onEnable() {
        DiscManager.prepareAllResourcePacks(this);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new JukeboxListener(), this);}
}
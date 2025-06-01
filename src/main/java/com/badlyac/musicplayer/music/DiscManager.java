package com.badlyac.musicplayer.music;

import com.badlyac.musicplayer.MusicPlayerMain;
import com.badlyac.musicplayer.music.Disc.GoBigDisc;
import com.badlyac.musicplayer.music.Disc.ZhLemonDisc;
import com.badlyac.musicplayer.utils.ResourcePackUtils;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscManager {
    private static final Map<Material, IMusicDisc> handlerMap = new HashMap<>();
    private static final List<IMusicDisc> allDiscs = new ArrayList<>();

    public static void registerAllDiscs() {
        register(new ZhLemonDisc());
        register(new GoBigDisc());
    }

    private static void register(IMusicDisc handler) {
        handlerMap.put(handler.getDisc(), handler);
        allDiscs.add(handler);
    }

    public static IMusicDisc getHandler(Material disc) {
        return handlerMap.get(disc);
    }

    public static void prepareAllResourcePacks(JavaPlugin plugin) {
        registerAllDiscs();
        File baseFolder = new File(plugin.getDataFolder(), "resourcepack");
        if (!baseFolder.exists()) baseFolder.mkdirs();

        for (IMusicDisc disc : allDiscs) {
            String zipName = disc.getResourcePackFileName();
            File zipFile = new File(baseFolder, zipName);

            if (!zipFile.exists()) {
                try (InputStream in = plugin.getResource(zipName)) {
                    if (in == null) {
                        plugin.getLogger().warning("internal resource pack can not find: " + zipName);
                        continue;
                    }
                    Files.copy(in, zipFile.toPath());
                    MusicPlayerMain.resourcePackSha1 = ResourcePackUtils.computeSha1(zipFile);
                    plugin.getLogger().info("resource pack copied: " + zipName);
                } catch (IOException e) {
                    plugin.getLogger().warning("encountered error while copying resource pack: " + e.getMessage());
                }
            }

            MusicPlayerMain.resourcePackSha1 = ResourcePackUtils.computeSha1(zipFile);
            if (MusicPlayerMain.resourcePackSha1 == null) {
                plugin.getLogger().warning("SHA-1 compute failed：" + zipName);
                continue;
            }

            if (disc instanceof AbstractMusicDisc) {
                ((AbstractMusicDisc) disc).setSha1(MusicPlayerMain.resourcePackSha1);
            }
        }
    }
}

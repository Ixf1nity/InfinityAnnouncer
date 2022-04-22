package me.infinitydev.announcer;

import lombok.Getter;
import me.infinitydev.announcer.announcer.MessageAnnouncer;
import me.infinitydev.announcer.announcer.TitleAnnouncer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class AnnouncerPlugin extends JavaPlugin {

    @Getter
    private static AnnouncerPlugin instance;
    private final MessageAnnouncer messageAnnouncer = new MessageAnnouncer();
    private final TitleAnnouncer titleAnnouncer = new TitleAnnouncer();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        if (this.getConfig().getBoolean("message-announcement")) {
            Bukkit.getScheduler().runTaskTimer(this, messageAnnouncer, 0L, messageAnnouncer.getDelayTimer());
        }
        if (this.getConfig().getBoolean("title-announcement")){
            Bukkit.getScheduler().runTaskTimer(this, titleAnnouncer, 0L, titleAnnouncer.getDelayTimer());
        }
        this.getLogger().log(Level.INFO, "InfinityAnnouncer " + this.getDescription().getVersion());
        this.getLogger().log(Level.INFO, "Author: Infinity#1392");
    }
}

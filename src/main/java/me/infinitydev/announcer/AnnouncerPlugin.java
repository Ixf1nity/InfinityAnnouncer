package me.infinitydev.announcer;

import lombok.Getter;
import me.infinitydev.announcer.announcer.MessageAnnouncer;
import me.infinitydev.announcer.announcer.TitleAnnouncer;
import me.infinitydev.announcer.utility.TaskUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class AnnouncerPlugin extends JavaPlugin {

    @Getter
    private static AnnouncerPlugin instance;
    
    @Override   
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        MessageAnnouncer messageAnnouncer = new MessageAnnouncer();
        if (this.getConfig().getBoolean("message-announcement")) {
            TaskUtils.runLaterAsync(messageAnnouncer, messageAnnouncer.getDelayTimer());
        }
        TitleAnnouncer titleAnnouncer = new TitleAnnouncer();
        if (this.getConfig().getBoolean("title-announcement")){
            TaskUtils.runLaterAsync(titleAnnouncer, titleAnnouncer.getDelayTimer());
        }
        this.getLogger().log(Level.INFO, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        this.getLogger().log(Level.INFO, "InfinityAnnouncer ENABLED");
        this.getLogger().log(Level.INFO, "Version: " + this.getDescription().getVersion());
        this.getLogger().log(Level.INFO, "Author: " + this.getDescription().getAuthors());
        this.getLogger().log(Level.INFO, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    @Override
    public void onDisable() {

    }
}

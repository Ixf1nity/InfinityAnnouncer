package me.infinitydev.announcer.announcer;

import lombok.Getter;
import me.infinitydev.announcer.AnnouncerPlugin;
import me.infinitydev.announcer.utility.ChatUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * @author infinity
 * 13-04-2022 / 12:00 PM
 * untitled / me.infinitydev.announcer.announcer
 */

@Getter
public class MessageAnnouncer implements Runnable {

    private long delayTimer;
    private List<String> messages;
    private boolean isSoundEnabled;
    private String sound;
    private final AnnouncerPlugin plugin = AnnouncerPlugin.getInstance();

    @Override
    public void run() {
        for (String keys : plugin.getConfig().getConfigurationSection("message-announcement").getKeys(false)) {
            this.delayTimer = Long.parseLong((keys + ".delay-timer"));
            this.messages = Collections.singletonList((keys + ".message-lines"));
            this.isSoundEnabled = Boolean.parseBoolean((keys + ".sound-settings.enabled"));
            this.sound = (keys + ".sound-settings.sound");
            for (Player player : plugin.getServer().getOnlinePlayers()) {
                for (String message : messages) {
                    player.sendMessage(ChatUtils.translate(message, player));
                    if (isSoundEnabled) {
                        player.playSound(player.getLocation(), Sound.valueOf(sound), 100f, 1f);
                    }
                }
            }
        }
    }
}
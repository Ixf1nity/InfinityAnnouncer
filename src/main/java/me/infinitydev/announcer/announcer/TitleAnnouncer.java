package me.infinitydev.announcer.announcer;

import lombok.Getter;
import me.infinitydev.announcer.AnnouncerPlugin;
import me.infinitydev.announcer.utility.ChatUtils;
import me.infinitydev.announcer.utility.TitleUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * @author Infinity
 * 13-04-2022 / 11:59 AM
 * untitled / me.infinitydev.announcer.announcer
 */

@Getter
public class TitleAnnouncer implements Runnable {

    private long delayTimer;
    private String title;
    private String subtitle;
    private int fadeIn;
    private int stay;
    private int fadeOut;
    private boolean isSoundEnabled;
    private String sound;
    private final AnnouncerPlugin plugin = AnnouncerPlugin.getInstance();

    @Override
    public void run() {
        for (String keys : plugin.getConfig().getConfigurationSection("title-announcement").getKeys(false)) {
            this.delayTimer = Long.parseLong((keys + ".delay-timer"));
            this.title = (keys + ".title");
            this.subtitle = (keys + ".subtitle");
            this.fadeIn = Integer.parseInt((keys + ".fade-in"));
            this.fadeOut = Integer.parseInt((keys + ".fade-out"));
            this.stay = Integer.parseInt((keys + ".stay"));
            this.isSoundEnabled = Boolean.parseBoolean((keys + ".sound-settings.enabled"));
            this.sound = (keys + ".sound-settings.sound");
            for (Player player : plugin.getServer().getOnlinePlayers()) {
                TitleUtils.sendTitle(player, fadeIn, stay, fadeOut,ChatUtils.translate(title, player),ChatUtils.translate(subtitle, player));
                if (isSoundEnabled) {
                    player.playSound(player.getLocation(), Sound.valueOf(sound), 100f, 1f);
                }
            }
        }
    }
}

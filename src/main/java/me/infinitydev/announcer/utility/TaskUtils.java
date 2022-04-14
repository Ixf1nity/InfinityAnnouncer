package me.infinitydev.announcer.utility;

import lombok.experimental.UtilityClass;
import me.infinitydev.announcer.AnnouncerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Infinity
 * 22-03-2022 / 10:53 AM
 * VenusHub / xyz.stormdev.venus.utility
 */

@UtilityClass
public class TaskUtils {

    public void run(Runnable runnable) {
        AnnouncerPlugin.getInstance().getServer().getScheduler().runTask(AnnouncerPlugin.getInstance(), runnable);
    }

    public void runTimer(Runnable runnable, long delay, long timer) {
        AnnouncerPlugin.getInstance().getServer().getScheduler().runTaskTimer(AnnouncerPlugin.getInstance(), runnable, delay, timer);
    }

    public void runTimerAsync(Runnable runnable, long delay, long timer) {
        AnnouncerPlugin.getInstance().getServer().getScheduler().runTaskTimerAsynchronously(AnnouncerPlugin.getInstance(), runnable, delay, timer);
    }

    public void runTimer(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimer(AnnouncerPlugin.getInstance(), delay, timer);
    }

    public void runLater(Runnable runnable, long delay) {
        AnnouncerPlugin.getInstance().getServer().getScheduler().runTaskLater(AnnouncerPlugin.getInstance(), runnable, delay);
    }

    public void runLaterAsync(Runnable runnable, long delay) {
        AnnouncerPlugin.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(AnnouncerPlugin.getInstance(), runnable, delay);
    }

    public void runSync(Runnable runnable) {
        if (Bukkit.isPrimaryThread())
            runnable.run();
        else
            Bukkit.getScheduler().runTask(AnnouncerPlugin.getInstance(), runnable);
    }

    public void runAsync(Runnable runnable) {
        if (Bukkit.isPrimaryThread())
            Bukkit.getScheduler().runTaskAsynchronously(AnnouncerPlugin.getInstance(), runnable);
        else
            runnable.run();
    }
}

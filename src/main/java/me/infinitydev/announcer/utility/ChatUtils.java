package me.infinitydev.announcer.utility;

import lombok.experimental.UtilityClass;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author Infinity
 * 12-03-2022 / 11:57 AM
 * StormCore / cool.krumpez.stormcore.command.commands
 */

@UtilityClass
public class ChatUtils {

    public String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public String translate(String message, Player player) {
        String toReturn = ChatColor.translateAlternateColorCodes('&', message);
        return PlaceholderAPI.setPlaceholders(player, toReturn);
    }

    public String BLUE;
    public String AQUA;
    public String YELLOW;
    public String RED;
    public String GRAY;
    public String GOLD;
    public String GREEN;
    public String WHITE;
    public String BLACK;
    public String BOLD;
    public String ITALIC;
    public String UNDER_LINE;
    public String STRIKE_THROUGH;
    public String RESET;
    public String MAGIC;
    public String DARK_BLUE;
    public String DARK_AQUA;
    public String DARK_GRAY;
    public String DARK_GREEN;
    public String DARK_PURPLE;
    public String DARK_RED;
    public String PINK;
    public String MENU_BAR;
    public String CHAT_BAR;
    public String SB_BAR;

    {
        ChatUtils.BLUE = ChatColor.BLUE.toString();
        ChatUtils.AQUA = ChatColor.AQUA.toString();
        ChatUtils.YELLOW = ChatColor.YELLOW.toString();
        ChatUtils.RED = ChatColor.RED.toString();
        ChatUtils.GRAY = ChatColor.GRAY.toString();
        ChatUtils.GOLD = ChatColor.GOLD.toString();
        ChatUtils.GREEN = ChatColor.GREEN.toString();
        ChatUtils.WHITE = ChatColor.WHITE.toString();
        ChatUtils.BLACK = ChatColor.BLACK.toString();
        ChatUtils.BOLD = ChatColor.BOLD.toString();
        ChatUtils.ITALIC = ChatColor.ITALIC.toString();
        ChatUtils.UNDER_LINE = ChatColor.UNDERLINE.toString();
        ChatUtils.STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();
        ChatUtils.RESET = ChatColor.RESET.toString();
        ChatUtils.MAGIC = ChatColor.MAGIC.toString();
        ChatUtils.DARK_BLUE = ChatColor.DARK_BLUE.toString();
        ChatUtils.DARK_AQUA = ChatColor.DARK_AQUA.toString();
        ChatUtils.DARK_GRAY = ChatColor.DARK_GRAY.toString();
        ChatUtils.DARK_GREEN = ChatColor.DARK_GREEN.toString();
        ChatUtils.DARK_PURPLE = ChatColor.DARK_PURPLE.toString();
        ChatUtils.DARK_RED = ChatColor.DARK_RED.toString();
        ChatUtils.PINK = ChatColor.LIGHT_PURPLE.toString();
        ChatUtils.MENU_BAR = String.valueOf(ChatColor.GRAY.toString()) + ChatColor.STRIKETHROUGH.toString() + "------------------------";
        ChatUtils.CHAT_BAR = String.valueOf(ChatColor.GRAY.toString()) + ChatColor.STRIKETHROUGH.toString() + "------------------------------------------------";
        ChatUtils.SB_BAR = String.valueOf(ChatColor.GRAY.toString()) + ChatColor.STRIKETHROUGH.toString() + "----------------------";
    }
}
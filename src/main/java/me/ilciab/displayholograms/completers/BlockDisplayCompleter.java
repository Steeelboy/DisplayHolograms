package me.ilciab.displayholograms.completers;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockDisplayCompleter implements TabCompleter {

    final List<String> options = new ArrayList<>(Arrays.asList("create", "modify", "remove"));
    public static final List<String> names = new ArrayList<>();


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        Player player = (Player) sender;
        names.clear();
        for (Entity entity : player.getWorld().getEntities()) {
            if (entity instanceof BlockDisplay && entity.getCustomName() != null)
                names.add(entity.getCustomName());
        }
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) StringUtil.copyPartialMatches(args[0], options, completions);
        if (args.length >= 2) {
            switch (args[0]) {
                case "modify", "remove" -> StringUtil.copyPartialMatches(args[1], names, completions);
            }
        }
        return completions;
    }

    public static Entity searchEntitybyName(World world, String name) {
        for (Entity entity : world.getEntities()) {
            if (entity instanceof BlockDisplay && BlockDisplayCompleter.names.contains(entity.getCustomName())) {
                return entity;
            }
        }
        return null;
    }
}

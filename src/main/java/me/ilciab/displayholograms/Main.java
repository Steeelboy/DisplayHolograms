package me.ilciab.displayholograms;

import me.ilciab.displayholograms.commands.BlockDisplayCommand;
import me.ilciab.displayholograms.completers.BlockDisplayCompleter;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand createCommand = getCommand("blockdisplay");
        if(createCommand == null) return;
        createCommand.setExecutor(new BlockDisplayCommand());
        createCommand.setTabCompleter(new BlockDisplayCompleter());
        createCommand.setLabel("cd");
    }
}

package me.ilciab.displayholograms.commands;

import me.ilciab.displayholograms.InventoryContents;
import me.ilciab.displayholograms.completers.BlockDisplayCompleter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Transformation;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.Objects;

public class BlockDisplayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)){
            sender.sendMessage("Can't execute command from console");
            return true;
        }
        Location location = player.getLocation();
        World world = player.getWorld();
        if(args.length <2){
            sender.sendMessage("Non valid command");
            return true;
        }
            switch (args[0]){
                case "create" ->{
                    if(args.length < 2){
                        sender.sendMessage("Non valid command");
                        return true;
                    }
                    if(BlockDisplayCompleter.names.contains(args[1])){
                        sender.sendMessage("Another display with that name already exists");
                        return true;
                    }
                    Material material;
                    try {
                        material = Material.valueOf(args[2].toUpperCase());
                    }catch (IllegalArgumentException ignored){
                        sender.sendMessage("Non valid material");
                        return true;
                    };
                    BlockData block = material.createBlockData();
                    if(block instanceof Stairs stair){stair.setFacing(BlockFace.NORTH);
                        //chain
                        // fence
                        // gate
                        // trapdoor
                        // button
                        // door
                        // slab
                        // wall
                        // bed
                        // pointed_dripstone
                        // chorus_plant
                        // chorus_flower
                        // vines
                        // glow
                        // lichens
                        // non tutti
                    }
                    BlockDisplay blockDisplay = (BlockDisplay) world.spawnEntity(location, EntityType.BLOCK_DISPLAY);
                    blockDisplay.setCustomName(args[1]);
                    blockDisplay.setBlock(block);
                    player.openInventory(InventoryContents.initializeBlockDisplayInventory()Inventory());

                }
                case "modify" ->{
                    Entity entity = BlockDisplayCompleter.searchEntitybyName(world, args[1]);
                    if(entity == null){
                        sender.sendMessage("Display not found");
                        return true;
                    }
                    sender.sendMessage("Inserire gui");



                }
                case "remove" ->{
                    Entity entity = BlockDisplayCompleter.searchEntitybyName(world, args[1]);
                    if(entity == null){
                        sender.sendMessage("Display not found");
                        return true;
                    }
                    entity.remove();
                }
                default -> throw new IllegalStateException("Unexpected value: " + args[0]);
            }
        return true;
    }

}

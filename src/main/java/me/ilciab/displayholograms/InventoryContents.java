package me.ilciab.displayholograms;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Display;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryContents {

    public static Inventory initializeBlockDisplayInventory() {
        ItemStack[] contents = new ItemStack[27];

        for(int i = 0; i<27; i++) {

            contents[i] = new ItemStack(Material.AIR);
        }

        contents[0].setType(Material.OAK_HANGING_SIGN);
        contents[0].getItemMeta().setDisplayName("Billboard");
        contents[1].setType(Material.LIGHT);
        contents[1].getItemMeta().setDisplayName("Brightness");
        contents[2].setType(Material.SPECTRAL_ARROW);
        contents[2].getItemMeta().setDisplayName("Glow");
        contents[9].setType(Material.MINECART);
        contents[9].getItemMeta().setDisplayName("Translation");
        contents[10].setType(Material.STRUCTURE_VOID);
        contents[10].getItemMeta().setDisplayName("Scale");
        contents[13].setType(Material.NETHER_STAR);
        contents[13].getItemMeta().setDisplayName("Add block");
        contents[15].setType(Material.BARRIER);
        contents[15].getItemMeta().setDisplayName("Selected block");
        contents[17].setType(Material.STRUCTURE_BLOCK);
        contents[17].getItemMeta().setDisplayName("Special blocks");
        contents[24].setType(Material.OBSERVER);
        contents[24].getItemMeta().setDisplayName("Block states");

        Inventory inv = Bukkit.createInventory(null, 27, "sium");
        inv.setContents(contents);
        return inv;
    }
}
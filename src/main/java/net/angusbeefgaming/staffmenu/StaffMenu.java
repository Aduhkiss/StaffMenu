/*
 * Staff Menu Plugin
 * Written by Atticus Zambrana
 * 
 * Menu for Staff to use, to access staff features
 */
package net.angusbeefgaming.staffmenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

public class StaffMenu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission("angusbeef.staffmenu.open") || sender.isOp())) { // checks if the player has permission
            sender.sendMessage("Missing Permission Node: angusbeef.staffmenu.open");
            return false;
        }
        if(!(sender instanceof Player)) { // Then Checks if the player is in the game
            sender.sendMessage("You Must run this command in-game!"); 
            return false;
        }
        Player player = (Player) sender; // Cast Player to Sender
        Inventory inv = Bukkit.createInventory(null, 18, ChatColor.BLUE + "Staff Menu");
        
        // Here I Setup The Items for the inventory
        ItemStack ITEMA = nameItem(Material.DIAMOND, ChatColor.AQUA + "StaffMenu Written by Atticus Zambrana");
        ItemStack ITEM1 = nameItem(Material.COMPASS, ChatColor.AQUA + "Toggle Staff Mode");
        ItemStack ITEM2 = nameItem(Material.GRASS, ChatColor.AQUA + "Toggle Super Vanish");
        // And now I will bind the items to the inventory
        inv.setItem(0, ITEM1);
        inv.setItem(1, ITEM2);
        inv.setItem(9, ITEMA);
        
        // And then Finnaly, I am going to open the Inv for the player
        player.openInventory(inv);
        // And Of course, return true!
        return true;
    }
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}

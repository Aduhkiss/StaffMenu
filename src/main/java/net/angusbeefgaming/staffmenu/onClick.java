/*
 * onClick Detector
 * Written by Atticus Zambrana
 * 
 * Main file that calls code when the user clickes on the inventory
 */
package net.angusbeefgaming.staffmenu;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.*;

public class onClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (!inv.getTitle().equals(ChatColor.BLUE + "Staff Menu")) {
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        
        Player player = (Player) event.getWhoClicked();
        
        ItemStack item = event.getCurrentItem();
        if (item.getType()==Material.COMPASS) {
            Bukkit.getServer().dispatchCommand(player, "staff");
            event.setCancelled(true);
            player.closeInventory();
        }
        if (item.getType()==Material.GRASS) {
            Bukkit.getServer().dispatchCommand(player, "sv");
            event.setCancelled(true);
            player.closeInventory();
        }
        if(item.getType()==Material.CLOCK) {
            Bukkit.getServer().dispatchCommand(player, "socialspy");
            event.setCancelled(true);
            player.closeInventory();
        }
        if (item.getType()==Material.DIAMOND) {
            player.sendMessage("StaffMenu Written by Atticus Zambrana or TheBeefSteak");
            event.setCancelled(true);
            player.closeInventory();
        }
        event.setCancelled(true);
    }
}



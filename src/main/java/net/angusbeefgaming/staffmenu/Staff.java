package net.angusbeefgaming.staffmenu;
import org.bukkit.plugin.java.JavaPlugin;

public class Staff extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("staffm").setExecutor(new StaffMenu());
        getServer().getPluginManager().registerEvents(new onClick(), this); 
        
    }
    @Override
    public void onDisable() {
        getLogger().info("ALERT! Staff Menu Plugin Disabled! Is the Server Shutting down");
    }
}

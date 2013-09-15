package pescado;

import lstnrEvents.*;
import org.bukkit.plugin.java.JavaPlugin;

import cmds.EnablePescadoCommand;



public class Pescado extends JavaPlugin {
	
	// Cuando el plugin se activa
	
	public void onEnable(){
		
		getLogger().info("Pescado was Enable.");
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new PlyrRIPEvent(this), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
		getServer().getPluginManager().registerEvents(new DroItemEvent(this), this);
		getCommand("pescado").setExecutor(new EnablePescadoCommand(this));
		
	}
	
	// Cuando el plugin se desactiva
	
	public void onDisable(){
		
		getLogger().info("Pescado was Disable.");
		
	}
	
	
	
	
}

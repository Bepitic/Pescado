package pescado;

import lstnrEvents.*;
import org.bukkit.plugin.java.JavaPlugin;

import cmds.EnablePescadoCommand;



public class Pescado extends JavaPlugin {
	
	// Cuando el plugin se activa
	
	public void onEnable(){
		saveDefaultConfig();
		
		getLogger().info("Pescado was Enable.");
		getServer().getPluginManager().registerEvents(new PlyrRIPEvent(this), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
		getServer().getPluginManager().registerEvents(new DroItemEvent(this), this);
		getCommand("pescado").setExecutor(new EnablePescadoCommand(this));
		super.onEnable();
	}
	
	// Cuando el plugin se desactiva
	
	public void onDisable(){
		
		getLogger().info("Pescado was Disable.");
		super.onDisable();
	}
	
	
	
	
}

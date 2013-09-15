package task;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import pescado.Pescado;

public class setTime0Task extends BukkitRunnable {
	
	private final Pescado plugin;
	
	private final World world;

		public setTime0Task(Pescado plugin, World world){
			this.plugin = plugin;
			this.world = world;
			
		}
	
	@Override
	public void run() {
		
		for (Player p : world.getPlayers()) {
	           
			plugin.getConfig().set("users.TimePescado." + p.getDisplayName() , 0);
    		
        }
		plugin.saveConfig();
		
		// TODO Auto-generated method stub
		
	}

}

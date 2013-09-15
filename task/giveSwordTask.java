package task;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.inventory.*;

import pescado.Pescado;

public class giveSwordTask extends BukkitRunnable {

	private final Pescado plugin;
	private World w;
	ItemStack sword = new ItemStack( Material.WOOD_SWORD , 1);

		public giveSwordTask(Pescado plugin,World w){
			this.plugin = plugin;
			this.w = w;
			
		}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (Player p : w.getPlayers()) {
	           
			if(p.getDisplayName() != plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getDisplayName() )
    		{
				p.getInventory().setItemInHand(sword);
				plugin.getConfig().set("users.TimePescadoAux2." + p.getDisplayName(), true);
				//plugin.getConfig().set("users.TimePescado." + p.getDisplayName() , 0);
	    		
            }
    		
        }
		//plugin.saveConfig();
		
	}

}

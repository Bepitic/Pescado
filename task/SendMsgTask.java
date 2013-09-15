package task;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import pescado.Pescado;


public class SendMsgTask extends BukkitRunnable {
	
private final Pescado plugin;
private final Player newPescado;
private final World world;
private final String msg;

	public SendMsgTask(Pescado plugin, World world, Player killer, String msg){
		this.plugin = plugin;
		this.world = world;
		this.newPescado = killer;
		this.msg = msg;
		
	}
	@Override
	public void run() {
		
		
		for (Player p : world.getPlayers()) {
	           
    		p.sendMessage( ChatColor.DARK_GREEN + msg + newPescado.getDisplayName() );
    		
        }
		
	}

}

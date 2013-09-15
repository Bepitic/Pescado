package lstnrEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitTask;
import pescado.Pescado;

public class PlyrLoginEvent implements Listener {

	private final Pescado plugin;
	public PlyrLoginEvent( Pescado plugin ){
		this.plugin = plugin;
	}
	
	@EventHandler
    public void normalLogin( PlayerLoginEvent event ) {
		
		plugin.getConfig().set("users.TimePescado." + event.getPlayer()  , 0);
		
    }

}

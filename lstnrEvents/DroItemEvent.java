package lstnrEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import pescado.Pescado;

public class DroItemEvent implements Listener {
	
	private final Pescado plugin;
	private Player player;

	public DroItemEvent( Pescado plugin ){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void DroItemEvent( PlayerDropItemEvent e ){
		if( e.getPlayer().getWorld() == plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getWorld() )
		{
			e.setCancelled(true);
		}
		
	}

}

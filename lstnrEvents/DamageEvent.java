package lstnrEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import pescado.Pescado;

public class DamageEvent implements Listener {

	private final Pescado plugin;
	private Player player;

	public DamageEvent( Pescado plugin ){
		this.plugin = plugin;
	}

	@EventHandler
	public void DamageEvent( EntityDamageByEntityEvent e ) {

		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player)
		{
			Player playerrecive = (Player) e.getEntity();
			Player playerda = (Player) e.getDamager();
			//cambiar a distinto
			if(playerda.getWorld() == plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getWorld() && playerrecive.getWorld() == plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getWorld())
			{
				e.setCancelled(true);

				if (playerda.getDisplayName() == plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getDisplayName() || playerrecive.getDisplayName() == plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getDisplayName() )
				{

					e.setCancelled(false);

				}
			}
		}

	}

}

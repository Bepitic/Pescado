package task;

import org.bukkit.ChatColor;
import org.bukkit.World;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import pescado.Pescado;

public class checkSecondsTask extends BukkitRunnable {
	
	private final Pescado plugin;
	private Player plyr;
	private int sec, limit, timeDone;
	private World w;
	private boolean one = true;

		public checkSecondsTask(Pescado plugin, int limit,World w){
			this.plugin = plugin;
			this.limit = limit;
			this.w = w;
			
		}

	@Override
	public void run() {
		//obtiene el pescator
		plyr = plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator"));
		
		final Calendar cal = new GregorianCalendar();
		final int segActual = cal.get(Calendar.SECOND);
		timeDone = plugin.getConfig().getInt("users.TimePescado." + plyr.getDisplayName());
		sec = plugin.getConfig().getInt("users.TimePescadoAux." + plyr.getDisplayName());
		
		
		if(plugin.getConfig().getBoolean("users.TimePescadoAux2." + plyr.getDisplayName()))
			{
			
			
			sec = segActual;
			plugin.getConfig().set("users.TimePescadoAux2." + plyr.getDisplayName(), false);
			plugin.saveConfig();
			
			}
		
		
		if( timeDone < limit )
		{
			
			
			if( sec <= segActual && one )
			{
				
				timeDone += segActual - sec;
				
				//cambiar a 10
				if(timeDone%10 == 0)
				{
					BukkitTask checktas = new SendMsgTask(plugin, plyr.getWorld(), plyr, "El Pescado tiene : "+ timeDone +" sec -> ").runTask(plugin);
					BukkitTask chec = new giveSwordTask(plugin, plyr.getWorld()).runTask(plugin);
				}
				
				plugin.getConfig().set("users.TimePescado." + plyr.getDisplayName(), timeDone );
				
				plugin.getConfig().set("users.TimePescadoAux." + plyr.getDisplayName(), segActual );
				
			}else if( sec > segActual && one )
			{
				
				timeDone += segActual + (60 - sec);
				
				plugin.getConfig().set("users.TimePescado." + plyr.getDisplayName(), timeDone );
				
				plugin.getConfig().set("users.TimePescadoAux." + plyr.getDisplayName(), segActual );
				
				
			}
			
		//	plugin.getConfig().set("users.TimePescado." + plyr.getDisplayName() , sec);
			
		}
		else
		{
			
			if(one)
			{
				for (Player p : w.getPlayers()) {
			
		           
	    		p.sendMessage( ChatColor.GOLD + "The winner is : " + plyr.getDisplayName() );
	    		
				}
				one = false;
			}
			
			//encontrar una forma para que se acabe por si solo la tarea
		}
		
		plugin.saveConfig();
		
	}

}

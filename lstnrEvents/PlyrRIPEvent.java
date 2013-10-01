package lstnrEvents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import task.SendMsgTask;
import task.setTime0Task;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitTask;
import pescado.Pescado;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;


public class PlyrRIPEvent implements Listener {

	ItemStack pescado = new ItemStack( Material.RAW_FISH , 1);
	private final Pescado plugin;
	
	public PlyrRIPEvent( Pescado plugin ){
		this.plugin = plugin;
	}
	
	
	@EventHandler
    public void RipEvent( PlayerDeathEvent event ) {
		//el .getEntity solo te dice quien ha muerto no que lo ha matado
		Player muerto = event.getEntity();
		
		if( muerto.getDisplayName() == plugin.getServer().getPlayer(plugin.getConfig().getString("thePescator")).getDisplayName()  ){
		//y del muerto sacamos el .getKiller que es quien lo ha matado
		Player asesino = muerto.getKiller();
		
		event.getDrops().clear();
		
		muerto.sendMessage(ChatColor.AQUA + plugin.getConfig().getString("translate.EventRip") + plugin.getConfig().getInt("users.TimePescado." + muerto.getDisplayName() ) + 
				plugin.getConfig().getString("translate.EventRip2") );
		
		plugin.getConfig().set("users.TimePescado." + muerto.getDisplayName(),0 );
		
		plugin.getConfig().set("thePescator" , asesino.getDisplayName());
		
		asesino.getInventory().setHelmet(new ItemStack(90, 1));
		asesino.getInventory().setItemInHand(pescado);
		asesino.getItemInHand().addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
		
		//final Calendar cal = new GregorianCalendar();
		//final int segActual = cal.get(Calendar.SECOND);
		
		//plugin.getConfig().set("users.TimePescadoAux." + asesino.getDisplayName(), segActual);
		plugin.saveConfig();
		
		BukkitTask SendMsgTask = new SendMsgTask(plugin, asesino.getWorld(), asesino, plugin.getConfig().getString("translate.EventNewPescado") ).runTask(plugin);
		BukkitTask setTime0Task = new setTime0Task(plugin, asesino.getWorld()).runTask(plugin);
		}

    }
	
}

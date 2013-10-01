package cmds;

import java.util.Calendar;
import java.util.GregorianCalendar;
import pescado.Pescado;
import task.setTime0Task;
import task.checkSecondsTask;
import task.SendMsgTask;
import task.giveSwordTask;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;


public class EnablePescadoCommand implements CommandExecutor  {
	
	Pescado plugin;
	public EnablePescadoCommand(Pescado plugin) {
	this.plugin = plugin;
	}
	int sec = 40;
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] arg3) {
		
			if(!(sender instanceof Player)) {
				return false;
			}
		
			Player player = (Player) sender;
			
			if (!sender.hasPermission("cmd.pescado")) {
	             sender.sendMessage( ChatColor.DARK_RED + "You dont have permission" );
	             return true;
	        }
			
			final Calendar cal = new GregorianCalendar();
			final int segActual = cal.get(Calendar.SECOND);
			
			
			if(arg3.length == 0 ){
				
				
				
				if(plugin.getConfig().getBoolean("canUse")){
					
					plugin.getConfig().set("canUse", false);
					
					player.sendMessage( ChatColor.RED + "Time : "+sec+" s");
					
					BukkitTask checktask = new setTime0Task(plugin, player.getWorld()).runTask(plugin);
					BukkitTask giveSwordTask = new giveSwordTask(plugin, player.getWorld()).runTask(plugin);
					plugin.getConfig().set("thePescator" , player.getDisplayName());
					plugin.getConfig().set("users.TimePescadoAux." + player.getDisplayName(), segActual );
					plugin.saveConfig();
					ItemStack pescado = new ItemStack( Material.RAW_FISH , 1);
					player.getInventory().setHelmet(new ItemStack(90, 1));
					player.getInventory().setItemInHand(pescado);
					player.getItemInHand().addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
					
					BukkitTask checktask2 = new SendMsgTask(plugin, player.getWorld(), player, " WINO WANT FISH "+ plugin.getConfig().getString("translate.EventStart") ).runTask(plugin);
					plugin.getConfig().set("users.TimePescado." + player.getDisplayName(),0 );
					plugin.saveConfig();
					BukkitTask checktask3 = new checkSecondsTask(plugin, sec,  player.getWorld()).runTaskTimer(plugin, 20L, 20L);
				
				}else{
				
					player.sendMessage(ChatColor.DARK_RED + "You must use /pescado stop  ");
				
				}
				
				return true;
			}
			
			
			
			if(arg3.length == 1){
				if(arg3[0].equalsIgnoreCase("stop")){
					player.sendMessage(ChatColor.RED + "Pescado stop");
					plugin.getServer().getScheduler().cancelTasks(plugin);
					plugin.getConfig().set("canUse", true);
					plugin.saveConfig();
					return true;
				}else{
					//completarlo ¡¡¡
					player.sendMessage(ChatColor.RED + "this is not implement. Comes soon");
					return true;
				}
			}
			
		return false;
	}

}

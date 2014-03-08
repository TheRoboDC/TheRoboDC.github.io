package io.github.TheRoboDC; // Package name.

import org.bukkit.ChatColor; //Allows use of colored chat messages.
import org.bukkit.command.Command; //Allows the use of commands.
import org.bukkit.command.CommandSender; //Allows the use of entities sending commands.
import org.bukkit.entity.Player; //Allows the use of Player Entities.
import org.bukkit.plugin.java.JavaPlugin; //Allows this to be a plugin - this is the main class.

public class iHealPlus extends JavaPlugin {
	public static iHealPlus plugin; //Defines iHealPlus as a plugin.
	
	@Override
	public void onDisable() {
		getLogger().info("iHealPlus v0.1 has been disabled!"); //Info message sent to Console.
	}
	
	@Override
	public void onEnable() {
		getLogger().info("iHealPlus v0.1 has been enabled!");  //Info message sent to Console.
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("heal")) {
			if(args.length == 0 && !(sender instanceof Player)) { //Checks if the sender is a Player or not.
				sender.sendMessage("This command can only be run by a Player to prevent internal errors.");		
			} else if(args.length == 0 && sender instanceof Player) { //Sender is player and there are no args.
				player.setHealth(20);
				player.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "Congrats - you have been healed!");
			  }
		}     
			if(args.length == 1) { //1 arg - for ex. /heal robo7193
				if (player.getServer().getPlayer(args [0]) != null) { //Is player online?
					Player playerArgument1 = player.getServer().getPlayer(args [0]);
					playerArgument1.setHealth(20);
					playerArgument1.setFireTicks(0);
					playerArgument1.sendMessage(ChatColor.GREEN + "Congrats - you have been healed!");
			    } else if(args.length > 1) { 
						sender.sendMessage(ChatColor.RED + "You have too many arguments!"); //More than 1 arg.
				 		
			      } else { 
					player.sendMessage(ChatColor.RED + "The requested player could not be found. Please try again later.");	
			      }	
			}
		return false;
	}	
}
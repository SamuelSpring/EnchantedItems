package me.IAmSam.EnchantedItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class ItemTab implements TabCompleter{
	
	List<String> arguments = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
		if(arguments.isEmpty()) {
			arguments.add("help");
			arguments.add("reload"); 
			arguments.add("feather");
			arguments.add("nether_star"); 
			arguments.add("spider_eye");
			arguments.add("heal_wand"); 
			arguments.add("blaze_rod");
			arguments.add("emerald"); 
			arguments.add("wither_rose");
			arguments.add("rabbit_foot"); 
			arguments.add("honey_comb");
			arguments.add("glowstone_dust"); 
			arguments.add("prismarine");
			arguments.add("ender_dasher");
			arguments.add("fox_spirit");
			arguments.add("refresh_cooldown"); arguments.add("rc");
			arguments.add("turtle_egg");
		}
		
		List<String> result = new ArrayList<String>();
		if(args.length == 1) {
			for (String a : arguments) {
				if (a.toLowerCase().startsWith(args[0].toLowerCase()))
					result.add(a);
			}
			return result;
		}
		return null;
		
	}
}

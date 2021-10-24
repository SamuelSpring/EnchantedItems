package me.IAmSam.EnchantedItems;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommand implements CommandExecutor {
	GetItemCommands itemget = new GetItemCommands();
	private Main main;
	private EventHandlers eHan;
	public ItemCommand(Main main) {
		this.main = main;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		Location loc = player.getLocation();
		World world = player.getWorld();
		if(label.equalsIgnoreCase("enchanteditem") || label.equalsIgnoreCase("ei") || label.equalsIgnoreCase("enchantedi" )) {
			
			if(!(sender instanceof Player)) {
				sender.sendMessage("Not accessable from console");
				return true;
			}
			if(args.length==0) {
				displayMenu(player);
				return true;
				}
					
			}
			if(args.length > 1) {
				player.sendMessage(ChatColor.RED + ""   + "Invalid Syntax: 1 Argument Required");
				return true;
			}
		
			if(args[0].equalsIgnoreCase("help")) {
				displayMenu(player);
				return true;
			}
			if(!player.isOp()) {
				player.sendMessage(ChatColor.RED + ""   + "You do not have permission to use this command!");
			}
			//OP Required Commands
			if(player.isOp()) {
			if(args[0].equalsIgnoreCase("feather")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getFeather());
					return true;
				}
				player.getInventory().addItem(itemget.getFeather());
				return true;
			}
			if(args[0].equalsIgnoreCase("nether_star")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getNetherStar());
					return true;
				}
				player.getInventory().addItem(itemget.getNetherStar());
				return true;
			}
			if(args[0].equalsIgnoreCase("turtle_egg")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getTurtleEgg());
					return true;
				}
				player.getInventory().addItem(itemget.getTurtleEgg());
				return true;
			}
			if(args[0].equalsIgnoreCase("spider_eye")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getSpiderEye());
					return true;
				}
				player.getInventory().addItem(itemget.getSpiderEye());
				return true;
			}
			if(args[0].equalsIgnoreCase("heal_wand")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getNecroStick());
					return true;
				}
				player.getInventory().addItem(itemget.getNecroStick());
				return true;
			}
			if(args[0].equalsIgnoreCase("blaze_rod")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getBlazeRod());
					return true;
				}
				player.getInventory().addItem(itemget.getBlazeRod());
				return true;
			}
			if(args[0].equalsIgnoreCase("emerald")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getEmerald());
					return true;
				}
				player.getInventory().addItem(itemget.getEmerald());
				return true;
			}
			if(args[0].equalsIgnoreCase("wither_rose")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getWitherRose());
					return true;
				}
				player.getInventory().addItem(itemget.getWitherRose());
				return true;
			}
			if(args[0].equalsIgnoreCase("rabbit_foot")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getRabbitFoot());
					return true;
				}
				player.getInventory().addItem(itemget.getRabbitFoot());
				return true;
			}
			if(args[0].equalsIgnoreCase("honey_comb")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getHoneyComb());
					return true;
				}
				player.getInventory().addItem(itemget.getHoneyComb());
				return true;
			}
			if(args[0].equalsIgnoreCase("glowstone_dust")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getGlowstoneDust());
					return true;
				}
				player.getInventory().addItem(itemget.getGlowstoneDust());
				return true;
			}
			if(args[0].equalsIgnoreCase("prismarine")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getCrystal());
					return true;
				}
				player.getInventory().addItem(itemget.getCrystal());
				return true;
			}
			if(args[0].equalsIgnoreCase("ender_dasher")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getEnderDasher());
					return true;
				}
				player.getInventory().addItem(itemget.getEnderDasher());
				return true;
			}
			if(args[0].equalsIgnoreCase("fox_spirit")) {
				if(player.getInventory().firstEmpty() == -1) {
					//inventory full
					world.dropItemNaturally(loc, itemget.getFoxSpirit());
					return true;
				}
				player.getInventory().addItem(itemget.getFoxSpirit());
				return true;
			}
			if(args[0].equalsIgnoreCase("reload")) {
				main.reloadConfig();
				sender.sendMessage("EI config reloaded");
				return true;
			}
			if(args[0].equalsIgnoreCase("refresh_cooldown") || args[0].equalsIgnoreCase("rc") ) {
				
				EventHandlers.removeCooldowns(sender.getName());
				sender.sendMessage(ChatColor.RED + ""   + "Abilities refreshed");
			
				return true;
			}
		}
	
		return false;
}
	public void displayMenu(Player player) {
		player.sendMessage(ChatColor.BLUE + "" + "Mobs:");
		player.sendMessage(ChatColor.BLUE + "" + "Chicken:                        Drops Enchanted Feather           1/1000");
		player.sendMessage(ChatColor.BLUE + "" + "Spider:                         Drops Enchanted Spider Eye        1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Blaze:                          Drops Enchanted Blaze Rod         1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Pillager:                       Drops Enchanted Emerald           1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Wither Skeleton:              Drops Enchanted Wither Rose       1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Rabbit:                         Drops Enchanted Rabbit Foot       1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Bee:                            Drops Enchanted Honey Comb        1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Husk:                           Drops Enchanted Glow Stone        1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Guardian:                      Drops Enchanted Prismarine        1/300");
		player.sendMessage(ChatColor.BLUE + "" + "Enderman:                     Drops Ender Dasher                1/1000");
		player.sendMessage(ChatColor.BLUE + "" + "Fox:                            Drops Spirit of the Fox                1/300");

		}
	}


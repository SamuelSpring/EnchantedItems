package me.IAmSam.EnchantedItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity.Spigot;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Husk;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Spider;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		Bukkit.addRecipe(getRecipe());
		this.getServer().getPluginManager().registerEvents(new EventHandlers(this), this);
		this.getCommand("enchanteditem").setExecutor(new ItemCommand(this));
		this.getCommand("enchanteditem").setTabCompleter(new ItemTab());
		
	}
	
	@Override
	public void onDisable() {}
	
	

	


private ShapedRecipe getRecipe() {
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	meta.setCustomModelData(1234567);
	meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Blood Staff");
	//Lore
	meta.setUnbreakable(true);
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "staff of blood");
	meta.setLore(lore);
	
	item.setItemMeta(meta);
	//Recipe
	NamespacedKey key = new NamespacedKey(this, "golden_sword");
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	recipe.shape("B","B","R");
	recipe.setIngredient('B', Material.GOLD_BLOCK);
	recipe.setIngredient('R', Material.BLAZE_ROD);
	return recipe;
	
}
}



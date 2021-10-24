package me.IAmSam.EnchantedItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetItemCommands {
public ItemStack getFeather() {
		
		ItemStack feather = new ItemStack(Material.FEATHER);
		ItemMeta meta = feather.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Feather");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "breaks your fall");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		feather.setItemMeta(meta);
		
		return feather;
	}

public ItemStack getFoxSpirit() {
	
	ItemStack foxSpirit = new ItemStack(Material.ORANGE_DYE);
	ItemMeta meta = foxSpirit.getItemMeta();
	meta.setCustomModelData(123456);
	meta.setDisplayName(ChatColor.AQUA + "Spirit of the Fox");
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "move swiftly and strike");
	meta.setLore(lore);
	meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	meta.setUnbreakable(true);
	foxSpirit.setItemMeta(meta);
	return foxSpirit;
}


public ItemStack getNecroStick() {
	
	ItemStack necroStick = new ItemStack(Material.STICK);
	ItemMeta meta = necroStick.getItemMeta();
	meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Healing Wand");
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "divinity in it's purest form");
	meta.setLore(lore);
	meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	meta.setUnbreakable(true);
	
	necroStick.setItemMeta(meta);
	
	return necroStick;
}

public ItemStack getSpiderEye() {
	
	ItemStack spiderEye = new ItemStack(Material.FERMENTED_SPIDER_EYE);
	ItemMeta meta = spiderEye.getItemMeta();
	meta.setDisplayName(ChatColor.GOLD + "Enchanted Spider Eye");
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "cures poison");
	meta.setLore(lore);
	meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	meta.setUnbreakable(true);
	
	spiderEye.setItemMeta(meta);
	
	return spiderEye;
}
	
	public ItemStack getNetherStar() {
		
		ItemStack nether_star = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = nether_star.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Seed of Corruption");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "holding this makes you hear the voices");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		nether_star.setItemMeta(meta);
		
		return nether_star;
	}
	
	
		public ItemStack getHoneyComb() {
		
		ItemStack honeycomb = new ItemStack(Material.HONEYCOMB);
		ItemMeta meta = honeycomb.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Honeycomb");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "never be hungry again");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		honeycomb.setItemMeta(meta);
		
		return honeycomb;
	}
		
		public ItemStack getGlowstoneDust() {
			
			ItemStack glowDust = new ItemStack(Material.GLOWSTONE_DUST);
			ItemMeta meta = glowDust.getItemMeta();
			meta.setDisplayName(ChatColor.GOLD + "Enchanted Glowstone Dust");
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "light up the night");
			meta.setLore(lore);
			meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.setUnbreakable(true);
			
			glowDust.setItemMeta(meta);
			
			return glowDust;
		}
	
	public ItemStack getBlazeRod() {
		
		ItemStack blazeRod = new ItemStack(Material.BLAZE_ROD);
		ItemMeta meta = blazeRod.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Blaze Rod");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "shields you from fire");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);

		blazeRod.setItemMeta(meta);
		
		return blazeRod;
	}
	
	public ItemStack getEmerald() {
		
		ItemStack emerald = new ItemStack(Material.EMERALD);
		ItemMeta meta = emerald.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Emerald");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "makes you a hero");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		emerald.setItemMeta(meta);
		
		return emerald;
	}
	
	public ItemStack getWitherRose() {
		
		ItemStack witherRose = new ItemStack(Material.WITHER_ROSE);
		ItemMeta meta = witherRose.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Wither Rose");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "cures you from wither");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		witherRose.setItemMeta(meta);
		
		return witherRose;
	}
	
	public ItemStack getCrystal() {
		
		ItemStack crystal = new ItemStack(Material.PRISMARINE_CRYSTALS);
		ItemMeta meta = crystal.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Prismarine Crystal");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "swim with grace");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		crystal.setItemMeta(meta);
		
		return crystal;
	}
public ItemStack getRabbitFoot() {
		
		ItemStack rabbitFoot = new ItemStack(Material.RABBIT_FOOT);
		ItemMeta meta = rabbitFoot.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Enchanted Rabbit Foot");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "jump higher than before");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		rabbitFoot.setItemMeta(meta);
		
		return rabbitFoot;
	}

public ItemStack getEnderDasher() {
	
	ItemStack enderDasher = new ItemStack(Material.ENDER_EYE);
	ItemMeta meta = enderDasher.getItemMeta();
	meta.setDisplayName(ChatColor.GOLD + "Ender Dasher");
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "right click to dash forward!");
	meta.setLore(lore);
	meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	meta.setUnbreakable(true);
	
	enderDasher.setItemMeta(meta);
	
	return enderDasher;
}

public ItemStack getTurtleEgg() {
	
	ItemStack turtleEgg = new ItemStack(Material.TURTLE_EGG);
	ItemMeta meta = turtleEgg.getItemMeta();
	meta.setDisplayName(ChatColor.GOLD + "Enchanted Turtle Egg");
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "no need to hold your breath");
	meta.setLore(lore);
	meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	meta.setUnbreakable(true);
	
	turtleEgg.setItemMeta(meta);
	
	return turtleEgg;
}
}

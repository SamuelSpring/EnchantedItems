package me.IAmSam.EnchantedItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Husk;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Turtle;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_16_R3.PacketPlayOutChat;

public class EventHandlers implements Listener {
	static Map<String, Long> cooldowns = new HashMap<String, Long>();
	static Map<String, Long> cooldownsNecroStick = new HashMap<String, Long>();
	static Map<String, Long> enderDashercooldown = new HashMap<String, Long>();
	static Map<String, Long> foxSpiritcooldown = new HashMap<String, Long>();
	int DROP_ITEM = 1;

	GetItemCommands itemget = new GetItemCommands();
	private Main main;

	public EventHandlers(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		// event.getPlayer().setResourcePack("https://www.dropbox.com/sh/ydstmyaqlav72n8/AAAf46H0P2ub713fe0W12-iqa?dl=1");
		// //direct download to resource pack
	}

	@EventHandler
	public void featherUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Feather")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 0));
		}

	}

	@EventHandler
	public void GlowstoneDustUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Glowstone Dust")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1200, 0));
		}

	}

	@EventHandler
	public void blazeRodUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Blaze Rod")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0));
		}

	}

	@EventHandler
	public void EmeraldUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Emerald")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {

			if (cooldowns.containsKey(p.getName())) {
				// player is in hashmap
				if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
					// they still have time left in cooldown
					long timeLeft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
					if (timeLeft < 60) {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft + " second(s)");
					} else {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft / 60 + " minutes");
					}
					return;
				}
			}
			cooldowns.put(p.getName(), System.currentTimeMillis() + (1800 * 1000));
			p.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 1200, 0));
		}

	}

	@EventHandler
	public void witherRoseUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Wither Rose")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.removePotionEffect(PotionEffectType.WITHER);
		}

	}
	@EventHandler
	public void bloodStaff3(ProjectileHitEvent e) {
		Projectile pr = e.getEntity();
		Entity mob = e.getHitEntity();
		Location destBlock = mob.getLocation();
	   final Player p = (Player) pr.getShooter();
	   if(pr.getCustomName().equals("blood")) {
		   List<Entity> nearbyEntites = (List<Entity>) destBlock.getWorld().getNearbyEntities(destBlock, 2, 2, 2);
		   destBlock.getWorld().spawnParticle(Particle.FLAME, destBlock, 100);
		   ArrayList<LivingEntity> le = new ArrayList(); 
		   le.add((LivingEntity) mob);
		   
		   for( Entity x : nearbyEntites )
					  {
			   if(x instanceof LivingEntity) { 
				   le.add((LivingEntity) x); 
				   } 
			   } for(LivingEntity x : le ) { 
				   x.damage(4); p.setHealth(p.getHealth() + 2); 
				   
				   }
	   }
	}
	
	@EventHandler
	public void bloodStaff(ProjectileHitEvent e) {
		Projectile pr = e.getEntity();
		Block block = e.getHitBlock();
		Location destBlock = block.getLocation();
	   final Player p = (Player) pr.getShooter();
	   if(pr.getCustomName().equals("blood")) {
		   List<Entity> nearbyEntites = (List<Entity>) destBlock.getWorld().getNearbyEntities(destBlock, 2, 2, 2);
		   destBlock.getWorld().spawnParticle(Particle.FLAME, destBlock, 100);
		   ArrayList<LivingEntity> le = new ArrayList(); 
		   
		   
		   for( Entity x : nearbyEntites )
					  {
			   if(x instanceof LivingEntity) { 
				   le.add((LivingEntity) x); 
				   } 
			   } for(LivingEntity x : le ) {
				   x.damage(4); 
				   if(p.getHealth() <= 18) {
				   p.setHealth(p.getHealth() + 2);
				   }
				   else if(p.getHealth() == 19){
						  p.setHealth(p.getHealth() + 1);
					  }
				   else {
					   p.setHealth(20);
				   }
			  
			   }
	   }
	}
	 @EventHandler public void staffClick(PlayerInteractEvent e) {
		 final Player p = e.getPlayer(); 
		 Action a = e.getAction(); 
		 Location loc = p.getLocation();
		 
		 if(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() ==
		    1234567 && (a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK) &&
			p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			 p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "You casted Blood Blitz"));
		   Snowball ball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
		   ball.setCustomName("blood");
		   ball.setCustomNameVisible(false);
           ball.setShooter(p);
           ball.setVelocity(p.getLocation().getDirection().multiply(50));
           
		 }
	 }
	
	
	  
	  @EventHandler public void staffClick2(PlayerInteractEvent e) { final Player p
	  = e.getPlayer(); Action a = e.getAction(); Location loc = p.getLocation();
	  
	  if ((a == Action.PHYSICAL) || (e.getItem() == null)) return;
	  if(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() ==
	  1234567 && (a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK) &&
	  p.getInventory().getItemInMainHand().getItemMeta().hasLore()) { 
		  p.getWorld().playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 3.0F, 0.5F);
		  Location
	  loc1= p.getEyeLocation(); Vector direction = loc1.getDirection().normalize();
	  for(int t = 0; t < 60; t++) { double x = direction.getX() * t; double y =
			 direction.getY() * t; double z = direction.getZ() * t; loc1.add(x,y,z);
	  p.getWorld().spawnParticle(Particle.HEART, loc1, 1);
	  p.getWorld().spawnParticle(Particle.CRIMSON_SPORE, loc1, 1);
	  p.getWorld().spawnParticle(Particle.SPELL, loc1, 1); loc1.subtract(x,y,z); }
	  p.getWorld().spawnParticle(Particle.CRIMSON_SPORE, loc, 10); 
	  Block block = p.getTargetBlockExact(50); 
	  Location destBlock = block.getLocation();
	  List<Entity> nearbyEntites = (List<Entity>)
	  destBlock.getWorld().getNearbyEntities(destBlock, 2, 2, 2);
	  ArrayList<LivingEntity> le = new ArrayList(); for( Entity x : nearbyEntites )
	  { if(x instanceof LivingEntity) { le.add((LivingEntity) x); } } for(
	  LivingEntity x : le ) { 
		  x.damage(2);    if(p.getHealth() <= 18) {
			   p.setHealth(p.getHealth() + 2);
			   }
		  else if(p.getHealth() == 19){
			  p.setHealth(p.getHealth() + 1);
		  }
			   else {
				   p.setHealth(20);
			   } }
	  
	  
	  
	  
	  
	  } }
	 
	 

	@EventHandler
	public void spiderEyeUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Spider Eye")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.removePotionEffect(PotionEffectType.POISON);
		}

	}

	@EventHandler
	public void crystalUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Prismarine Crystal")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 200, 0));
		}

	}

	@EventHandler
	public void rabbitFootUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Rabbit Foot")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 2));
		}

	}

	@EventHandler
	public void honeyCombUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Honeycomb")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.setFoodLevel(p.getFoodLevel() + 2);
		}

	}

	@EventHandler
	public void netherStarUsed(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Seed of Corruption")
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.launchProjectile(WitherSkull.class);
		}

	}

	@EventHandler
	public void mobDeath(EntityDeathEvent event) {
		Random rand = new Random();
		int eFeatherDropRate = Integer.parseInt(main.getConfig().getString("dropRate.CHICKEN"));
		int eBlazeRodDropRate = Integer.parseInt(main.getConfig().getString("dropRate.BLAZE"));
		int eGlowStoneDropRate = Integer.parseInt(main.getConfig().getString("dropRate.HUSK"));
		int eEmeraldDropRate = Integer.parseInt(main.getConfig().getString("dropRate.PILLAGER"));
		int eCrystalDropRate = Integer.parseInt(main.getConfig().getString("dropRate.GUARDIAN"));
		int eWitherRoseDropRate = Integer.parseInt(main.getConfig().getString("dropRate.WITHER_SKELETON"));
		int eSpiderEyeDropRate = Integer.parseInt(main.getConfig().getString("dropRate.SPIDER"));
		int eRabbitFootDropRate = Integer.parseInt(main.getConfig().getString("dropRate.RABBIT"));
		int eHoneyCombDropRate = Integer.parseInt(main.getConfig().getString("dropRate.BEE"));
		int enderDasherDropRate = Integer.parseInt(main.getConfig().getString("dropRate.ENDERMAN"));
		int foxSpiritDropRate = Integer.parseInt(main.getConfig().getString("dropRate.FOX"));
		LivingEntity entity = event.getEntity();
		if (entity instanceof Chicken) {

			int int_random = rand.nextInt(eFeatherDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(), new ItemStack(itemget.getFeather()));
			}
		} else if (entity instanceof Blaze) {
			int int_random = rand.nextInt(eBlazeRodDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(), new ItemStack(itemget.getBlazeRod()));
			}
		}
		if (entity instanceof Husk) {

			int int_random = rand.nextInt(eGlowStoneDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getGlowstoneDust()));
			}
		} else if (entity instanceof Pillager) {
			int int_random = rand.nextInt(eEmeraldDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(), new ItemStack(itemget.getEmerald()));
			}
		} else if (entity instanceof Guardian) {
			int int_random = rand.nextInt(eCrystalDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(), new ItemStack(itemget.getCrystal()));
			}
		} else if (entity instanceof WitherSkeleton) {
			int int_random = rand.nextInt(eWitherRoseDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getWitherRose()));
			}
		} else if (entity instanceof Spider) {
			int int_random = rand.nextInt(eSpiderEyeDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getSpiderEye()));
			}

		} else if (entity instanceof Rabbit) {
			int int_random = rand.nextInt(eRabbitFootDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getRabbitFoot()));
			}

		} else if (entity instanceof Bee) {
			int int_random = rand.nextInt(eHoneyCombDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getHoneyComb()));
			}
		} else if (entity instanceof Enderman) {
			int int_random = rand.nextInt(enderDasherDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getEnderDasher()));
			}
		} else if (entity instanceof Fox) {
			int int_random = rand.nextInt(foxSpiritDropRate);
			if (int_random == DROP_ITEM) {
				entity.getEyeLocation().getWorld().dropItem(entity.getLocation(),
						new ItemStack(itemget.getFoxSpirit()));
			}
		}

	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		Projectile ws = e.getEntity();
		LivingEntity x = (LivingEntity) e.getHitEntity();
		Player p = (Player) ws.getShooter();
		World w = p.getWorld();

		if (e.getEntity() instanceof WitherSkull && ws.getShooter() instanceof Player) {
			x.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 0));

		}
	}

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent event) {
		Projectile ws = (Projectile) event.getEntity();

		if (event.getEntity() instanceof WitherSkull && ws.getShooter() instanceof Player) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void necroStick(EntityDamageByEntityEvent event) {
		Player p = (Player) event.getDamager();
		LivingEntity x = (LivingEntity) event.getEntity();
		if (event.getDamager() instanceof Player) {
			if (p.getItemInHand().getItemMeta().hasLore()
					&& p.getItemInHand().getItemMeta().getDisplayName().contains("Healing Wand")) {

				if (cooldownsNecroStick.containsKey(p.getName())) {
					// player is in hashmap
					if (cooldownsNecroStick.get(p.getName()) > System.currentTimeMillis()) {
						// they still have time left in cooldown
						long timeLeft = (cooldownsNecroStick.get(p.getName()) - System.currentTimeMillis()) / 1000;
						if (timeLeft < 60) {
							p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft + " second(s)");
						} else {
							p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft / 60 + " minutes");
						}
						return;
					}
				}

				x.getWorld().spawnParticle(Particle.HEART, x.getLocation().getX() + 1, x.getLocation().getY() + 0,
						x.getLocation().getZ() + 0, 5);

				x.getWorld().spawnParticle(Particle.HEART, x.getLocation().getX() + 0, x.getLocation().getY() + 1,
						x.getLocation().getZ() + 0, 5);

				x.getWorld().spawnParticle(Particle.HEART, x.getLocation().getX() + 0, x.getLocation().getY() + 0,
						x.getLocation().getZ() + 1, 5);
				x.getWorld().spawnParticle(Particle.HEART, x.getLocation().getX() + 1, x.getLocation().getY() + 0,
						x.getLocation().getZ() + 1, 5);

				x.sendMessage(ChatColor.GREEN + "You have been healed!");
				p.sendMessage(ChatColor.GREEN + "You casted a healing spell!");
				cooldownsNecroStick.put(p.getName(), System.currentTimeMillis() + (10 * 1000));
				x.setHealth(x.getHealth() + 6);

			}
		}
	}

	@EventHandler
	public void noPlaceBlock(BlockPlaceEvent e) {
		Player p = (Player) e.getPlayer();
		if (e.getHand() == EquipmentSlot.OFF_HAND)
			return;
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Wither Rose")
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			e.setCancelled(true);
		}
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Turtle Egg")
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void noPlaceBlockOffHand(BlockPlaceEvent e) {
		Player p = (Player) e.getPlayer();
		if (e.getHand() == EquipmentSlot.HAND)
			return;
		if (p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().contains("Enchanted Wither Rose")
				&& p.getInventory().getItemInOffHand().getItemMeta().hasLore()) {
			e.setCancelled(true);
		}
		if (p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().contains("Enchanted Turtle Egg")
				&& p.getInventory().getItemInOffHand().getItemMeta().hasLore()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void enderDasher(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (e.getHand() == EquipmentSlot.OFF_HAND)
			return;
		if ((p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Ender Dasher"))
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			e.setCancelled(true);
			if (enderDashercooldown.containsKey(p.getName())) {
				// player is in hashmap
				if (enderDashercooldown.get(p.getName()) > System.currentTimeMillis()) {
					// they still have time left in cooldown
					long timeLeft = (enderDashercooldown.get(p.getName()) - System.currentTimeMillis()) / 1000;
					if (timeLeft < 60) {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft + " second(s)");
					} else {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft / 60 + " minutes");
					}
					return;
				}
			}
			enderDashercooldown.put(p.getName(), System.currentTimeMillis() + (3 * 1000));
			p.setVelocity(p.getLocation().getDirection().multiply(2));
			enderDasherParticles(p, Particle.CLOUD);
		}

	}

	@EventHandler
	public void turtleEgg(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;

		if ((p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Enchanted Turtle Egg"))
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1200, 0));
		}

	}

	@EventHandler
	public void enderDasherOffHand(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (e.getHand() == EquipmentSlot.HAND)
			return;
		if ((p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().contains("Ender Dasher"))
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInOffHand().getItemMeta().hasLore()) {
			e.setCancelled(true);
			if (enderDashercooldown.containsKey(p.getName())) {
				// player is in hashmap
				if (enderDashercooldown.get(p.getName()) > System.currentTimeMillis()) {
					// they still have time left in cooldown
					long timeLeft = (enderDashercooldown.get(p.getName()) - System.currentTimeMillis()) / 1000;
					if (timeLeft < 60) {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft + " second(s)");
					} else {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft / 60 + " minutes");
					}
					return;
				}
			}
			enderDashercooldown.put(p.getName(), System.currentTimeMillis() + (3 * 1000));
			p.setVelocity(p.getLocation().getDirection().multiply(2));
			enderDasherParticles(p, Particle.CLOUD);
		}

	}

	@EventHandler
	public void SpiritOfTheFox(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if ((a == Action.PHYSICAL) || (e.getItem() == null))
			return;
		if (e.getHand() == EquipmentSlot.OFF_HAND)
			return;
		if ((p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Spirit of the Fox"))
				&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			if (foxSpiritcooldown.containsKey(p.getName())) {
				// player is in hashmap
				if (foxSpiritcooldown.get(p.getName()) > System.currentTimeMillis()) {
					// they still have time left in cooldown
					long timeLeft = (foxSpiritcooldown.get(p.getName()) - System.currentTimeMillis()) / 1000;
					if (timeLeft < 60) {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft + " second(s)");
					} else {
						p.sendMessage(ChatColor.RED + "Ability will be ready in " + timeLeft / 60 + " minutes");
					}
					return;
				}
			}
			foxSpiritcooldown.put(p.getName(), System.currentTimeMillis() + (180 * 1000));
			p.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "THE ANCIENT SPIRIT COURSES THROUGH YOUR VEINS");
			p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "YOU SEE ALL," + ChatColor.RED + " NOW HUNT");

			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
			enderDasherParticles(p, Particle.VILLAGER_ANGRY);
			p.getWorld().playSound(p.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 3.0F, 0.5F);
			ArrayList<LivingEntity> nearby = getNearbyPlayers(p);
			for (LivingEntity en : nearby) {
				en.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 400, 0));
			}
		}

	}

	@EventHandler
	public void TurtleEggDrop(EntityChangeBlockEvent e) {
		Random rand = new Random();
		int turtleEggDropRate = Integer.parseInt(main.getConfig().getString("dropRate.TURTLE"));
		if (!(e.getEntity() instanceof Player)) {
			if (e.getTo() == Material.TURTLE_EGG) {
				int int_random = rand.nextInt(turtleEggDropRate);
				if (int_random == DROP_ITEM) {
					e.getEntity().getWorld().dropItemNaturally(e.getBlock().getLocation(), itemget.getTurtleEgg());
				}

			}
		}

	}

	public void enderDasherParticles(Player p, Particle par) {
		p.getWorld().spawnParticle(par, p.getLocation().getX() + 1, p.getLocation().getY() + 0,
				p.getLocation().getZ() + 0, 5);

		p.getWorld().spawnParticle(par, p.getLocation().getX() + 0, p.getLocation().getY() + 1,
				p.getLocation().getZ() + 0, 5);

		p.getWorld().spawnParticle(par, p.getLocation().getX() + 0, p.getLocation().getY() + 0,
				p.getLocation().getZ() + 1, 5);
		p.getWorld().spawnParticle(par, p.getLocation().getX() + 1, p.getLocation().getY() + 0,
				p.getLocation().getZ() + 1, 5);
	}

	public ArrayList<LivingEntity> getNearbyPlayers(Player pl) {
		ArrayList<LivingEntity> nearby = new ArrayList<LivingEntity>();
		double range = 30;
		for (Entity e : pl.getNearbyEntities(range, range, range)) {
			if (e instanceof LivingEntity) {
				nearby.add((LivingEntity) e);
			}
		}
		return nearby;
	}

	public static void removeCooldowns(String playerName) {

		cooldowns.remove(playerName);
		cooldowns.remove(playerName);
		enderDashercooldown.remove(playerName);
		foxSpiritcooldown.remove(playerName);

	}
	
	
	
	
	
}

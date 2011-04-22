package net.craftrepo.WeatherControl;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import org.bukkit.Location;
import org.bukkit.World;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class weathercontrol extends JavaPlugin
{	
	private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
	public HashMap<String, Integer> items = new HashMap<String, Integer>();
	private final Logger log = Logger.getLogger("Minecraft");
	public static PermissionHandler Permissions = null;
	public static String logPrefix = "[CraftBird]";
	public weathercontrol plugin;
	public static Configuration config;
	public static String id = null;

	public void onEnable() 
	{
		setupPermissions();
		log.info(logPrefix + " version " + this.getDescription().getVersion() + " enabled!");
	}

	public void onDisable() 
	{
		log.info(logPrefix + " version " + this.getDescription().getVersion() + " disabled!");
	}

	public boolean isDebugging(final Player player) 
	{
		if (debugees.containsKey(player)) 
			return debugees.get(player);
		return false;
	}

	public void setDebugging(final Player player, final boolean value) 
	{
		debugees.put(player, value);
	}

	public void notifyPlayers(String message) 
	{
		for (Player p: getServer().getOnlinePlayers()) 
		{ 
			p.sendMessage(message);
		}
	}

	public void setupPermissions() 
	{
		Plugin perms = this.getServer().getPluginManager().getPlugin("Permissions");
		PluginDescriptionFile pdfFile = this.getDescription();

		if (weathercontrol.Permissions == null) 
		{
			if (perms != null) 
			{
				this.getServer().getPluginManager().enablePlugin(perms);
				weathercontrol.Permissions = ((Permissions) perms).getHandler();
				log.info(logPrefix + " version " + pdfFile.getVersion() + " Permissions detected...");
			}
			else 
			{
				log.severe(logPrefix + " version " + pdfFile.getVersion() + " not enabled. Permissions not detected.");
				this.getServer().getPluginManager().disablePlugin(this);
			}
		}
	}

	public static String strip(String s) 
	{
		String good = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String result = "";
		for ( int i = 0; i < s.length(); i++ ) 
		{
			if ( good.indexOf(s.charAt(i)) >= 0 )
				result += s.charAt(i);
		}
		return result;
	}

	public boolean onCommand(CommandSender sender, Command commandArg, String commandLabel, String[] arg) 
	{
		Player player = (Player) sender;
		String command = commandArg.getName().toLowerCase();
		Player target;
		//strike a player with lightning.
		if (command.equalsIgnoreCase("lightningstrike")) 
		{
			if (player.isOp() || weathercontrol.Permissions.has(player, "weathercontrol.lightning.lightningstrike"))
			{
				World world = player.getWorld();
				Block targetBlock = player.getTargetBlock(null, 20);
				if (targetBlock!=null){
					Location strikeloc = targetBlock.getLocation();
					world.strikeLightning(strikeloc);
				}else
				{
					player.sendMessage("No block in sight");
				}
			}
			else 
			{
				player.sendMessage("You don't have access to this command.");
				log.info(logPrefix + " - " + player.getDisplayName() + " tried to use command " + command + "! Denied access." );
			}
			return true;
		}else if (command.equalsIgnoreCase("strikeplayer")) 
		{
			if (player.isOp() || weathercontrol.Permissions.has(player, "weathercontrol.lightning.strikeplayer"))
			{
				if (arg.length <= 1)
				{
					if (arg[0] != null)
					{
						target = getServer().getPlayer(arg[0]);
						World world = target.getWorld();
						world.strikeLightning(target.getLocation());
					}
					else
					{
						player.getWorld().strikeLightning(player.getLocation());
					}
				}
				else
				{
					player.sendMessage("Correct usage is /lightning {player}");
				}
			}
			else 
			{
				player.sendMessage("You don't have access to this command.");
				log.info(logPrefix + " - " + player.getDisplayName() + " tried to use command " + command + "! Denied access." );
			}
			return true;
		}
		//start a lightning storm
		else if (command.equalsIgnoreCase("startlightningstorm"))
		{
			if (player.isOp() || weathercontrol.Permissions.has(player, "weathercontrol.lightningstorm"))
			{
				if (arg.length == 1)
				{
					World world = player.getWorld();
					world.setStorm(true);
					world.setThundering(true);
					world.setThunderDuration(Integer.parseInt(arg[0])/50);
					world.setWeatherDuration(Integer.parseInt(arg[0])/50);
				}
				else
				{
					player.sendMessage("Correct usage is /startstorm [length]");
				}
			}
			else
			{
				player.sendMessage("You don't have access to this command.");
				log.info(logPrefix + " - " + player.getDisplayName() + " tried to use command " + command + "! Denied access." );
			}
		}
		//start a rain/snow storm
		else if (command.equalsIgnoreCase("startrain"))
		{
			if (player.isOp() || weathercontrol.Permissions.has(player, "weathercontrol.rainstorm"))
			{
				if (arg.length == 1)
				{
					World world = player.getWorld();
					world.setStorm(true);
					world.setThundering(false);
					world.setWeatherDuration(Integer.parseInt(arg[0])/50);
				}
				else
				{
					player.sendMessage("Correct usage is /startstorm [length]");
				}
			}
			else
			{
				player.sendMessage("You don't have access to this command.");
				log.info(logPrefix + " - " + player.getDisplayName() + " tried to use command " + command + "! Denied access." );
			}
		}
		else if (command.equalsIgnoreCase("strikecreepers"))
		{
			if (player.isOp() || weathercontrol.Permissions.has(player, "weathercontrol.lightning.strikecreeper"))
			{
				if (arg.length == 1)
				{
					double round = 2 * Integer.parseInt(arg[0]);
					List<Entity> entities = player.getNearbyEntities(round, round, round);
					for (Entity e : entities)
					{
						if (e instanceof Creeper)
						{
							World world = e.getWorld();
							world.strikeLightning(e.getLocation());
						}
					}
				}
				else
				{
					player.sendMessage("Correct usage is /strikecreepers [radius]");
				}
			}
		}
		else if (command.equalsIgnoreCase("strikepig"))
		{
			if (player.isOp() || weathercontrol.Permissions.has(player, "weathercontrol.lightning.strikepig"))
			{
				if (arg.length == 1)
				{
					double round = 2 * Integer.parseInt(arg[0]);
					List<Entity> entities = player.getNearbyEntities(round, round, round);
					for (Entity e : entities)
					{
						if (e instanceof Pig)
						{
							World world = e.getWorld();
							world.strikeLightning(e.getLocation());
						}
					}
				}
				else
				{
					player.sendMessage("Correct usage is /strikecreepers [radius]");
				}
			}
		}
		return true;
	}
}

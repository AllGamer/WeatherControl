package net.craftrepo.WeatherControl;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

/**
 * CraftRepo Bans for Bukkit
 * @author AllGamer
 * 
 * Copyright 2011 AllGamer, LLC.
 * See LICENSE for licensing information.
 */

public class weathercontrolPlayerListener extends PlayerListener 
{
	@SuppressWarnings("unused")
	private final weathercontrol plugin;
	private final Logger log = Logger.getLogger("Minecraft");

	public weathercontrolPlayerListener(weathercontrol instance) 
	{
		plugin = instance;
	}

	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Action action = event.getAction();
		if(action == Action.RIGHT_CLICK_BLOCK)
		{
			int pickid = 278;
			ItemStack pick = new ItemStack(pickid);
			if(event.getItem() == pick)
			{
				lightningweapon user = (lightningweapon)event.getPlayer();
				if (user.getWeapon())
				{
					Location strikeloc = event.getClickedBlock().getLocation();
					user.getWorld().strikeLightning(strikeloc);
				}
			}
		}
	}
}


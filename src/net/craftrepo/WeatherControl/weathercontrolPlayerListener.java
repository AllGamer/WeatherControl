package net.craftrepo.WeatherControl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

/**
 * CraftRepo Bans for Bukkit
 * @author AllGamer
 * 
 * Copyright 2011 AllGamer, LLC.
 * See LICENSE for licensing information.
 */

public class weathercontrolPlayerListener extends PlayerListener 
{
	private final weathercontrol plugin;
	//private final Logger log = Logger.getLogger("Minecraft");

	public weathercontrolPlayerListener(weathercontrol instance) 
	{
		plugin = instance;
	}
	
	@Override
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		//if(!event.isCancelled())
		{
			Action action = event.getAction();
			if(action == Action.RIGHT_CLICK_AIR||action == Action.RIGHT_CLICK_BLOCK)
			{
				int pickid = 278;
				if(event.getItem()!=null)
					if(event.getItem().getTypeId()==pickid)
					{
						if (plugin.lightningpick.containsKey(event.getPlayer()))
						{
							Block targetBlock = event.getPlayer().getTargetBlock(null, 35);
							if (targetBlock!=null)
							{
								Location strikeloc = targetBlock.getLocation();
								strikeloc.setY(strikeloc.getBlockY()+1);
								plugin.lightning.add(strikeloc);
								event.getPlayer().getWorld().strikeLightning(strikeloc);
							}
							else
							{
								event.getPlayer().sendMessage("No block in sight");
							}
						}
					}
			}
		}
		super.onPlayerInteract(event);
	}
}


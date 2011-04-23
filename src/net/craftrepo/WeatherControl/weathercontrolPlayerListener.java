package net.craftrepo.WeatherControl;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
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
	@SuppressWarnings("unused")
	private final weathercontrol plugin;
	private final Logger log = Logger.getLogger("Minecraft");

	public weathercontrolPlayerListener(weathercontrol instance) 
	{
		plugin = instance;
	}

	//Add rightclick event here

}


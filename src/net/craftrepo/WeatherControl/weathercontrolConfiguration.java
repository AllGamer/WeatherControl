package net.craftrepo.WeatherControl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;

/**
 * CraftRepo weathercontrol for Bukkit
 * @author AllGamer
 * 
 * Copyright 2011 AllGamer, LLC.
 * See LICENSE for licensing information.
 */

public class weathercontrolConfiguration 
{

	private weathercontrol plugin;
	private File folder;
	private final Logger log = Logger.getLogger("Minecraft");
	private String logPrefix;

	public weathercontrolConfiguration(File folder, weathercontrol instance) 
	{
		this.folder = folder;
		this.plugin = instance;
		this.logPrefix = weathercontrol.logPrefix;
	}

	public void setupConfigs() 
	{
		File config = new File(this.folder, "config.yml");
		if (!config.exists()) 
		{
			try 
				{
					log.info(logPrefix + " - Creating config directory... ");
					log.info(logPrefix + " - Creating config files... ");
					config.createNewFile();
					FileWriter fstream = new FileWriter(config);
					BufferedWriter out = new BufferedWriter(fstream);

					out.write("#WeatherControl Configuration\n");
					out.write("#Fill this in with lines for the default config file. Make sure to add the newline...\n");
					out.write("BlockWeight:\n");
					out.write(" - 42 3\n");
					out.write(" - 66 1\n");
					out.write(" - 27 2\n");
					out.write(" - 41 2\n");
					out.write("\n");
					out.write("#This is the id for the lightnignpick wand. It defaults to 278 (diamond pick). It will fall to default if blank.\n");
					out.write("#Set this to the id you want to use.\n");
					out.write("WandID: 278\n");
					out.close();
					fstream.close();
					log.info(logPrefix + " Make sure to edit your config file!");
				
				}
			catch (IOException ex) 
				{
					log.severe(logPrefix + " Error creating default Configuration File");
					log.severe(logPrefix + " " + ex);
					this.plugin.getServer().getPluginManager().disablePlugin((Plugin) this);
				}
		}
		
	}
}


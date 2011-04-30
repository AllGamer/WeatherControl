package net.craftrepo.WeatherControl;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class weathercontrolEntityDamage extends EntityListener {
	private static weathercontrol plugin;
	public weathercontrolEntityDamage(weathercontrol weathercontrol) {
		plugin=weathercontrol;
	}
	@Override
	public void onEntityDamage(EntityDamageEvent event) {
		if(!event.isCancelled())
		{
			if(event.getCause().equals(DamageCause.LIGHTNING)&&(event.getEntity() instanceof Player))
				if(((Player)event.getEntity()).isOp() || weathercontrol.Permissions.has(((Player)event.getEntity()), "weathercontrol.nodamage"))
					event.setCancelled(true);
		}
		super.onEntityDamage(event);
	}

}

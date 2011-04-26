package net.craftrepo.WeatherControl;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Achievement;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Vehicle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

public class lightningweapon implements Player
{
boolean state = false;

public void setWeapon(boolean toggle)
{
state = toggle;
}

public boolean getWeapon()
{
return state;
}


public void awardAchievement(Achievement arg0)
{
}


public void chat(String arg0)
{
}


public InetSocketAddress getAddress()
{
return null;
}


public Location getCompassTarget()
{
return null;
}


public String getDisplayName()
{
return null;
}


public void incrementStatistic(Statistic arg0)
{
}


public void incrementStatistic(Statistic arg0, int arg1)
{
}


public void incrementStatistic(Statistic arg0, Material arg1)
{
}


public void incrementStatistic(Statistic arg0, Material arg1, int arg2)
{
}


public boolean isOnline()
{
return false;
}


public boolean isSleepingIgnored()
{
return false;
}


public boolean isSneaking()
{
return false;
}


public void kickPlayer(String arg0)
{
}


public void loadData()
{
}


public boolean performCommand(String arg0)
{
return false;
}


public void saveData()
{
}


public void sendRawMessage(String arg0)
{
}


public void setCompassTarget(Location arg0)
{
}


public void setDisplayName(String arg0)
{
}


public void setSleepingIgnored(boolean arg0)
{
}


public void setSneaking(boolean arg0)
{
}


public void updateInventory()
{
}


public PlayerInventory getInventory() {

return null;
}


public ItemStack getItemInHand()
{
return null;
}


public String getName()
{
return null;
}


public int getSleepTicks()
{
return 0;
}


public boolean isSleeping()
{
return false;
}


public void setItemInHand(ItemStack arg0)
{
}


public void damage(int arg0)
{
}


public void damage(int arg0, Entity arg1)
{
}


public double getEyeHeight()
{
return 0;
}


public double getEyeHeight(boolean arg0)
{
return 0;
}


public Location getEyeLocation()
{
return null;
}


public int getHealth()
{
return 0;
}


public int getLastDamage()
{
return 0;
}


public List<Block> getLastTwoTargetBlocks(HashSet<Byte> arg0, int arg1)
{
return null;
}


public List<Block> getLineOfSight(HashSet<Byte> arg0, int arg1)
{
return null;
}


public int getMaximumAir()
{
return 0;
}


public int getMaximumNoDamageTicks()
{
return 0;
}


public int getNoDamageTicks()
{
return 0;
}


public int getRemainingAir()
{
return 0;
}


public Block getTargetBlock(HashSet<Byte> arg0, int arg1)
{
return null;
}


public Vehicle getVehicle()
{
return null;
}


public boolean isInsideVehicle()
{
return false;
}


public boolean leaveVehicle()
{
return false;
}


public void setHealth(int arg0)
{
}

public void setLastDamage(int arg0)
{
}

public void setMaximumAir(int arg0)
{
}

public void setMaximumNoDamageTicks(int arg0)
{
}

public void setNoDamageTicks(int arg0)
{
}

public void setRemainingAir(int arg0)
{
}

public Arrow shootArrow()
{
return null;
}

public Egg throwEgg()
{
return null;
}

public Snowball throwSnowball()
{
return null;
}

public boolean isOp()
{
return false;
}

public void sendMessage(String arg0)
{
}

public boolean eject()
{
return false;
}

public int getEntityId()
{
return 0;
}

public float getFallDistance()
{
return 0;
}

public int getFireTicks()
{
return 0;
}

public Location getLocation()
{
return null;
}

public int getMaxFireTicks()
{
return 0;
}

public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2)
{
return null;
}

public Entity getPassenger()
{
return null;
}

public Server getServer()
{
return null;
}

public Vector getVelocity()
{
return null;
}

public World getWorld()
{
return null;
}

public boolean isDead()
{
return false;
}

public boolean isEmpty()
{
return false;
}

public void remove()
{
}

public void setFallDistance(float arg0)
{
}

public void setFireTicks(int arg0)
{
}

public boolean setPassenger(Entity arg0)
{
return false;
}

public void setVelocity(Vector arg0)
{
}

public boolean teleport(Location arg0)
{
return false;
}

public boolean teleport(Entity arg0)
{
return false;
}


public void teleportTo(Location arg0)
{
}

public void teleportTo(Entity arg0)
{
}
}
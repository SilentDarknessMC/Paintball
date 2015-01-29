package me.SDMC.SDMCFireworkPlugin;

import java.util.logging.Logger;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		saveDefaultConfig();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " ----------------"
				+ "Has Been Enabled! Welcome To Our Awesome Custom Plugin!"
				+ "----------------");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			if(cmd.getLabel().equalsIgnoreCase("shoot"))
			{
				Player player = (Player) sender;
				
				if(player.hasPermission("firework.star"))
				{
					Firework firework = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
					
					FireworkMeta meta = firework.getFireworkMeta();
					
					FireworkEffect effect = FireworkEffect.builder()
							.flicker(true)
							.withColor(Color.MAROON)
							.withFade(Color.BLUE)
							.with(Type.STAR)
							.trail(true)
							.build();
					
					meta.addEffect(effect);
					meta.setPower(2);
					
					firework.setFireworkMeta(meta);
				}
				
				if(player.hasPermission("firework.creeper"))
				{
					Firework firework = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
					
					FireworkMeta meta = firework.getFireworkMeta();
					
					FireworkEffect effect = FireworkEffect.builder()
							.flicker(true)
							.withColor(Color.RED)
							.withFade(Color.GREEN)
							.with(Type.CREEPER)
							.trail(true)
							.build();
					
					meta.addEffect(effect);
					meta.setPower(2);
					
					firework.setFireworkMeta(meta);
				}
				
				if(player.hasPermission("firework.none"))
				{
					player.sendMessage(ChatColor.YELLOW + "Please Buy VIP To Use This Feature!");
				}
			}
		}
		
		return false;
	}
}
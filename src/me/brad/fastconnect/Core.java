package me.brad.fastconnect;
import net.md_5.bungee.PacketConstants;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.protocol.packet.Respawn;
public class Core extends Plugin {
	private static Core instance;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		try {
			instance = this;
			CommandSender console = getProxy().getConsole();
			getProxy().getPluginManager().registerCommand(this, new FastConnectCommand());
			console.sendMessage("");
			console.sendMessage(ChatColor.GREEN + "    -=[FastConnect]=- ");
			console.sendMessage("");
			console.sendMessage(ChatColor.RED + "Version: " + Core.getInstnace().getDescription().getVersion());
			console.sendMessage(ChatColor.RED + "By " + Core.getInstnace().getDescription().getAuthor());
			console.sendMessage("");
			ReflectionUtil.setObject(PacketConstants.class, null, "DIM1_SWITCH",
					new Respawn(0, (short) 0, (short) 0, (short) 0, "default"));
			ReflectionUtil.setObject(PacketConstants.class, null, "DIM2_SWITCH",
					new Respawn(0, (short) 0, (short) 0, (short) 0, "default"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onDisable() {
		try {
			ReflectionUtil.setObject(PacketConstants.class, null, "DIM1_SWITCH",
					new Respawn(1, (short) 0, (short) 0, (short) 0, "default"));
			ReflectionUtil.setObject(PacketConstants.class, null, "DIM2_SWITCH",
					new Respawn(-1, (short) 0, (short) 0, (short) 0, "default"));
		} catch (Exception e) {
		}
	}
	public static Core getInstnace() {
		return instance;
	}
}
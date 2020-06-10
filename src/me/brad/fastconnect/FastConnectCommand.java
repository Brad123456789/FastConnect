package me.brad.fastconnect;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
public class FastConnectCommand extends Command {
	public FastConnectCommand() {
		super("fastconnect");
	}
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.DARK_GRAY + "FastConnect version " + Core.getInstnace().getDescription().getVersion() + " By Brad");
	}
}
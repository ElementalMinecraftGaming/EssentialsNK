package cn.yescallop.essentialsnk.command.defaults.warp;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.level.Location;
import cn.nukkit.utils.TextFormat;
import cn.yescallop.essentialsnk.EssentialsAPI;
import cn.yescallop.essentialsnk.Language;
import cn.yescallop.essentialsnk.command.CommandBase;

public class WarpListCommand extends CommandBase {

    public WarpListCommand(EssentialsAPI api) {
        super("warplist", api);
         commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[] {
                new CommandParameter("warplist", CommandParamType.STRING, true),
        });
    }
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!sender.hasPermission("essentialsnk.warplist")) {
            sender.sendMessage(TextFormat.RED + Language.translate("Missing warp list perms"));
            return false;
        } 
        if (args.length > 0) {
            this.sendUsage(sender);
            return false;
        }
        if (args.length == 0) {
            String[] list = api.getWarpsList();
            if (list.length == 0) {
                sender.sendMessage(TextFormat.RED + Language.translate("commands.warp.nowarp"));
                return false;
            }
            sender.sendMessage(Language.translate("commands.warp.list") + "\n" + String.join(", ", list));
            return true;
        }
        return true;
    }
}

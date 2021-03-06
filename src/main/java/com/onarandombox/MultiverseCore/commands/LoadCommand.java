/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

public class LoadCommand extends MultiverseCommand {

    public LoadCommand(MultiverseCore plugin) {
        super(plugin);
        this.setName("Load World");
        this.setCommandUsage("/mv load" + ChatColor.GREEN + " {WORLD}");
        this.setArgRange(1, 1);
        this.addKey("mvload");
        this.addKey("mv load");
        this.setPermission("multiverse.core.load", "Loads a world into Multiverse.", PermissionDefault.OP);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (this.plugin.getMVWorldManager().loadWorld(args.get(0))) {
            sender.sendMessage("World Loaded!");
        } else {
            sender.sendMessage("Error trying to load world!");
        }
    }
}

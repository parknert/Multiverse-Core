/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.destination;

import com.onarandombox.MultiverseCore.api.MVDestination;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class PlayerDestination implements MVDestination {
    String player;
    private boolean isValid;
    private JavaPlugin plugin;

    @Override
    public String getIdentifier() {
        return "pl";
    }

    @Override
    public boolean isThisType(JavaPlugin plugin, String destination) {
        String[] items = destination.split(":");
        if (items.length != 2) {
            return false;
        }
        if (!items[0].equalsIgnoreCase("pl")) {
            return false;
        }
        return true;
    }

    @Override
    public Location getLocation(Entity e) {
        Player p = plugin.getServer().getPlayer(this.player);
        Player plLoc = null;
        if (e instanceof Player) {
            plLoc = (Player) e;
        } else if (e.getPassenger() instanceof Player) {
            plLoc = (Player) e.getPassenger();
        }

        if (p != null && plLoc != null && !plLoc.getName().equalsIgnoreCase(p.getName())) {
            return p.getLocation();
        }
        return null;
    }

    @Override
    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public void setDestination(JavaPlugin plugin, String destination) {
        String[] items = destination.split(":");
        if (items.length != 2) {
            this.isValid = false;
        }
        if (!items[0].equalsIgnoreCase("pl")) {
            this.isValid = false;
        }
        this.isValid = true;
        this.player = items[1];
        this.plugin = plugin;
    }

    @Override
    public String getType() {
        return "Player";
    }

    @Override
    public String getName() {
        return this.player;
    }

    @Override
    public String toString() {
        return "pl:" + this.player;
    }

    @Override
    public String getRequiredPermission() {
        return "";
    }
    public Vector getVelocity() {
        return new Vector(0,0,0);
    }

    @Override
    public boolean useSafeTeleporter() {
        return true;
    }

}

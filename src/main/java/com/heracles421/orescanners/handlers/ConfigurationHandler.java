/***************************************************************************************************
 * Heracles Ore Scanners - Find your GT ores
 *
 * Copyright (C) 2017 Heracles421 (Ian Ramírez España)
 * This file is part of Heracles Ore Scanners
 *
 * Heracles Ore Scanners is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************************************/

package com.heracles421.orescanners.handlers;

import com.heracles421.orescanners.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Heracles421 on 10-Jul-17.
 */
public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean updateCheck = true;
    public static final String CATEGORY_UPDATE = "update_check";

    public static void initConfiguration(String configDir){
        if (configuration == null){
            File path = new File(configDir + "/" + Reference.MOD_ID + ".cfg");
            configuration = new Configuration(path);

            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        updateCheck = configuration.getBoolean("Check For Updates", CATEGORY_UPDATE, true, "Allow this mod to check for updates");
        if(configuration.hasChanged()){
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent e){
        if (e.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }
    }

    public static Configuration getConfiguration(){
        return configuration;
    }
}

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

package com.heracles421.orescanners;

/**
 * Created by Heracles421 on 10-Jul-17.
 */

import com.heracles421.orescanners.handlers.ConfigurationHandler;
import com.heracles421.orescanners.proxy.IProxy;
import com.heracles421.orescanners.reference.Reference;
import com.heracles421.orescanners.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        dependencies = Reference.MOD_DEPENDENCIES,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        canBeDeactivated = true,
        guiFactory = Reference.GUI_FACTORY)

public class HeraclesOreScanners {

    @Mod.Instance(Reference.MOD_ID)
    public static HeraclesOreScanners instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e){
        ConfigurationHandler.initConfiguration(e.getModConfigurationDirectory().toString());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre-Init complete, initiate countdown.");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e){
        LogHelper.info("Init complete, we have liftoff!");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e){
        LogHelper.info("Post-Init complete, we've reached orbit.");
    }
}

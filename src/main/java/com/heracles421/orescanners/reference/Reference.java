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

package com.heracles421.orescanners.reference;

/**
 * Created by Heracles421 on 10-Jul-17.
 */
public class Reference {
    public static final String MOD_ID = "HeraclesOreScanners";
    public static final String MOD_NAME = "Heracles Ore Scanners";
    public static final String MOD_VERSION = "1.0";
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[10.13.4.1558,]";//required-after:gregtech";
    public static final String MC_VERSION = "1.7.10";

    public static final String CLIENT_PROXY = "com.heracles421.orescanners.proxy.ClientProxy";
    public static final String SERVER_PROXY = "com.heracles421.orescanners.proxy.ServerProxy";
    public static final String GUI_FACTORY = "com.heracles421.orescanners.client.gui.GuiFactory";
}
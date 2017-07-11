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

import com.heracles421.orescanners.HeraclesOreScanners;
import com.heracles421.orescanners.reference.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

/**
 * Created by Heracles421 on 10-Jul-17.
 */
public class VersionHandler {

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {

        if (!HeraclesOreScanners.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote
                && !HeraclesOreScanners.versionChecker.isLatestVersion())
        {
            ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL,
                    "https://github.com/ianespana/HeraclesOreScanners/releases");
            ChatStyle clickableChatStyle = new ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
            ChatComponentText versionWarningChatComponent =
                    new ChatComponentText("[" + Reference.MOD_ID + "] There's a new version out, click here to update.");
            versionWarningChatComponent.setChatStyle(clickableChatStyle);
            event.player.addChatMessage(versionWarningChatComponent);
            HeraclesOreScanners.haveWarnedVersionOutOfDate = true;
        }
    }
}

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

package com.heracles421.orescanners.utility;

import com.heracles421.orescanners.reference.Reference;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Heracles421 on 10-Jul-17.
 */
public class VersionChecker implements Runnable {
    private static boolean isLatestVersion = false;
    private static String latestVersion = "";

    @Override
    public void run() {
        InputStream url = null;
        try
        {
            url = new URL(Reference.UPDATE_URL).openStream();
        }
        catch
                (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            latestVersion = IOUtils.readLines(url).get(0);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(url);
        }
        LogHelper.info("Latest mod version = " + latestVersion);
        isLatestVersion = Reference.MOD_VERSION.equals(latestVersion);
        LogHelper.info("Are you running latest version = " + isLatestVersion);
    }

    public boolean isLatestVersion()
    {
        return isLatestVersion;
    }

    public String getLatestVersion()
    {
        return latestVersion;
    }
}

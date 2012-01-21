/*******************************************************************************
 * Copyright (c) 2011 - 2012, Cristiano Gavião - C4Biz
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Cristiano Gavião - initial API and implementation
 *******************************************************************************/

package com.c4biz.feast.util.osgi.commands.equinox;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.Configuration;

public class CreateCommand extends AbstractCmSubCommand {

    @Override
    protected void doCommand(BundleContext context, String cmd, List<String> args, String commandLine) throws IOException {
        Configuration configuration;
        if (args.size() > 0) {
            configuration = configurationAdmin.getConfiguration(pid, (String) args.get(0));
        }
        else {
            // Create with null location, will be bound to the bundle that uses it.
            configuration = configurationAdmin.getConfiguration(pid, null);
        }
        // Ensure update is called, when properties are null; otherwise configuration will not
        // be returned when listConfigurations is called (see specification 104.15.3.7)
        if (configuration.getProperties() == null) {
            configuration.update(new Hashtable<String, String>());
        }
    }

}

/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.loxone.internal;

import java.util.Set;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.loxone.LoxoneBindingConstants;
import org.openhab.binding.loxone.handler.LoxoneMiniserverHandler;

import com.google.common.collect.Sets;

/**
 * Factory responsible for creating Loxone things (Miniservers) and their handlers ({@link LoxoneMiniserverHandler}
 *
 * @author Pawel Pieczul - Initial contribution
 */
public class LoxoneHandlerFactory extends BaseThingHandlerFactory {

    public static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Sets
            .newHashSet(LoxoneBindingConstants.THING_TYPE_MINISERVER);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        ThingTypeUID uid = thing.getThingTypeUID();
        if (uid.equals(LoxoneBindingConstants.THING_TYPE_MINISERVER)) {
            LoxoneMiniserverHandler handler = new LoxoneMiniserverHandler(thing);
            return handler;
        }
        return null;
    }
}

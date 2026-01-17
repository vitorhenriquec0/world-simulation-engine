package com.vitorhenriquec0.worldsim.events;

import com.vitorhenriquec0.worldsim.model.World;

public abstract class WorldEvent {
    public abstract String getName();

    public abstract void apply(World world);
}

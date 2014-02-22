package org.terasology.anotherWorld;

import org.terasology.math.Vector3i;
import org.terasology.world.WorldProvider;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
public class WorldLocalParameters implements LocalParameters {
    private WorldProvider worldProvider;
    private Vector3i location;

    public WorldLocalParameters(WorldProvider worldProvider, Vector3i location) {
        this.worldProvider = worldProvider;
        this.location = location;
    }

    @Override
    public float getTemperature() {
        return worldProvider.getTemperature(location.toVector3f());
    }

    @Override
    public float getHumidity() {
        return worldProvider.getHumidity(location.toVector3f());
    }
}
/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.anotherWorld;

import org.terasology.anotherWorld.generation.HumidityFacet;
import org.terasology.anotherWorld.generation.TemperatureFacet;
import org.terasology.math.Vector3i;
import org.terasology.world.generation.Region;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
public class GenerationLocalParameters implements LocalParameters {
    private Vector3i location;
    private TemperatureFacet surfaceTemperatureFacet;
    private HumidityFacet surfaceHumidityFacet;


    public GenerationLocalParameters(Region chunkRegion, Vector3i location) {
        this.location = location;
        surfaceTemperatureFacet = chunkRegion.getFacet(TemperatureFacet.class);
        surfaceHumidityFacet = chunkRegion.getFacet(HumidityFacet.class);
    }

    @Override
    public float getTemperature() {
        return surfaceTemperatureFacet.get(location.x, location.y, location.z);
    }

    @Override
    public float getHumidity() {
        return surfaceHumidityFacet.get(location.x, location.y, location.z);
    }
}

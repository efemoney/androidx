/*
 * Copyright 2021 The Android Open Source Project
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
package androidx.car.app.hardware.info;

import static java.util.Objects.requireNonNull;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.car.app.annotations.CarProtocol;
import androidx.car.app.annotations.RequiresCarApi;
import androidx.car.app.hardware.common.CarValue;

import java.util.Objects;

/** Information about car specific compass available from the car hardware. */
@CarProtocol
@RequiresCarApi(3)
public final class Compass {

    @Keep
    @NonNull
    private final CarValue<Float[]> mOrientations;

    /**
     * Returns the raw compass data from the car sensor.
     *
     * <p>Follows the same format as {@link android.hardware.SensorEvent#values}.
     */
    @NonNull
    public CarValue<Float[]> getOrientations() {
        return requireNonNull(mOrientations);
    }

    @Override
    @NonNull
    public String toString() {
        return "[ orientations: " + mOrientations + " ]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(mOrientations);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Compass)) {
            return false;
        }
        Compass otherCompass = (Compass) other;

        return Objects.equals(mOrientations, otherCompass.mOrientations);
    }

    /**
     * Creates an {@link Compass} with the given raw data.
     *
     * @throws NullPointerException if {@code orientations} is {@code null}
     */
    public Compass(@NonNull CarValue<Float[]> orientations) {
        mOrientations = requireNonNull(orientations);
    }

    /** Constructs an empty instance, used by serialization code. */
    private Compass() {
        mOrientations = CarValue.UNIMPLEMENTED_FLOAT_ARRAY;
    }
}

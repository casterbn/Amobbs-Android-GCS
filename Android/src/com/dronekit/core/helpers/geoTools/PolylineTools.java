package com.dronekit.core.helpers.geoTools;

import com.dronekit.core.helpers.coordinates.LatLong;

import java.util.List;

public class PolylineTools {

    /**
     * Total length of the polyline in meters
     *
     * @param gridPoints
     * @return
     */
    public static double getPolylineLength(List<LatLong> gridPoints) {
        double length = 0;
        for (int i = 1; i < gridPoints.size(); i++) {
            final LatLong to = gridPoints.get(i - 1);
            if (to == null) {
                continue;
            }

            length += GeoTools.getDistance(gridPoints.get(i), to);
        }
        return length;
    }
}

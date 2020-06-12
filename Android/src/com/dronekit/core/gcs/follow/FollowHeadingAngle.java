package com.dronekit.core.gcs.follow;

import android.os.Handler;

import com.dronekit.core.drone.DroneManager;
import com.dronekit.core.drone.autopilot.Drone;
import com.dronekit.core.gcs.location.Location;
import com.dronekit.core.helpers.coordinates.LatLong;
import com.dronekit.core.helpers.geoTools.GeoTools;

public abstract class FollowHeadingAngle extends FollowWithRadiusAlgorithm {

    protected final Drone drone;
    protected double angleOffset;

    protected FollowHeadingAngle(DroneManager droneMgr, Handler handler, double radius, double angleOffset) {
        super(droneMgr, handler, radius);
        this.angleOffset = angleOffset;

        this.drone = droneMgr.getDrone();
    }

    @Override
    public void processNewLocation(Location location) {
        LatLong gcsCoord = new LatLong(location.getCoord());
        double bearing = location.getBearing();

        LatLong goCoord = GeoTools.newCoordFromBearingAndDistance(gcsCoord, bearing + angleOffset, radius);
        drone.getGuidedPoint().newGuidedCoord(goCoord);
    }
}
package com.ftc.fia.business;

import com.ftc.fia.domain.Location;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
public interface ILocationBusiness {
    Location findLocationById(int locationId);
    Location createLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(Location location);
    List<Location> findAllLocation();
}

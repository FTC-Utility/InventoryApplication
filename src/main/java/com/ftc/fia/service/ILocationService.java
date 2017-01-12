package com.ftc.fia.service;

import com.ftc.fia.domain.Location;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
public interface ILocationService {
    Location findLocationById(int locationId);
    Location createLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(Location location);
    List<Location> findAllLocation();
}

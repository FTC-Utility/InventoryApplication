package com.ftc.fia.business.impl;

import com.ftc.fia.business.ILocationBusiness;
import com.ftc.fia.domain.Location;
import com.ftc.fia.repository.ILocationRepository;
import com.ftc.fia.service.impl.HardwareServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
@Component
public class LocationBusinessImpl implements ILocationBusiness {

    static final Logger logger = LoggerFactory.getLogger(HardwareServiceImpl.class);

    @Autowired
    ILocationRepository locationRepository;

    @Override
    public Location findLocationById(int locationId) {
        logger.info("finding location by id :",locationId);
        return locationRepository.findLocationById(locationId);
    }

    @Override
    public Location createLocation(Location location) {
        logger.info("Creating location ", location);
        return locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        logger.info("Updating location ", location);
        createLocation(location);
    }

    @Override
    public void deleteLocation(Location location) {
        logger.info("Deleting location ", location);
        locationRepository.delete(location);
    }

    @Override
    public List<Location> findAllLocation() {
        logger.info("Deleting location ");
        return locationRepository.findAll();
    }
}

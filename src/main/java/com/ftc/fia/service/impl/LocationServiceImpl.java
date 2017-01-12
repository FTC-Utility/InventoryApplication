package com.ftc.fia.service.impl;

import com.ftc.fia.business.ILocationBusiness;
import com.ftc.fia.domain.Location;
import com.ftc.fia.service.ILocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
@Service
@Transactional
public class LocationServiceImpl implements ILocationService {

    static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    ILocationBusiness locationBusiness;

    @Override
    public Location findLocationById(int locationId) {
        logger.info("Getting Location By Id : ",locationId);
        return locationBusiness.findLocationById(locationId);
    }

    @Override
    public Location createLocation(Location location) {
        logger.info("Creating Location : ",location);
        return locationBusiness.createLocation(location);
    }

    @Override
    public void updateLocation(Location location) {
        logger.info("Updating Location : ",location);
        locationBusiness.updateLocation(location);
    }

    @Override
    public void deleteLocation(Location location) {
        logger.info("Deleting Location : ",location);
        locationBusiness.deleteLocation(location);
    }

    @Override
    public List<Location> findAllLocation() {
        logger.info("Finding Location : ");
        return locationBusiness.findAllLocation();
    }
}

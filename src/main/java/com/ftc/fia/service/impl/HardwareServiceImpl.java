package com.ftc.fia.service.impl;

import com.ftc.fia.business.IHardwareBusiness;
import com.ftc.fia.domain.Hardware;
import com.ftc.fia.service.IHardwareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/10/2017.
 */
@Service
@Transactional
public class HardwareServiceImpl implements IHardwareService {

    static final Logger logger = LoggerFactory.getLogger(HardwareServiceImpl.class);

    @Autowired
    IHardwareBusiness hardwareBusiness;

    @Override
    public Hardware getHardwareById(int hardwareId) {
        logger.info("Getting Hardware By Id : ",hardwareId);
        return hardwareBusiness.getHardwareById(hardwareId);
    }

    @Override
    public Hardware findHardwareByLocation(int locationId) {
        logger.info("Getting Hardware By Location : ", locationId);
        return hardwareBusiness.findHardwareByLocation(locationId);
    }

    @Override
    public Hardware createHardware(Hardware hardware) {
        logger.info("Creating Hardware : ", hardware);
        return hardwareBusiness.createHardware(hardware);
    }

    @Override
    public void updateHardware(Hardware hardware) {
        logger.info("Updating Hardware : ", hardware);
        hardwareBusiness.updateHardware(hardware);
    }

    @Override
    public void deleteHardware(Hardware hardware) {
        logger.info("Deleting Hardware : ", hardware);
        hardwareBusiness.deleteHardware(hardware);
    }

    @Override
    public List<Hardware> findAllHardware() {
        logger.info("Getting All Hardware");
        return hardwareBusiness.findAllHardware();
    }
}

package com.ftc.fia.business.impl;

import com.ftc.fia.business.IHardwareBusiness;
import com.ftc.fia.domain.Hardware;
import com.ftc.fia.repository.IHardwareRepository;
import com.ftc.fia.service.impl.EquipmentTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/10/2017.
 */
@Component
public class HardwareBusinessImpl implements IHardwareBusiness {

    static final Logger logger = LoggerFactory.getLogger(HardwareBusinessImpl.class);

    @Autowired
    IHardwareRepository hardwareRepository;

    @Override
    public Hardware getHardwareById(int hardwareId) {
        logger.info("Getting Hardware By Id :", hardwareId);
        return hardwareRepository.getHardwareById(hardwareId);
    }

    @Override
    public Hardware findHardwareByLocation(int locationId) {
        logger.info("Getting Hardware By Location  : {}",locationId);
        return hardwareRepository.findHardwareByLocation(locationId);
    }

    @Override
    public Hardware createHardware(Hardware hardware) {
        logger.info("Creating Hardware : ", hardware);
        return hardwareRepository.save(hardware);
    }

    @Override
    public void updateHardware(Hardware hardware) {
        logger.info("Updating Hardware : ", hardware);
        createHardware(hardware);
    }

    @Override
    public void deleteHardware(Hardware hardware) {
        logger.info("Deleting Hardware :", hardware);
        hardwareRepository.delete(hardware);
    }

    @Override
    public List<Hardware> findAllHardware() {
        logger.info("Finding All Hardware : ");
        return hardwareRepository.findAll();
    }
}

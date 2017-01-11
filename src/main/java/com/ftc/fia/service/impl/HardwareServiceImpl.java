package com.ftc.fia.service.impl;

import com.ftc.fia.domain.Hardware;
import com.ftc.fia.service.IHardwareService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/10/2017.
 */
@Service
public class HardwareServiceImpl implements IHardwareService {

    @Override
    public Hardware getHardwareById(int hardwareId) {
        return null;
    }

    @Override
    public Hardware findHardwareByLocation(int locationId) {
        return null;
    }

    @Override
    public Hardware createHardware(Hardware hardware) {
        return null;
    }

    @Override
    public void updateHardware(Hardware hardware) {

    }

    @Override
    public void deleteHardware(Hardware hardware) {

    }

    @Override
    public List<Hardware> findAllHardware() {
        return null;
    }
}

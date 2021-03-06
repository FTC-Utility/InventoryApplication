package com.ftc.fia.service;

import com.ftc.fia.domain.Hardware;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/10/2017.
 */
public interface IHardwareService {
    Hardware getHardwareById(int hardwareId);
    Hardware findHardwareByLocation(int locationId);
    Hardware createHardware(Hardware hardware);
    void updateHardware(Hardware hardware);
    void deleteHardware(Hardware hardware);
    List<Hardware> findAllHardware();
}

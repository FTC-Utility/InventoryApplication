package com.ftc.fia.business.impl;

import com.ftc.fia.business.IVendorBusiness;
import com.ftc.fia.domain.Vendor;
import com.ftc.fia.repository.IVendorRepository;
import com.ftc.fia.service.impl.EquipmentTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
@Component
public class VendorBusinessImpl implements IVendorBusiness {
    static final Logger logger = LoggerFactory.getLogger(VendorBusinessImpl.class);

    @Autowired
    IVendorRepository vendorRepository;

    @Override
    public Vendor findVendorById(int vendorId) {
        logger.info("Finding Vendor By Id :", vendorId);
        return vendorRepository.findVendorById(vendorId);
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        logger.info("Create Vendor :", vendor);
        return vendorRepository.save(vendor);
    }

    @Override
    public void updateVendor(Vendor vendor) {
        logger.info("Update Vendor :", vendor);
        createVendor(vendor);

    }

    @Override
    public void deleteVendor(Vendor vendor) {
        logger.info("Deleting Vendor :", vendor);
        vendorRepository.delete(vendor);
    }

    @Override
    public List<Vendor> findAllVendor() {
        logger.info("Finding All Vendor :");
        return vendorRepository.findAll();
    }
}

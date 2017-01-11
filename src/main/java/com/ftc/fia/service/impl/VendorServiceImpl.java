package com.ftc.fia.service.impl;

import com.ftc.fia.business.IVendorBusiness;
import com.ftc.fia.domain.Location;
import com.ftc.fia.domain.Vendor;
import com.ftc.fia.service.IVendorService;
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
public class VendorServiceImpl implements IVendorService {

    static final Logger logger = LoggerFactory.getLogger(EquipmentTypeServiceImpl.class);

    @Autowired
    IVendorBusiness vendorBusiness;

    @Override
    public Vendor findVendorById(int vendorId) {
        logger.info("Finding Vendor By Id :", vendorId);
        return vendorBusiness.findVendorById(vendorId);
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        logger.info("Creating Vendor ", vendor);
        return vendorBusiness.createVendor(vendor);
    }

    @Override
    public void updateVendor(Vendor vendor) {
        logger.info("Updating Vendor :", vendor);
        createVendor(vendor);
    }

    @Override
    public void deleteVendor(Vendor vendor) {
        logger.info("Deleting Vendor :", vendor);
        vendorBusiness.deleteVendor(vendor);
    }

    @Override
    public List<Vendor> findAllVendor() {
        logger.info("Finding All Vendor :");
        return vendorBusiness.findAllVendor();
    }
}

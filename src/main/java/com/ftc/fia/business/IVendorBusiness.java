package com.ftc.fia.business;

import com.ftc.fia.domain.Location;
import com.ftc.fia.domain.Vendor;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
public interface IVendorBusiness {
    Vendor findVendorById(int vendorId);
    Vendor createVendor(Vendor vendor);
    void updateVendor(Vendor vendor);
    void deleteVendor(Vendor vendor);
    List<Vendor> findAllVendor();
}

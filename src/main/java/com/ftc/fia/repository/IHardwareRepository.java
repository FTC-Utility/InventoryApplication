package com.ftc.fia.repository;

import com.ftc.fia.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eyuel Tadesse on 1/10/2017.
 */
public interface IHardwareRepository extends JpaRepository<Hardware, Integer> {
}

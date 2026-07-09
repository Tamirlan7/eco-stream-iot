package com.tami.deviceservice.repository;

import com.tami.deviceservice.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}

package com.tami.deviceservice.repository;

import com.tami.deviceservice.dto.DeviceDto;
import com.tami.deviceservice.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAllByUserId(Long userId);
}

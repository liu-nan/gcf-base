package com.gcf.provider.code.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcf.provider.code.repository.entity.AssetTypeEntity;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetTypeEntity, Long> {

}

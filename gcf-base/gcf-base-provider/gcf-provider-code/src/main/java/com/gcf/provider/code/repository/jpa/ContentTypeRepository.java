package com.gcf.provider.code.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcf.provider.code.repository.entity.ContentTypeEntity;

@Repository
public interface ContentTypeRepository extends JpaRepository<ContentTypeEntity, Long> {

}

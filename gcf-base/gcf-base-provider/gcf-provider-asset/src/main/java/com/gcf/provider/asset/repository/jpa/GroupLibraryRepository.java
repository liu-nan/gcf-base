package com.gcf.provider.asset.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcf.provider.asset.repository.entity.GroupLibrary;

@Repository
public interface GroupLibraryRepository extends JpaRepository<GroupLibrary, Long> {

}

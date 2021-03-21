package com.gcf.provider.content.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcf.provider.content.repository.entity.CategoryLibrary;

@Repository
public interface CategoryLibraryRepository extends JpaRepository<CategoryLibrary, Long> {

}

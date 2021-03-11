package com.gcf.provider.tag.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcf.provider.tag.repository.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}

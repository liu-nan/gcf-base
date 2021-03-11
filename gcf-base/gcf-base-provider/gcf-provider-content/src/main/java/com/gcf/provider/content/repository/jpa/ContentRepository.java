package com.gcf.provider.content.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcf.provider.content.repository.entity.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}

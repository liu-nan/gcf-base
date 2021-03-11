package com.gcf.provider.content.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcf.provider.content.repository.entity.ContentText;

public interface ContentTextRepository extends JpaRepository<ContentText, Long> {

}

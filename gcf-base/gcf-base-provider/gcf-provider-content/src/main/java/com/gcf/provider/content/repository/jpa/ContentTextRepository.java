package com.gcf.provider.content.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcf.provider.content.repository.entity.ContentText;

@Repository
public interface ContentTextRepository extends JpaRepository<ContentText, Long> {

}

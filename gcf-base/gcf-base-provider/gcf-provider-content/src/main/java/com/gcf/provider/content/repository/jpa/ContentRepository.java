package com.gcf.provider.content.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.gcf.provider.content.repository.entity.Content;

public interface ContentRepository extends CrudRepository<Content, Long> {

}

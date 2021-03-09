package com.gcf.provider.user.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.gcf.provider.user.repository.entity.Content;

public interface ContentRepository extends CrudRepository<Content, Long> {

}

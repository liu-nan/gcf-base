package com.gcf.provider.content.repository.jpa;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gcf.provider.content.repository.entity.CategoryLibrary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class CategoryLibraryRepositoryTest {
	@Autowired
	private CategoryLibraryRepository categoryLibraryRepository;

	@Test
	public void save() {
		CategoryLibrary value= new CategoryLibrary();
		value.setCategoryLibraryCode("123");
		value.setCategoryLibraryName("123");
		value.setDescription("123");
		value.setRef("12343");
		value.setCreateAccount("aaa");
		value.setCreateTime(LocalDateTime.now());
		value.setLastModifyAccount("aaa");
		value.setLastModifyTime(LocalDateTime.now());
		CategoryLibrary entity = categoryLibraryRepository.save(value);
		assertNotNull(entity);
	}

}

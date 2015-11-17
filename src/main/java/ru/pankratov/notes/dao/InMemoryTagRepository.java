package ru.pankratov.notes.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.pankratov.notes.domain.Tag;

/**
 * Вместо файлов :)
 *  
 * @author vasiliy
 *
 */
@Component
@Scope
@Profile("inMemory")
public class InMemoryTagRepository implements TagRepository {
	
	private List<Tag> tags = new ArrayList<Tag>();
	
	public InMemoryTagRepository() {
		tags.add(new Tag("Счастье"));
		tags.add(new Tag("Здоровье"));
		tags.add(new Tag("Успех"));
		tags.add(new Tag("Красота"));
	}
	
	@Override
	public List<Tag> findAll() {
		return tags;
	}
}

package ru.pankratov.notes.dao;

import java.util.List;

import ru.pankratov.notes.domain.Tag;

public interface TagRepository {
	
	List<Tag> findAll();
}

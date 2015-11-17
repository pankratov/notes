package ru.pankratov.notes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import ru.pankratov.notes.domain.Tag;

@Repository
@Profile("db")
public class DBTagRepository implements TagRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Tag> findAll() {
		return entityManager.createQuery("from Tag", Tag.class).getResultList();
	}

}

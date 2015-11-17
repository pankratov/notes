package ru.pankratov.notes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.pankratov.notes.domain.Note;

@Repository
@Profile("db")
public class DBNoteRepository implements NoteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Note> findAll() {
		return entityManager.createQuery("from Note", Note.class).getResultList();
	}

	@Override
	@Transactional
	public Note save(Note note) {
		entityManager.persist(note);
		return note;
	}

}

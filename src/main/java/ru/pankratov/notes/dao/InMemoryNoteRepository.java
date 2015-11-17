package ru.pankratov.notes.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import ru.pankratov.notes.domain.Note;

/**
 * Вместо файлов :)
 *  
 * @author vasiliy
 *
 */
@Component
@Profile("inMemory")
public class InMemoryNoteRepository implements NoteRepository {
	
	private List<Note> notes = Collections.synchronizedList(new ArrayList<Note>());
	
	@Override
	public List<Note> findAll() {
		return this.notes;
	}
	
	@Override
	public Note save(Note note) {
		notes.add(note);
		return note;
	}
}

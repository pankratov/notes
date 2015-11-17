package ru.pankratov.notes.dao;


import java.util.List;

import ru.pankratov.notes.domain.Note;

public interface NoteRepository {
	
	List<Note> findAll();

	Note save(Note note);
	
}

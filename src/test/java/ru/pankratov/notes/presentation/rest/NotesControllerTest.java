package ru.pankratov.notes.presentation.rest;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ru.pankratov.notes.dao.NoteRepository;
import ru.pankratov.notes.domain.Note;
import ru.pankratov.notes.presentation.exception.BadTitleException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class NotesControllerTest {
	
	private NotesController controllerUT;
	
	@Mock
	private NoteRepository mockedRepository;
	
	@Before
	public void setUp() {
		controllerUT = new NotesController();
		controllerUT.setNoteRepository(mockedRepository);
	}

	@Test
	public void testCreate() throws Exception {

		Note note = new Note();
		controllerUT.create(note);		
		
		verify(mockedRepository, atLeast(1)).save(note);
		
	}
	
	@Test(expected = BadTitleException.class)
	public void testCreateExceptions() throws Exception {
		Note note = new Note();
		note.setTitle("Ошибка");
		controllerUT.create(note);
	}

	@Test
	public void testReadAll() throws Exception {
		Note note1 = new Note();
		Note note2 = new Note();
		when(mockedRepository.findAll()).thenReturn(Arrays.asList(note1, note2));
		
		List<Note> notes = controllerUT.readAll();
		assertEquals(2, notes.size());
		assertEquals(note1, notes.get(0));
		assertEquals(note2, notes.get(1));
	}

}

package ru.pankratov.notes.dao;

import org.junit.Before;
import org.junit.Test;

import ru.pankratov.notes.domain.Note;

import static org.junit.Assert.*;

public class InMemoryNoteRepositoryTest {

	private InMemoryNoteRepository repositoryUT;
	
	@Before
	public void setUp() {
		repositoryUT = new InMemoryNoteRepository();
	}
	
	@Test
	public void testSave() throws Exception {
		Note note1 = new Note();
		Note note2 = new Note();
		assertNotNull(repositoryUT.findAll());
		assertEquals(0, repositoryUT.findAll().size());
		
		repositoryUT.save(note1);
		assertEquals(1, repositoryUT.findAll().size());
		assertEquals(note1, repositoryUT.findAll().get(0));

		repositoryUT.save(note2);
		assertEquals(2, repositoryUT.findAll().size());

		repositoryUT.save(note1);
		assertEquals(3, repositoryUT.findAll().size());

	}

}

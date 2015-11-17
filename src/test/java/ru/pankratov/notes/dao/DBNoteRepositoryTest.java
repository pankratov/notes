package ru.pankratov.notes.dao;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ru.pankratov.notes.domain.Note;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DBNoteRepositoryTest {

	@Mock
	private EntityManager entityManager;
	
	private DBNoteRepository repositoryUT;
	
	@Before
	public void setUp() {
		repositoryUT = new DBNoteRepository();
		repositoryUT.setEntityManager(entityManager);
	}
	
	
	@Test
	public void testSave() throws Exception {
		Note note = new Note();
		repositoryUT.save(note);
		verify(entityManager, atLeast(1)).persist(note);
	}

}

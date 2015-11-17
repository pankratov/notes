package ru.pankratov.notes.dao;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InMemoryTagRepositoryTest {
	
	private InMemoryTagRepository repositoryUT;
	
	@Before
	public void setUp() {
		repositoryUT = new InMemoryTagRepository();
	}

	@Test
	public void testFindAll() throws Exception {
		assertNotNull(repositoryUT.findAll());
	}

}

package ru.pankratov.notes.presentation.rest;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ru.pankratov.notes.dao.TagRepository;
import ru.pankratov.notes.domain.Tag;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TagsControllerTest {

	@InjectMocks
	private TagsController controllerUT;
	
	@Mock
	private TagRepository mockedRepository;
	
	@Test
	public void testReadAll() throws Exception {
		Tag tag1 = new Tag();
		Tag tag2 = new Tag();
		when(mockedRepository.findAll()).thenReturn(Arrays.asList(tag1, tag2));
		
		List<Tag> tags = controllerUT.readAll();
		assertEquals(2, tags.size());
		assertEquals(tag1, tags.get(0));
		assertEquals(tag2, tags.get(1));
	}
	
	
}

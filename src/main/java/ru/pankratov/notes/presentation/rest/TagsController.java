package ru.pankratov.notes.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.pankratov.notes.dao.TagRepository;
import ru.pankratov.notes.domain.Tag;

@RestController
@RequestMapping("/rest/tags")
public class TagsController {

	private TagRepository tagRepository;
	
	@Autowired
	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Tag> readAll() {
		return tagRepository.findAll();
	}
}

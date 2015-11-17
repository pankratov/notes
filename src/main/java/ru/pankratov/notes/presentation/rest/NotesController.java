package ru.pankratov.notes.presentation.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.pankratov.notes.dao.NoteRepository;
import ru.pankratov.notes.domain.Note;
import ru.pankratov.notes.presentation.exception.BadTitleException;
import ru.pankratov.notes.presentation.exception.BadTitleMessage;

@RestController
@RequestMapping("/rest/notes")
public class NotesController {

	private NoteRepository noteRepository;

	@Autowired
	@Qualifier("db")
	public void setNoteRepository(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Note> readAll() {
		return noteRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public Note create(@RequestBody Note note) {
		
		if("Ошибка".equals(note.getTitle())) throw new BadTitleException();
		return noteRepository.save(note);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadTitleException.class)
	@ResponseBody BadTitleMessage handleBadRequest(HttpServletRequest req, Exception ex) {
	    return new BadTitleMessage("Очень плохой заголовок");
	} 

}

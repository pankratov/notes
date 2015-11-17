package ru.pankratov.notes.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "notes")
public class Note {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "title")
	private String title = "";

	@Column(name = "body")
	private String body = "";

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "notes_tags", 
		joinColumns = { @JoinColumn(name = "note", referencedColumnName = "id") }, 
		inverseJoinColumns = { @JoinColumn(name = "tag", referencedColumnName = "value") })
	private List<Tag> tags = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

}

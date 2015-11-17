package ru.pankratov.notes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@Column(name = "value")
	private String value = "";
	
	public Tag(String tag) {
		this.value = tag;
	}

	public Tag() {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "value");
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "value");
	}	
	
}

package model.entites;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String name;
	private String email;

	public Person() {
	}

	public Person(Integer id, String name, String email) {
		Id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Person [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	}

}

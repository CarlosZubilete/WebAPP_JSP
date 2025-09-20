package entities;

public class TypeSeguro {
	private int id;
	private String description;

	public TypeSeguro() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TypeSeguro [id=" + id + ", description=" + description + "]";
	}

}

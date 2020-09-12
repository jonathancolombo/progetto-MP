package project.mp.book;

import java.util.Objects;

public class Novel extends Book {

	private String genry;

	public Novel(String title, String author, boolean available, String genry) {
		super(title, author, available);
		this.genry = genry;
	}

	public String getGenry() {
		return genry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(genry);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Novel other = (Novel) obj;
		return Objects.equals(genry, other.genry);
	}

	@Override
	public String toString() {
		return super.toString() + " [genry=" + genry + "]";
	}
	
}

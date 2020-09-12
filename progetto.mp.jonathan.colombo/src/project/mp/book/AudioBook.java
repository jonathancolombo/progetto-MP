package project.mp.book;

import java.util.Objects;

public class AudioBook extends Book {

	private String audioBookNarrator;

	public AudioBook(String title, String author, boolean available,
			String audioBookNarrator) {
		super(title, author, available);
		this.audioBookNarrator = audioBookNarrator;
	}

	public String getAudioBookNarrator() {
		return audioBookNarrator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(audioBookNarrator);
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
		AudioBook other = (AudioBook) obj;
		return Objects.equals(audioBookNarrator, other.audioBookNarrator);
	}

	@Override
	public String toString() {
		return super.toString() + " [audioBookNarrator=" + audioBookNarrator + "]";
	}
	
}

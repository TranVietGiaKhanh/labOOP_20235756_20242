package hust.soict.hedspi.aims.media;
import java.util.ArrayList;

public class MediaTest {
	ArrayList<Media> mediae = new ArrayList<>();
	Book book = new Book(1, "no home", "Education", 4.5f, null);
    Media dvd = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
    Track track = new Track("Freedom Tower", (int) 25f);

    mediae.add(book);
    mediae.add(dvd);
    mediae.add(track);

    for (Media media : mediae) {
        System.out.println(media.toString());
    }
}

package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		super(++nbDigitalVideoDiscs, title, null, 0, null, 0);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(++nbDigitalVideoDiscs, title, category, cost, director, length);
	}
	public void play() { 
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
		}
}

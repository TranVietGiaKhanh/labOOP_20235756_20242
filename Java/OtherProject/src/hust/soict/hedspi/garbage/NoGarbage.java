package hust.soict.hedspi.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
	   	public static void main(String[] args) throws IOException {
	        String filename = "test.txt";
	        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
	        long startTime, endTime;

	        startTime = System.currentTimeMillis();
	        StringBuilder sb = new StringBuilder();
	        for (byte b : inputBytes) {
	            sb.append((char) b);
	        }
	        String result = sb.toString();
	        endTime = System.currentTimeMillis();
	        System.out.println("Time with StringBuilder: " + (endTime - startTime) + "ms");
	   }
}

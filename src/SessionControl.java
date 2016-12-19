import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class SessionControl { 

	File file = new File("LatLong.txt");
	Scanner sc;
	public LatLng setDestination() throws FileNotFoundException {
		sc = new Scanner(file);
		long lat = sc.nextLong();
		long lon = sc.nextLong();
		LatLng destination = new LatLng(lat,lon);
		return destination;
	}
	
	Session currentSession;
	public void startSession() {
		if(currentSession.isCreated) {
			currentSession.sessionRunning = true;
		}
	}
	
	public void endSession() {
		if(currentSession.sessionRunning) {
			currentSession.sessionRunning = false;
		}
	}
	
	
	public LatLng currentLocation;
	public LatLng updateCurrentLocation() throws FileNotFoundException {
		sc = new Scanner(file);
		long lat = sc.nextLong();
		long lon = sc.nextLong();
		currentLocation = new LatLng(lat,lon);
		return currentLocation;
		
	}
}
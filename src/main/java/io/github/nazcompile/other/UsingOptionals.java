package io.github.nazcompile.other;

import java.util.Optional;

public class UsingOptionals {

	public static void main(String[] args) {
		UsingOptionals uopt = new UsingOptionals();
		uopt.runCodeSample();
	}

	void runCodeSample() {
		GPSData gpsData = new GPSData();
		
		String direction = "UNKNOWN";
		if (gpsData != null) {
			Position p = gpsData.getPosition();
			if (p != null) {
				Latitude latitude = p.getLatitude();
				if (latitude != null) {
					direction = latitude.getDirection();
				}
			}
		}
		
		//JAVA 8 
//		String direction = Optional.ofNullable(gpsData)
//									.map(data -> data.getPosition())
//									.map(position -> position.getLatitude())
//									.map(lat -> lat.getDirection())
//									.orElse("UNKNOWN");
		
		
							
		System.out.println("Direction - " + direction);
	}

	class GPSData {
		Position getPosition() {
			return new Position();
		}
	}

	class Position {
		Latitude getLatitude() {
			return new Latitude();
		}
	}

	class Latitude {
		String getDirection() {
			return "N";
		}
	}

}

package org.ezquerro.hibernate.airlines;

import java.util.ArrayList;
import java.util.List;

import org.ezquerro.hibernate.airlines.dao.AircraftDAO;
import org.ezquerro.hibernate.airlines.dao.PilotDAO;
import org.ezquerro.hibernate.airlines.models.Aircraft;
import org.ezquerro.hibernate.airlines.models.Pilot;

public class Main {

	public static void main(String[] args) {
		Aircraft aircraft1 = new Aircraft();
		aircraft1.setModel("Boing 747");
		aircraft1.setAutonomy(1000F);
		Aircraft aircraft2 = new Aircraft();
		aircraft2.setModel("Boing 745");
		aircraft2.setAutonomy(1000000F);

		Pilot pilot1 = new Pilot();
		pilot1.setName("David");
		pilot1.setLicense(2);

		Pilot pilot2 = new Pilot();
		pilot2.setName("Sergio");
		pilot2.setLicense(3);
		aircraft1.setPilot(pilot1);
		aircraft2.setPilot(pilot2);

		
		
		AircraftDAO aircraftDAO = new AircraftDAO();
		PilotDAO pilotDAO = new PilotDAO();
		
		//Se almacena el primer país
		aircraftDAO.insert(aircraft1);
		
		//Se almacenan los otros dos países que tienen presidentes asociados, por lo tanto, los
		//presidentes se almacenan en cascada.
		
		aircraftDAO.insert(aircraft2);
		List<Aircraft> aircrafts = new ArrayList<Aircraft>();
		aircrafts = aircraftDAO.selectAll();
		
		for(Aircraft aircraft:aircrafts){
			System.out.println(aircraft.toString());
		}

	}

}

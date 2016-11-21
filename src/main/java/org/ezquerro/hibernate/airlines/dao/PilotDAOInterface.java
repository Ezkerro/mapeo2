package org.ezquerro.hibernate.airlines.dao;

import java.util.List;

import org.ezquerro.hibernate.airlines.models.Pilot;

/**
 * interface for PresidentDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface PilotDAOInterface {
	
	public Pilot selectById(Long id);
	public List<Pilot> selectAll ();
	public void insert (Pilot pilot);
	public void update (Pilot pilot);
	public void delete (Pilot pilot);

}

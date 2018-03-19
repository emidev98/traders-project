package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Planet;
import model.SolarSystem;

@ManagedBean
@ViewScoped
public class ChosePlanet {
	
	private List<SolarSystem> solarSystems = null;
	private List<Planet> planets = null;
	private SolarSystem selectedSolarSystem = null;
	
	public ChosePlanet() {
		solarSystems = SolarSystem.getAllSolarSystems();
	}
	
	public List<SolarSystem> getSolarSystems() {
		return solarSystems;
	}
	
	public List<Planet> getPlanets(SolarSystem solarSystem) {
		System.out.println(solarSystem.toString());
		return solarSystem.getPlanets();
	}
	
	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public SolarSystem getSelectedSolarSystem() {
		return selectedSolarSystem;
	}

	public void setSelectedSolarSystem(SolarSystem selectedSolarSystem) {
		this.selectedSolarSystem = selectedSolarSystem;
	}
}

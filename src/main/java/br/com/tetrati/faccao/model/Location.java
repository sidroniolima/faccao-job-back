package br.com.tetrati.faccao.model;

public class Location 
{
	private String type;
	private Long[] coordinates; 
	
	public Location() 
	{
		type = "Point";
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Long[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Long[] coordinates) {
		this.coordinates = coordinates;
	}
}

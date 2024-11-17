package indywinners.Pack;

public class IndyWinner {
	private int year;
	private String driver;
	private double averagespeed;
	private String country;
	
public IndyWinner(int year, String driver, double averagespeed, String country) {
	this.year = year;
	this.driver = driver;
	this.averagespeed = averagespeed;
	this.country = country;
	
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public String getDriver() {
	return driver;
}

public void setDriver(String driver) {
	this.driver = driver;
}

public double getAveragespeed() {
	return averagespeed;
}

public void setAveragespeed(double averagespeed) {
	this.averagespeed = averagespeed;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}


}

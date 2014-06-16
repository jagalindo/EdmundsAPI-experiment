package data;

import java.util.Collection;

public class Year {

	public Year(Long id, Long year, Collection<Year> years) {
		super();
		this.id = id;
		this.year = year;
		this.years = years;
	}
	
	Long id;
	Long year;
	Collection<Year> years;
	
}

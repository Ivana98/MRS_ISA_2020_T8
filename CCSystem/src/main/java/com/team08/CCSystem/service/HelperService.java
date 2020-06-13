/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * @author Veljko
 *
 */
@Service
public class HelperService {
	
	/**
	 * We try to find out if the first (static) date intersects with the second date.
	 * 
	 * @param startDate1 - static date
	 * @param endDate1 - static date
	 * @param startDate2 - dynamic date
	 * @param endDate2 - dynamic date
	 * @return true if dates overlap
	 */
	public boolean areDatesOverlap(Date startDate1, Date endDate1,
			Date startDate2, Date endDate2) {

		if (endDate1.after(startDate2) && endDate1.before(endDate2))
			return true;
		
		if (startDate1.after(startDate2) && endDate1.before(endDate2))
			return true;
		
		if (startDate1.after(startDate2) && startDate1.before(endDate2))
			return true;
		
		if (startDate1.before(startDate2) && endDate1.after(endDate2))
			return true;
		
		return false;
	}
	
	/**
	 * @param startDate is Date
	 * @param duration is duration of examination in minutes
	 * @return start date plus duration (end date)
	 */
	public Date getDatePlusDuration(Date startDate, int duration) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.MINUTE, duration);
		
		return new Date(cal.getTimeInMillis());
	}

}

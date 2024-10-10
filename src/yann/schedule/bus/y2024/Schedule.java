/*
 * (c) Copyright 2001-2003 Yann-Ga�l Gu�h�neuc,
 * �cole des Mines de Nantes and Object Technology International, Inc.
 * 
 * Use and copying of this software and preparation of derivative works
 * based upon this software are permitted. Any copy of this software or
 * of any derivative work must include the above copyright notice of
 * the author, this paragraph and the one after it.
 * 
 * This software is made available AS IS, and THE AUTHOR DISCLAIMS
 * ALL WARRANTIES, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE, AND NOT WITHSTANDING ANY OTHER PROVISION CONTAINED HEREIN,
 * ANY LIABILITY FOR DAMAGES RESULTING FROM THE SOFTWARE OR ITS USE IS
 * EXPRESSLY DISCLAIMED, WHETHER ARISING IN CONTRACT, TORT (INCLUDING
 * NEGLIGENCE) OR STRICT LIABILITY, EVEN IF THE AUTHOR IS ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 * 
 * All Rights Reserved.
 */
package yann.schedule.bus.y2024;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import fr.emn.spiraclock.ATime;
import fr.emn.spiraclock.AppProperties;
import fr.emn.spiraclock.Appointment;

/**
 * @author Yann-Ga�l Gu�h�neuc
 * @since 2004/01/16
 */
public class Schedule extends fr.emn.spiraclock.Schedule {
	private static final Calendar CALENDAR = Calendar.getInstance();
	private static final int SAFETY_TIME = 1;

	private static DepartureTime[] route105east = new DepartureTime[] { new DepartureTime(5, 22),
			new DepartureTime(5, 44), new DepartureTime(6, 4), new DepartureTime(6, 15), new DepartureTime(6, 26),
			new DepartureTime(6, 37), new DepartureTime(6, 46), new DepartureTime(6, 54), new DepartureTime(7, 01),
			new DepartureTime(7, 8), new DepartureTime(7, 14), new DepartureTime(7, 20), new DepartureTime(7, 26),
			new DepartureTime(7, 30), new DepartureTime(7, 35), new DepartureTime(7, 38), new DepartureTime(7, 41),
			new DepartureTime(7, 45), new DepartureTime(7, 49), new DepartureTime(7, 52), new DepartureTime(7, 56),
			new DepartureTime(8, 00), new DepartureTime(8, 4), new DepartureTime(8, 7), new DepartureTime(8, 10),
			new DepartureTime(8, 14), new DepartureTime(8, 18), new DepartureTime(8, 21), new DepartureTime(8, 25),
			new DepartureTime(8, 29), new DepartureTime(8, 38), new DepartureTime(8, 42), new DepartureTime(8, 47),
			new DepartureTime(8, 52), new DepartureTime(8, 59), new DepartureTime(9, 6), new DepartureTime(9, 13),
			new DepartureTime(9, 21), new DepartureTime(9, 27), new DepartureTime(9, 33), new DepartureTime(9, 40),
			new DepartureTime(9, 47), new DepartureTime(9, 55), new DepartureTime(10, 4), new DepartureTime(10, 13),
			new DepartureTime(10, 23), new DepartureTime(10, 33), new DepartureTime(10, 42), new DepartureTime(10, 50),
			new DepartureTime(10, 58), new DepartureTime(11, 5), new DepartureTime(11, 13), new DepartureTime(11, 21),
			new DepartureTime(11, 32), new DepartureTime(11, 43), new DepartureTime(12, 2), new DepartureTime(12, 11),
			new DepartureTime(12, 20), new DepartureTime(12, 30), new DepartureTime(12, 49), new DepartureTime(12, 58),
			new DepartureTime(13, 7), new DepartureTime(13, 22), new DepartureTime(13, 29), new DepartureTime(13, 37),
			new DepartureTime(13, 45), new DepartureTime(13, 54), new DepartureTime(14, 12), new DepartureTime(14, 21),
			new DepartureTime(14, 29), new DepartureTime(14, 37), new DepartureTime(14, 44), new DepartureTime(14, 51),
			new DepartureTime(14, 57), new DepartureTime(15, 2), new DepartureTime(15, 8), new DepartureTime(15, 14),
			new DepartureTime(15, 22), new DepartureTime(15, 28), new DepartureTime(15, 33), new DepartureTime(15, 38),
			new DepartureTime(15, 44), new DepartureTime(15, 56), new DepartureTime(16, 4), new DepartureTime(16, 12),
			new DepartureTime(16, 19), new DepartureTime(16, 26), new DepartureTime(16, 33), new DepartureTime(16, 40),
			new DepartureTime(16, 48), new DepartureTime(16, 57), new DepartureTime(17, 5), new DepartureTime(17, 12),
			new DepartureTime(17, 27), new DepartureTime(17, 35), new DepartureTime(17, 44), new DepartureTime(17, 53),
			new DepartureTime(18, 3), new DepartureTime(18, 13), new DepartureTime(18, 23), new DepartureTime(18, 35),
			new DepartureTime(18, 47), new DepartureTime(18, 58), new DepartureTime(19, 8), new DepartureTime(19, 20),
			new DepartureTime(19, 32), new DepartureTime(19, 44), new DepartureTime(19, 56), new DepartureTime(20, 8),
			new DepartureTime(20, 20), new DepartureTime(20, 32), new DepartureTime(20, 44), new DepartureTime(20, 56),
			new DepartureTime(21, 8), new DepartureTime(21, 30), new DepartureTime(21, 56), new DepartureTime(22, 22),
			new DepartureTime(22, 46), new DepartureTime(23, 10), new DepartureTime(23, 34), new DepartureTime(0, 0),
			new DepartureTime(0, 27), new DepartureTime(0, 53), };

	private static DepartureTime[] route66south = new DepartureTime[] { new DepartureTime(5, 29),
			new DepartureTime(6, 0), new DepartureTime(6, 31), new DepartureTime(7, 1), new DepartureTime(7, 27),
			new DepartureTime(8, 1), new DepartureTime(8, 29), new DepartureTime(8, 59), new DepartureTime(9, 25),
			new DepartureTime(9, 55), new DepartureTime(10, 23), new DepartureTime(10, 49), new DepartureTime(11, 17),
			new DepartureTime(11, 46), new DepartureTime(12, 16), new DepartureTime(12, 46), new DepartureTime(13, 16),
			new DepartureTime(13, 46), new DepartureTime(14, 16), new DepartureTime(14, 46), new DepartureTime(15, 19),
			new DepartureTime(15, 52), new DepartureTime(16, 22), new DepartureTime(16, 49), new DepartureTime(17, 19),
			new DepartureTime(17, 48), new DepartureTime(18, 15), new DepartureTime(18, 43), new DepartureTime(19, 14),
			new DepartureTime(19, 43), new DepartureTime(20, 16), new DepartureTime(20, 49), new DepartureTime(21, 20),
			new DepartureTime(21, 50), new DepartureTime(22, 20), new DepartureTime(22, 50), new DepartureTime(23, 19),
			new DepartureTime(23, 49), new DepartureTime(0, 19), new DepartureTime(0, 46), };

	private static DepartureTime computeStartTimeWithSafety(final DepartureTime departureTime) {
		Schedule.CALENDAR.set(Calendar.HOUR_OF_DAY, departureTime.getHours());
		Schedule.CALENDAR.set(Calendar.MINUTE, departureTime.getMinutes());
		Schedule.CALENDAR.add(Calendar.MINUTE, -SAFETY_TIME);

		return new DepartureTime(Schedule.CALENDAR.get(Calendar.HOUR_OF_DAY), Schedule.CALENDAR.get(Calendar.MINUTE));
	}

	public void beforeClosing() {
	}

	public Appointment[] getDayAppointments(final ATime time) {
		final List<Appointment> appointments = new ArrayList<>();
		final AppProperties appointmentProperties = new AppProperties();
		appointmentProperties.setCategory("Bus route");
		appointmentProperties.setFadeOnEnd(true);
		appointmentProperties.setOverlap(true);
		appointmentProperties.setShowEnd(false);
		appointmentProperties.setShowStart(false);

		// Yann 2004/01/16: Dynamicity!
		// I create appointments dynamically to make sure that
		// SpiraClock displays bus departure for the current
		// day and time SpiraClock shows.

		/* ROUTE 105 */
		appointmentProperties.setColor(Color.BLUE);
		for (int i = 0; i < Schedule.route105east.length; i++) {
			final ATime appointmentStart = new ATime(time.year, time.dayOfYear,
					Schedule.computeStartTimeWithSafety(route105east[i]).getHours(),
					Schedule.computeStartTimeWithSafety(route105east[i]).getMinutes(), 0);
			ATime appointmentEnd = new ATime(time.year, time.dayOfYear, Schedule.route105east[i].getHours(),
					Schedule.route105east[i].getMinutes(), 0);
			appointments.add(new Appointment(appointmentStart, appointmentEnd, "Route 105 east", "From Home to Vendôme",
					appointmentProperties));
		}

		/* ROUTE 66 */
		appointmentProperties.setColor(Color.RED);
		for (int i = 0; i < Schedule.route66south.length; i++) {
			final ATime appointmentStart = new ATime(time.year, time.dayOfYear,
					Schedule.computeStartTimeWithSafety(route66south[i]).getHours(),
					Schedule.computeStartTimeWithSafety(route66south[i]).getMinutes(), 0);
			ATime appointmentEnd = new ATime(time.year, time.dayOfYear, Schedule.route66south[i].getHours(),
					Schedule.route66south[i].getMinutes(), 0);
			appointments.add(new Appointment(appointmentStart, appointmentEnd, "Route 66 South",
					"From Viviane's to Guy-Concordia", appointmentProperties));
		}

		final Appointment[] arrayOfAppointments = new Appointment[appointments.size()];
		appointments.toArray(arrayOfAppointments);
		return arrayOfAppointments;
	}

	public String getName() {
		return "STM routes 105 and 66 to Concordia downtown";
	}

	public Hashtable<String, Object> getProperties() {
		return null;
	}

	public void reload() {
	}

	public void setProperties(@SuppressWarnings("rawtypes") final Hashtable properties) {
	}
}

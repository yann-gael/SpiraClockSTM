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
package yann.schedule.bus.y2004;

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
	private static DepartureTime[] route165 = new DepartureTime[] { new DepartureTime(5, 45), new DepartureTime(6, 14),
			new DepartureTime(6, 29), new DepartureTime(9, 27), new DepartureTime(15, 8, 300),
			new DepartureTime(15, 14), new DepartureTime(18, 27), new DepartureTime(18, 32), new DepartureTime(18, 37),
			new DepartureTime(18, 43), new DepartureTime(18, 50), new DepartureTime(18, 58), new DepartureTime(19, 6),
			new DepartureTime(19, 14), new DepartureTime(19, 23), new DepartureTime(19, 31), new DepartureTime(19, 39),
			new DepartureTime(19, 48), new DepartureTime(19, 57), new DepartureTime(20, 5), new DepartureTime(20, 14),
			new DepartureTime(20, 23), new DepartureTime(20, 33), new DepartureTime(20, 42), new DepartureTime(20, 52),
			new DepartureTime(21, 2), new DepartureTime(21, 12), new DepartureTime(21, 22), new DepartureTime(21, 32),
			new DepartureTime(21, 42), new DepartureTime(21, 52), new DepartureTime(22, 2), new DepartureTime(22, 11),
			new DepartureTime(22, 21), new DepartureTime(22, 35), new DepartureTime(22, 49), new DepartureTime(23, 14),
			new DepartureTime(23, 39), new DepartureTime(0, 4), new DepartureTime(0, 29), new DepartureTime(0, 54) };

	private static DepartureTime[] route166 = new DepartureTime[] { new DepartureTime(6, 10), new DepartureTime(6, 41),
			new DepartureTime(7, 11), new DepartureTime(7, 41), new DepartureTime(8, 13), new DepartureTime(8, 43),
			new DepartureTime(9, 13), new DepartureTime(9, 43), new DepartureTime(10, 11), new DepartureTime(10, 41),
			new DepartureTime(11, 11), new DepartureTime(11, 42), new DepartureTime(12, 14), new DepartureTime(12, 44),
			new DepartureTime(13, 14), new DepartureTime(13, 44), new DepartureTime(14, 14), new DepartureTime(14, 44),
			new DepartureTime(15, 14), new DepartureTime(15, 43), new DepartureTime(16, 12), new DepartureTime(16, 41),
			new DepartureTime(17, 10), new DepartureTime(17, 39), new DepartureTime(18, 8), new DepartureTime(18, 25),
			new DepartureTime(19, 6), new DepartureTime(19, 38), new DepartureTime(20, 10), new DepartureTime(20, 42),
			new DepartureTime(21, 14), new DepartureTime(21, 45), new DepartureTime(22, 20), new DepartureTime(22, 56),
			new DepartureTime(23, 32), new DepartureTime(0, 9) };

	private static DepartureTime[] route535 = new DepartureTime[] { new DepartureTime(6, 42), new DepartureTime(7, 2),
			new DepartureTime(9, 16, 120), new DepartureTime(9, 22), new DepartureTime(15, 13),
			new DepartureTime(18, 17, 180), new DepartureTime(18, 23) };

	private static final Calendar CALENDAR = Calendar.getInstance();

	private static DepartureTime computeStartTimeWithSafety(final DepartureTime departureTime) {
		Schedule.CALENDAR.set(Calendar.HOUR_OF_DAY, departureTime.getHours());
		Schedule.CALENDAR.set(Calendar.MINUTE, departureTime.getMinutes());
		Schedule.CALENDAR.add(Calendar.MINUTE, -departureTime.getSafetyTime());

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

		/* ROUTE 165 */
		appointmentProperties.setColor(Color.BLUE);
		for (int i = 0; i < Schedule.route165.length; i++) {
			final ATime appointmentStart = new ATime(time.year, time.dayOfYear,
					Schedule.computeStartTimeWithSafety(route165[i]).getHours(),
					Schedule.computeStartTimeWithSafety(route165[i]).getMinutes(), 0);
			ATime appointmentEnd = new ATime(time.year, time.dayOfYear, Schedule.route165[i].getHours(),
					Schedule.route165[i].getMinutes(), 0);
			appointments.add(new Appointment(appointmentStart, appointmentEnd, "Route 165",
					"From Queen Mary to Downtown", appointmentProperties));
		}

		/* ROUTE 166 */
		appointmentProperties.setColor(Color.RED);
		for (int i = 0; i < Schedule.route166.length; i++) {
			final ATime appointmentStart = new ATime(time.year, time.dayOfYear,
					Schedule.computeStartTimeWithSafety(route166[i]).getHours(),
					Schedule.computeStartTimeWithSafety(route166[i]).getMinutes(), 0);
			ATime appointmentEnd = new ATime(time.year, time.dayOfYear, Schedule.route166[i].getHours(),
					Schedule.route166[i].getMinutes(), 0);
			appointments.add(new Appointment(appointmentStart, appointmentEnd, "Route 166",
					"From Queen Mary to Downtown", appointmentProperties));
		}

		/* ROUTE 525 */
		appointmentProperties.setColor(Color.GREEN);
		for (int i = 0; i < Schedule.route535.length; i++) {
			final ATime appointmentStart = new ATime(time.year, time.dayOfYear,
					Schedule.computeStartTimeWithSafety(route535[i]).getHours(),
					Schedule.computeStartTimeWithSafety(route535[i]).getMinutes(), 0);
			ATime appointmentEnd = new ATime(time.year, time.dayOfYear, Schedule.route535[i].getHours(),
					Schedule.route535[i].getMinutes(), 0);
			appointments.add(new Appointment(appointmentStart, appointmentEnd, "Route 535",
					"From Queen Mary to Downtown", appointmentProperties));
		}

		final Appointment[] arrayOfAppointments = new Appointment[appointments.size()];
		appointments.toArray(arrayOfAppointments);
		return arrayOfAppointments;
	}

	public String getName() {
		return "STM routes 165, 166, and 525 from UdeM to downtown";
	}

	public Hashtable<String, Object> getProperties() {
		return null;
	}

	public void reload() {
	}

	public void setProperties(@SuppressWarnings("rawtypes") final Hashtable properties) {
	}
}

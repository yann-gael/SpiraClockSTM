
package fr.emn.spiraclock;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

public class SpiraWindow extends JFrame {
	private class SpiraWindowListener implements WindowListener {
		@Override
		public void windowActivated(final WindowEvent e) {
		}

		@Override
		public void windowClosed(final WindowEvent e) {
			System.exit(0);
		}

		@Override
		public void windowClosing(final WindowEvent e) {
			if ((SpiraWindow.this.clock != null) && (SpiraWindow.this.clock.getSchedule() != null)) {
				SpiraWindow.this.clock.getSchedule().beforeClosing();
			}
			this.windowClosed(e);
		}

		@Override
		public void windowDeactivated(final WindowEvent e) {
		}

		@Override
		public void windowDeiconified(final WindowEvent e) {
			SpiraWindow.this.clock.followCurrentTime(true);
		}

		@Override
		public void windowIconified(final WindowEvent e) {
			SpiraWindow.this.clock.followCurrentTime(false);
		}

		@Override
		public void windowOpened(final WindowEvent e) {
			SpiraWindow.this.clock.followCurrentTime(true);
		}
	}

	private static final Dimension PREFERRED_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private static final long serialVersionUID = 5351676786217065038L;
	private final SpiraWindowListener spiraWindowListener = new SpiraWindowListener();
	private final JSpiraclock clock;

	public SpiraWindow(final JSpiraclock clock) {
		super("SpiraClock");

		final Hashtable<String, Object> properties = new Hashtable<>();
		properties.put("SHOWDIGIT", true);
		properties.put("SHOWDATE", true);
		properties.put("HOURWIDTH", 20.0D);
		properties.put("SHOWBORDER", false);
		properties.put("TOP", true);
		properties.put("SHOWNIGHT", false);
		properties.put("BDAY", 480);
		properties.put("EDAY", 1080);
		properties.put("POS", new Rectangle(new Point(0, 0), PREFERRED_SIZE));
		properties.put("SPLASH", false);

		this.clock = clock;
		this.clock.setProperties(properties);
		this.clock.getSchedule().setProperties(properties);
		this.clock.updateAppointments();

		super.getContentPane().add(clock, "Center");
		super.addWindowListener(this.spiraWindowListener);
		super.setSize(PREFERRED_SIZE);
	}

	public SpiraWindow(final Schedule sc) {
		this(new JSpiraclock(sc));
	}

	public void installPopupCommands(final JPopupMenu popup) {
	}
}
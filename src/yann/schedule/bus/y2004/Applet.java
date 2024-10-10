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

import java.awt.BorderLayout;

import fr.emn.spiraclock.JSpiraclock;

/**
 * @author Yann-Ga�l Gu�h�neuc
 * @since 2004/05/18
 */
@SuppressWarnings("removal")
public class Applet extends java.applet.Applet {
	private static final long serialVersionUID = -5893175922603914634L;

	private JSpiraclock clock;

	public void init() {
		final Schedule schedule = new Schedule();
		this.clock = new JSpiraclock(schedule);
		this.setLayout(new BorderLayout());
		this.add(clock, BorderLayout.CENTER);
	}

	public void start() {
		super.start();

		this.clock.followCurrentTime(true);
	}

	public void stop() {
		super.stop();

		this.clock.followCurrentTime(false);
	}
}

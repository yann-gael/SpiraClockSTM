SpiraClock SDK v1.0
Authors: Stéphane Huot & Pierre Dragicevic
powered by SpiraClock v1.1e by Pierre Dragicevic & Stéphane Huot

1. Description -----------------------------------------------------------------

   SpiraClock SDK allows you to devellop your own SpiraClock powered application 
   or applet !!!

   Contacts: Stephane.Huot@emn.fr
             Pierre.Dragicevic@emn.fr

   Web: http://www.emn.fr/spiraclock

   Users Group and Discussion Board: http://groups.yahoo.com/group/spiraclock


   CREDITS:

   The 'Always on top' feature is developed by
   Oliver Pfeiffer (http://www.mysrc.net/eng/).

   Java COM bridge for Outlook communication is made with Jacob, developed
   by Dan Adler (http://www.danadler.com/jacob/)


2. Files -----------------------------------------------------------------------

   * SpiraClock.jar: the SpiraClock api
   * SpiraClock-doc.jar: the SpiraClock api documentation
   * jacob.dll: com bridge dll used for OutClock (see JacobCopyright.txt)
   * WinAlwaysOnTop.dll: the dll used for Always on top feature (see 
AlwaysOnTopCopyright.txt)
   * Copyright.txt: the SpiraClock license
   * /Graphics/*: various SpiraClock related graphic files (splash, logos,
 icons, ...)
   * /Examples/*:
	* ExampleSchedule.java: sample detailled code for an example 
SpiraClocked application
	* EMNBusClock/: source code of the first SpiraClocked application

3. Designing your SpiraClock application ---------------------------------------

   * see the detailled code of ExampleSchedule.java to design your own 
SpiraClock standalone application
   * for more details, see EMNBusSchedule code for an application, and 
EMNBusApplet for an applet. You can run EMNBusClock with: java -jar SpiraClock.jar
   * compiling your application: don't forget to include SpiraClock.jar in your 
classpath
   * running your application: WinAlwaysOnTop.dll must be in your classes
 directory


4. Known bugs ------------------------------------------------------------------

FIXED * #001 Moving hands too far (i.e. several months) will throw an exception
	  while they return to their original position (fixed in v1.0a11c).
FIXED * #002 Spiraclock only displays events from the current year (fixed in
          v1.0a11d).
FIXED * #003 Serious problems with english date formats (partly fixed in v1.0b11d).
FIXED * #004 Night shadowing does not always update properly (fixed in v1.0c11e).
FIXED * #005 "Main method not public" exception within j2re 1.4 (fixed in v1.0c11e).
   * #006 When launching OutClock, an error message says that smartj can't find
          OutlookSchedule.class. It seems to be a bug from smartj. As a
          workaround, download and install full distribution of OutClock.

5. Requirements ----------------------------------------------------------------

   * Windows 95, 98, NT, 2000 or XP.
   * Microsoft Outlook.
   COMPACT DISTRIBUTION ONLY:
   * Java 1.3 or higher (performs better with 1.3 than 1.4).

6. Using SpiraClock ------------------------------------------------------------

   * Spiraclock Applets and Applications:

   - Looking ahead/backward in time: Drag the minute hand.
   - Fast looking ahead/backward: Drag the hour hand.
   - Resetting to current time: Move the mouse out of the component.
   - Changing time extent: Drag the spiral toward its center or its border.
   - Showing/hiding the digital clock or current date: use the contextual
     menu (right button in Windows).
   - View event full description (if exists): click on the event and keep
     the button pressed
   - Reaching an event : double-click on the event
   - Toggle minute/hour coordinates frame: double-click on minute/hour hand

   * SpiraClock Applications only:

   - Resizing the clock: Drag window background toward spiral's center or
     outside.
   - Moving the window: Shift-drag window background.
   - Using the contextual menu, you can also add/remove window borders, close
     the window, or set it to be always on top. This last feature works
     only in Windows platforms. Some window managers have this feature
     built-in.
   - The showNight option progressively shadows Spiraclock background during
     "night". You can specify "day"'s begin and end times with the contextual
     menu.
   - Disable the Splash screen using the contextual menu.

package se.mah.k3;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class FireBase {
	private Firebase myFirebaseRef;
	private String ID; // To do
	private FirebaseData fbData = new FirebaseData();
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private String lastTheme = "Circles";
	private ThemeInterface themeInterface;
	Timer timer;

	public FireBase() {
		themeInterface = FullScreen.setUpTheme("Circles"); // Default screen
		myFirebaseRef = new Firebase(
				"https://popping-torch-1741.firebaseio.com/");
		myFirebaseRef.removeValue(); // Cleans out everything
		myFirebaseRef.child("ScreenNbr").setValue(145);
		myFirebaseRef.child("Active").setValue(Constants.falseValue);

		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildRemoved(DataSnapshot arg0) {
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
			}

			// A user changed some value so update
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				Iterable<DataSnapshot> dsList = arg0.getChildren();
				// Snapshot is listening for changes, and getting the data.
				for (DataSnapshot dataSnapshot : dsList) {
				}
			}

			// We got a new user
			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				// This is called the first when opened so lets add something to
				// initiate a call to onChildChanged

				// SET TIME HERE

				new Reminder(49990);
				getID();

				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						// Your database code here

					}
				}, 2 * 60 * 1000);

				if (arg0.hasChildren()) {
					// Nothing here, move on..
				}
			}

			@Override
			public void onCancelled(FirebaseError arg0) {

			}
		});

	}

	public void getID() {
		System.out.println("getID started");

		Firebase myFirebaseRef = new Firebase(
				"https://popping-torch-1741.firebaseio.com/");

		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				String temp;
				if (arg0.getKey().length() == 26) {
					temp = arg0.getKey();
					getActive(temp);
				}

				themeInterface.updateData(fbData);
			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void getActive(String temp) {
		final String theTemp = temp;

		Firebase myFirebaseRef = new Firebase(
				"https://popping-torch-1741.firebaseio.com/" + temp);

		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {

				// Så här långt har jag kommit, vet inte varför datasnapshot
				// INTE innehåller något värde alls...
				// Firebase referensen är korrekt, IDt är korrekt... Men ändå
				// inget data.
				// I övrigt så ska resten utav programmet nog fungera hyffsat.

			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {

				if (arg0.getKey().equals("Active")) {
					boolean tempBool = (Boolean) arg0.getValue();
					System.out.println(tempBool);
					if (tempBool == true) {
						fbData.setActiveID(theTemp);
						System.out.println("The active is: " + theTemp);
						getIDData();
					}
				}
				themeInterface.updateData(fbData);
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void getIDData() {
		System.out.println("getIDData started");
		final Firebase myFirebaseRef = new Firebase(
				"https://popping-torch-1741.firebaseio.com/"
						+ fbData.getActiveID());
		System.out.println("The url: " + myFirebaseRef);

		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {

			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub

				// System.out.println("das " + arg0);

				if (arg0.getKey().equals("Question")) {

					fbData.setQuestion((String) arg0.getValue());
				}

				if (arg0.getKey().equals("Theme")) {

					fbData.setTheme((String) arg0.getValue());
					if (arg0.getValue() != null) {
						myFirebaseRef.child("Active").setValue(true);
					}
				}

				if (arg0.getKey().equals("Creator")) {
					fbData.setCreator((String) arg0.getValue());
				}

				Iterable<DataSnapshot> dsList = arg0.getChildren();

				for (DataSnapshot dataSnapshot : dsList) {

					System.out.println(dataSnapshot);

					if (arg0.getKey().equals("Alt: 1")) {
						fbData.setVote1((long) arg0.getValue());
						fbData.addVotes((int) arg0.getValue());
					}
					if (arg0.getKey().equals("Alt: 2")) {
						fbData.setVote2((long) arg0.getValue());
						fbData.addVotes((int) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt: 3")) {
						fbData.setVote3((long) arg0.getValue());
						fbData.addVotes((int) arg0.getValue());
					}
					if (arg0.getKey().equals("Alt: 4")) {
						fbData.setVote4((long) arg0.getValue());
						fbData.addVotes((int) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt: 5")) {
						fbData.setVote5((long) arg0.getValue());
						fbData.addVotes((int) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt: 6")) {
						fbData.setVote6((long) arg0.getValue());
						fbData.addVotes((int) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt1")) {
						fbData.setAlt1(((String) arg0.getValue()));
						fbData.addAnswer((String) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt2")) {
						fbData.setAlt2(((String) arg0.getValue()));
						fbData.addAnswer((String) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt3")) {
						fbData.setAlt3(((String) arg0.getValue()));
						fbData.addAnswer((String) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt4")) {
						fbData.setAlt4(((String) arg0.getValue()));
						fbData.addAnswer((String) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt5")) {
						fbData.setAlt5(((String) arg0.getValue()));
						fbData.addAnswer((String) arg0.getValue());
					}

					if (arg0.getKey().equals("Alt6")) {
						fbData.setAlt6(((String) arg0.getValue()));
						fbData.addAnswer((String) arg0.getValue());
					}

				}

				themeInterface.updateData(fbData);

			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub

			}
		});

		if (!lastTheme.equals(fbData.getTheme())) {
			themeInterface = FullScreen.setUpTheme(fbData.getTheme());
			lastTheme = fbData.getTheme();
		}
	}

	public class Reminder {

		public Reminder(int seconds) {
			timer = new Timer();
			timer.schedule(new RemindTask(), seconds * 1000);
		}

		class RemindTask extends TimerTask {
			public void run() {
				myFirebaseRef.child("Active").setValue(false);
				myFirebaseRef.child(fbData.getActiveID()).child("Active")
						.setValue(false);
				System.out.format("Time's up!%n");
				themeInterface = FullScreen.setUpTheme("Circles");
				timer.cancel(); // Terminate the timer thread
			}
		}

	}

}

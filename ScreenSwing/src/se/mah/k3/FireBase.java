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

		myFirebaseRef = new Firebase(
				"https://popping-torch-1741.firebaseio.com/");

		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				String temp;
				if (arg0.getKey().length() == 26) {
					temp = arg0.getKey();
					getActive(temp);
				}

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

		myFirebaseRef = new Firebase("https://popping-torch-1741.firebaseio.com/"+temp+"/Active");
		
		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				System.out.println(arg0);
				System.out.println(arg1);

				//Så här långt har jag kommit, vet inte varför datasnapshot INTE innehåller något värde alls...
				//Firebase referensen är korrekt, IDt är korrekt... Men ändå inget data.
				//I övrigt så ska resten utav programmet nog fungera hyffsat.

			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				System.out.println(arg0);
				System.out.println(arg1);
				
				boolean tempBool = (Boolean) arg0.getValue();
				System.out.println(tempBool);
				if (tempBool == true) {
					fbData.setActiveID(theTemp);
					System.out.println("The active is: " + theTemp);
					getIDData();
				}
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
		myFirebaseRef = new Firebase(
				"https://popping-torch-1741.firebaseio.com/"
						+ fbData.getActiveID() + "/Active");

		myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				Iterable<DataSnapshot> dsList = arg0.getChildren();

				for (DataSnapshot dataSnapshot : dsList) {
					if (dataSnapshot.getKey().equals("Question")) {
						System.out.println("New Question: "
								+ (String) dataSnapshot.getValue());
						fbData.setQuestion((String) dataSnapshot.getValue());
					}

					if (dataSnapshot.getKey().equals("Theme")) {
						// System.out.println("New theme: "+(String)dataSnapshot.getValue());
						fbData.setTheme((String) dataSnapshot.getValue());
						if (dataSnapshot.getValue() != null) {
							myFirebaseRef.child("Active").setValue(true);
						}
					}

					String alt1 = null;
					if (dataSnapshot.child("Votes").getKey().equals("Alt: 1")) {
						fbData.setAlt1((String) dataSnapshot.getValue());
					}
					String alt2 = null;
					if (dataSnapshot.child("Votes").getKey().equals("Alt: 2")) {
						fbData.setAlt2((String) dataSnapshot.getValue());
					}
					String alt3 = null;
					if (dataSnapshot.child("Votes").getKey().equals("Alt: 3")) {
						fbData.setAlt3((String) dataSnapshot.getValue());
					}
					String alt4 = null;
					if (dataSnapshot.child("Votes").getKey().equals("Alt: 4")) {
						fbData.setAlt4((String) dataSnapshot.getValue());
					}

					String alt5 = null;
					if (dataSnapshot.child("Votes").getKey().equals("Alt: 5")) {
						fbData.setAlt5((String) dataSnapshot.getValue());
					}

					String alt6 = null;
					if (dataSnapshot.child("Votes").getKey().equals("Alt: 6")) {
						fbData.setAlt6((String) dataSnapshot.getValue());
					}

					long vote1 = 0;
					if (dataSnapshot.child("Alternatives").getKey()
							.equals("Vote1")) {
						fbData.setVote1(((long) dataSnapshot.getValue()));
					}

					long vote2 = 0;
					if (dataSnapshot.child("Alternatives").getKey()
							.equals("Vote2")) {
						fbData.setVote2(((long) dataSnapshot.getValue()));
					}

					long vote3 = 0;
					if (dataSnapshot.child("Alternatives").getKey()
							.equals("Vote3")) {
						fbData.setVote3(((long) dataSnapshot.getValue()));
					}

					long vote4 = 0;
					if (dataSnapshot.child("Alternatives").getKey()
							.equals("Vote4")) {
						fbData.setVote4(((long) dataSnapshot.getValue()));
					}

					long vote5 = 0;
					if (dataSnapshot.child("Alternatives").getKey()
							.equals("Vote5")) {
						fbData.setVote5(((long) dataSnapshot.getValue()));
					}

					long vote6 = 0;
					if (dataSnapshot.child("Alternatives").getKey()
							.equals("Vote6")) {
						fbData.setVote6(((long) dataSnapshot.getValue()));
					}
					themeInterface.updateData(fbData);
				}
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
				timer.cancel(); // Terminate the timer thread
			}
		}

	}

}

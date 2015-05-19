package se.mah.k3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class FireBase {
	private Firebase myFirebaseRef;
	private Vector<User> users = new Vector<User>();
	private String ID; // To do
	private FirebaseData fbData;
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private String theme;
	private ThemeInterface themeInterface;
	

	
	public FireBase(){
		myFirebaseRef = new Firebase("https://popping-torch-1741.firebaseio.com/");
		myFirebaseRef.removeValue(); //Cleans out everything
		myFirebaseRef.child("ScreenNbr").setValue(Constants.screenNbr);  //Has to be same as on the app. So place specific can't you see the screen you don't know the number
		fbData = new FirebaseData();
		
		 myFirebaseRef.addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildRemoved(DataSnapshot arg0) {}
			
			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {}
			
			//A user changed some value so update
			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				Iterable<DataSnapshot> dsList = arg0.getChildren();
				Collections.sort(users);
				int place = Collections.binarySearch(users, new User(arg0.getKey(),0,0)); //Find the user username has to be unique uses the method compareTo in User
				
				//Snapshot is listening for changes, and getting the data.
				for (DataSnapshot dataSnapshot : dsList) {


					if (dataSnapshot.getKey().equals("Question")){
						 fbData.setQuestion((String)dataSnapshot.getValue());
					 }
					
					if (dataSnapshot.getKey().equals("Theme")){
						theme = (String)dataSnapshot.getValue();
						fbData.setTheme(theme);						// Returns Null ;(
					}
					
					themeInterface = FullScreen.setUpTheme("string");
					
																								//      H  A  S  H  M  A  P
					/*if (dataSnapshot.getKey().equals("four")){
						 Map<String, Object> newPost = (Map<String, Object>) arg0.getValue();
					     System.out.println("Answer: " + newPost.get("alternative"));
					     System.out.println("Votes: " + newPost.get("votes"));
					 }
					
					*/
					String alt1 = null;
					if (dataSnapshot.getKey().equals("Alt1")){
						 alt1 = (String)dataSnapshot.getValue();
					 }
					String alt2 = null;
					if (dataSnapshot.getKey().equals("Alt2")){
						 alt2 = (String)dataSnapshot.getValue();
					 }
					String alt3 = null;
					if (dataSnapshot.getKey().equals("Alt3")){
						 alt3 = (String)dataSnapshot.getValue();
					 }
					String alt4 = null;
					if (dataSnapshot.getKey().equals("Alt4")){
						 alt4 = (String)dataSnapshot.getValue();
					 }
					
					long vote1 = 0;
					if (dataSnapshot.getKey().equals("Vote1")){
						 vote1 = ((long)dataSnapshot.getValue()); 
					}
					
					long vote2 = 0;
					if (dataSnapshot.getKey().equals("Vote2")){
						 vote2 = ((long)dataSnapshot.getValue()); 
					}
					
					long vote3 = 0;
					if (dataSnapshot.getKey().equals("Vote3")){
						 vote3 = ((long)dataSnapshot.getValue()); 
					}
					
					long vote4 = 0;
					if (dataSnapshot.getKey().equals("Vote4")){
						 vote4 = ((long)dataSnapshot.getValue()); 
					}
					
					Integer x1 = (int) vote1;
					Integer x2 = (int) vote2;
					Integer x3 = (int) vote3;
					Integer x4 = (int) vote4;

					map.put(alt1, x1);
					map.put(alt2, x2);
					map.put(alt3, x3);
					map.put(alt4, x4);
					
				 }
			}
			
			//We got a new user
			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				if (arg0.hasChildren()){
					//Nothing here, move on..
				}
			}
			
			
			@Override
			public void onCancelled(FirebaseError arg0) {
				
			}
		});
	}
	

}

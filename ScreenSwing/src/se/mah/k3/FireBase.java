package se.mah.k3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class FireBase {
	private Firebase myFirebaseRef;
	private String ID; // To do
	private FirebaseData fbData;
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private String lastTheme = "Circles";
	private ThemeInterface themeInterface;
	Timer timer;


	

	
	public FireBase(){
		themeInterface = FullScreen.setUpTheme("Circles");  //Default screen
		myFirebaseRef = new Firebase("https://popping-torch-1741.firebaseio.com/");
		myFirebaseRef.removeValue(); //Cleans out everything
		myFirebaseRef.child("ScreenNbr").setValue(145); //Has to be same as on the app. So place specific can't you see the screen you don't know the number
    	myFirebaseRef.child("Active").setValue(Constants.falseValue);
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
				
				//Snapshot is listening for changes, and getting the data.
				for (DataSnapshot dataSnapshot : dsList) {


					if (dataSnapshot.getKey().equals("Question")){
						//System.out.println("New Question: "+(String)dataSnapshot.getValue());
						 fbData.setQuestion((String)dataSnapshot.getValue());
					 }
					
					if (dataSnapshot.getKey().equals("Theme")){
						//System.out.println("New theme: "+(String)dataSnapshot.getValue());
						fbData.setTheme((String)dataSnapshot.getValue());
						if(dataSnapshot.getValue() != null){
				        	myFirebaseRef.child("Active").setValue(true);
						}
					}
										
									
					//      H  A  S  H  M  A  P
					
			/*		for(int i = 0; i<10; i++){
						String index = Integer.toString(i);
					if (dataSnapshot.getKey().equals(index)){
						 //HashMap<String, Integer> newPost = (HashMap<String, Integer>) arg0.getValue();
						 //System.out.println("newPost "+newPost);
						 
						 //fbData.setInData(newPost);
						 
							Map<String, Object> newPost2 = (Map<String, Object>) arg0.getValue();
							Set<String> keys = newPost2.keySet();
							
							for(String key: keys){
								//System.out.println(key);
								//System.out.println(" "+newPost2.get(key));
								
								
								
								
								@SuppressWarnings("unchecked")
								HashMap<Long, HashMap<String, Long>> mapp = (HashMap<Long, HashMap<String, Long>>) newPost2.get(key);
								
								if(mapp.equals("alternative")){
									System.out.println(mapp);
								}
								
								
								
								if(key.equals("alternative")){
									//System.out.println(key);
								}
							}
							
						 
						 Iterable<DataSnapshot> fourChildren = dataSnapshot.getChildren();
						 for (DataSnapshot dataSnapshot2 : fourChildren) {
							 							 
							if (dataSnapshot2.getKey().equals("alternative")){
								System.out.println("alternative: "+dataSnapshot2.getValue());
							}
							if (dataSnapshot2.getKey().equals("votes")){
								System.out.println("votes: "+dataSnapshot2.getValue());
							}
						} 
					 } 
					 
					
					
					} */

					String alt1 = null;
					if (dataSnapshot.getKey().equals("Alt1")){
						 fbData.setAlt1((String)dataSnapshot.getValue());
					 }
					String alt2 = null;
					if (dataSnapshot.getKey().equals("Alt2")){
						 fbData.setAlt2((String)dataSnapshot.getValue());
					 }
					String alt3 = null;
					if (dataSnapshot.getKey().equals("Alt3")){
						 fbData.setAlt3((String)dataSnapshot.getValue());
					 }
					String alt4 = null;
					if (dataSnapshot.getKey().equals("Alt4")){
						 fbData.setAlt4((String)dataSnapshot.getValue());
					 }
					
					long vote1 = 0;
					if (dataSnapshot.getKey().equals("Vote1")){
						 fbData.setVote1(((long)dataSnapshot.getValue())); 
					}
					
					long vote2 = 0;
					if (dataSnapshot.getKey().equals("Vote2")){
						fbData.setVote2(((long)dataSnapshot.getValue())); 
					}
					
					long vote3 = 0;
					if (dataSnapshot.getKey().equals("Vote3")){
						fbData.setVote3(((long)dataSnapshot.getValue())); 
					}
					
					long vote4 = 0;
					if (dataSnapshot.getKey().equals("Vote4")){
						fbData.setVote4(((long)dataSnapshot.getValue())); 
					}
					
					//OK tell the panel that there is data
					
//					Integer x1 = (int) vote1;
//					Integer x2 = (int) vote2;
//					Integer x3 = (int) vote3;
//					Integer x4 = (int) vote4;
//
//					map.put(alt1, x1);
//					map.put(alt2, x2);
//					map.put(alt3, x3);
//					map.put(alt4, x4);
					
				 }
				
				//Nu har vi all ny data.
				//Change screen if there is a new theme
				if (!lastTheme.equals(fbData.getTheme())){
					themeInterface = FullScreen.setUpTheme(fbData.getTheme());
					lastTheme = fbData.getTheme();
				}
				//Tell the interface that there are changes
				themeInterface.updateData(fbData);
			}
				
			
			//We got a new user
			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				//This is called the first when opened so lets add something to initiate a call to onChildChanged
				
//SET TIME HERE
				
				new Reminder(49990);

				timer.schedule(new TimerTask() {
					  @Override
					  public void run() {
					    // Your database code here

					  }
					}, 2*60*1000);
				
				if (arg0.hasChildren()){
					//Nothing here, move on..
				}
			}
			
			
			@Override
			public void onCancelled(FirebaseError arg0) {
				
			}
		});
		
	}
	
	public class Reminder{
	
	public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
        	myFirebaseRef.child("Active").setValue(false);
            System.out.format("Time's up!%n");
            timer.cancel(); //Terminate the timer thread
        }
    }
    
	}
 
	

}

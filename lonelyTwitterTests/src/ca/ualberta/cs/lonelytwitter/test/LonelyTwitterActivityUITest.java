package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
@SuppressLint("NewApi")
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testAddTweet() throws Throwable {
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run(){
				makeTweet("hi there #testing");
			}
		});
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
	public void testNewElement() throws Throwable{
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run(){
				ListView listView = (ListView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList);
				@SuppressWarnings("unchecked")
				ArrayAdapter<NormalTweetModel> a = (ArrayAdapter<NormalTweetModel>) listView.getAdapter();
				int size = a.getCount();
				makeTweet("hi there #testing");
				int sizeAfter = a.getCount();
				assertEquals(size+1, sizeAfter);
				
			}
		});
	}
	
	public void testAddedTweetModel() throws Throwable{
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run(){
				ListView listView = (ListView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList);
				@SuppressWarnings("unchecked")
				ArrayAdapter<NormalTweetModel> a = (ArrayAdapter<NormalTweetModel>) listView.getAdapter();
				makeTweet("hi there #testing");
				int index = a.getCount()-1;
				assertEquals(NormalTweetModel.class, a.getItem(index).getClass());
				
			}
		});
	}
	
	public void testAddedText() throws Throwable{
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run(){
				ListView listView = (ListView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList);
				@SuppressWarnings("unchecked")
				ArrayAdapter<NormalTweetModel> a = (ArrayAdapter<NormalTweetModel>) listView.getAdapter();
				String text = "hi there #testing";
				makeTweet(text);
				int index = a.getCount()-1;
				assertEquals(text, a.getItem(index).getText());
				
			}
		});
	}
}

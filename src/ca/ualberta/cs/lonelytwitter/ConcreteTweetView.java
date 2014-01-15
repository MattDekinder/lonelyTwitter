package ca.ualberta.cs.lonelytwitter;

public class ConcreteTweetView implements TweetView
{

	public String formatTweet(LonelyTweetModel It){
		return It.getTimestamp().toString() + " | " + It.getText();
	}

}

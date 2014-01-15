package ca.ualberta.cs.lonelytwitter;


public class TweetListController{
	private static TweetListModel tweetListModel;

	public TweetListController()
	{
		super();
		if (tweetListModel == null){
		tweetListModel = new TweetListModel();
		}
	}
	
	public void addTweet(String text){
		It = new NormalTweetModel(text);
	}
	
}

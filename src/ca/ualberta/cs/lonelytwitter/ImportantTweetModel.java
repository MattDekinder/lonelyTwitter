package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class ImportantTweetModel extends LonelyTweetModel
{

	public ImportantTweetModel(String text, Date timestamp){
		super(text, timestamp);
		// TODO Auto-generated constructor stub
	}

	public ImportantTweetModel(String text){
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public void setText(String text){	
		this.text = text;
	}

	@Override
	public boolean isNormal(){
		return false;
	}

	@Override
	public void setImportant(boolean important) throws Exception
	{

		// TODO Auto-generated method stub
		
	}

}

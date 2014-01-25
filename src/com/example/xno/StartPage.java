package com.example.xno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartPage extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startpage);
		Thread game=new Thread(){
			public void run(){
				try{
					sleep(1000);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					Intent menu=new Intent("com.example.xno.MENU");
					startActivity(menu);
				}
			}
		};
		game.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
}

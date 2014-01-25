package com.example.xno;

//import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	int flag,j,m,n,ff=0;
	int id[]=new int[9];
	char game[][]=new char[3][3];
	int win;
	Button a,b,c,d,e,f,g,h,i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);
		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		i.setOnClickListener(this);
		}
	
	public void initialize() {
	Toast.makeText(getApplicationContext(), "Welcome !!!",Toast.LENGTH_LONG).show();
	a=(Button) findViewById(R.id.b1);
	b=(Button) findViewById(R.id.b2);
	c=(Button) findViewById(R.id.b3);
	d=(Button) findViewById(R.id.b4);
	e=(Button) findViewById(R.id.b5);
	f=(Button) findViewById(R.id.b6);
	g=(Button) findViewById(R.id.b7);
	h=(Button) findViewById(R.id.b8);
	i=(Button) findViewById(R.id.b9);
	flag=0;
	id[0]=R.id.b1;
	id[1]=R.id.b2;
	id[2]=R.id.b3;
	id[3]=R.id.b4;
	id[4]=R.id.b5;
	id[5]=R.id.b6;
	id[6]=R.id.b7;
	id[7]=R.id.b8;
	id[8]=R.id.b9;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		
	
			switch(id)
			{
				case R.id.b1: setbuttonText(a);
				break;
				case R.id.b2: setbuttonText(b);
				break;
				case R.id.b3: setbuttonText(c);
				break;
				case R.id.b4: setbuttonText(d);
				break;
				case R.id.b5: setbuttonText(e);
				break;
				case R.id.b6: setbuttonText(f);
				break;
				case R.id.b7: setbuttonText(g);
				break;
				case R.id.b8: setbuttonText(h);
				break;
				case R.id.b9: setbuttonText(i);
				break;
				default: Toast.makeText(this,"No button clicked", Toast.LENGTH_LONG).show();
		
			}
			win();
			ff++;
			if(ff==9 && win!=1)
			{
				
					Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_LONG).show();
					Intent restart= new Intent(getApplicationContext(),MainActivity.class);
				    startActivity(restart);
			}  
	}
	public void setbuttonText(Button but)
	{
	 if(flag==0)
	 {
	 	but.setText("X");
	 	for(int j=0;j<9;j++)
	 	{
	 		if(id[j]==but.getId()){
	 			m=j/3;
	 			n=(j%3);
	 			game[m][n]='X';
	 		}
	 	}
	 	flag=1;
	 }
	 else
	 {
 		but.setText("O");
 		for(j=0;j<9;j++)
	 	{
	 		if(id[j]==but.getId()){
	 			m=j/3;
	 			n=(j%3);
	 			game[m][n]='O';
	 		}
	 	}
		flag=0;
	 }
	
	but.setClickable(false);
	}
	
	public void win()
	{
		
	for(m=0;m<3;m++)
	{
		
		for(n=0;n<3;n++)
		{
			if(game[m][0]==game[m][1] && game[m][0]==game[m][2] && game[m][0]!='\u0000' )
		    {
		        winner();
		        break;
		    }
		}
	    
	}
	for(n=0;n<3;n++)
	   {
		if(game[0][n]==game[1][n] && game[0][n]==game[2][n] && game[0][n]!='\u0000')
	    {
	        winner();
	        break;
	    }
	   }
	if(game[0][0]==game[1][1] && game[0][0]==game[2][2] && game[0][0]!='\u0000'){
		winner();
	}
	if(game[0][2]==game[1][1] && game[0][2]==game[2][0] && game[1][1]!='\u0000'){
		winner();
	} 
	} 
	public void winner() {
	if(flag==1){Toast.makeText(getApplicationContext(), "Congratulations!!!Player1 wins", Toast.LENGTH_LONG).show();}
	if(flag==0){Toast.makeText(getApplicationContext(), "Congratulations!!!Player2 wins", Toast.LENGTH_LONG).show();}
    win=1;
	Intent restart= new Intent(getApplicationContext(),MainActivity.class);
    startActivity(restart);
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}

package app.buusk15.quiz02repair01_55410488;

import java.util.Random;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Play<getUserid> extends Activity implements OnClickListener {
	private Button btnp1, btnp2, btnp3,btnsh,btnc;
	private TextView txtshow1, txtshow2, txtshow3;
	private int rn, result;
	private String getUserid, put;
	int sum1 = 0;
	int sum2 = 0;
	int sum3 = 0;
	control488DB db = new control488DB(this);
	int con1 = 1,con0 = 0;	
	int total1 = 0,total2 = 0,total3 = 0;
	////////////////////////////
	int Score1,Score2,Score3;
	int strPlay1 = 1, strPlay2 = 2, strPlay3 = 3;		
	String strPlayer1 = "Player1",strPlayer2 = "Player2", strPlayer3 = "Player3";		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		btnp1 = (Button) findViewById(R.id.btnp1_488);
		btnp2 = (Button) findViewById(R.id.btnp2_488);
		btnp3 = (Button) findViewById(R.id.btnp3_488);
		btnsh = (Button) findViewById(R.id.btnsh_488);
		btnc = (Button) findViewById(R.id.btnc);
		btnp1.setOnClickListener(this);
		btnp2.setOnClickListener(this);
		btnp3.setOnClickListener(this);
		btnsh.setOnClickListener(this);
		btnc.setOnClickListener(this);
		
		getUserid = getIntent().getStringExtra("Userid");
		getUserid.toString();

	
	}

	private int random() {
		int rnds = 0;
		Random r = new Random();		
			rnds = r.nextInt(3 - 1 + 1) + 1;		
		return rnds;
	}

//	private int Firstrandom() {
//		Random r = new Random();
//		int rnd = r.nextInt(9 - 1 + 1) + 1;
//		return rnd;
//	}
	private int calpos(int sum1){
		result = random();
		sum1 = result+sum1;		
		return sum1;
	}

	@Override
	public void onClick(View v) {
			
		////////////////////////////
		switch (v.getId()) {
		case R.id.btnp1_488:		
			total1 = calpos(sum1);
			sum1 = total1;
			Score1 = db.RouteScore(total1); Score2 = db.RouteScore(con0); Score3 = db.RouteScore(con0);		
			db.InsertPlayStatus(strPlay1, result, strPlayer1, total1, con1, Score1);
			db.InsertPlayStatus(strPlay2, con0, strPlayer2, total2, con0, Score2);
			db.InsertPlayStatus(strPlay3, con0, strPlayer3, total3, con0, Score3);
			break;
			
		case R.id.btnp2_488:
			total2 = calpos(sum2);
			sum2 = total2;			
			Score1 = db.RouteScore(con0);Score2 = db.RouteScore(total2); Score3 = db.RouteScore(con0);		
			db.InsertPlayStatus(strPlay1, con0, strPlayer1, total1, con0, Score1);
			db.InsertPlayStatus(strPlay2, result, strPlayer2, total2, con1, Score2);
			db.InsertPlayStatus(strPlay3, con0, strPlayer3, total3, con0, Score3);
			break;
			
		case R.id.btnp3_488:	
			total3 = calpos(sum3);			
			sum3 = total3;			
			Score1 = db.RouteScore(con0);Score2 = db.RouteScore(con0); Score3 = db.RouteScore(total3);		
			db.InsertPlayStatus(strPlay1, con0, strPlayer1, total1, con0, Score1);
			db.InsertPlayStatus(strPlay2, con0, strPlayer2, total2, con0, Score2);
			db.InsertPlayStatus(strPlay3, result, strPlayer3, total3, con1, Score3);		
			break;
			
		case R.id.btnsh_488:
			Intent i = new Intent(getApplicationContext(),ShowPlayStatus.class);
			startActivity(i);
			break;
		case R.id.btnc:
			finish();
			break;
		default:
			break;
		}

	}

}

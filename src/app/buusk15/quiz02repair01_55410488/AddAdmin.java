package app.buusk15.quiz02repair01_55410488;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

public class AddAdmin extends Activity implements OnClickListener {

	private EditText e2, e3, e4;
	private Button add, show, play, close;
	private String getUserid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.addadmin);

		add = (Button) findViewById(R.id.btnadd_488);
		show = (Button) findViewById(R.id.btnshow_488);
		play = (Button) findViewById(R.id.btnplay_488);
		close = (Button) findViewById(R.id.btnclose_admin_488);

		add.setOnClickListener(this);
		show.setOnClickListener(this);
		play.setOnClickListener(this);
		close.setOnClickListener(this);
		
		getUserid = getIntent().getStringExtra("Userid");

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnadd_488:
			add();
			break;
		case R.id.btnshow_488:
			Intent i = new Intent(getApplicationContext(), Show.class);
			startActivity(i);
			break;
		case R.id.btnplay_488:
			Intent m = new Intent(getApplicationContext(), Play.class);
			m.putExtra("Userid", getUserid);			
			startActivity(m);
			break;
		case R.id.btnclose_admin_488:
			finish();
			break;
		default:
			break;
		}

	}

	private boolean add() {

		e2 = (EditText) findViewById(R.id.e2admin_488);
		e3 = (EditText) findViewById(R.id.e3_488);
		e4 = (EditText) findViewById(R.id.e4_488);

		final AlertDialog.Builder adb = new AlertDialog.Builder(this);

		AlertDialog ad = adb.create();

		if (e2.getText().length() == 0) {

			ad.setMessage("Please input Username");

			e2.requestFocus();

			return false;

		}

		if (e3.getText().length() == 0) {

			ad.setMessage("Please input Password");

			e3.requestFocus();

			return false;

		}

		if (e4.getText().length() == 0) {

			ad.setMessage("Please input Position");

			e4.requestFocus();

			return false;

		}

		control488DB dbclass = new control488DB(this);
		String getUserid = dbclass.checkId(e2.getText().toString());
		if (getUserid.equalsIgnoreCase("")) {
			long savedata = dbclass.InsertDataAdmin(e2.getText().toString(), e3
					.getText().toString(), e4.getText().toString());

			if (savedata <= 0) {

				ad.setMessage("Error !!!");

				ad.show();

				return false;

			}

			Toast.makeText(getApplicationContext(), "Add Data Successfully",
					Toast.LENGTH_SHORT).show();

		} else {
			Toast.makeText(getApplicationContext(), "Username has already",
					Toast.LENGTH_SHORT).show();
		}

		return true;
	}

}

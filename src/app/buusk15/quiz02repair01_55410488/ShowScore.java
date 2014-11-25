package app.buusk15.quiz02repair01_55410488;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowScore  extends Activity {
	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_488);
			String getUserid = getIntent().getStringExtra("Userid").toString();
			control488DB control488db = new control488DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control488db.SelectAllScore(getUserid);
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(ShowScore.this, MyArrayList, R.layout.itemscore, new String[]{"Scoreid","Userid","Score"},new int[]{R.id.ColScoreid_488,R.id.ColUserid_488,R.id.ColScore_488});
			ListView.setAdapter(adapter);
			
		}
	}

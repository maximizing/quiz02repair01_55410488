package app.buusk15.quiz02repair01_55410488;


	import java.util.ArrayList;
	import java.util.HashMap;

	import android.app.Activity;
	import android.os.Bundle;
	import android.widget.ListView;
	import android.widget.SimpleAdapter;

	public class Show  extends Activity {
	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_488);
			control488DB control488db = new control488DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control488db.SelectAllData();
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(Show.this, MyArrayList, R.layout.item, new String[]{"Userid","Username","Password","Position"},new int[]{R.id.ColUserid_488,R.id.ColUsername_488,R.id.ColPassword_488,R.id.ColPosition_488});
			ListView.setAdapter(adapter);
			
		}
	}


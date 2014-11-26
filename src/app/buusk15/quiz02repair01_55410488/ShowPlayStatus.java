package app.buusk15.quiz02repair01_55410488;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.impl.conn.AbstractClientConnAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowPlayStatus extends Activity{

	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_488);
			control488DB control488db = new control488DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control488db.SelectPlayStatus();
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(ShowPlayStatus.this, MyArrayList, R.layout.itemplaystatus, new String[]{"Play","Dice","Player","Position","Status","Score"},new int[]{R.id.ColPlay_488,R.id.ColDice_488,R.id.ColUseridp_488,R.id.ColPositionp_488,R.id.ColStatus_488,R.id.ColScorep_488});
			ListView.setAdapter(adapter);
			
		}
}

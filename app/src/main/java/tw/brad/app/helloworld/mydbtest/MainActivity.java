package tw.brad.app.helloworld.mydbtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);

        myDBHelper = new MyDBHelper(this, "brad", null, 1);
        db = myDBHelper.getReadableDatabase();

        query(null);
    }

    public void insert(View view){
        // insert into cust (cname,tel,birthday) values ('xxx','xxx','xxx');
        ContentValues values = new ContentValues();
        values.put("cname", "Brad");
        values.put("tel", "123");
        values.put("birthday", "1999-01-02");
        db.insert("cust", null, values);
        query(null);
    }
    public void delete(View view){
        // delete from cust where _id = 3 and cname='Brad'
        db.delete("cust","_id=? and cname=?", new String[]{"3","Brad"});
        query(null);
    }
    public void update(View view){

    }
    public void query(View view){
        // select * from cust
        tv.setText("");
        Cursor cursor = db.query("cust",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String cname = cursor.getString(1);
            String tel = cursor.getString(2);
            String birthday = cursor.getString(3);
            tv.append(id+":"+cname+":"+tel+":"+birthday + "\n");
        }
    }
}

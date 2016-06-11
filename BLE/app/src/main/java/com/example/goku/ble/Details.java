package com.example.goku.ble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Goku on 6/11/2016.
 */
public class Details extends Activity implements View.OnClickListener {
    EditText t1,t2;
    Button b1;
    TextView add,tv1,tv2;
    String maddress,name,sname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        t1=(EditText)findViewById(R.id.mname);
        t2=(EditText)findViewById(R.id.mname);
        b1=(Button)findViewById(R.id.next1);
        tv1=(TextView)findViewById(R.id.error1);
        tv2=(TextView)findViewById(R.id.error2);
        add=(TextView)findViewById(R.id.madd);
        Bundle gt=getIntent().getExtras();
        maddress=gt.getString("abc");
        add.setText(maddress);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //startActivity(new Intent(Details.this, Bluetoothlist.class));
        name=t1.getText().toString();
        sname=t2.getText().toString();
        if(name.equals(""))
        {
            tv1.setText("Please Enter valid name !");
            tv1.setVisibility(view.VISIBLE);
       }else if(sname.equals(""))
        {
            tv2.setText("Please Enter valid name !");
            tv2.setVisibility(view.VISIBLE);
        }
        else
        {
            tv1.setVisibility(view.INVISIBLE);
            tv2.setVisibility(view.INVISIBLE);
        }

    }
}

package net.androidbootcamp.concerttickets;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import java.text.DecimalFormat;


public class Main extends Activity {

    //declaring variables
    double costPerTicket=59.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;

    @Override

    //customary to launch the Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // the EditTicket is stored in tickets. final , will not be changed .
        final EditText tickets=(EditText) findViewById(R.id.txtTickets);
        // the spinner is stored at group
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        Button cost = (Button) findViewById(R.id.btnCost);
        final TextView result = ((TextView) findViewById(R.id.txtResult));
        //button onClickListener
        cost.setOnClickListener (new View.OnClickListener (){

            @Override
            public void onClick(View v){

                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerTicket * numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Total Cost for "+ groupChoice + " is " + currency.format(totalCost));

            }

        });

       // final TextView result =((TextView) findViewById (R.id.txtResult));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

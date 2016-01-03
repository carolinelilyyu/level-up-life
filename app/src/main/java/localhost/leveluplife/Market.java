package localhost.leveluplife;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Market extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_market, menu);
        Button sheep=(Button) findViewById(R.id.sheep);
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
        getString(R.string.sheep), Context.MODE_PRIVATE);
       int shep=sharedPref.getInt(getString(R.string.sheep), 0);
        if(shep>0)
        {
            sheep.setText("Sold Out");
            sheep.setFocusable(false);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.sheep), 0);
            editor.commit();
            sheep.setText("Sheep-1001");
            sheep.setFocusable(true);
           // sheep.setFilterTouchesWhenObscured(true);
        }

        Button dog=(Button) findViewById(R.id.dog);

        sharedPref = context.getSharedPreferences(
                getString(R.string.dog), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.dog), 0);
        if(shep>0)
        {
            dog.setText("Sold Out");
            dog.setFocusable(false);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.dog), 0);
            editor.commit();
            dog.setText("Dog-1001");
            dog.setFocusable(true);
            // sheep.setFilterTouchesWhenObscured(true);
        }



        Button games=(Button) findViewById(R.id.games);

        sharedPref = context.getSharedPreferences(
                getString(R.string.games), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.games), 0);
        if(shep>0)
        {
            games.setText("Sold Out");
            games.setFocusable(false);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.games), 0);
            editor.commit();
            games.setText("Games-751");
            games.setFocusable(true);
            // sheep.setFilterTouchesWhenObscured(true);
        }

        Button instrument=(Button) findViewById(R.id.instrument);

        sharedPref = context.getSharedPreferences(
                getString(R.string.instrument), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.instrument), 0);
        if(shep>0)
        {
            instrument.setText("Sold Out");
           instrument.setFocusable(false);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.instrument), 0);
            editor.commit();
            instrument.setText("Instrument-251");
            instrument.setFocusable(true);
            // sheep.setFilterTouchesWhenObscured(true);
        }

        Button food=(Button) findViewById(R.id.food);

        sharedPref = context.getSharedPreferences(
                getString(R.string.food), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.food), 0);
        if(shep>0)
        {
            food.setText("Sold Out");
            food.setFocusable(false);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.food), 0);
            editor.commit();
            food.setText("Food-751");
            food.setFocusable(true);
            // sheep.setFilterTouchesWhenObscured(true);
        }


        Button hat=(Button) findViewById(R.id.hat);

        sharedPref = context.getSharedPreferences(
                getString(R.string.hat), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.hat), 0);
        if(shep>0)
        {
            hat.setText("Sold Out");
            hat.setFocusable(false);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.hat), 0);
            editor.commit();
            hat.setText("Hat-251");
            hat.setFocusable(true);
            // sheep.setFilterTouchesWhenObscured(true);
        }

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
    public void sheep(View view){
        Context context = this;
        SharedPreferences sharedPre = context.getSharedPreferences(
                "Money", Context.MODE_PRIVATE);
        int shep=sharedPre.getInt("Money", 0);

        if(shep>1001) {

            SharedPreferences sharedPref = context.getSharedPreferences(
                    getString(R.string.sheep), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.sheep), 1);
            Button sheep = (Button) findViewById(R.id.sheep);
            sheep.setText("Sold Out");
            sheep.setFocusable(false);
            editor.commit();

            int diff=shep-1001;
            editor=sharedPre.edit();

            editor.putInt("Money", diff);
            editor.commit();
            TextView s=(TextView)findViewById(R.id.mun);
            s.setText("Money: " +diff);
        }
    }

    public void dog(View view){
        Context context = this;
        SharedPreferences sharedPre = context.getSharedPreferences(
                "Money", Context.MODE_PRIVATE);
        int shep=sharedPre.getInt("Money", 0);

        if(shep>1001) {

            SharedPreferences sharedPref = context.getSharedPreferences(
                    getString(R.string.dog), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.dog), 1);
            Button dog = (Button) findViewById(R.id.dog);
            dog.setText("Sold Out");
            dog.setFocusable(false);
            editor.commit();

            int diff=shep-751;
            editor=sharedPre.edit();
            editor.putInt("Money", diff);
            editor.commit();
            TextView s=(TextView)findViewById(R.id.mun);
            s.setText("Money: " + diff);
        }
    }


    public void food(View view){
        Context context = this;
        SharedPreferences sharedPre = context.getSharedPreferences(
                "Money", Context.MODE_PRIVATE);
        int shep=sharedPre.getInt("Money", 0);

        if(shep>751) {

            SharedPreferences sharedPref = context.getSharedPreferences(
                    getString(R.string.games), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.games), 1);
            Button games = (Button) findViewById(R.id.games);
           games.setText("Sold Out");
            games.setFocusable(false);
            editor.commit();

            int diff=shep-751;
            editor=sharedPre.edit();
            editor.putInt("Money", diff);
            editor.commit();
            TextView s=(TextView)findViewById(R.id.mun);
            s.setText("Money: " + diff);
        }
    }

    public void hat(View view){
        Context context = this;
        SharedPreferences sharedPre = context.getSharedPreferences(
                "Money", Context.MODE_PRIVATE);
        int shep=sharedPre.getInt("Money", 0);

        if(shep>251) {

            SharedPreferences sharedPref = context.getSharedPreferences(
                    getString(R.string.hat), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.hat), 1);
            Button hat = (Button) findViewById(R.id.hat);
            hat.setText("Sold Out");
           hat.setFocusable(false);
            editor.commit();

            int diff=shep-251;
            editor=sharedPre.edit();
            editor.putInt("Money", diff);
            editor.commit();
            TextView s=(TextView)findViewById(R.id.mun);
            s.setText("Money: " + diff);
        }
    }


    public void instrument(View view){
        Context context = this;
        SharedPreferences sharedPre = context.getSharedPreferences(
                "Money", Context.MODE_PRIVATE);
        int shep=sharedPre.getInt("Money", 0);

        if(shep>251) {

            SharedPreferences sharedPref = context.getSharedPreferences(
                    getString(R.string.instrument), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.instrument), 1);
            Button instrument = (Button) findViewById(R.id.instrument);
            instrument.setText("Sold Out");
            instrument.setFocusable(false);
            editor.commit();

            int diff=shep-251;
            editor=sharedPre.edit();
            editor.putInt("Money", diff);
            editor.commit();
            TextView s=(TextView)findViewById(R.id.mun);
            s.setText("Money: " + diff);
        }
    }
}

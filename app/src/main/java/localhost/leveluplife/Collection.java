package localhost.leveluplife;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class Collection extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);
        TextView sheep=(TextView) findViewById(R.id.sheepm);
        TextView dog=(TextView) findViewById(R.id.dog);
        TextView hat=(TextView) findViewById(R.id.hat);
        TextView food=(TextView) findViewById(R.id.food);
        TextView games=(TextView) findViewById(R.id.games);
        TextView instrument=(TextView) findViewById(R.id.instrument);

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.sheep), Context.MODE_PRIVATE);
        int shep=sharedPref.getInt(getString(R.string.sheep), 0);
        if(shep>0)
        {
            sheep.setText("Sheep");
            sheep.setFocusable(true);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.sheep), 0);
            editor.commit();
            sheep.setText("Don't Have");
            sheep.setFocusable(false);
            // sheep.setFilterTouchesWhenObscured(true);
        }

        sharedPref = context.getSharedPreferences(
                getString(R.string.dog), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.dog), 0);
        if(shep>0)
        {
            dog.setText("Dog");
            dog.setFocusable(true);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.dog), 0);
            editor.commit();
            dog.setText("Don't Have");
            dog.setFocusable(false);
            // sheep.setFilterTouchesWhenObscured(true);
        }

        sharedPref = context.getSharedPreferences(
                getString(R.string.hat), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.hat), 0);
        if(shep>0)
        {
            hat.setText("Hat");
            hat.setFocusable(true);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.hat), 0);
            editor.commit();
            hat.setText("Don't Have");
            hat.setFocusable(false);
            // sheep.setFilterTouchesWhenObscured(true);
        }
        sharedPref = context.getSharedPreferences(
                getString(R.string.food), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.food), 0);
        if(shep>0)
        {
            food.setText("Food");
            food.setFocusable(true);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.food), 0);
            editor.commit();
            food.setText("Don't Have");
            food.setFocusable(false);
            // sheep.setFilterTouchesWhenObscured(true);
        }

        sharedPref = context.getSharedPreferences(
                getString(R.string.games), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.games), 0);
        if(shep>0)
        {
            games.setText("Games");
            games.setFocusable(true);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.games), 0);
            editor.commit();
            games.setText("Don't Have");
            games.setFocusable(false);
            // sheep.setFilterTouchesWhenObscured(true);
        }
        sharedPref = context.getSharedPreferences(
                getString(R.string.instrument), Context.MODE_PRIVATE);
        shep=sharedPref.getInt(getString(R.string.instrument), 0);
        if(shep>0)
        {
            instrument.setText("Instrument");
            instrument.setFocusable(true);
            //sheep.setFilterTouchesWhenObscured(false);
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.instrument), 0);
            editor.commit();
            instrument.setText("Don't Have");
            instrument.setFocusable(false);
            // sheep.setFilterTouchesWhenObscured(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collection, menu);
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

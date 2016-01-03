package localhost.leveluplife;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Tasks extends ActionBarActivity {
    private String[] sStory={"Deliver along the road less traveled on:", "Accompany a traveling circuis"};
    private String[] cStory={"One long day of farmwork:", "Run drills with an army:"};
    private String[] mStory={"Accompany a girl to grandmother's house:", "Find a lost dog:"};
    private String[] fStory={"Carry an Old Woman To The Top of the Mt.:", "Bring a message to the girl in the tower:"};
    private int step[]={20, 15000,20000};
    private int min[]= {60, 90, 120};
    private int fl[]= {20, 30,40};
    private int cal[]= {200, 300, 400};
    private int mon[] = {100, 200, 300};
    private String qual1[]= {"walk at least", "burn at least", "excersise at least", "walk up at least"};
    private String qual2[]={"steps", "calories through excersie", "minutes", "flights of stairs"};
    private String stor[][]= new String[4][2];
    private int op[][]= new int[4][3];
    private String la[] = {"Steps", "Calories", "Min", "Floors"};
    boolean done1=false;
    boolean done2=false;
    boolean done3=false;
    Button b1;
    Button b2;
    //Button b3= (Button) findViewById(R.id.b3);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);
        stor[0]=sStory;
        stor[1]=cStory;
        stor[2]=mStory;
        stor[3]=fStory;
        op[0]=step;
        op[1]=cal;
        op[2]=min;
        op[3]=fl;
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        Context context = this;
        SharedPreferences mun = context.getSharedPreferences(
                "Mon1", Context.MODE_PRIVATE);
        int shep=mun.getInt("Mon1",3);
        if(shep>2)
        {
             shep=0;
            SharedPreferences.Editor editor = mun.edit();
            editor.putInt("Mon1", shep);
            editor.commit();
        }


        SharedPreferences exc = context.getSharedPreferences(
                "Ex1", Context.MODE_PRIVATE);
        int ex=exc.getInt("Ex1",4);
        if(ex>3)
        {
            ex=0;
            SharedPreferences.Editor editor =exc.edit();
            editor.putInt("Ex1", ex);
            editor.commit();
        }

        SharedPreferences sto = context.getSharedPreferences(
                "Sto1", Context.MODE_PRIVATE);
        int st=sto.getInt("Sto1",2);
        if(st>1)
        {
            st=0;
            SharedPreferences.Editor editor = sto.edit();
            editor.putInt("Sto1", st);
            editor.commit();
        }

        SharedPreferences o = context.getSharedPreferences(
                "O1", Context.MODE_PRIVATE);
        int oper=o.getInt("O1",3);

        if(oper>2)
        {
            oper=0;
            SharedPreferences.Editor editor = o.edit();
            editor.putInt("O1", oper);
            editor.commit();
        }
        String newline = System.getProperty("line.separator");
        SharedPreferences bo = context.getSharedPreferences(
                la[ex], Context.MODE_PRIVATE);
        int goal= bo.getInt(la[ex], -1);
        String str1=stor[ex][st] + newline + "You must " + qual1[ex] + " "  + op[ex][oper]  + " " + qual2[ex] + newline + "In one day to complete this quest and earn " + newline + mon[shep] + " dollars" + newline + "you've accomplished " + goal + " today";

        b1.setText(str1);
        System.out.println("GOAL"+goal);
        if(goal>op[ex][oper])
        {
            done1=true;
           // b1.setTextColor(0X00FF00);
        }
       // else
       // {
           // b1.setTextColor(0XFF0000);
       // }




        mun = context.getSharedPreferences(
                "Mon2", Context.MODE_PRIVATE);
         shep=mun.getInt("Mon2",3);
        if(shep>2)
        {
            shep=1;
            SharedPreferences.Editor editor = mun.edit();
            editor.putInt("Mon2", shep);
            editor.commit();
        }


         exc = context.getSharedPreferences(
                "Ex2", Context.MODE_PRIVATE);
         ex=exc.getInt("Ex2",4);
        if(ex>3)
        {
            ex=1;
            SharedPreferences.Editor editor =exc.edit();
            editor.putInt("Ex2", ex);
            editor.commit();
        }

         sto = context.getSharedPreferences(
                "Sto2", Context.MODE_PRIVATE);
         st=sto.getInt("Sto2",2);
        if(st>1)
        {
            st=1;
            SharedPreferences.Editor editor = sto.edit();
            editor.putInt("Sto2", st);
            editor.commit();
        }

         o = context.getSharedPreferences(
                "O2", Context.MODE_PRIVATE);
         oper=o.getInt("O2",3);

        if(oper>2)
        {
            oper=1;
            SharedPreferences.Editor editor = o.edit();
            editor.putInt("O2", oper);
            editor.commit();
        }

        bo = context.getSharedPreferences(
                la[ex], Context.MODE_PRIVATE);
        goal= bo.getInt(la[ex], -1);
        //newline = System.getProperty("line.separator");
        String str2=stor[ex][st] + newline + "You must " + qual1[ex] + " "  + op[ex][oper]  + " " + qual2[ex] + newline + "In one day to complete this quest and earn " + newline + mon[shep] + " dollars" + newline + "you've accomplished " + goal + " today";

        b2.setText(str2);

        System.out.println("GOAL"+goal);
        if(goal>op[ex][oper])
        {
            done2=true;
           // b2.setTextColor(0X00FF00);
        }
        else
        {
            //b2.setTextColor(0XFF0000);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tasks, menu);

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

    public void bu1(View view){
        if(done1)
        {
            done1=false;
            b1.setTextColor(0xff0000);
            Context context = this;
            SharedPreferences mun = context.getSharedPreferences(
                    "Mon1", Context.MODE_PRIVATE);
            int shep=mun.getInt("Mon1",3);
            shep=(shep+1)%3;
            SharedPreferences.Editor editor = mun.edit();
            editor.putInt("Mon1", shep);
            editor.commit();
            SharedPreferences exc = context.getSharedPreferences(
                    "Ex1", Context.MODE_PRIVATE);
            int ex=exc.getInt("Ex1",4);
            ex=(ex+1)%4;
            editor = exc.edit();
            editor.putInt("Ex1", ex);
            editor.commit();

            SharedPreferences sto = context.getSharedPreferences(
                    "Sto1", Context.MODE_PRIVATE);
            int st=sto.getInt("Sto1",2);
            st=(st+1)%2;
           // ex=(ex+1)%4;
            editor = sto.edit();
            editor.putInt("Sto1", st);
            editor.commit();


            SharedPreferences o = context.getSharedPreferences(
                    "O1", Context.MODE_PRIVATE);
            int oper=o.getInt("O1",3);
            oper=(oper+4)%3;
           // ex=(ex+1)%4;
            editor = o.edit();
            editor.putInt("O1", oper);
            editor.commit();


        }


    }

    public void bu2(View view){
        if(done2)
        {
            done2=false;
            b2.setTextColor(0xff0000);
            Context context = this;
            SharedPreferences mun = context.getSharedPreferences(
                    "Mon2", Context.MODE_PRIVATE);
            int shep=mun.getInt("Mon2",3);
            shep=(shep+1)%3;
            SharedPreferences.Editor editor = mun.edit();
            editor.putInt("Mon2", shep);
            editor.commit();
            SharedPreferences exc = context.getSharedPreferences(
                    "Ex2", Context.MODE_PRIVATE);
            int ex=exc.getInt("Ex2",4);
            ex=(ex+1)%4;
            editor = exc.edit();
            editor.putInt("Ex2", ex);
            editor.commit();

            SharedPreferences sto = context.getSharedPreferences(
                    "Sto2", Context.MODE_PRIVATE);
            int st=sto.getInt("Sto2",2);
            st=(st+1)%2;
            //ex=(ex+1)%4;
            editor = sto.edit();
            editor.putInt("Sto2", st);
            editor.commit();


            SharedPreferences o = context.getSharedPreferences(
                    "O2", Context.MODE_PRIVATE);
            int oper=o.getInt("O2",3);
            oper=(oper+4)%3;
            //ex=(ex+1)%4;
            editor = o.edit();
            editor.putInt("O2", oper);
            editor.commit();


        }


    }

}

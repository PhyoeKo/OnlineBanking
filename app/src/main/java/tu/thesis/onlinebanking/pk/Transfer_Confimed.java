package tu.thesis.onlinebanking.pk;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Transfer_Confimed extends AppCompatActivity {

   private TextView fromAccount,toAccount,name,date,description,amount,charges;
private    String from,to,n,desc,am,d;
long c,balance,main_balance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer__confimed);
        fromAccount = findViewById(R.id.fromAccount);
        toAccount = findViewById(R.id.toAccount);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        amount = findViewById(R.id.amount);
        charges = findViewById(R.id.charges);

        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Confirmed");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow);

        setSupportActionBar(mToolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        from = bundle.getString("from");
        to = bundle.getString("to");
        n= bundle.getString("name");
        d = bundle.getString("date");
        desc = bundle.getString("description");
        am = bundle.getString("amount");
        c = bundle.getLong("charges");
        balance = bundle.getLong("balance");
        main_balance = bundle.getLong("mainbalance");


       // showMsg("Success","You have successfully"+  am + "Ks transferred to " + to + "for "+desc);

        fromAccount.setText(from);
        toAccount.setText(to);
        name.setText(n);
        date.setText(d);
        description.setText(desc);
        amount.setText(am+ " Ks");
        charges.setText(c + " Ks");



    }

    public void onClick(View v){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alertdialog_for_detail, null);
        dialogBuilder.setView(dialogView);

        final TextView tv_have = dialogView.findViewById(R.id.diag_have);
        final TextView tv_transfered = dialogView.findViewById(R.id.diag_transfered);
        final TextView tv_charges = dialogView.findViewById(R.id.diag_charges);
        final TextView tv_current = dialogView.findViewById(R.id.diag_current_balance);



        dialogBuilder.setTitle("Total cost.");

        tv_have.setText("You have : "+main_balance+" Ks");
        tv_transfered.setText("You transferred : "+am+" Ks");
        tv_charges.setText("Transfer charges : "+c+ " Ks");
        tv_current.setText("So, your current balance is : "+balance+" Ks");

        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        final AlertDialog b = dialogBuilder.create();
        b.setCanceledOnTouchOutside(false);
        b.show();




    }

//    public void showMsg(String title, String msg)
//    {
//        final AlertDialog ad=new AlertDialog.Builder(this).create();
//
//        ad.setTitle(title);
//        ad.setMessage(msg);
//
//        ad.setButton(
//                AlertDialog.BUTTON_POSITIVE,
//                "Ok",
//                new DialogInterface.OnClickListener() {
//
//
//
//
//                    @Override
//                    public void onClick(DialogInterface p1, int p2)
//                    {
//                        ad.dismiss();
//                      //  finish();
//                    }
//                });
//        ad.show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}

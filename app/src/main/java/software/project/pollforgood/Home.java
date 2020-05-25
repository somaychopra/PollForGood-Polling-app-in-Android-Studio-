package software.project.pollforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class Home extends AppCompatActivity {

    private Button LogoutBtn;
    private Button UserPolls;
    private Button Vote;
    private Button ViewResults;
    private Button Account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LogoutBtn = (Button) findViewById(R.id.logout_buttn);
        UserPolls = (Button) findViewById(R.id.yourpoll_btn);
        Vote = (Button) findViewById(R.id.vote_btn);
        ViewResults = (Button) findViewById(R.id.viewresults_btn);
        Account = (Button) findViewById(R.id.account_btn);

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().destroy();
                Intent intent1 = new Intent(Home.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        UserPolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Home.this,YourPolls.class);
                startActivity(intent2);
            }
        });
        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Home.this,AccountSettings.class);
                startActivity(intent3);
            }
        });
        Vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Home.this,AllVotes.class);
                startActivity(intent4);
            }
        });
        ViewResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Home.this,Results.class);
                startActivity(intent5);
            }
        });

    }
}

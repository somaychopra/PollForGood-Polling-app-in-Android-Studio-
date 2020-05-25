package software.project.pollforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import io.paperdb.Paper;
import software.project.pollforgood.Model.Polls;

public class DeletePoll extends AppCompatActivity {

    private Button Delete;
    private DatabaseReference ref;
    private TextView pollQuestion;
    private CheckBox pollOption1,pollOption2,pollOption3,pollOption4,pollOption5,pollOption6,pollOption7;
    private String PollID,user_created;
    private Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_poll);

        PollID = getIntent().getStringExtra("pollid");
        pollQuestion = (TextView) findViewById(R.id.pollquestion);
        pollOption1 = (CheckBox) findViewById(R.id.optionbox1);
        pollOption2 = (CheckBox) findViewById(R.id.optionbox2);
        pollOption3 = (CheckBox) findViewById(R.id.optionbox3);
        pollOption4 = (CheckBox) findViewById(R.id.optionbox4);
        pollOption5 = (CheckBox) findViewById(R.id.optionbox5);
        pollOption6 = (CheckBox) findViewById(R.id.optionbox6);
        pollOption7 = (CheckBox) findViewById(R.id.optionbox7);
        Back = (Button) findViewById(R.id.back_btn);
        final Polls[] polls = new Polls[1];
        if(login.current_user_roll_number!=null)
            user_created = login.current_user_roll_number;//Paper.book().read("UserRoll");
        else
            user_created = Paper.book().read("UserRoll");
        ref = FirebaseDatabase.getInstance().getReference().child("UserCreated").child(user_created);
        ref.child(PollID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                polls[0] = dataSnapshot.getValue(Polls.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeletePoll.this,YourPolls.class);
                startActivity(intent);
            }
        });
        Delete = (Button) findViewById(R.id.delete);
        getPollDetails(PollID,user_created);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = 1;
                Calendar calendar = Calendar.getInstance();
                int Hourof = calendar.get(Calendar.HOUR_OF_DAY);
                int Dayof = calendar.get(Calendar.DAY_OF_YEAR);
                if(polls[0].getDayofyear()+(polls[0].getDurationinHrs())/24<Dayof)
                {
                    flag = 0;
                }
                else
                {
                    if(polls[0].getDayofyear()+(polls[0].getDurationinHrs())/24==Dayof)
                    {
                        if(polls[0].getHourofday()+(polls[0].getDurationinHrs())%24<Hourof)
                            flag=0;
                    }
                }
                if(flag==1)
                {
                    DatabaseReference userpollref = FirebaseDatabase.getInstance().getReference().child("UserCreated").child(user_created);
                    userpollref.child(PollID).removeValue();
                    DatabaseReference pollreference = FirebaseDatabase.getInstance().getReference().child("Poll");
                    pollreference.child(PollID).removeValue();
                    Intent intent = new Intent(DeletePoll.this,YourPolls.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(DeletePoll.this, "Cannot delete as the Poll has already ended.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void getPollDetails(String PollID,String user_created) {

        DatabaseReference pollref = FirebaseDatabase.getInstance().getReference().child("UserCreated").child(user_created);
        pollref.child(PollID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Polls polls = dataSnapshot.getValue(Polls.class);
                    assert polls != null;
                    pollQuestion.setText(polls.getQuestion());
                    pollOption1.setText(polls.getOption1());
                    pollOption2.setText(polls.getOption2());
                    pollOption3.setText(polls.getOption3());
                    pollOption4.setText(polls.getOption4());
                    pollOption5.setText(polls.getOption5());
                    pollOption6.setText(polls.getOption6());
                    pollOption7.setText(polls.getOption7());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

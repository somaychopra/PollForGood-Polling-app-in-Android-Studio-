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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import io.paperdb.Paper;
import software.project.pollforgood.Model.Polls;
import software.project.pollforgood.Prevalent.Prevalent;

public class PollDetails extends AppCompatActivity {

    private TextView pollQuestion;
    private CheckBox pollOption1,pollOption2,pollOption3,pollOption4,pollOption5,pollOption6,pollOption7;
    private String PollID,user_created;
    private Button Poll_it,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_details);
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
        Poll_it = (Button) findViewById(R.id.vote_it);
        if(login.current_user_roll_number!=null)
            user_created = login.current_user_roll_number;//Paper.book().read("UserRoll");
        else
            user_created = Paper.book().read("UserRoll");
        getPollDetails(PollID);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentiii = new Intent(PollDetails.this,AllVotes.class);
                startActivity(intentiii);
            }
        });
        Poll_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference check = FirebaseDatabase.getInstance().getReference().child("UserVoted").child(user_created);
                check.child(PollID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            Toast.makeText(PollDetails.this, "You have already voted for this poll", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            IncreaseCount(PollID,user_created);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private void IncreaseCount(final String PollID, final String user_voted) {
        final DatabaseReference pollref = FirebaseDatabase.getInstance().getReference().child("Poll");
        pollref.child(PollID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if(dataSnapshot.exists())
               {
                   if((pollOption3.getText().toString().equalsIgnoreCase("(NA)") && pollOption3.isChecked())
                           ||(pollOption4.getText().toString().equalsIgnoreCase("(NA)") && pollOption4.isChecked())
                           ||(pollOption5.getText().toString().equalsIgnoreCase("(NA)") && pollOption5.isChecked())
                           ||(pollOption6.getText().toString().equalsIgnoreCase("(NA)") && pollOption6.isChecked())
                           ||(pollOption7.getText().toString().equalsIgnoreCase("(NA)") && pollOption7.isChecked()))
                   {
                       Toast.makeText(PollDetails.this, "Select valid options", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       Polls polldata = dataSnapshot.getValue(Polls.class);
                       //if(polldata==null) Toast.makeText(PollDetails.this, "I am here", Toast.LENGTH_SHORT).show();

                       //HashMap<String, Object> updatecount = new HashMap<>();
                       int temp1 = polldata.getOption1count()
                               ,temp2 = polldata.getOption2count()
                               ,temp3 = polldata.getOption3count()
                               ,temp4 = polldata.getOption4count()
                               ,temp5 = polldata.getOption5count()
                               ,temp6 = polldata.getOption6count()
                               ,temp7 = polldata.getOption7count();
                       int flag1=0,flag2=0,flag3=0,flag4=0,flag5=0,flag6=0,flag7=0;
                       if(pollOption1.isChecked() && polldata!=null && flag1==0) {temp1 = temp1 + 1;flag1=1;pollOption1.setChecked(false);}
                       if(pollOption2.isChecked() && polldata!=null && flag2==0) {temp2 = temp2 + 1;flag2=1;pollOption2.setChecked(false);}
                       if(pollOption3.isChecked() && polldata!=null && flag3==0) {temp3 = temp3 + 1;flag3=1;pollOption3.setChecked(false);}
                       if(pollOption4.isChecked() && polldata!=null && flag4==0) {temp4 = temp4 + 1;flag4=1;pollOption4.setChecked(false);}
                       if(pollOption5.isChecked() && polldata!=null && flag5==0) {temp5 = temp5 + 1;flag5=1;pollOption5.setChecked(false);}
                       if(pollOption6.isChecked() && polldata!=null && flag6==0) {temp6 = temp6 + 1;flag6=1;pollOption6.setChecked(false);}
                       if(pollOption7.isChecked() && polldata!=null && flag7==0) {temp7 = temp7 + 1;flag7=1;pollOption7.setChecked(false);}
                       /*pollref.child(PollID).child("option1count").setValue(temp1);
                       pollref.child(PollID).child("option2count").setValue(temp2);
                       pollref.child(PollID).child("option3count").setValue(temp3);
                       pollref.child(PollID).child("option4count").setValue(temp4);
                       pollref.child(PollID).child("option5count").setValue(temp5);
                       pollref.child(PollID).child("option6count").setValue(temp6);
                       pollref.child(PollID).child("option7count").setValue(temp7);*/
                       HashMap<String, Object> pollMap = new HashMap<>();
                       pollMap.put("pollid", polldata.getPollid());
                       pollMap.put("date", polldata.getDate());
                       pollMap.put("time", polldata.getTime());
                       pollMap.put("question", polldata.getQuestion());
                       pollMap.put("option1", polldata.getOption1());
                       pollMap.put("option2", polldata.getOption2());
                       pollMap.put("option3", polldata.getOption3());
                       pollMap.put("option4", polldata.getOption4());
                       pollMap.put("option5", polldata.getOption5());
                       pollMap.put("option6", polldata.getOption6());
                       pollMap.put("option7", polldata.getOption7());
                       pollMap.put("option1count",temp1);
                       pollMap.put("option2count",temp2);
                       pollMap.put("option3count",temp3);
                       pollMap.put("option4count",temp4);
                       pollMap.put("option5count",temp5);
                       pollMap.put("option6count",temp6);
                       pollMap.put("option7count",temp7);
                       pollMap.put("durationinHrs",polldata.getDurationinHrs());
                       pollMap.put("hourofday",polldata.getHourofday());
                       pollMap.put("dayofyear",polldata.getDayofyear());
                       pollref.child(PollID).updateChildren(pollMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful())
                               {
                                   AddpolltoUser(PollID,user_voted);
                                   Toast.makeText(PollDetails.this, "Your Response has been Saved!", Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(PollDetails.this,AllVotes.class);
                                   startActivity(intent);
                               }
                               else
                               {
                               }
                           }
                       });
                   }
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void AddpolltoUser(String PollID,String user_voted) {
        final DatabaseReference pollref = FirebaseDatabase.getInstance().getReference().child("UserVoted").child(user_voted);
        HashMap<String, Object> pollMap = new HashMap<>();
        pollMap.put(PollID, "Voted");
        pollref.updateChildren(pollMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {

                        }
                        else
                        {

                        }
                    }
                });
    }

    private void getPollDetails(String PollID) {

        DatabaseReference pollref = FirebaseDatabase.getInstance().getReference().child("Poll");
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

package software.project.pollforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import software.project.pollforgood.Model.Polls;
import software.project.pollforgood.ViewHolder.PollHolder;

public class AllVotes extends AppCompatActivity {

    private DatabaseReference PollRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_votes);
        PollRef = FirebaseDatabase.getInstance().getReference().child("Poll");
        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Back = (Button) findViewById(R.id.back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllVotes.this,Home.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Polls> options =
                new FirebaseRecyclerOptions.Builder<Polls>()
                        .setQuery(PollRef,Polls.class)
                        .build();
        FirebaseRecyclerAdapter<Polls, PollHolder> adapter =
                new FirebaseRecyclerAdapter<Polls, PollHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull PollHolder pollHolder, int i, @NonNull final Polls polls) {
                        pollHolder.txtQuestion.setText(polls.getQuestion());
                        String temp = "Duration : " + polls.getDurationinHrs() + " Hrs";
                        pollHolder.txtTimeleft.setText(temp);
                        int flag = 1;
                        Calendar calendar = Calendar.getInstance();
                        int Hourof = calendar.get(Calendar.HOUR_OF_DAY);
                        int Dayof = calendar.get(Calendar.DAY_OF_YEAR);
                        if(polls.getDayofyear()+(polls.getDurationinHrs())/24<Dayof)
                        {
                            flag = 0;
                        }
                        else
                        {
                            if(polls.getDayofyear()+(polls.getDurationinHrs())/24==Dayof)
                            {
                                if(polls.getHourofday()+(polls.getDurationinHrs())%24<Hourof)
                                    flag=0;
                            }
                        }
                        if(flag==1)
                        {
                            /*pollHolder.itemView.setVisibility(View.VISIBLE);
                            pollHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));*/
                            pollHolder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AllVotes.this,PollDetails.class);
                                intent.putExtra("pollid",polls.getPollid());
                                startActivity(intent);
                            }
                        });
                        }
                        else
                        {
                            pollHolder.itemView.setVisibility(View.GONE);
                            pollHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
                        }
                    }

                    @NonNull
                    @Override
                    public PollHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poll_appearance,parent,false);
                        PollHolder pollHolder = new PollHolder(view);
                        return pollHolder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}

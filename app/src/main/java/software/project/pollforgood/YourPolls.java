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

import io.paperdb.Paper;
import software.project.pollforgood.Model.Polls;
import software.project.pollforgood.ViewHolder.PollHolder;

public class YourPolls extends AppCompatActivity {


    private Button AddPoll;
    private DatabaseReference PollRef,Userpollref;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_polls);
        AddPoll = (Button) findViewById(R.id.addpoll);
        PollRef = FirebaseDatabase.getInstance().getReference().child("Poll");
        String user_created = login.current_user_roll_number;//Paper.book().read("UserRoll");
        if(user_created!=null) Userpollref = FirebaseDatabase.getInstance().getReference().child("UserCreated").child(user_created);
        if(Userpollref==null)
            Userpollref = FirebaseDatabase.getInstance().getReference().child("UserCreated").child((String) Paper.book().read("UserRoll"));
        recyclerView = findViewById(R.id.recycler_yours);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Back = (Button) findViewById(R.id.back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourPolls.this,Home.class);
                startActivity(intent);
            }
        });


        AddPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourPolls.this,AddPollButton.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Polls> options =
                new FirebaseRecyclerOptions.Builder<Polls>()
                        .setQuery(Userpollref,Polls.class)
                        .build();
        FirebaseRecyclerAdapter<Polls, PollHolder> adapter =
                new FirebaseRecyclerAdapter<Polls, PollHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull PollHolder pollHolder, int i, @NonNull final Polls polls) {

                        pollHolder.txtQuestion.setText(polls.getQuestion());
                        String temp = "Duration : " + polls.getDurationinHrs() + " Hrs";
                        pollHolder.txtTimeleft.setText(temp);
                        pollHolder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(YourPolls.this,DeletePoll.class);
                                intent.putExtra("pollid",polls.getPollid());
                                startActivity(intent);
                            }
                        });
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

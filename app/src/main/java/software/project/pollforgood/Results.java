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

import java.util.Calendar;

import software.project.pollforgood.Model.Polls;
import software.project.pollforgood.ViewHolder.PollHolder;
import software.project.pollforgood.ViewHolder.ResultHolder;

public class Results extends AppCompatActivity {

    private DatabaseReference PollRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        PollRef = FirebaseDatabase.getInstance().getReference().child("Poll");
        recyclerView = findViewById(R.id.recycler_results);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Back = (Button) findViewById(R.id.back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Results.this,Home.class);
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
        FirebaseRecyclerAdapter<Polls, ResultHolder> adapter =
                new FirebaseRecyclerAdapter<Polls, ResultHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ResultHolder resultHolder, int i, @NonNull final Polls polls) {
                        resultHolder.txtQuestion.setText(polls.getQuestion());
                        int temp = polls.getOption1count();
                        String resultant = polls.getOption1();
                        if(temp<polls.getOption2count())
                        {
                            temp = polls.getOption2count();
                            resultant = polls.getOption2();
                        }
                        if(temp<polls.getOption3count())
                        {
                            temp = polls.getOption3count();
                            resultant = polls.getOption3();
                        }
                        if(temp<polls.getOption4count())
                        {
                            temp = polls.getOption4count();
                            resultant = polls.getOption4();
                        }
                        if(temp<polls.getOption5count())
                        {
                            temp = polls.getOption5count();
                            resultant = polls.getOption5();
                        }
                        if(temp<polls.getOption6count())
                        {
                            temp = polls.getOption6count();
                            resultant = polls.getOption6();
                        }
                        if(temp<polls.getOption7count())
                        {
                            temp = polls.getOption7count();
                            resultant = polls.getOption7();
                        }
                        String finalresult = "Poll Result : " + resultant;
                        resultHolder.txtResult.setText(finalresult);
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
                        if(flag==0)
                        {
                            resultHolder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Results.this,ResultBarGraph.class);
                                intent.putExtra("pollid",polls.getPollid());
                                startActivity(intent);
                            }
                        });
                        }
                        else
                        {
                            resultHolder.itemView.setVisibility(View.GONE);
                            resultHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
                        }
                    }

                    @NonNull
                    @Override
                    public ResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result,parent,false);
                        ResultHolder resultHolder = new ResultHolder(view);
                        return resultHolder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}

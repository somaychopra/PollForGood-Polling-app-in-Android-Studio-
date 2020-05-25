package software.project.pollforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import software.project.pollforgood.Model.Polls;

public class ResultBarGraph extends AppCompatActivity {

    private String PollID;
    private Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bar_graph);
        PollID = getIntent().getStringExtra("pollid");
        Back = (Button) findViewById(R.id.back_btn);
        showbar(PollID);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultBarGraph.this,Results.class);
                startActivity(intent);
            }
        });
    }

    private void showbar(String PollID) {

        DatabaseReference pollref = FirebaseDatabase.getInstance().getReference().child("Poll");
        pollref.child(PollID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    BarChart barChart = (BarChart) findViewById(R.id.barchart);
                    Polls polls = dataSnapshot.getValue(Polls.class);
                    int temp = 2;
                    if(!polls.getOption3().equalsIgnoreCase("(NA)")) temp = temp + 1;
                    if(!polls.getOption4().equalsIgnoreCase("(NA)")) temp = temp + 1;
                    if(!polls.getOption5().equalsIgnoreCase("(NA)")) temp = temp + 1;
                    if(!polls.getOption6().equalsIgnoreCase("(NA)")) temp = temp + 1;
                    if(!polls.getOption7().equalsIgnoreCase("(NA)")) temp = temp + 1;
                    if(temp==2)
                    {
                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(polls.getOption1count(), 0));
                        entries.add(new BarEntry(polls.getOption2count(), 1));

                        BarDataSet bardataset = new BarDataSet(entries, "Poll Options");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add(polls.getOption1());
                        labels.add(polls.getOption2());

                        BarData data = new BarData(labels, bardataset);
                        barChart.setData(data);
                        barChart.setDescription("");
                        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(5000);
                    }
                    if(temp==3)
                    {
                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(polls.getOption1count(), 0));
                        entries.add(new BarEntry(polls.getOption2count(), 1));
                        entries.add(new BarEntry(polls.getOption3count(), 2));

                        BarDataSet bardataset = new BarDataSet(entries, "Poll Options");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add(polls.getOption1());
                        labels.add(polls.getOption2());
                        labels.add(polls.getOption3());

                        BarData data = new BarData(labels, bardataset);
                        barChart.setData(data);
                        barChart.setDescription("");
                        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(5000);
                    }
                    if(temp==4)
                    {
                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(polls.getOption1count(), 0));
                        entries.add(new BarEntry(polls.getOption2count(), 1));
                        entries.add(new BarEntry(polls.getOption3count(), 2));
                        entries.add(new BarEntry(polls.getOption4count(), 3));

                        BarDataSet bardataset = new BarDataSet(entries, "Poll Options");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add(polls.getOption1());
                        labels.add(polls.getOption2());
                        labels.add(polls.getOption3());
                        labels.add(polls.getOption4());

                        BarData data = new BarData(labels, bardataset);
                        barChart.setData(data);
                        barChart.setDescription("");
                        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(5000);
                    }
                    if(temp==5)
                    {
                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(polls.getOption1count(), 0));
                        entries.add(new BarEntry(polls.getOption2count(), 1));
                        entries.add(new BarEntry(polls.getOption3count(), 2));
                        entries.add(new BarEntry(polls.getOption4count(), 3));
                        entries.add(new BarEntry(polls.getOption5count(), 4));

                        BarDataSet bardataset = new BarDataSet(entries, "Poll Options");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add(polls.getOption1());
                        labels.add(polls.getOption2());
                        labels.add(polls.getOption3());
                        labels.add(polls.getOption4());
                        labels.add(polls.getOption5());

                        BarData data = new BarData(labels, bardataset);
                        barChart.setData(data);
                        barChart.setDescription("");
                        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(5000);
                    }
                    if(temp==6)
                    {
                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(polls.getOption1count(), 0));
                        entries.add(new BarEntry(polls.getOption2count(), 1));
                        entries.add(new BarEntry(polls.getOption3count(), 2));
                        entries.add(new BarEntry(polls.getOption4count(), 3));
                        entries.add(new BarEntry(polls.getOption5count(), 4));
                        entries.add(new BarEntry(polls.getOption6count(), 5));

                        BarDataSet bardataset = new BarDataSet(entries, "Poll Options");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add(polls.getOption1());
                        labels.add(polls.getOption2());
                        labels.add(polls.getOption3());
                        labels.add(polls.getOption4());
                        labels.add(polls.getOption5());
                        labels.add(polls.getOption6());

                        BarData data = new BarData(labels, bardataset);
                        barChart.setData(data);
                        barChart.setDescription("");
                        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(5000);
                    }
                    if(temp==7)
                    {
                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(polls.getOption1count(), 0));
                        entries.add(new BarEntry(polls.getOption2count(), 1));
                        entries.add(new BarEntry(polls.getOption3count(), 2));
                        entries.add(new BarEntry(polls.getOption4count(), 3));
                        entries.add(new BarEntry(polls.getOption5count(), 4));
                        entries.add(new BarEntry(polls.getOption6count(), 5));
                        entries.add(new BarEntry(polls.getOption7count(), 6));

                        BarDataSet bardataset = new BarDataSet(entries, "Poll Options");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add(polls.getOption1());
                        labels.add(polls.getOption2());
                        labels.add(polls.getOption3());
                        labels.add(polls.getOption4());
                        labels.add(polls.getOption5());
                        labels.add(polls.getOption6());
                        labels.add(polls.getOption7());

                        BarData data = new BarData(labels, bardataset);
                        barChart.setData(data);
                        barChart.setDescription("");
                        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(5000);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

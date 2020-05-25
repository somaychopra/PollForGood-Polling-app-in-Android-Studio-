package software.project.pollforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import io.paperdb.Paper;

public class FillOptions extends AppCompatActivity {

    private String[] Options_String = new String[7];
    private int Hourofday,Dayofyear;
    private EditText Question, Time, edittexti1, edittexti2, edittexti3, edittexti4, edittexti5, edittexti6, edittexti7;
    private LinearLayout ll;
    private int TimeinHours,Value;
    private String QuestionString, saveCurrentDate, saveCurrentTime, pollRandomKey;
    private Button Create,Back;
    private ProgressDialog loadingBar;
    private DatabaseReference ProductsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_options);

        Intent myintent = getIntent();
        Value = myintent.getIntExtra("HeyOptions", 0);
        ll = (LinearLayout) findViewById(R.id.linear_layout2);
        Time = (EditText) findViewById(R.id.duration);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Poll");
        loadingBar = new ProgressDialog(this);
        Question = (EditText) findViewById(R.id.question);
        Back = (Button) findViewById(R.id.back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillOptions.this, AddPollButton.class);
                startActivity(intent);
            }
        });
        for (int i = 0; i < 7; i++) {
            Options_String[i] = "(NA)";
        }
        if (Value == 2) {
            EditText edittext1 = new EditText(this);
            edittext1.setHint("Option 1");
            EditText edittext2 = new EditText(this);
            edittext2.setHint("Option 2");
            if (edittext1.getParent() != null) {
                ((ViewGroup) edittext1.getParent()).removeView(edittext1);
            }
            if (edittext2.getParent() != null) {
                ((ViewGroup) edittext2.getParent()).removeView(edittext2);
            }
            ll.addView(edittext1);
            ll.addView(edittext2);
            Options_String[0] = edittext1.getText().toString();
            Options_String[1] = edittext2.getText().toString();
            edittexti1 = edittext1;
            edittexti2 = edittext2;
        }
        if (Value == 3) {
            EditText edittext1 = new EditText(this);
            edittext1.setHint("Option 1");
            EditText edittext2 = new EditText(this);
            edittext2.setHint("Option 2");
            EditText edittext3 = new EditText(this);
            edittext3.setHint("Option 3");
            if (edittext1.getParent() != null) {
                ((ViewGroup) edittext1.getParent()).removeView(edittext1);
            }
            if (edittext2.getParent() != null) {
                ((ViewGroup) edittext2.getParent()).removeView(edittext2);
            }
            if (edittext3.getParent() != null) {
                ((ViewGroup) edittext3.getParent()).removeView(edittext3);
            }
            ll.addView(edittext1);
            ll.addView(edittext2);
            ll.addView(edittext3);
            Options_String[0] = edittext1.getText().toString();
            Options_String[1] = edittext2.getText().toString();
            Options_String[2] = edittext3.getText().toString();
            edittexti1 = edittext1;
            edittexti2 = edittext2;
            edittexti3 = edittext3;
        }
        if (Value == 4) {
            EditText edittext1 = new EditText(this);
            edittext1.setHint("Option 1");
            EditText edittext2 = new EditText(this);
            edittext2.setHint("Option 2");
            EditText edittext3 = new EditText(this);
            edittext3.setHint("Option 3");
            EditText edittext4 = new EditText(this);
            edittext4.setHint("Option 4");

            if (edittext1.getParent() != null) {
                ((ViewGroup) edittext1.getParent()).removeView(edittext1);
            }
            if (edittext2.getParent() != null) {
                ((ViewGroup) edittext2.getParent()).removeView(edittext2);
            }
            if (edittext3.getParent() != null) {
                ((ViewGroup) edittext3.getParent()).removeView(edittext3);
            }
            if (edittext4.getParent() != null) {
                ((ViewGroup) edittext4.getParent()).removeView(edittext4);
            }
            ll.addView(edittext1);
            ll.addView(edittext2);
            ll.addView(edittext3);
            ll.addView(edittext4);
            Options_String[0] = edittext1.getText().toString();
            Options_String[1] = edittext2.getText().toString();
            Options_String[2] = edittext3.getText().toString();
            Options_String[3] = edittext4.getText().toString();
            edittexti1 = edittext1;
            edittexti2 = edittext2;
            edittexti3 = edittext3;
            edittexti4 = edittext4;
        }
        if (Value == 5) {
            EditText edittext1 = new EditText(this);
            edittext1.setHint("Option 1");
            EditText edittext2 = new EditText(this);
            edittext2.setHint("Option 2");
            EditText edittext3 = new EditText(this);
            edittext3.setHint("Option 3");
            EditText edittext4 = new EditText(this);
            edittext4.setHint("Option 4");
            EditText edittext5 = new EditText(this);
            edittext5.setHint("Option 5");
            if (edittext1.getParent() != null) {
                ((ViewGroup) edittext1.getParent()).removeView(edittext1);
            }
            if (edittext2.getParent() != null) {
                ((ViewGroup) edittext2.getParent()).removeView(edittext2);
            }
            if (edittext3.getParent() != null) {
                ((ViewGroup) edittext3.getParent()).removeView(edittext3);
            }
            if (edittext4.getParent() != null) {
                ((ViewGroup) edittext4.getParent()).removeView(edittext4);
            }
            if (edittext5.getParent() != null) {
                ((ViewGroup) edittext5.getParent()).removeView(edittext5);
            }
            ll.addView(edittext1);
            ll.addView(edittext2);
            ll.addView(edittext3);
            ll.addView(edittext4);
            ll.addView(edittext5);
            Options_String[0] = edittext1.getText().toString();
            Options_String[1] = edittext2.getText().toString();
            Options_String[2] = edittext3.getText().toString();
            Options_String[3] = edittext4.getText().toString();
            Options_String[4] = edittext5.getText().toString();
            edittexti1 = edittext1;
            edittexti2 = edittext2;
            edittexti3 = edittext3;
            edittexti4 = edittext4;
            edittexti5 = edittext5;
        }
        if (Value == 6) {
            EditText edittext1 = new EditText(this);
            edittext1.setHint("Option 1");
            EditText edittext2 = new EditText(this);
            edittext2.setHint("Option 2");
            EditText edittext3 = new EditText(this);
            edittext3.setHint("Option 3");
            EditText edittext4 = new EditText(this);
            edittext4.setHint("Option 4");
            EditText edittext5 = new EditText(this);
            edittext5.setHint("Option 5");
            EditText edittext6 = new EditText(this);
            edittext6.setHint("Option 6");
            if (edittext1.getParent() != null) {
                ((ViewGroup) edittext1.getParent()).removeView(edittext1);
            }
            if (edittext2.getParent() != null) {
                ((ViewGroup) edittext2.getParent()).removeView(edittext2);
            }
            if (edittext3.getParent() != null) {
                ((ViewGroup) edittext3.getParent()).removeView(edittext3);
            }
            if (edittext4.getParent() != null) {
                ((ViewGroup) edittext4.getParent()).removeView(edittext4);
            }
            if (edittext5.getParent() != null) {
                ((ViewGroup) edittext5.getParent()).removeView(edittext5);
            }
            if (edittext6.getParent() != null) {
                ((ViewGroup) edittext5.getParent()).removeView(edittext6);
            }
            ll.addView(edittext1);
            ll.addView(edittext2);
            ll.addView(edittext3);
            ll.addView(edittext4);
            ll.addView(edittext5);
            ll.addView(edittext6);
            Options_String[0] = edittext1.getText().toString();
            Options_String[1] = edittext2.getText().toString();
            Options_String[2] = edittext3.getText().toString();
            Options_String[3] = edittext4.getText().toString();
            Options_String[4] = edittext5.getText().toString();
            Options_String[5] = edittext6.getText().toString();
            edittexti1 = edittext1;
            edittexti2 = edittext2;
            edittexti3 = edittext3;
            edittexti4 = edittext4;
            edittexti5 = edittext5;
            edittexti6 = edittext6;
        }
        if (Value == 7) {
            EditText edittext1 = new EditText(this);
            edittext1.setHint("Option 1");
            EditText edittext2 = new EditText(this);
            edittext2.setHint("Option 2");
            EditText edittext3 = new EditText(this);
            edittext3.setHint("Option 3");
            EditText edittext4 = new EditText(this);
            edittext4.setHint("Option 4");
            EditText edittext5 = new EditText(this);
            edittext5.setHint("Option 5");
            EditText edittext6 = new EditText(this);
            edittext6.setHint("Option 6");
            EditText edittext7 = new EditText(this);
            edittext7.setHint("Option 7");
            if (edittext1.getParent() != null) {
                ((ViewGroup) edittext1.getParent()).removeView(edittext1);
            }
            if (edittext2.getParent() != null) {
                ((ViewGroup) edittext2.getParent()).removeView(edittext2);
            }
            if (edittext3.getParent() != null) {
                ((ViewGroup) edittext3.getParent()).removeView(edittext3);
            }
            if (edittext4.getParent() != null) {
                ((ViewGroup) edittext4.getParent()).removeView(edittext4);
            }
            if (edittext5.getParent() != null) {
                ((ViewGroup) edittext5.getParent()).removeView(edittext5);
            }
            if (edittext6.getParent() != null) {
                ((ViewGroup) edittext5.getParent()).removeView(edittext6);
            }
            if (edittext7.getParent() != null) {
                ((ViewGroup) edittext7.getParent()).removeView(edittext7);
            }
            ll.addView(edittext1);
            ll.addView(edittext2);
            ll.addView(edittext3);
            ll.addView(edittext4);
            ll.addView(edittext5);
            ll.addView(edittext6);
            ll.addView(edittext7);
            Options_String[0] = edittext1.getText().toString();
            Options_String[1] = edittext2.getText().toString();
            Options_String[2] = edittext3.getText().toString();
            Options_String[3] = edittext4.getText().toString();
            Options_String[4] = edittext5.getText().toString();
            Options_String[5] = edittext6.getText().toString();
            Options_String[6] = edittext7.getText().toString();
            edittexti1 = edittext1;
            edittexti2 = edittext2;
            edittexti3 = edittext3;
            edittexti4 = edittext4;
            edittexti5 = edittext5;
            edittexti6 = edittext6;
            edittexti7 = edittext7;
        }

        Create = (Button) findViewById(R.id.create_button);
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidatePollData();
            }
        });
    }

    private void ValidatePollData() {
        if(Time.getText()!=null) TimeinHours = Integer.parseInt(Time.getText().toString());

        QuestionString = Question.getText().toString();
        if(Value==2)
        {
            Options_String[0] = edittexti1.getText().toString();
            Options_String[1] = edittexti2.getText().toString();
        }
        if(Value==3)
        {
            Options_String[0] = edittexti1.getText().toString();
            Options_String[1] = edittexti2.getText().toString();
            Options_String[2] = edittexti3.getText().toString();
        }
        if(Value==4)
        {
            Options_String[0] = edittexti1.getText().toString();
            Options_String[1] = edittexti2.getText().toString();
            Options_String[2] = edittexti3.getText().toString();
            Options_String[3] = edittexti4.getText().toString();
        }
        if(Value==5)
        {
            Options_String[0] = edittexti1.getText().toString();
            Options_String[1] = edittexti2.getText().toString();
            Options_String[2] = edittexti3.getText().toString();
            Options_String[3] = edittexti4.getText().toString();
            Options_String[4] = edittexti5.getText().toString();
        }
        if(Value==6)
        {
            Options_String[0] = edittexti1.getText().toString();
            Options_String[1] = edittexti2.getText().toString();
            Options_String[2] = edittexti3.getText().toString();
            Options_String[3] = edittexti4.getText().toString();
            Options_String[4] = edittexti5.getText().toString();
            Options_String[5] = edittexti6.getText().toString();
        }
        if(Value==7)
        {
            Options_String[0] = edittexti1.getText().toString();
            Options_String[1] = edittexti2.getText().toString();
            Options_String[2] = edittexti3.getText().toString();
            Options_String[3] = edittexti4.getText().toString();
            Options_String[4] = edittexti5.getText().toString();
            Options_String[5] = edittexti6.getText().toString();
            Options_String[6] = edittexti7.getText().toString();
        }
        if (TextUtils.isEmpty(QuestionString)) {
            Toast.makeText(this, "Please enter the poll question....", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Time.getText()))
        {
            Toast.makeText(this, "Please enter the poll Duration....", Toast.LENGTH_SHORT).show();
        }
            else {
            StorePollInformation();
        }
    }

    private void StorePollInformation() {
        loadingBar.setTitle("Create New Poll");
        loadingBar.setMessage("Dear Admin, please wait while we are creating the new poll.");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MM,dd,yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());
        Hourofday = calendar.get(Calendar.HOUR_OF_DAY);
        Dayofyear = calendar.get(Calendar.DAY_OF_YEAR);

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
        saveCurrentTime = currentTime.format(calendar.getTime());

        pollRandomKey = saveCurrentDate + saveCurrentTime;
        SavePollInfoToDatabase();
    }

    private void SavePollInfoToDatabase() {
        HashMap<String, Object> pollMap = new HashMap<>();
        pollMap.put("pollid", pollRandomKey);
        pollMap.put("date", saveCurrentDate);
        pollMap.put("time", saveCurrentTime);
        pollMap.put("question", QuestionString);
        pollMap.put("option1", Options_String[0]);
        pollMap.put("option2", Options_String[1]);
        pollMap.put("option3", Options_String[2]);
        pollMap.put("option4", Options_String[3]);
        pollMap.put("option5", Options_String[4]);
        pollMap.put("option6", Options_String[5]);
        pollMap.put("option7", Options_String[6]);
        pollMap.put("option1count",0);
        pollMap.put("option2count",0);
        pollMap.put("option3count",0);
        pollMap.put("option4count",0);
        pollMap.put("option5count",0);
        pollMap.put("option6count",0);
        pollMap.put("option7count",0);
        pollMap.put("durationinHrs",TimeinHours);
        pollMap.put("hourofday",Hourofday);
        pollMap.put("dayofyear",Dayofyear);

        ProductsRef.child(pollRandomKey).updateChildren(pollMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            addtouserpolls(pollRandomKey);
                            Intent intent = new Intent(FillOptions.this, Home.class);
                            startActivity(intent);
                            loadingBar.dismiss();
                            Toast.makeText(FillOptions.this, "Poll created successfully..", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(FillOptions.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void addtouserpolls(String pollRandomKey) {
        String user_created;
        if(login.current_user_roll_number!=null)
            user_created = login.current_user_roll_number;//Paper.book().read("UserRoll");
        else
            user_created = Paper.book().read("UserRoll");
        final DatabaseReference heya = FirebaseDatabase.getInstance().getReference().child("UserCreated").child(user_created);
        HashMap<String, Object> pollMap = new HashMap<>();
        pollMap.put("pollid", pollRandomKey);
        pollMap.put("date", saveCurrentDate);
        pollMap.put("time", saveCurrentTime);
        pollMap.put("question", QuestionString);
        pollMap.put("option1", Options_String[0]);
        pollMap.put("option2", Options_String[1]);
        pollMap.put("option3", Options_String[2]);
        pollMap.put("option4", Options_String[3]);
        pollMap.put("option5", Options_String[4]);
        pollMap.put("option6", Options_String[5]);
        pollMap.put("option7", Options_String[6]);
        pollMap.put("option1count",0);
        pollMap.put("option2count",0);
        pollMap.put("option3count",0);
        pollMap.put("option4count",0);
        pollMap.put("option5count",0);
        pollMap.put("option6count",0);
        pollMap.put("option7count",0);
        pollMap.put("durationinHrs",TimeinHours);
        pollMap.put("hourofday",Hourofday);
        pollMap.put("dayofyear",Dayofyear);
        heya.child(pollRandomKey).updateChildren(pollMap)
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
}

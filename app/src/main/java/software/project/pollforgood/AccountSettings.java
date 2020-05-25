package software.project.pollforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;

import io.paperdb.Paper;
import software.project.pollforgood.Prevalent.Prevalent;

public class AccountSettings extends AppCompatActivity {

    private Button Close_button, Update_button;
    private EditText new_name, new_roll, new_phone, new_pass;
    private String user_created;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Close_button = (Button) findViewById(R.id.close_setting);
        Update_button = (Button) findViewById(R.id.update_setting);
        new_name = (EditText) findViewById(R.id.username);
        new_roll = (EditText) findViewById(R.id.roll);
        new_phone = (EditText) findViewById(R.id.phone_number);
        new_pass = (EditText) findViewById(R.id.password);
        if(login.current_user_roll_number!=null)
            user_created = login.current_user_roll_number;//Paper.book().read("UserRoll");
        else
            user_created = Paper.book().read("UserRoll");
        userinfodisplay();

        Close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateinfo();
            }
        });
    }

    private void updateinfo() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        HashMap<String, Object> userMap = new HashMap<>();
        userMap. put("name", new_name.getText().toString());
        userMap. put("phone", new_phone.getText().toString());
        userMap. put("password", new_pass.getText().toString());
        userMap. put("roll", new_roll.getText().toString());
        ref.child(user_created).removeValue();
        ref.child(new_roll.getText().toString()).updateChildren(userMap);

        startActivity(new Intent(AccountSettings.this, Home.class));
        Toast.makeText(AccountSettings.this, "Profile Info updated." +
                "Please Login Again.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AccountSettings.this,MainActivity.class);
        startActivity(intent);
    }

    private void userinfodisplay() {

        DatabaseReference Userref = FirebaseDatabase.getInstance().getReference().child("Users").child(user_created);
        Userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    String name = Objects.requireNonNull(dataSnapshot.child("name").getValue()).toString();
                    String roll = Objects.requireNonNull(dataSnapshot.child("roll").getValue()).toString();
                    String phone = Objects.requireNonNull(dataSnapshot.child("phone").getValue()).toString();
                    String password = Objects.requireNonNull(dataSnapshot.child("password").getValue()).toString();

                    new_name.setText(name);
                    new_pass.setText(password);
                    new_phone.setText(phone);
                    new_roll.setText(roll);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

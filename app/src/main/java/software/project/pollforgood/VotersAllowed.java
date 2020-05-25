package software.project.pollforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class VotersAllowed extends AppCompatActivity {

    private Button Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voters_allowed);

        Next = (Button) findViewById(R.id.next_button);
        Intent intenti = new Intent(VotersAllowed.this,AddPollButton.class);
        startActivity(intenti);

    }
}

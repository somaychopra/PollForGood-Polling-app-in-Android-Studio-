package software.project.pollforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPollButton extends AppCompatActivity{


    private RadioGroup radio_group;
    private RadioButton Option_selected;
    private Button Next,Back;
    private String selected;
    public int options=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_poll_button);


        radio_group = (RadioGroup) findViewById(R.id.radio_group);
        Option_selected = (RadioButton) findViewById(R.id.radioButton2);
        Next = (Button) findViewById(R.id.next_button) ;
        Back = (Button) findViewById(R.id.back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPollButton.this,YourPolls.class);
                startActivity(intent);
            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radio_group.getCheckedRadioButtonId();
                Option_selected = findViewById(radioId);
                int position = radio_group.indexOfChild(Option_selected);
                options = position + 2;
                /*Toast.makeText(AddPollButton.this, "Selected Radio Button: " +position ,
                        Toast.LENGTH_SHORT).show();*/
                Intent intentuti = new Intent(AddPollButton.this,FillOptions.class);
                intentuti.putExtra("HeyOptions",options);
                startActivity(intentuti);
            }
        });
    }

    /*public void checkButton(View v) {
        int radioId = radio_group.getCheckedRadioButtonId();
        Option_selected = findViewById(radioId);
        Toast.makeText(this, "Selected Radio Button: " + Option_selected.getText(),
                Toast.LENGTH_SHORT).show();
    }*/

}

package edu.psu.jeh5723.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            TextView tv = findViewById(R.id.textViewTo);
            tv.setText(savedInstanceState.getString("EMAIL_ADDRESS"));

            tv = findViewById(R.id.textViewSubject);
            tv.setText(savedInstanceState.getString("EMAIL_SUBJECT"));

            tv = findViewById(R.id.textViewResults);
            tv.setText(savedInstanceState.getString("RESULTS_DATA"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {


        //Saves email address
        TextView tv = findViewById(R.id.textViewTo);
        outState.putString("EMAIL_ADDRESS", tv.getText().toString());

        //saves subject
        tv = findViewById(R.id.textViewSubject);
        outState.putString("EMAIL_SUBJECT", tv.getText().toString());

        //saves results
        tv = findViewById(R.id.textViewResults);
        outState.putString("RESULTS_DATA", tv.getText().toString());

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    public void sendMessage(View view){
        //String EXTRA_MESSAGE = "SENDING MESSAGE";
        //Intent intent = new Intent(this, MainActivity.class);
        String message = "";

        //Get email address
        EditText editText = findViewById(R.id.editTextAddress);
        String emailAddress = editText.getText().toString();

        //Get email subject
        editText = findViewById(R.id.editTextSubject);
        String emailSubject = editText.getText().toString();

        //Get spinner value
        Spinner mySpinner = findViewById(R.id.dataStructureSpinner);
        String dataStructure = mySpinner.getSelectedItem().toString();
        int spinnerPosition = mySpinner.getSelectedItemPosition();

        //Get checkboxes
        CheckBox getMinCB = findViewById(R.id.checkBoxGetMin);
        CheckBox insertCB = findViewById(R.id.checkBoxInsert);
        CheckBox searchCB = findViewById(R.id.checkBoxSearch);

        //Get radio button selections
        RadioButton worstCaseRB = findViewById(R.id.radioButtonWorstCase);
        RadioButton averageCaseRB = findViewById(R.id.radioButtonAverageCase);

        //Fill in results
        TextView textView = findViewById(R.id.textViewTo);
        textView.setText(emailAddress);

        textView = findViewById(R.id.textViewSubject);
        textView.setText(emailSubject);

        int selectedCase = 0;
        if (worstCaseRB.isChecked()) {
            message = "Worst Case";
            selectedCase = 0;
        }
        if (averageCaseRB.isChecked()) {
            message = "Average Case";
            selectedCase = 1;
        }

        message = message + " Time Complexity for " + dataStructure + " Operations\n";


        String[][][] complexity = { { {"O(log(n))", "O(log(n))", "O(log(n))"},
                                                         {"ϴ(log(n))", "ϴ(log(n))", "ϴ(log(n))"} },
                                                       { {"O(n)", "O(n)", "O(n)"},
                                                         {"ϴ(log(n))", "ϴ(log(n))", "ϴ(log(n))"} },
                                                       { {"O(n)", "O(n)", "O(n)"},
                                                         {"ϴ(1)", "ϴ(1)", "ϴ(1)"} },
                                                       { {"O(n)", "O(1)", "O(n)"},
                                                         {"ϴ(n)", "ϴ(1)", "ϴ(n)"} },
                                                       { {"O(1)", "O(log(n))", "O(n)"},
                                                         {"ϴ(1)", "ϴ(log(n))", "ϴ(n)"} } };

        if (getMinCB.isChecked()){
            message = message + "    Get Minimum: " + complexity[spinnerPosition][selectedCase][0] + "\n";
        }
        if (insertCB.isChecked()) {
            if (spinnerPosition == 3) {
                message = message + "    Insert (at the beginning): " + complexity[spinnerPosition][selectedCase][1] + "\n";
            }
            else{
                message = message + "    Insert: " + complexity[spinnerPosition][selectedCase][1] + "\n";
            }
        }
        if (searchCB.isChecked()){
            message = message + "    Search: " + complexity[spinnerPosition][selectedCase][2] + "\n";
        }

        //Sets the text
        textView = findViewById(R.id.textViewResults);
        textView.setText(message);

        //@@@@@@@@@@@@@@@@@ For later implementation @@@@@@@@@@@@@@@@@@@@@
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

    }


}


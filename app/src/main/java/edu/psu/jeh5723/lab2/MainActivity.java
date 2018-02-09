package edu.psu.jeh5723.lab2;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        //String EXTRA_MESSAGE = "SENDING MESSAGE";
        //Intent intent = new Intent(this, MainActivity.class);
        String message = "";

        //Get email address
        EditText editText = (EditText) findViewById(R.id.editTextAddress);
        String emailAddress = editText.getText().toString();

        //Get email subject
        editText = (EditText) findViewById(R.id.editTextSubject);
        String emailSubject = editText.getText().toString();

        //Get spinner value
        Spinner mySpinner =(Spinner) findViewById(R.id.dataStructureSpinner);
        String dataStructure = mySpinner.getSelectedItem().toString();
        int spinnerPosition = mySpinner.getSelectedItemPosition();

        //Get checkboxes
        CheckBox getMinCB = (CheckBox)findViewById(R.id.checkBoxGetMin);
        CheckBox insertCB = (CheckBox)findViewById(R.id.checkBoxInsert);
        CheckBox searchCB = (CheckBox)findViewById(R.id.checkBoxSearch);

        //Get radio button selections
        RadioButton worstCaseRB = (RadioButton)findViewById(R.id.radioButtonWorstCase);
        RadioButton averageCaseRB = (RadioButton)findViewById(R.id.radioButtonAverageCase);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioCase);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        TextView textView = (TextView) findViewById(R.id.textViewResults);

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
            message = message + "   Get Min: " + complexity[spinnerPosition][selectedCase][0] + "\n";
        }
        if (insertCB.isChecked()){
            message = message + "   Insert: " + complexity[spinnerPosition][selectedCase][1] + "\n";
        }
        if (searchCB.isChecked()){
            message = message + "   Search: " + complexity[spinnerPosition][selectedCase][2] + "\n";
        }





        textView.setText(message);
        //@@@@@@@@@@@@@@@@@ For later implementation @@@@@@@@@@@@@@@@@@@@@
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

    }


}


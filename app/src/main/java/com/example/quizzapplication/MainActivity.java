package com.example.quizzapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText questOne;
    public EditText questThree;
    public EditText questFive;
    public EditText questSix;
    public EditText questSeven;
    public EditText questEight;
    public Button submitButton;
    public CheckBox cbShikar;
    public CheckBox cbSharma;
    public CheckBox cbKholi;
    public CheckBox cbDev;
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * creating views:
         */

        //Edit text view
        questOne = findViewById(R.id.questOne);
        questThree = findViewById(R.id.questThree);
        questFive = findViewById(R.id.questFive);
        questSix = findViewById(R.id.questSix);
        questSeven = findViewById(R.id.questSeven);
        questEight = findViewById(R.id.questEight);

        //Button view
        submitButton = findViewById(R.id.submitButton);

        //CheckBox view:
        cbShikar = findViewById(R.id.cbShikar);
        cbDev = findViewById(R.id.cbDev);
        cbKholi = findViewById(R.id.cbKholi);
        cbSharma = findViewById(R.id.cbSharma);

        //radio button
        radioGroup = (RadioGroup) findViewById(R.id.groupRadio);

        onClickListener();

    }


    private void onClickListener() {

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculating the score of the result

                if (!questOne.getText().toString().isEmpty() && !questThree.getText().toString().isEmpty() && !questFive.getText().toString().isEmpty()
                        && !questSix.getText().toString().isEmpty() && !questSeven.getText().toString().isEmpty() && !questEight.getText().toString().isEmpty()) {
                    if (questOne.getText().toString().equals(getString(R.string.year))) {
                        score++;
                    }

                    if (questThree.getText().toString().equals(getString(R.string.new_zealand)) || questThree.getText().toString().equals(getString(R.string.new_small_zealand))) {
                        score++;
                    }

                    if (questFive.getText().toString().equals(getString(R.string.umpire)) || questFive.getText().toString().equals(getString(R.string.small_umpire))) {
                        score++;
                    }

                    if (questSix.getText().toString().equals(getString(R.string.joe_root)) || questSix.getText().toString().equals(getString(R.string.joe_small_root))) {
                        score++;
                    }

                    if (questSeven.getText().toString().equals(getString(R.string.australia)) || questSeven.getText().toString().equals(getString(R.string.small_australia))) {
                        score++;
                    }

                    if (questEight.getText().toString().equals(getString(R.string.sunil_gavaskar)) || questEight.getText().toString().equals(getString(R.string.sunil_small_gavaskar))) {
                        score++;
                    }

                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);

                    if (radioButton.getText().toString().equals(getString(R.string.unlimited_overs)) || radioButton.getText().toString().equals(getString(R.string.unlimited_small_overs))) {
                        score++;
                    }

                    if (cbSharma.isChecked() && cbShikar.isChecked()) {
                        score++;
                    }
                } else {
                    Toast.makeText(MainActivity.this, R.string.mandatory_questions, Toast.LENGTH_SHORT).show();
                }



                Toast.makeText(MainActivity.this, getString(R.string.you_have_scored) + score + getString(R.string.by_8), Toast.LENGTH_SHORT).show();

                score = 0;
            }
        });

    }
}

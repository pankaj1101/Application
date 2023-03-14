package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class MainActivity2 extends AppCompatActivity {

    private EditText name, phone, age, gender, marital, domilcile, education, occupation, concern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.mobile);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        marital = findViewById(R.id.marital_status);
        domilcile = findViewById(R.id.domilcile);
        education = findViewById(R.id.Education);
        occupation = findViewById(R.id.Occupation);
        concern = findViewById(R.id.Concerns);


        findViewById(R.id.submitButton).setOnClickListener(v -> {
            String namee = name.getText().toString();
            String phonee = phone.getText().toString();
            String agee = age.getText().toString();
            String genderr = gender.getText().toString();
            String maritall = marital.getText().toString();
            String domilcilee = domilcile.getText().toString();
            String educationn = education.getText().toString();
            String occupationn = occupation.getText().toString();
            String concernn = concern.getText().toString();

            store(namee, phonee, agee, genderr, maritall, domilcilee, educationn, occupationn, concernn);
            startActivity(new Intent(this, MainActivity3.class));
        });
    }

    private void store(String namee, String phonee, String agee, String genderr, String maritall, String domilcilee, String educationn, String occupationn, String concernn) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();

        HashMap<Object, String> hashMap = new HashMap<>();
        hashMap.put("Name", namee);
        hashMap.put("Mobile Number", phonee);
        hashMap.put("Gender", genderr);
        hashMap.put("Marital Status", maritall);
        hashMap.put("Domilcile", domilcilee);
        hashMap.put("Education", educationn);
        hashMap.put("Occupation", occupationn);
        hashMap.put("Concern", concernn);

        reference.child("Information").setValue(hashMap);
        Toast.makeText(this, "Data successfully Stored", Toast.LENGTH_SHORT).show();
        finish();
    }
}

package  com.example.realtimedatbase_usingfirbase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.realtimedatbase_usingfirbase.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userId;
    EditText address;
    EditText mobileNumber;
    Button readBtn;
    Button updateBtn;
    Button insertBtn;
    Button deleteBtn;

    TextView textId;
    TextView textName;
    TextView textAddress;
    TextView textmb;

    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing UI components
        userName = findViewById(R.id.userName);
        userId = findViewById(R.id.userData);
        readBtn = findViewById(R.id.readBtn);
        updateBtn = findViewById(R.id.updateBtn);
        insertBtn = findViewById(R.id.insertBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        address = findViewById(R.id.addressEditText);
        mobileNumber = findViewById(R.id.mbEditText);

        textId = findViewById(R.id.textId);
        textName = findViewById(R.id.textName);
        textAddress = findViewById(R.id.textAddress);
        textmb = findViewById(R.id.textmb);

        // Reference to Firebase Realtime Database
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        // Insert Button Logic
        insertBtn.setOnClickListener(view -> {
            String name = userName.getText().toString();
            String address1 = address.getText().toString();
            String mobile = mobileNumber.getText().toString();
            int id = Integer.parseInt(userId.getText().toString());

            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("Name", name);
            hashMap.put("Id", id);
            hashMap.put("Address", address1);
            hashMap.put("Mobile", mobile);

            databaseReference.child("user1").setValue(hashMap).addOnSuccessListener(aVoid -> {
                Toast.makeText(MainActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e -> {
                Toast.makeText(MainActivity.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
            });
        });

        // Read Button Logic
        readBtn.setOnClickListener(view -> databaseReference.child("user1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    if (map != null) {
                        Object id = map.get("Id");
                        Object name = map.get("Name");
                        Object address = map.get("Address");
                        Object mobile = map.get("Mobile");

                        // Update UI with data
                        if (id != null) textId.setText(id.toString());
                        if (name != null) textName.setText(name.toString());
                        if (address != null) textAddress.setText(address.toString());
                        if (mobile != null) textmb.setText(mobile.toString());
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Failed to read data", Toast.LENGTH_SHORT).show();
            }
        }));

        // Update Button Logic
        updateBtn.setOnClickListener(view -> {
            String name = userName.getText().toString();
            String address1 = address.getText().toString();
            String mobile = mobileNumber.getText().toString();
            int id = Integer.parseInt(userId.getText().toString());

            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("Name", name);
            hashMap.put("Id", id);
            hashMap.put("Address", address1);
            hashMap.put("Mobile", mobile);

            databaseReference.child("user1").updateChildren(hashMap).addOnSuccessListener(aVoid -> {
                Toast.makeText(MainActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e -> {
                Toast.makeText(MainActivity.this, "Failed to update data", Toast.LENGTH_SHORT).show();
            });
        });

        // Delete Button Logic
        deleteBtn.setOnClickListener(view -> {
            databaseReference.child("user1").removeValue().addOnSuccessListener(aVoid -> {
                Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e -> {
                Toast.makeText(MainActivity.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
            });
        });
    }
}

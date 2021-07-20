package sg.edu.rp.c346.id20019648.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    Button btnUpdate, btnDelete;
    EditText etContent;
    TextView tvID, tvEdit;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        etContent = findViewById(R.id.etContent);
        tvEdit = findViewById(R.id.tvEdit);
        tvID = findViewById(R.id.tvID);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etContent.setText(data.getNoteContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();

                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                finish();
            }
        });
    }
}
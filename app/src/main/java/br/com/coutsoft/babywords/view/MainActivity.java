package br.com.coutsoft.babywords.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.coutsoft.babywords.R;
import br.com.coutsoft.babywords.model.Word;
import br.com.coutsoft.babywords.service.WordAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter adapter;
    private List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wordList = new ArrayList<>();
        wordList.add(new Word("Apple", LocalDate.of(2024, 6, 16)));
        wordList.add(new Word("Banana", LocalDate.of(2024, 5, 22)));
        wordList.add(new Word("Orange", LocalDate.of(2024, 4, 26)));

        adapter = new WordAdapter(wordList);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Word deletedWord = wordList.get(position);
                wordList.remove(position);
                adapter.notifyItemRemoved(position);

            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
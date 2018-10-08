package com.tinkoff.androidcourse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.tinkoff.androidcourse.recycler.ItemTouchHelperCallback;
import com.tinkoff.androidcourse.recycler.RecyclerWithEmptyView;
import com.tinkoff.androidcourse.recycler.WorkersAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int TEST_WORKERS_COUNT = 5;

    private RecyclerWithEmptyView workersRecyclerView;
    private WorkersAdapter workersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workersRecyclerView = findViewById(R.id.recycler_view);
        workersRecyclerView.setEmptyView(findViewById(R.id.tv_empty_view));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Реализовать добавление тестовых работников
                 */
                Worker worker = WorkerGenerator.generateWorker();
                workersAdapter.addItem(worker);
                workersRecyclerView.smoothScrollToPosition(workersAdapter.getItemCount());
            }
        });


        /**
         * Реализовать адаптер, выбрать любой LayoutManager и прикрутить это всё к RecyclerView
         *
         * Тестовые данные для отображения генерятся WorkerGenerator
         */
        List<Worker> testWorkers = WorkerGenerator.generateWorkers(TEST_WORKERS_COUNT);
        workersAdapter = new WorkersAdapter(testWorkers);
        workersRecyclerView.setAdapter(workersAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        workersRecyclerView.setLayoutManager(layoutManager);

        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(workersAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(workersRecyclerView);
    }
}

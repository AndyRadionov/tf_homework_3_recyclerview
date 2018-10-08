package com.tinkoff.androidcourse;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Andrey Radionov
 */
public class WorkersAdapter extends RecyclerView.Adapter<WorkersAdapter.WorkerViewHolder> {

    private final List<Worker> workers;

    public WorkersAdapter(@NonNull final List<Worker> workers) {
        this.workers = workers;
    }

    @NonNull
    @Override
    public WorkerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_worker, parent, false);
        return new WorkerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerViewHolder holder, int position) {
        final Worker worker = workers.get(position);
        Resources resources = holder.itemView.getResources();

        holder.photo.setImageResource(worker.getPhoto());
        holder.name.setText(worker.getName());
        holder.position.setText(resources.getString(R.string.position_label_text, worker.getPosition()));
        holder.age.setText(resources.getString(R.string.age_label_text, worker.getAge()));
    }

    @Override
    public int getItemCount() {
        return workers.size();
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
        notifyItemInserted(workers.size() - 1);
    }

    static class WorkerViewHolder extends RecyclerView.ViewHolder {

        private final ImageView photo;
        private final TextView name;
        private final TextView position;
        private final TextView age;

        private WorkerViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.iv_worker_photo);
            name = itemView.findViewById(R.id.tv_worker_name);
            position = itemView.findViewById(R.id.tv_worker_position);
            age = itemView.findViewById(R.id.tv_worker_age);
        }
    }
}

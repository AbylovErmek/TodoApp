package com.geektech.todoapp.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.todoapp.R;
import com.geektech.todoapp.databinding.FragmentHomeBinding;
import com.geektech.todoapp.databinding.ItemTodoBinding;
import com.geektech.todoapp.ui.models.Task;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> list = new ArrayList<>();

    public void addItems(Task task) {
        list.add(task);
        notifyDataSetChanged();
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NotNull TaskAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemTodoBinding binding;

        public ViewHolder(ItemTodoBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Task task) {
            binding.textTitle.setText(task.getTitle());
        }
    }
}

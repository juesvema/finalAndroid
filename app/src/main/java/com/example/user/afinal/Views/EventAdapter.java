package com.example.user.afinal.Views;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.afinal.Domain.Event;
import com.example.user.afinal.Model.ItemEventViewModel;
import com.example.user.afinal.R;
import com.example.user.afinal.databinding.ItemEventBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by User on 28/10/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventAdapterViewHolder> {

    private List<Event> eventList;

    public EventAdapter() {
        this.eventList = Collections.emptyList();
    }

    @Override
    public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEventBinding itemEventBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_event,
                        parent, false);
        return new EventAdapterViewHolder(itemEventBinding);
    }

    @Override
    public void onBindViewHolder(EventAdapterViewHolder holder, int position) {
        holder.bindEvent(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemEventBinding itemEventBinding;

        public EventAdapterViewHolder(ItemEventBinding itemEventBinding) {
            super(itemEventBinding.itemEvent);
            this.itemEventBinding = itemEventBinding;
        }

        void bindEvent(Event event) {
            if (itemEventBinding.getEventViewModel() == null) {
                itemEventBinding.setEventViewModel(
                        new ItemEventViewModel(event, itemView.getContext()));
            } else {
                itemEventBinding.getEventViewModel().setEvent(event);
            }
        }
    }
}

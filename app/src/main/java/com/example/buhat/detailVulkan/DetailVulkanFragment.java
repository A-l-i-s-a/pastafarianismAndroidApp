package com.example.buhat.detailVulkan;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.buhat.BD.Event;
import com.example.buhat.R;

import java.util.Objects;


public class DetailVulkanFragment extends Fragment {

    Event event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_vulkan, container, false);
        Application application = Objects.requireNonNull(getActivity()).getApplication();

        Bundle bundle = getArguments();
        event = new Event();
        System.out.println(bundle);
        if (bundle != null) {
            event = bundle.getParcelable("event");
            System.out.println(event);
        }


        ImageView imageView = view.findViewById(R.id.imageView2);
        Glide
                .with(imageView.getContext())
                .load(event.getBar().getImageUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image))
                .into(imageView);

        TextView textViewNameDetail = view.findViewById(R.id.textViewNameDetail);
        TextView textViewCountPeople = view.findViewById(R.id.textViewCountPeople);
        TextView textViewAutor = view.findViewById(R.id.textViewAutor);
        TextView textViewDescripticon = view.findViewById(R.id.textViewDescripticon);
        TextView textViewAddress = view.findViewById(R.id.textViewAddress);

        System.out.println(event.toString());

        textViewNameDetail.setText(event.getEventName());
        textViewCountPeople.setText(Integer.toString(event.getCountPeople()));
        textViewAutor.setText(event.getEventCreator().getLogin());
        textViewDescripticon.setText(event.getDescription());
        textViewAddress.setText(event.getAddress());


        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = event.getCountPeople();
                event.setCountPeople(count + 1);
                textViewCountPeople.setText(Integer.toString(event.getCountPeople()));
            }
        });

        return view;
    }

}

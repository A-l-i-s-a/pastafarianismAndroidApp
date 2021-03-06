package com.example.buhat.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buhat.BD.Event;
import com.example.buhat.R;
import com.example.buhat.BD.Msg;
import com.example.buhat.chat.msg.MsgAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChatFragment extends Fragment {
    private List<Msg> msgs = new ArrayList<>();
    private void setMsgs() {
        msgs.add(new Msg("User 1", "Fkdbf dfj sdksdlkb lszvn jdfv lxkdfhb ldfh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 1", "Uh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 2", "Lvn jdfv lxkdfhb ldfh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 1", "Dfj sdksdlkb lszvn jdfv lxkdfhb ldfh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 2", "Fkdbfb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 2", "Fkdbf skjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 1", "Ykdbf dfj sdksdlkb lsbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 1", "Rlxkdfhb ldfh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 1", "Pkdbszvn jdfv lxkdfhb ldfh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 2", "Fkh lfkbhskjb jhhfkfg", Calendar.getInstance()));
        msgs.add(new Msg("User 1", "Fkdbf dfj sdksdlkb lszvn jdfv lxkdfhb ldfh lfkbhskjb jhhfkfg", Calendar.getInstance()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chat, container, false);

        setMsgs();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMsgs);
        MsgAdapter msgAdapter = new MsgAdapter(msgs);
        recyclerView.setAdapter(msgAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Event event = new Event();

        Bundle bundle = getArguments();
        event = new Event();
        System.out.println(bundle);
        if (bundle != null) {
            event = bundle.getParcelable("event");
            System.out.println(event);
        }


        Event finalEvent = event;
        view.findViewById(R.id.buttonSend).setOnClickListener(view1 -> {
            EditText editText = view.findViewById(R.id.editText);
            msgs.add(new Msg(finalEvent.getEventCreator().getLogin(), editText.getText().toString(), Calendar.getInstance()));
            msgAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(msgAdapter.getItemCount() - 1);
            editText.setText("");
        });

        return view;
    }
}

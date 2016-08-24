package com.example.my.viewpagerstrip;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by My on 2016/7/22.
 */
public class DummaryFragment extends Fragment {
    private ListView listView_dummary;
    private SimpleAdapter sim_adapter = null;
    private Context mContext = null;
    private List<Map<String, Object>> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int tabIndex = getArguments().getInt("tabIndex");
        mContext = getContext();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("icon", R.mipmap.ic_launcher);
            map.put("title", "title" + i + ">>>" + tabIndex);
            map.put("summary", "summmary" + i + ">>>" + tabIndex);
            list.add(map);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummary, container, false);
        listView_dummary = (ListView) view.findViewById(R.id.listView_fragment_dummary);
        sim_adapter = new SimpleAdapter(mContext, list, R.layout.item_listview_fragment, new
                String[]{"icon", "title", "summary"}, new int[]{R.id.imageView_item_listView, R
                .id.textView_item_title, R.id.textView_item_summary});
        listView_dummary.setAdapter(sim_adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static DummaryFragment newInstance(int tabIndex) {

        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", tabIndex);
        DummaryFragment fragment = new DummaryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}

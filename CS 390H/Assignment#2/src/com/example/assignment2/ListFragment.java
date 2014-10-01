package com.example.assignment2;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListFragment extends Fragment {
	OnItemSelectedListener activityCall;
	ListView lv;
	ArrayAdapter<String> listAdapter;
	ViewGroup hostContainer;
	OnItemClickListener listClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.i("ListFragment_listClickListener", "parent "
					+ parent);
			Log.i("Fragment_listClickListener", "view " + view);
			Log.i("ListFragment_listClickListener", "position "
					+ position);
			Log.i("Assignment2ListFragment_listClickListener", "id " + id);
			activityCall.onItemSelected(parent.getItemAtPosition(position)
					.toString());
		}
	};

	public interface OnItemSelectedListener {
		public void onItemSelected(String itemName);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("ListFragment_onCreateView", "On create started");
		if (container == null) {
			return null;
		}
		View view = inflater.inflate(R.layout.list_fragment, container,
				false);
		lv = (ListView) view.findViewById(R.id.mainListView);
		String[] values = new String[] { "Cheddar", "Swiss", "Parmigiano-Reggiano",
				"Brie", "Feta", "Mozzarella","Monterey Jack", "Provolone",
				"Gouda", "Gorgonzolla", "Bleu", "Havarti"};
		ArrayAdapter<String> files = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, values);
		lv.setAdapter(files);
		lv.setOnItemClickListener(listClickListener);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception
		try {
			activityCall = (OnItemSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnItemSelectedListener");
		}
	}
}
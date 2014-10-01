package com.example.assignment2;

import android.support.v4.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {
	// private static ImageView drawingImageView = null;
	final static String IMAGETODISPLAY = "Name of the Image to Display";
	String imageName = "default";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			imageName = savedInstanceState.getString(IMAGETODISPLAY);
		}
		return inflater.inflate(R.layout.image_fragment, container,
				false);
	}

	@Override
	public void onStart() {
		super.onStart();
		Bundle args = getArguments();
		if (args != null) {
			updateImageView(args.getString(IMAGETODISPLAY));
		} else if (!imageName.equalsIgnoreCase("default")) {
			updateImageView(imageName);
		}
	}

	public void updateImageView(String newImageName) {
		Drawable picture = null;
		ImageView image = (ImageView) getActivity().findViewById(
				R.id.listImageViewer);
		if (newImageName.equalsIgnoreCase("Parmigiano-Reggiano")) {
			picture = getResources().getDrawable(R.drawable.parmesan);
		} else if (newImageName.equalsIgnoreCase("Brie")) {
			picture = getResources().getDrawable(R.drawable.brie);
		} else if (newImageName.equalsIgnoreCase("Feta")) {
			picture = getResources().getDrawable(R.drawable.feta);
		} else if (newImageName.equalsIgnoreCase("Swiss")) {
			picture = getResources().getDrawable(R.drawable.swiss);
		} else if (newImageName.equalsIgnoreCase("Mozzarella")) {
			picture = getResources().getDrawable(R.drawable.mozzarella);
		} else if (newImageName.equalsIgnoreCase("Monterey Jack")) {
			picture = getResources().getDrawable(R.drawable.montereyjack);
		} else if (newImageName.equalsIgnoreCase("Provolone")) {
			picture = getResources().getDrawable(R.drawable.provolone);
		} else if (newImageName.equalsIgnoreCase("Gouda")) {
			picture = getResources().getDrawable(R.drawable.gouda);
		} else if (newImageName.equalsIgnoreCase("Gorgonzolla")) {
			picture = getResources().getDrawable(R.drawable.gorgonzolla);
		} else if (newImageName.equalsIgnoreCase("Bleu")) {
			picture = getResources().getDrawable(R.drawable.bluecheese);
		} else if (newImageName.equalsIgnoreCase("Havarti")) {
			picture = getResources().getDrawable(R.drawable.havarti);
		} else {
			picture = getResources().getDrawable(R.drawable.cheddar);
		}
		image.setImageDrawable(picture);
		imageName = newImageName;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(IMAGETODISPLAY, imageName);
	}
}
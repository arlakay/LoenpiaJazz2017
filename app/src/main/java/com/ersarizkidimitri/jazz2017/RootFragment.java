package com.ersarizkidimitri.jazz2017;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.ersarizkidimitri.jazz2017.about.AboutActivity;
import com.ersarizkidimitri.jazz2017.artist.ArtistActivity;
import com.ersarizkidimitri.jazz2017.schedule.StageActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class RootFragment extends Fragment {
	private FrameLayout fragmentContainer;
	private RecyclerView recyclerView;
	private RecyclerView.LayoutManager layoutManager;

	private GoogleMap googleMap;
	MapView mMapView;

	/**
	 * Create a new instance of the fragment
	 */
	public static RootFragment newInstance(int index) {
		RootFragment fragment = new RootFragment();
		Bundle b = new Bundle();
		b.putInt("index", index);
		fragment.setArguments(b);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (getArguments().getInt("index", 0) == 0) {
			View view = inflater.inflate(R.layout.fragment_home, container, false);
			initHomeView(view);
			return view;
		}
		if (getArguments().getInt("index", 1) == 1) {
			View view = inflater.inflate(R.layout.fragment_my_plan, container, false);
//			initDemoSettings(view);
			return view;
		} else {
			View view = inflater.inflate(R.layout.fragment_map, container, false);

			mMapView = (MapView) view.findViewById(R.id.map);
			mMapView.onCreate(savedInstanceState);

			mMapView.onResume(); // needed to get the map to display immediately

			try {
				MapsInitializer.initialize(getActivity());
			} catch (Exception e) {
				e.printStackTrace();
			}

			mMapView.getMapAsync(new OnMapReadyCallback() {
				@Override
				public void onMapReady(GoogleMap mMap) {
					googleMap = mMap;

					LatLng sydney = new LatLng(-6.9929414,110.418244);
					googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

					CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(13).build();
					googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

					if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
							&& ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
						// TODO: Consider calling
						return;
					}
					googleMap.setMyLocationEnabled(true);

				}
			});

			return view;
		}
	}

	private  void initHomeView(View view){
		ImageButton btnSchedule = (ImageButton) view.findViewById(R.id.btn_schedule);
		ImageButton btnArtist = (ImageButton) view.findViewById(R.id.btn_artist);
		ImageButton btnAbout = (ImageButton) view.findViewById(R.id.btn_about);

		btnSchedule.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getActivity(), StageActivity.class);
				startActivity(i);
			}
		});
		btnArtist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getActivity(), ArtistActivity.class);
				startActivity(i);
			}
		});
		btnAbout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getActivity(), AboutActivity.class);
				startActivity(i);
			}
		});
	}

	public void refresh() {
		if (getArguments().getInt("index", 0) > 0 && recyclerView != null) {
			recyclerView.smoothScrollToPosition(0);
		}
	}

	public void willBeDisplayed() {
		// Do what you want here, for example animate the content
		if (fragmentContainer != null) {
			Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
			fragmentContainer.startAnimation(fadeIn);
		}
	}

	public void willBeHidden() {
		if (fragmentContainer != null) {
			Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
			fragmentContainer.startAnimation(fadeOut);
		}
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mMapView.onLowMemory();
	}

}

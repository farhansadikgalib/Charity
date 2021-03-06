package com.farhan.charity;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class PresentAddressFragment extends Fragment {

    TextView present_address_village_bnTV, present_address_road_bnTV, division_name_bnTV, district_name_bnTV, thana_name_bnTV,
            upazila_name_bnTV, post_office_name_bnTV, post_office_code_bnTV;
    private RequestQueue mRequestQueue;

    public PresentAddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_present_address_fragment, container, false);

        present_address_village_bnTV = view.findViewById(R.id.present_address_village_bnID);
        present_address_road_bnTV = view.findViewById(R.id.present_address_road_bnID);
        division_name_bnTV = view.findViewById(R.id.division_name_bnID);
        district_name_bnTV = view.findViewById(R.id.district_name_bnID);
        thana_name_bnTV = view.findViewById(R.id.thana_name_bnID);
        upazila_name_bnTV = view.findViewById(R.id.upazila_name_bnID);
        post_office_name_bnTV = view.findViewById(R.id.post_office_name_bnID);
        post_office_code_bnTV = view.findViewById(R.id.post_office_code_bnID);

        mRequestQueue = Volley.newRequestQueue(getContext());

        PresentAddressParse();

        return view;
    }

    private void PresentAddressParse() {


        String url = "http://charity.olivineltd.com/api/user/vfDDQMOL20180726203942";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //      Toast.makeText(DashBoard.this,response.toString(),Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject = (JSONObject) response.get("presentAddress");

                    String present_address_village_bn = jsonObject.getString("present_address_village_bn");
                    String present_address_road_bn = jsonObject.getString("present_address_road_bn");
                    String division_name_bn = jsonObject.getString("division_name_bn");
                    String district_name_bn = jsonObject.getString("district_name_bn");
                    String thana_name_bn = jsonObject.getString("thana_name_bn");
                    String upazila_name_bn = jsonObject.getString("upazila_name_bn");
                    String post_office_name_bn = jsonObject.getString("post_office_name_bn");
                    String post_office_code_bn = jsonObject.getString("post_office_code_bn");


                    present_address_village_bnTV.setText(present_address_village_bn);
                    present_address_road_bnTV.setText(present_address_road_bn);
                    division_name_bnTV.setText(division_name_bn);
                    district_name_bnTV.setText(district_name_bn);
                    thana_name_bnTV.setText(thana_name_bn);
                    upazila_name_bnTV.setText(upazila_name_bn);
                    post_office_name_bnTV.setText(post_office_name_bn);
                    post_office_code_bnTV.setText(post_office_code_bn);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
            }
        });

        mRequestQueue.add(request);
    }

}
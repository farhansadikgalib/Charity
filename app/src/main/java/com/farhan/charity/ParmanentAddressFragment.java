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
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParmanentAddressFragment extends Fragment {

    TextView permanent_address_village_bnTV, permanent_address_road_bnTV, division_name_bnTV, district_name_bnTV, thana_name_bnTV,
            upazila_name_bnTV, post_office_name_bnTV, post_office_code_bnTV;
    private RequestQueue mRequestQueue;


    public ParmanentAddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_parmanent_address_fragment, container, false);

        permanent_address_village_bnTV = view.findViewById(R.id.permanent_address_village_bnID);
        permanent_address_road_bnTV = view.findViewById(R.id.permanent_address_road_bnID);
        division_name_bnTV = view.findViewById(R.id.pt_division_name_bnID);
        district_name_bnTV = view.findViewById(R.id.pt_district_name_bnID);
        thana_name_bnTV = view.findViewById(R.id.pt_thana_name_bnID);
        upazila_name_bnTV = view.findViewById(R.id.pt_upazila_name_bnID);
        post_office_name_bnTV = view.findViewById(R.id.pt_post_office_name_bnID);
        post_office_code_bnTV = view.findViewById(R.id.pt_post_office_code_bnID);

        mRequestQueue = Volley.newRequestQueue(getContext());

        permanentAddressParse();

        return view;
    }

    private void permanentAddressParse() {


        String url = "http://charity.olivineltd.com/api/user/vfDDQMOL20180726203942";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //      Toast.makeText(DashBoard.this,response.toString(),Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject = (JSONObject) response.get("permanentAddress");

                    String permanent_address_village_bn = jsonObject.getString("permanent_address_village_bn");
                    String permanent_address_road_bn = jsonObject.getString("permanent_address_road_bn");
                    String division_name_bn = jsonObject.getString("division_name_bn");
                    String district_name_bn = jsonObject.getString("district_name_bn");
                    String thana_name_bn = jsonObject.getString("thana_name_bn");
                    String upazila_name_bn = jsonObject.getString("upazila_name_bn");
                    String post_office_name_bn = jsonObject.getString("post_office_name_bn");
                    String post_office_code_bn = jsonObject.getString("post_office_code_bn");

                    permanent_address_village_bnTV.setText(permanent_address_village_bn);
                    permanent_address_road_bnTV.setText(permanent_address_road_bn);
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

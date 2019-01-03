package com.spectraverse.spectraverse.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.spectraverse.spectraverse.R;
import com.spectraverse.spectraverse.Adapters.JobAdapter;
import com.spectraverse.spectraverse.models.JobsResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JobsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private JobAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
   private RequestQueue mRequestQueue;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_jobs, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new JobAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRequestQueue = Volley.newRequestQueue(getActivity());

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(true);

       parseJSON();

        return rootView;
    }


    private void parseJSON() {
        progressDialog.show();
        String url = "https://www.spectraverse.in/Api/getSpectraverseContents";
        //Post params to be sent to the server
        JSONObject object = new JSONObject();
        try {
            object.put("ref_type", "jobs");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.hide();
                Log.e("response",response.toString());
                JobsResponseModel jobsResponseModel = new Gson().fromJson(response.toString(),JobsResponseModel.class);
                if(jobsResponseModel.getStatus()==1){
                   ArrayList<JobsResponseModel.JobsDataModel> list= jobsResponseModel.getResultData();
                   if(list!=null && list.size()>0){
                       mAdapter.setDataValue(list);

                       }else {
                       mRecyclerView.setVisibility(View.GONE);
                   }

                }else {
                    Toast.makeText(getActivity(), jobsResponseModel.getMessage(),Toast.LENGTH_SHORT).show();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

}

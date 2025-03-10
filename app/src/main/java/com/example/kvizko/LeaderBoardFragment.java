package com.example.kvizko;

import static com.example.kvizko.DbQuery.g_usersCount;
import static com.example.kvizko.DbQuery.g_usersList;
import static com.example.kvizko.DbQuery.myPerformance;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvizko.Adapters.RankAdapter;


public class LeaderBoardFragment extends Fragment {

    private TextView totalUsersTV, myImgTextTV, myScoreTV, myRankTV;
    private RecyclerView usersView;
    private RankAdapter adapter;
    private Dialog progressDialog;
    private TextView dialogText;

    public LeaderBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leader_board, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Leaderboard");

        initViews(view);

        progressDialog = new Dialog(getContext());
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.dialog_text);
        dialogText.setText("Loading...");
        progressDialog.show();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        usersView.setLayoutManager(layoutManager);

        adapter = new RankAdapter(DbQuery.g_usersList);

        usersView.setAdapter(adapter);


        DbQuery.getTopUsers(new MyCompleteListener() {
            @Override
            public void onSuccess() {
                adapter.notifyDataSetChanged();

                if (myPerformance.getScore() != 0) {
                    if (!DbQuery.isMeOnTopList) {
                        calculateRank();
                    }
                    myScoreTV.setText("Score : " + myPerformance.getScore());
                    myRankTV.setText("Rank - " + myPerformance.getRank());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure() {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Something went wrong ! Please try again.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        totalUsersTV.setText("Total users: " + DbQuery.g_usersCount);
        myImgTextTV.setText(myPerformance.getName().toUpperCase().substring(0, 1));


        return view;
    }

    private void initViews(View view) {
        totalUsersTV = view.findViewById(R.id.total_users);
        myImgTextTV = view.findViewById(R.id.img_text);
        myScoreTV = view.findViewById(R.id.total_score_leaderb);
        myRankTV = view.findViewById(R.id.rank_leaderboard);
        usersView = view.findViewById(R.id.users_view);

    }

    private void calculateRank() {
        int lowTopScore = g_usersList.get(g_usersList.size() - 1).getScore();
        int remaining_slots = g_usersCount - 20;
        int myslot = (myPerformance.getScore() * remaining_slots) / lowTopScore;
        int rank;

        if (lowTopScore != myPerformance.getScore()) {
            rank = g_usersCount - myslot;
        } else {
            rank = 21;
        }
        myPerformance.setRank(rank);

    }
}
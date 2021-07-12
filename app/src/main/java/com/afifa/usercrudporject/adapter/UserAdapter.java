package com.afifa.usercrudporject.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afifa.usercrudporject.EditActivity;
import com.afifa.usercrudporject.R;
import com.afifa.usercrudporject.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    List<User> mUserList;
    public UserAdapter(List<User>userList){
        mUserList = userList;
    }
    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.mTextViewId.setText("Id = " +mUserList.get(position).getId());
        holder.mTextViewName.setText("Nama = " +mUserList.get(position).getName());
        holder.mTextViewEmail.setText("Email = " +mUserList.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id",mUserList.get(position).getId());
                mIntent.putExtra("Name",mUserList.get(position).getName());
                mIntent.putExtra("Email",mUserList.get(position).getEmail());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewName, mTextViewEmail;
        public MyViewHolder(View itemView){
            super(itemView);
            mTextViewId    = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewName  = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);

        }
    }
}

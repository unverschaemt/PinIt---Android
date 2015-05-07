package net.unverschaemt.pinfever;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by D060338 on 05.05.2015.
 */
public class FriendListAdapter extends BaseAdapter{
    private User[] friends = null;
    private Context context;
    private static LayoutInflater inflater=null;

    public FriendListAdapter(Context context, User[] friends) {
        this.friends = friends;
        this.context=context;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return friends.length;
    }

    @Override
    public Object getItem(int position) {
        return friends[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tvUserName;
        ImageView imgAvatar;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.friend_list, null);
        holder.tvUserName =(TextView) rowView.findViewById(R.id.FriendsList_userName);
        holder.imgAvatar =(ImageView) rowView.findViewById(R.id.FriendsList_avatar);
        holder.tvUserName.setText(friends[position].getUserName());
        holder.imgAvatar.setImageResource(friends[position].getAvatar());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Map.class);
                intent.putExtra(FriendsList.USER, friends[position]);
                v.getContext().startActivity(intent);
            }
        });
        return rowView;
    }
}

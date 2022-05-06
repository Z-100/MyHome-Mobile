package com.myhome.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhome.R;
import com.myhome.blueprint.Member;

import java.util.List;

/**
 * @author Rad14nt, Z-100
 */
public class GridAdapter extends BaseAdapter {

    private final Context context;
    private LayoutInflater inflater;

    private final List<Member> members;
    private final int[] avatars;

    public GridAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;

        avatars = new int[] {
                R.drawable.avatar_0, R.drawable.avatar_1, R.drawable.avatar_2,
                R.drawable.avatar_3, R.drawable.avatar_4, R.drawable.avatar_5,
                R.drawable.avatar_6, R.drawable.avatar_7, R.drawable.avatar_8,
                R.drawable.avatar_9, R.drawable.avatar_10, R.drawable.avatar_11,
                R.drawable.avatar_12, R.drawable.avatar_13
        };
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.member_grid_item, null);

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);

        textView.setText(members.get(position).getName());
        imageView.setImageResource(avatars[members.get(position).getIcon()]);

        return convertView;
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
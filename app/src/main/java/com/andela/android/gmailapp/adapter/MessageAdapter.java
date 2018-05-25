package com.andela.android.gmailapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.android.gmailapp.R;
import com.andela.android.gmailapp.model.Message;
import com.andela.android.gmailapp.util.CircleTransform;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * Created by chike on 23/05/2018.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    Context context;
    List<Message> messages;

    public MessageAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list_card, parent, false);

        return new ViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     *
     *  @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message currentMessageCard = messages.get(position);

        holder.from.setText(currentMessageCard.getFrom());
        holder.subject.setText(currentMessageCard.getSubject());
        holder.message.setText(currentMessageCard.getMessage());
        holder.timestamp.setText(currentMessageCard.getTimestamp());

        // display profile image
        applyProfilePicture(holder, currentMessageCard);
    }

    private void applyProfilePicture(ViewHolder holder, Message currentMessageCard) {
        if (!TextUtils.isEmpty(currentMessageCard.getPicture())) {
            Glide.with(context)
                    .load(currentMessageCard.getPicture())
                    .thumbnail(0.5f)
                    .apply(new RequestOptions()
                            .transform(new CircleTransform())
                    )
                    .into(holder.profileImage);
            holder.profileImage.setColorFilter(null);
            holder.profileText.setVisibility(View.GONE);
        } else {
            holder.profileImage.setImageResource(R.drawable.bg_image_circle);
            holder.profileImage.setColorFilter(currentMessageCard.getColor());
            holder.profileText.setText(currentMessageCard.getFrom().substring(0, 1));
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return messages.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView from, subject, message, profileText, timestamp;

        private ViewHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.image_profile_icon);
            from = itemView.findViewById(R.id.text_from);
            subject = itemView.findViewById(R.id.text_subject);
            message = itemView.findViewById(R.id.text_message);
            timestamp = itemView.findViewById(R.id.text_time_stamp);
            profileText = itemView.findViewById(R.id.text_profile_char);
        }

    }
}

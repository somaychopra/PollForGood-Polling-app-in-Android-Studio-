package software.project.pollforgood.ViewHolder;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Interface.ItemClickListener;
import software.project.pollforgood.R;

public class PollHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtQuestion, txtTimeleft;
    public ItemClickListener listener;

    public PollHolder(@NonNull View itemView) {
        super(itemView);
        txtQuestion = (TextView) itemView.findViewById(R.id.question);
        txtTimeleft = (TextView) itemView.findViewById(R.id.time_left);
    }
    public void setItemClickListener(ItemClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view)
    {
        listener.onClick(view, getAdapterPosition(), false);
    }
}

package software.project.pollforgood.ViewHolder;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Interface.ItemClickListener;
import software.project.pollforgood.R;

public class ResultHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtQuestion, txtResult;
    public ItemClickListener listener;

    public ResultHolder(@NonNull View itemView) {
        super(itemView);
        txtQuestion = (TextView) itemView.findViewById(R.id.poll_question);
        txtResult = (TextView) itemView.findViewById(R.id.poll_result);
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

package plugin.id.kuis;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Barang> contacts;
    Context context;

    public Adapter(Context context, List<Barang> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtname.setText(contacts.get(position).getNama());
        holder.txtcode.setText(contacts.get(position).getCode());
        holder.txttype.setText(contacts.get(position).getType());
        holder.txtprice.setText(contacts.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtname, txtcode, txttype, txtprice;
        public MyViewHolder(View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txtname);
            txtcode = itemView.findViewById(R.id.txtcode);
            txttype = itemView.findViewById(R.id.txttype);
            txtprice = itemView.findViewById(R.id.txtprice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Intent i = new Intent(context, EditorActivity.class);
//            i.putExtra("id", contacts.get(getAdapterPosition()).getId());
//            i.putExtra("name", contacts.get(getAdapterPosition()).getName());
//            i.putExtra("email", contacts.get(getAdapterPosition()).getEmail());
//            context.startActivity(i);
        }
    }
}
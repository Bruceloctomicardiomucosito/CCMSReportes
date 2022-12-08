package com.example.ccmsreportes.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ccmsreportes.R;
import com.example.ccmsreportes.model.Reportes;

import java.util.List;

public class ReporteListAdapter extends RecyclerView.Adapter<ReporteListAdapter.MyViewHolder> {
    private Context context;
    private List<Reportes> reportesList;
    private ElementClickListener elementClickListener;

    public ReporteListAdapter(Context context, List<Reportes> reportesList,ElementClickListener elementClickListener){
        this.context = context;
        this.reportesList = reportesList;
        this.elementClickListener=elementClickListener;
    }

    public void setReportesList(List<Reportes>reportesList){
        this.reportesList = reportesList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ReporteListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.renglon_reporte,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull ReporteListAdapter.MyViewHolder holder,  int position) {
        holder.labelID_Reporte.setText(String.valueOf((this.reportesList.get(position).getId_Reporte())));
        holder.labelDescripcion.setText(this.reportesList.get(position).getDescripcion());
        String estadoReporte = String.valueOf(this.reportesList.get(position).getRevisado());
        if (estadoReporte.equals("0")){
            holder.labelStatus.setText("Revisión pendiente");
        }
        if (estadoReporte.equals("1")){
            holder.labelStatus.setText("En proceso de revisión");
        }
        if (estadoReporte.equals("2")){
            holder.labelStatus.setText("Completado");
        }
        //holder.lblApMaterno.setText(this.reportesList.get(position).getApMaterno());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementClickListener.onElementClick(reportesList.get(position));
            }
        });
        holder.btnelemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementClickListener.onBtnElementClick(reportesList.get(position));
            }
        });
    }

    @Override
    public int getItemCount(){
        if (this.reportesList !=null)
            return this.reportesList.size();
        return 0;
    }

    public void setResultReportes(List<Reportes> reportesList){
        this.reportesList = reportesList;
        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView labelID_Reporte, labelDescripcion, labelStatus;
        private Button btnelemento;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            labelID_Reporte=(TextView) itemView.findViewById(R.id.rowidReporte);
            labelDescripcion=(TextView) itemView.findViewById(R.id.rowDescipcion);
            labelStatus=(TextView) itemView.findViewById(R.id.rowStatus);
            //lblApMaterno=(TextView) itemView.findViewById(R.id.rowapmaterno);
            btnelemento=(Button) itemView.findViewById(R.id.btnelement);
        }
    }
    //clase qu eobliga al adaptador del componente
    public interface ElementClickListener{
        void onElementClick(Reportes reportes);
        void onBtnElementClick(Reportes reportes);
    }
}
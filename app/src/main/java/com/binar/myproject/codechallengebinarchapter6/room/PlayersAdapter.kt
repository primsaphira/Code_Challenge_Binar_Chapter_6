package com.binar.myproject.codechallengebinar_chapter5.room

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PlayersAdapter(val listStudent : List<Player>) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.players_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listPlayers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvID.text = listPlayers[position].id.toString()
        holder.itemView.tvNama.text = listPlayers[position].nama
        holder.itemView.tvEmail.text = listPlayers[position].email

        holder.itemView.ivEdit.setOnClickListener {
            val intentKeEditActivity = Intent(it.context,
                EditActivity::class.java)

            intentKeEditActivity.putExtra("student",listPlayers[position])
            it.context.startActivity(intentKeEditActivity)
        }

        holder.itemView.ivDelete.setOnClickListener {
            AlertDialog.Builder(it.context).setPositiveButton("Ya") { p0, p1 ->
                val mDb = PlayerDatabase.getInstance(holder.itemView.context)

                GlobalScope.async {
                    val result = mDb?.playerDao()?.deletePlayer(listPlayer[position])

                    (holder.itemView.context as MainActivity).runOnUiThread {
                        if (result!=0){
                            Toast.makeText(it.context,"Data ${listPlayer[position].nama} berhasil dihapus",
                                Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(it.context,"Data ${listPlayer[position].nama} Gagal dihapus",
                                Toast.LENGTH_LONG).show()
                        }
                    }

                    (holder.itemView.context as MainActivity).fetchData()
                }
            }.setNegativeButton("Tidak"
            ) { p0, p1 ->
                p0.dismiss()
            }
                .setMessage("Apakah Anda Yakin ingin menghapus data ${listPlayer[position].nama}").setTitle("Konfirmasi Hapus").create().show()
        }
    }
}
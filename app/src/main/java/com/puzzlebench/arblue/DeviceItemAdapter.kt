package com.puzzlebench.arblue

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.puzzlebench.arblue.databinding.ItemDeviceBinding

class DeviceItemAdapter(private val interaction: Interaction? = null) :
    ListAdapter<DeviceInfo, DeviceItemAdapter.DeviceItemHolder>(DeviceInfoDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceItemHolder {
        val binding = ItemDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeviceItemHolder(binding, interaction)
    }


    override fun onBindViewHolder(holder: DeviceItemHolder, position: Int) =
        holder.bind(getItem(position))


    inner class DeviceItemHolder(
        private val itemBinding: ItemDeviceBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: DeviceInfo){
            with(itemBinding) {
                this.deviceName.text = item.name
            }
        }
    }

    interface Interaction {

    }

    private class DeviceInfoDC : DiffUtil.ItemCallback<DeviceInfo>() {
        override fun areItemsTheSame(oldItem: DeviceInfo, newItem: DeviceInfo): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DeviceInfo, newItem: DeviceInfo): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

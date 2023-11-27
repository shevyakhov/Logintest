package com.shevyakhov.feature.main.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shevyakhov.feature.main.databinding.PaymentItemBinding
import com.shevyakhov.feature.main.domain.entity.PaymentEntity
import java.text.SimpleDateFormat
import java.util.Date

class PaymentsAdapter(
	private val itemClick: (item: PaymentEntity) -> Unit,
) : ListAdapter<PaymentEntity, PaymentsAdapter.Holder>(FoodListDiffCallback) {

	inner class Holder(
		private val binding: PaymentItemBinding,
		private val itemClick: (item: PaymentEntity) -> Unit,
	) : RecyclerView.ViewHolder(binding.root) {

		fun bind(item: PaymentEntity) {
			binding.root.setOnClickListener {
				itemClick.invoke(item)
			}
			binding.title.text = item.title ?: "Неизвестно"

			item.created?.let {
				binding.created.text = convertLongToTime(it.toLong())
			}
			val created = item.created

			if (created != null) {
				val timeLong = created.toLong()
				binding.created.text = convertLongToTime(timeLong)
			} else
				binding.created.text = "Неизвестно"

			if (item.amount != null) {
				binding.amount.text = item.amount.toString() + "₽"
			} else
				binding.amount.text = "Неизвестно ₽"

		}
	}

	fun updateData(newData: List<PaymentEntity>) {
		submitList(newData)
	}

	fun convertLongToTime(time: Long): String {
		val date = Date(time)
		val format = SimpleDateFormat("HH:mm\ndd.MM.yyyy")
		return format.format(date)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val view = LayoutInflater.from(parent.context)
		val binding = PaymentItemBinding.inflate(view, parent, false)
		return Holder(binding, itemClick)
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(getItem(position))
	}

	private object FoodListDiffCallback : DiffUtil.ItemCallback<PaymentEntity>() {

		override fun areItemsTheSame(oldItem: PaymentEntity, newItem: PaymentEntity) = oldItem.id == newItem.id

		override fun areContentsTheSame(oldItem: PaymentEntity, newItem: PaymentEntity) = oldItem == newItem
	}
}
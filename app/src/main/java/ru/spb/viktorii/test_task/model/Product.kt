package ru.spb.viktorii.test_task.model

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val gcode: Int,
    val name: String,
    val price: Int,
    val old_price: Int,
    val new: Int,
    val has_discount: Int,
    val is_stocked: Int,
    val prior: Int,
    val cat_id: Int,
    val sale: Boolean,
    val img_preview: String,
    val stock: Int,
    val units: String,
    val pack: Int,
    val qty: Int,
    val leftover_controlled: Boolean,
    val outstock_reason: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gcode)
        parcel.writeString(name)
        parcel.writeInt(price)
        parcel.writeInt(old_price)
        parcel.writeInt(new)
        parcel.writeInt(has_discount)
        parcel.writeInt(is_stocked)
        parcel.writeInt(prior)
        parcel.writeInt(cat_id)
        parcel.writeByte(if (sale) 1 else 0)
        parcel.writeString(img_preview)
        parcel.writeInt(stock)
        parcel.writeString(units)
        parcel.writeInt(pack)
        parcel.writeInt(qty)
        parcel.writeByte(if (leftover_controlled) 1 else 0)
        parcel.writeString(outstock_reason)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}

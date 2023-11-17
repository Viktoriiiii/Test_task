package ru.spb.viktorii.test_task.catalog_screen.model

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
)

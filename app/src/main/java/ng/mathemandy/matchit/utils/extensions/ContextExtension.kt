package ng.mathemandy.matchit.utils.extensions

import android.content.Context
import android.view.Gravity
import android.widget.Toast

fun Context.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    val toast = Toast.makeText(this, message, duration)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
}
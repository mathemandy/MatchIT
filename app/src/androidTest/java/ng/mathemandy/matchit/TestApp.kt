package ng.mathemandy.matchit

import android.app.Application


open class TestApp  : Application(){
    open fun getApiUrl(): String {
        return "http://127.0.0.1:8080"
    }


}
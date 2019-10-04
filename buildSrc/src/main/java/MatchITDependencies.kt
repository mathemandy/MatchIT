import Versions.androidXTestVersion
import Versions.espressoVersion

object Versions {
    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
    const val minSdkVersion = 19


    const val versionCode = 1
    const val versionName = "1.0"

    const val materialComponent = "1.1.0-alpha09"
    const val rxAnimation = "0.0.6"

    //AndroidX versions
    const val kotlinStandardLibrary = "1.3.41"
    const val coreKtx = "1.0.2"
    const val fragmentKtx = "1.2.0-alpha02"
    const val appCompat = "1.1.0-rc01"
    const val lifecycle = "2.0.0"
    const val javaxInject = "1"
    const val javaxAnnotation = "1.0"
    const val roomVersion = "2.1.0"
    const val rxJava = "2.2.6"
    const val rxAndroid = "2.1.1"
    const val okhttp = "4.2.1"
    const val retrofit = "2.4.0"
    const val recyclerAnimator = "3.0.0"
    const val dagger = "2.24"
    const val scarlet = "0.2.4"
    const val stetho = "1.5.1"
    const val timber = "4.7.1"
    const val navigation = "2.2.0-alpha01"
    const val constraintLayout = "2.0.0-beta1"
    const val otpView = "1.4.3"
    const val shimmerLayout = "0.4.0"
    const val fresco = "2.0.0"
    const val multidex = "2.0.1"
    const val overscrollDecor = "1.0.4"
    const val gson = "2.8.5"
    const val pinEntryEditText = "2.0.6"
    const val  mockTest = "0.4.0"
    const val androidXTestVersion = "1.3.0-alpha02"
    const val espressoVersion = "3.2.0"
    const val mockwebserver = "4.2.1"
    const val arch_core = "2.0.1"
    const val  mockito = "2.25.0"
    const val mockito_all = "1.10.19"
    const val mockito_android = "2.25.0"
    const val atsl_rules = "1.1.1"
    const val atsl_runner = "1.1.1"
    const val atsl_junit = "1.1.0"

}


object RootDependencies {
    const val applicationId = "ng.mathemandy.matchIT"
    const val baseUrl = "\"https://mathemandy.com/\""

    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinStandardLibrary}"
    val javax = "javax.inject:javax.inject:${Versions.javaxInject}"
    val javaxAnnotation = "javax.annotation:jsr250-api:${Versions.javaxAnnotation}"
}

object TestDependencies  {
    val mockTest =  "com.github.andrzejchm.RESTMock:android:${Versions.mockTest}"
    //Test dependencies
    val testRule =  "androidx.test:rules:${androidXTestVersion}"
    val testRunner  =  "androidx.test:runner:${androidXTestVersion}"

    val espressoCore =  "androidx.test.espresso:espresso-core:${espressoVersion}"

    val androidX =  "androidx.appcompat:appcompat:1.0.2"
    val materialMe =  "com.google.android.material:material:1.0.0"
    val junit  =  "junit:junit:4.12"
    val espressoCoreTest =  "androidx.test.espresso:espresso-core:${espressoVersion}"
    val espressoContrib  = "androidx.test.espresso:espresso-contrib:${espressoVersion}"
    val espressoIntents = "androidx.test.espresso:espresso-intents:${espressoVersion}"

    val mock_web_server = "com.squareup.okhttp3:mockwebserver:${Versions.mockwebserver}"
    val arch_core_testing = "androidx.arch.core:core-testing:${Versions.arch_core}"


    val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
    val mockito_all = "org.mockito:mockito-all:${Versions.mockito_all}"
    val mockito_android = "org.mockito:mockito-android:${Versions.mockito_android}"

    val atsl_ext_junit = "androidx.test.ext:junit:${Versions.atsl_junit}"
    val atsl_runner = "androidx.test:runner:${Versions.atsl_runner}"
    val atsl_rules = "androidx.test:rules:${Versions.atsl_rules}"

}

object ViewDependencies {
    const val materialComponent = "com.google.android.material:material:${Versions.materialComponent}"
    const val rxAnimation = "com.mikhaellopez:rxanimation:${Versions.rxAnimation}"
}

object AndroidXDependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidFragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
}
object NetworkDependencies {
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
}

object AsyncDependencies {
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
}


object UtilityDependencies {
    const val recyclerAnimator = "jp.wasabeef:recyclerview-animators:${Versions.recyclerAnimator}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val optView = "com.chaos.view:pinview:${Versions.otpView}"
    const val overscrollDecor = "me.everything:overscroll-decor-android:${Versions.overscrollDecor}"
}

object DependencyInjectionDependencies {
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Classpaths {
    const val navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object PersistenceDependencies {
    val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    val roomRxJava = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

}

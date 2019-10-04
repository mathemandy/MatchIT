package ng.mathemandy.matchit.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.internal.util.NotificationLite.getValue
import io.reactivex.schedulers.Schedulers
import ng.mathemandy.core.utils.MatchITLog
import ng.mathemandy.matchit.util.NetworkFactory
import ng.mathemandy.remote.interceptors.MatchITResponseInterceptor
import ng.mathemandy.remote.models.MatchITRemoteTokenModel
import ng.mathemandy.remote.services.AuthenticationService
import ng.mathemandy.remote.utils.performActionOnError
import ng.mathemandy.repository.models.BaseMatchITRepositoryModel
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.BufferedSource
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsNull
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class MatchItServiceTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: AuthenticationService
    private lateinit var mockWebServer: MockWebServer
    private lateinit var tested: NetworkFactory



    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        val networkInterceptor = MatchITResponseInterceptor()
        tested = NetworkFactory(networkInterceptor)
        service = tested.createApi(AuthenticationService::class.java, mockWebServer.url("/").toString())

    }


    @After
    fun stopService() {

        mockWebServer.shutdown()
    }

    @Test
    fun LoginUser(){
        var result : BaseMatchITRepositoryModel<String>? = null
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(201)

        mockWebServer.enqueue(
            mockResponse.setBody( enqueueResponse("index.json").readString(Charsets.UTF_8))
        )
        val token  = service.logUserIn(hashMapOf(
            "email" to "andyeshiet@gmail.com",
            "password" to "password")).performActionOnError().map {
            result = BaseMatchITRepositoryModel(
                success = it.success,
                data = it.data?.token,
                message = it.message
            )
        }.blockingGet()

        val request = mockWebServer.takeRequest()
        Assert.assertThat(request.path, `is`("/login"))
        Assert.assertThat(result, IsNull.notNullValue())
        MatchITLog.e("testtest $token")
        Assert.assertThat(result?.success, `is` (true) )
        Assert.assertThat(result?.message, IsNull.nullValue() )
        Assert.assertThat(result?.data, `is` ("<response_token>"))


    }


    @Test
    fun LoginFailedUser(){
        var result : BaseMatchITRepositoryModel<String>? = null

        val mockResponse = MockResponse()
        mockResponse.setResponseCode(401)
        mockWebServer.enqueue(
            mockResponse.setBody( enqueueResponse("invalid_password.json").readString(Charsets.UTF_8))
        )
       service.logUserIn(hashMapOf(
            "email" to "andyeshiet@gmail.com",
            "password" to "passweord")).performActionOnError().map {
            result = BaseMatchITRepositoryModel(
                success = it.success,
                data = it.data?.token,
                message = it.message
            )
        }.blockingGet()

        val request = mockWebServer.takeRequest()
        Assert.assertThat(request.path, `is`("/login"))
        Assert.assertThat(result, IsNull.notNullValue())
        Assert.assertThat(result?.success, `is` (false) )
        Assert.assertThat(result?.message, `is`("Invalid Password") )


    }

    @Test
    fun LogInternalIssueFailedUser(){
        var result : BaseMatchITRepositoryModel<String>? = null

        val mockResponse = MockResponse()
        mockResponse.setResponseCode(500)
        mockWebServer.enqueue(
            mockResponse.setBody( enqueueResponse("internal_issue_summary.json").readString(Charsets.UTF_8))
        )
       service.logUserIn(hashMapOf(
            "email" to "andyeshiet@gmail.com",
            "password" to "passweord")).performActionOnError().map {
            result = BaseMatchITRepositoryModel(
                success = it.success,
                data = it.data?.token,
                message = it.message
            )
        }.blockingGet()

        val request = mockWebServer.takeRequest()
        Assert.assertThat(request.path, `is`("/login"))
        Assert.assertThat(result, IsNull.notNullValue())
        Assert.assertThat(result?.success, `is` (false) )
        Assert.assertThat(result?.message, `is`("Internal issue, try again later") )


    }


    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) : BufferedSource {
        val inputStream = javaClass.classLoader
            .getResourceAsStream("api-response/$fileName")
        return inputStream.source().buffer()

    }

}
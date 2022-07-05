package com.example.myapplicationstretorfit;

import com.google.firebase.firestore.auth.User;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IUserService {

    @GET
    Call<ResultModel> getUser(@Url String url);

    @GET("/users/{id}")
    Call<ResultModel> getUser(@Path("id")  int id);

    @GET("/users")      //  /user?phone=XXX&name=XXX
    Call<ResultModel> getUser(@Query("phone")  String phone, @Query("name")  String name );

    @GET("/users")      //  /user?phone=XXX&name=XXX
    Call<ResultModel> getUser(@QueryMap Map<String,Object> params);

    @POST("/users")
    Call<ResultModel> postUser(@Body User user);

    /************************* Part  PartMap ****************************/

    @Multipart
    @POST("/files")
    Call<ResultModel> postFile(@Part MultipartBody.Part part);

    @Multipart
    @POST("/files")
    Call<ResultModel> postFiles(@Part List<MultipartBody.Part> parts);

    /**
     * 上传多个文件
     * @param part
     * @param params
     * @return
     */
    @Multipart
    @POST("/files")
    Call<ResultModel> postFilesWithParams(@Part MultipartBody.Part part, @PartMap Map<String,String> params);

    /************************* Field  FieldMap ****************************/

    @POST("/users")
    Call<ResultModel> postUser(@Field("name") String name, @Field("phone")String phone);

    @POST("/users")
    Call<ResultModel> postUser(@FieldMap Map<String,Object> params);

    /************************* Header  Headers  HeaderMap ****************************/

    @POST("/users")
    Call<ResultModel> postUser(@Body User user,@Header("token")String token);

    @Headers({"token:sa56312as1d2","version:1"})
    @POST("/users")
    Call<ResultModel> postUser();

    @POST("/users")
    Call<ResultModel> postFile(@HeaderMap Map<String,String> headers);

}

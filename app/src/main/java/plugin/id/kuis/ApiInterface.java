package plugin.id.kuis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/readbarang.php")
    Call<List<Barang>> getContacts();

    @FormUrlEncoded
    @POST("api/addbarang.php")
    public Call<Barang> insertUser(
            @Field("code") String code,
            @Field("name") String name,
            @Field("type") String type,
            @Field("price") String price);
    }

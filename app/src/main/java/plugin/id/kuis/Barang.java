package plugin.id.kuis;

import com.google.gson.annotations.SerializedName;

public class Barang {

    @SerializedName("id")
    private String id;
    @SerializedName("code")
    private String code;
    @SerializedName("nama")
    private String nama;
    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private String price;

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNama() {
        return nama;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getValue() {
        return value;
    }

    public String getMassage() {
        return massage;
    }

    @SerializedName("value")
    private String value;
    @SerializedName("message")
    private String massage;



}

package qq.app01.com.fragment_app.Tools.mode;

/**
 * Created by zhuxiaofeng on 2016/8/31.
 */
public class HengMode {

    private String id;
    private String bid;
    private String sid;
    private String shopname;
    private String pic;
    private String address;
    private String businessname;
    private String lat;
    private String lng;
    private String juli;

    public HengMode(String id, String bid, String sid, String shopname, String pic, String address, String businessname, String lat, String lng, String juli) {
        this.id = id;
        this.bid = bid;
        this.sid = sid;
        this.shopname = shopname;
        this.pic = pic;
        this.address = address;
        this.businessname = businessname;
        this.lat = lat;
        this.lng = lng;
        this.juli = juli;
    }

    public HengMode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getJuli() {
        return juli;
    }

    public void setJuli(String juli) {
        this.juli = juli;
    }
}

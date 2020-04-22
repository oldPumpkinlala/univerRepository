package web.pojo;

public class Goods {
    private String gid;
    private String gname;
    private double price;
    private User user;//上传本商品的用户
    private String image;
    private Category category;//该商品所属的分类

    private boolean del;///判断该图书是否被删除

    @Override
    public String toString() {
        return "Goods{" +
                "gid='" + gid + '\'' +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", user=" + user +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", del=" + del +
                '}';
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public Goods() {
    }

    public Goods(String gid, String gname, double price, User user, String image, Category category, boolean del) {
        this.gid = gid;
        this.gname = gname;
        this.price = price;
        this.user = user;
        this.image = image;
        this.category = category;
        this.del = del;
    }
}

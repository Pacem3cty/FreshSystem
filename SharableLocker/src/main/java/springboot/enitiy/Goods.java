package springboot.enitiy;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 12:20
 */

@Component
public class Goods implements Serializable {
    String barcode;
    String gname;
    double price;
    int rest;
    String meno;

    public Goods() {
    }

    public Goods(String barcode, String gname, double price, int rest, String meno) {
        this.barcode = barcode;
        this.gname = gname;
        this.price = price;
        this.rest = rest;
        this.meno = meno;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "barcode='" + barcode + '\'' +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", rest=" + rest +
                ", meno='" + meno + '\'' +
                '}';
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }
}

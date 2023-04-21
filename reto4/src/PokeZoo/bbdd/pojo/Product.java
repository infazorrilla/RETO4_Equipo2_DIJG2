package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

	private static final long serialVersionUID = 237001453545700048L;

	// primary key
	private int idProduct = 0;

	// attributes
	private String namePr = "";
	private String descriptionPr = "";
	private double valuePr = 0;

	// link Product with shop
	private Shop shop = null;

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNamePr() {
		return namePr;
	}

	public void setNamePr(String namePr) {
		this.namePr = namePr;
	}

	public String getDescriptionPr() {
		return descriptionPr;
	}

	public void setDescriptionPr(String descriptionPr) {
		this.descriptionPr = descriptionPr;
	}

	public double getValuePr() {
		return valuePr;
	}

	public void setValuePr(double valuePr) {
		this.valuePr = valuePr;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descriptionPr, idProduct, namePr, shop, valuePr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(descriptionPr, other.descriptionPr) && idProduct == other.idProduct
				&& Objects.equals(namePr, other.namePr) && Objects.equals(shop, other.shop)
				&& Double.doubleToLongBits(valuePr) == Double.doubleToLongBits(other.valuePr);
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", namePr=" + namePr + ", descriptionPr=" + descriptionPr
				+ ", valuePr=" + valuePr + ", shop=" + shop + "]";
	}

}

package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class Product implements Serializable {

	private static final long serialVersionUID = 237001453545700048L;

	// primary key
	private int idProduct = 0;

	// attributes
	private String namePr = "";
	private String descriptionPr = "";
	private Blob photoPr = null;
	private double valuePr = 0;
	private int quantityPr = 0;

	// link Product with shop
	private Shop shop = null;

	// Getters and Setters
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

	public Blob getPhotoPr() {
		return photoPr;
	}

	public void setPhotoPr(Blob photoPr) {
		this.photoPr = photoPr;
	}

	public double getValuePr() {
		return valuePr;
	}

	public void setValuePr(double valuePr) {
		this.valuePr = valuePr;
	}

	public int getQuantityPr() {
		return quantityPr;
	}

	public void setQuantityPr(int quantityPr) {
		this.quantityPr = quantityPr;
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

	// HashCode method
	@Override
	public int hashCode() {
		return Objects.hash(descriptionPr, idProduct, namePr, photoPr, quantityPr, shop, valuePr);
	}

	// Equals method
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
				&& Objects.equals(namePr, other.namePr) && Objects.equals(photoPr, other.photoPr)
				&& quantityPr == other.quantityPr && Objects.equals(shop, other.shop)
				&& Double.doubleToLongBits(valuePr) == Double.doubleToLongBits(other.valuePr);
	}

	// ToString method
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", namePr=" + namePr + ", descriptionPr=" + descriptionPr
				+ ", photoPr=" + photoPr + ", valuePr=" + valuePr + ", quantityPr=" + quantityPr + ", shop=" + shop
				+ "]";
	}
}

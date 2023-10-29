package com.song.entity;

public class Offers {
    /**
     * 供货商信息数据表
     *
     * @param OfferID 供货商编号
     * OfferName 供货商名称
     * LegalIP 法人代表
     * Address 地址
     * Tel 电话
     */
    private int OfferID;
    private String OfferName;
    private String LegalIP;
    private String Address;
    private String Tel;

    public Offers() {
    }

    public Offers(int OfferID, String OfferName, String LegalIP, String Address, String Tel) {
        this.OfferID = OfferID;
        this.OfferName = OfferName;
        this.LegalIP = LegalIP;
        this.Address = Address;
        this.Tel = Tel;
    }

    public Offers(String OfferName, String LegalIP, String Address, String Tel) {
        this.OfferName = OfferName;
        this.LegalIP = LegalIP;
        this.Address = Address;
        this.Tel = Tel;
    }

    /**
     * 获取
     *
     * @return OfferID
     */
    public int getOfferID() {
        return OfferID;
    }

    /**
     * 设置
     *
     * @param OfferID
     */
    public void setOfferID(int OfferID) {
        this.OfferID = OfferID;
    }

    /**
     * 获取
     *
     * @return OfferName
     */
    public String getOfferName() {
        return OfferName;
    }

    /**
     * 设置
     *
     * @param OfferName
     */
    public void setOfferName(String OfferName) {
        this.OfferName = OfferName;
    }

    /**
     * 获取
     *
     * @return LegalIP
     */
    public String getLegalIP() {
        return LegalIP;
    }

    /**
     * 设置
     *
     * @param LegalIP
     */
    public void setLegalIP(String LegalIP) {
        this.LegalIP = LegalIP;
    }

    /**
     * 获取
     *
     * @return Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * 设置
     *
     * @param Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 获取
     *
     * @return Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * 设置
     *
     * @param Tel
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String toString() {
        return "Offers{OfferID = " + OfferID + ", OfferName = " + OfferName + ", LegalIP = " + LegalIP + ", Address = " + Address + ", Tel = " + Tel + "}";
    }
}

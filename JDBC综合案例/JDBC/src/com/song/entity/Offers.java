package com.song.entity;

/**
 * 供货商实体类
 * @author song
 */

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
    private int offerId;
    private String offerName;
    private String legalIp;
    private String address;
    private String tel;


    public Offers() {
    }

    /**
     * 有参构造方法
     * @param offerId 供货商编号
     * @param offerName 供货商名称
     * @param legalIp 法人代表
     * @param address 地址
     * @param tel 电话
     */
    public Offers(int offerId, String offerName, String legalIp, String address, String tel) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.legalIp = legalIp;
        this.address = address;
        this.tel = tel;
    }

    /**
     * 多条件查询的构造方法
     * @param offerName 供货商名称
     * @param legalIp 法人代表
     * @param address 地址
     * @param tel 电话
     */
    public Offers(String offerName, String legalIp, String address, String tel) {
        this.offerName = offerName;
        this.legalIp = legalIp;
        this.address = address;
        this.tel = tel;
    }

    /**
     * 获取
     * @return offerId
     */
    public int getOfferId() {
        return offerId;
    }

    /**
     * 设置
     * @param offerId
     */
    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    /**
     * 获取
     * @return offerName
     */
    public String getOfferName() {
        return offerName;
    }

    /**
     * 设置
     * @param offerName
     */
    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    /**
     * 获取
     * @return legalIp
     */
    public String getLegalIp() {
        return legalIp;
    }

    /**
     * 设置
     * @param legalIp
     */
    public void setLegalIp(String legalIp) {
        this.legalIp = legalIp;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String toString() {
        return "Offers{offerId = " + offerId + ", offerName = " + offerName + ", legalIp = " + legalIp + ", address = " + address + ", tel = " + tel + "}";
    }
}

package com.song.entity;

public class Type {
    /**
     * 电影类型实体类
     * @param TypeId 类型id
     *        TypeName 类型名
     *        Remark 备注
     */
    private int TypeId;
    private String TypeName;
    private String Remark;

    public Type() {
    }

    public Type(int TypeId, String TypeName, String Remark) {
        this.TypeId = TypeId;
        this.TypeName = TypeName;
        this.Remark = Remark;
    }

    /**
     * 获取
     * @return TypeId
     */
    public int getTypeId() {
        return TypeId;
    }

    /**
     * 设置
     * @param TypeId
     */
    public void setTypeId(int TypeId) {
        this.TypeId = TypeId;
    }

    /**
     * 获取
     * @return TypeName
     */
    public String getTypeName() {
        return TypeName;
    }

    /**
     * 设置
     * @param TypeName
     */
    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    /**
     * 获取
     * @return Remark
     */
    public String getRemark() {
        return Remark;
    }

    /**
     * 设置
     * @param Remark
     */
    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public String toString() {
        return "Type{TypeId = " + TypeId + ", TypeName = " + TypeName + ", Remark = " + Remark + "}";
    }
}

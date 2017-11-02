package com.xz.drip.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Pool {
    private Long id;

    private String poolCode;

    private String poolName;

    private Byte poolType;

    private BigDecimal limitAmount;

    private BigDecimal totalAmount;

    private BigDecimal stockAmount;

    private BigDecimal frozenAmount;

    private BigDecimal saleAmount;

    private Byte status;

    private Byte loadSwitchStatus;

    private Long financeSubjectId;

    private String financeSubjectCode;

    private Long trusteeId;

    private String trusteeCode;

    private Long version;

    private Date createTime;

    private String createBy;

    private Date modifyTime;

    private String modifyBy;

    private String poolDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoolCode() {
        return poolCode;
    }

    public void setPoolCode(String poolCode) {
        this.poolCode = poolCode == null ? null : poolCode.trim();
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName == null ? null : poolName.trim();
    }

    public Byte getPoolType() {
        return poolType;
    }

    public void setPoolType(Byte poolType) {
        this.poolType = poolType;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getLoadSwitchStatus() {
        return loadSwitchStatus;
    }

    public void setLoadSwitchStatus(Byte loadSwitchStatus) {
        this.loadSwitchStatus = loadSwitchStatus;
    }

    public Long getFinanceSubjectId() {
        return financeSubjectId;
    }

    public void setFinanceSubjectId(Long financeSubjectId) {
        this.financeSubjectId = financeSubjectId;
    }

    public String getFinanceSubjectCode() {
        return financeSubjectCode;
    }

    public void setFinanceSubjectCode(String financeSubjectCode) {
        this.financeSubjectCode = financeSubjectCode == null ? null : financeSubjectCode.trim();
    }

    public Long getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(Long trusteeId) {
        this.trusteeId = trusteeId;
    }

    public String getTrusteeCode() {
        return trusteeCode;
    }

    public void setTrusteeCode(String trusteeCode) {
        this.trusteeCode = trusteeCode == null ? null : trusteeCode.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public String getPoolDesc() {
        return poolDesc;
    }

    public void setPoolDesc(String poolDesc) {
        this.poolDesc = poolDesc == null ? null : poolDesc.trim();
    }
}
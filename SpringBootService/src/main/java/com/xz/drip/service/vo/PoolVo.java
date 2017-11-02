package com.xz.drip.service.vo;

import java.math.BigDecimal;

/**
 * Created by MABIAO on 2017/11/2.
 */
public class PoolVo extends BaseVo {

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

    private String createBy;

    private String poolDesc;

    public String getPoolCode() {
        return poolCode;
    }

    public void setPoolCode(String poolCode) {
        this.poolCode = poolCode;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
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
        this.financeSubjectCode = financeSubjectCode;
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
        this.trusteeCode = trusteeCode;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getPoolDesc() {
        return poolDesc;
    }

    public void setPoolDesc(String poolDesc) {
        this.poolDesc = poolDesc;
    }
}

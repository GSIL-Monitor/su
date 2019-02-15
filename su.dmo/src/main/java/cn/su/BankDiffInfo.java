package cn.su;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BankDiffInfo {
    private String tranBatchNo;
    private String tranDate;
    private String sapId;
    private String tranType;
    private BigDecimal tranAmount;
    private String payNo;
    private String subjectNo;
    private String tranNo;
    private String oldPayTime;
    private String diffDescribe;
    private String payInsitution;
    private String reciInsitution;
    private String companyCode;

    public String getTranBatchNo() {
        return tranBatchNo;
    }

    public void setTranBatchNo(String tranBatchNo) {
        this.tranBatchNo = tranBatchNo;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getSapId() {
        return sapId;
    }

    public void setSapId(String sapId) {
        this.sapId = sapId;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public String getOldPayTime() {
        return oldPayTime;
    }

    public void setOldPayTime(String oldPayTime) {
        this.oldPayTime = oldPayTime;
    }

    public String getDiffDescribe() {
        return diffDescribe;
    }

    public void setDiffDescribe(String diffDescribe) {
        this.diffDescribe = diffDescribe;
    }

    public String getPayInsitution() {
        return payInsitution;
    }

    public void setPayInsitution(String payInsitution) {
        this.payInsitution = payInsitution;
    }

    public String getReciInsitution() {
        return reciInsitution;
    }

    public void setReciInsitution(String reciInsitution) {
        this.reciInsitution = reciInsitution;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}

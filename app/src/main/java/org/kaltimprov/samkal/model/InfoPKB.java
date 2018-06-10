package org.kaltimprov.samkal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InfoPKB implements Serializable{

    @SerializedName("NO_POLISI")
    @Expose
    private String nOPOLISI;
    @SerializedName("NM_MEREK_KB")
    @Expose
    private String nMMEREKKB;
    @SerializedName("NM_MODEL_KB")
    @Expose
    private String nMMODELKB;
    @SerializedName("TH_RAKITAN")
    @Expose
    private String tHRAKITAN;
    @SerializedName("NO_RANGKA")
    @Expose
    private String nORANGKA;
    @SerializedName("NO_MESIN")
    @Expose
    private String nOMESIN;
    @SerializedName("PKB_POK")
    @Expose
    private String pKBPOK;
    @SerializedName("PKB_DEN")
    @Expose
    private String pKBDEN;
    @SerializedName("SWD_POK")
    @Expose
    private String sWDPOK;
    @SerializedName("SWD_DEN")
    @Expose
    private String sWDDEN;
    @SerializedName("BEA_ADM_STNK")
    @Expose
    private String bEAADMSTNK;
    @SerializedName("BEA_ADM_TNKB")
    @Expose
    private String bEAADMTNKB;
    @SerializedName("TOTAL_BAYAR")
    @Expose
    private String tOTALBAYAR;
    @SerializedName("TG_AKHIR_PJKLM")
    @Expose
    private String tGAKHIRPJKLM;
    @SerializedName("TG_AKHIR_STNKB")
    @Expose
    private String tGAKHIRSTNKB;
    @SerializedName("MILIK_KE")
    @Expose
    private String mILIKKE;
    private final static long serialVersionUID = -7319756656683524141L;

    public String getNOPOLISI() {
        return nOPOLISI;
    }

    public void setNOPOLISI(String nOPOLISI) {
        this.nOPOLISI = nOPOLISI;
    }

    public String getNMMEREKKB() {
        return nMMEREKKB;
    }

    public void setNMMEREKKB(String nMMEREKKB) {
        this.nMMEREKKB = nMMEREKKB;
    }

    public String getNMMODELKB() {
        return nMMODELKB;
    }

    public void setNMMODELKB(String nMMODELKB) {
        this.nMMODELKB = nMMODELKB;
    }

    public String getTHRAKITAN() {
        return tHRAKITAN;
    }

    public void setTHRAKITAN(String tHRAKITAN) {
        this.tHRAKITAN = tHRAKITAN;
    }

    public String getNORANGKA() {
        return nORANGKA;
    }

    public void setNORANGKA(String nORANGKA) {
        this.nORANGKA = nORANGKA;
    }

    public String getNOMESIN() {
        return nOMESIN;
    }

    public void setNOMESIN(String nOMESIN) {
        this.nOMESIN = nOMESIN;
    }

    public String getPKBPOK() {
        return pKBPOK;
    }

    public void setPKBPOK(String pKBPOK) {
        this.pKBPOK = pKBPOK;
    }

    public String getPKBDEN() {
        return pKBDEN;
    }

    public void setPKBDEN(String pKBDEN) {
        this.pKBDEN = pKBDEN;
    }

    public String getSWDPOK() {
        return sWDPOK;
    }

    public void setSWDPOK(String sWDPOK) {
        this.sWDPOK = sWDPOK;
    }

    public String getSWDDEN() {
        return sWDDEN;
    }

    public void setSWDDEN(String sWDDEN) {
        this.sWDDEN = sWDDEN;
    }

    public String getBEAADMSTNK() {
        return bEAADMSTNK;
    }

    public void setBEAADMSTNK(String bEAADMSTNK) {
        this.bEAADMSTNK = bEAADMSTNK;
    }

    public String getBEAADMTNKB() {
        return bEAADMTNKB;
    }

    public void setBEAADMTNKB(String bEAADMTNKB) {
        this.bEAADMTNKB = bEAADMTNKB;
    }

    public String getTOTALBAYAR() {
        return tOTALBAYAR;
    }

    public void setTOTALBAYAR(String tOTALBAYAR) {
        this.tOTALBAYAR = tOTALBAYAR;
    }

    public String getTGAKHIRPJKLM() {
        return tGAKHIRPJKLM;
    }

    public void setTGAKHIRPJKLM(String tGAKHIRPJKLM) {
        this.tGAKHIRPJKLM = tGAKHIRPJKLM;
    }

    public String getTGAKHIRSTNKB() {
        return tGAKHIRSTNKB;
    }

    public void setTGAKHIRSTNKB(String tGAKHIRSTNKB) {
        this.tGAKHIRSTNKB = tGAKHIRSTNKB;
    }

    public String getMILIKKE() {
        return mILIKKE;
    }

    public void setMILIKKE(String mILIKKE) {
        this.mILIKKE = mILIKKE;
    }

}

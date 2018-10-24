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
    private Object nMMEREKKB;
    @SerializedName("NM_MODEL_KB")
    @Expose
    private Object nMMODELKB;
    @SerializedName("TH_BUATAN")
    @Expose
    private Object tHBUATAN;
    @SerializedName("WARNA_KB")
    @Expose
    private Object wARNAKB;
    @SerializedName("NO_RANGKA")
    @Expose
    private Object nORANGKA;
    @SerializedName("NO_MESIN")
    @Expose
    private Object nOMESIN;
    @SerializedName("PKB_POK")
    @Expose
    private Object pKBPOK;
    @SerializedName("PKB_DEN")
    @Expose
    private Object pKBDEN;
    @SerializedName("SWD_POK")
    @Expose
    private Object sWDPOK;
    @SerializedName("SWD_DEN")
    @Expose
    private Object sWDDEN;
    @SerializedName("BEA_ADM_STNK")
    @Expose
    private Object bEAADMSTNK;
    @SerializedName("BEA_ADM_TNKB")
    @Expose
    private Object bEAADMTNKB;
    @SerializedName("TOTAL_BAYAR")
    @Expose
    private Object tOTALBAYAR;
    @SerializedName("TG_AKHIR_PAJAK")
    @Expose
    private Object tGAKHIRPAJAK;
    @SerializedName("TG_AKHIR_STNKB")
    @Expose
    private Object tGAKHIRSTNKB;
    @SerializedName("MILIK_KE")
    @Expose
    private Object mILIKKE;
    @SerializedName("DESKRIPSI")
    @Expose
    private String dESKRIPSI;
    private final static long serialVersionUID = 1356464623310095732L;

    public String getNOPOLISI() {
        return nOPOLISI;
    }

    public void setNOPOLISI(String nOPOLISI) {
        this.nOPOLISI = nOPOLISI;
    }

    public Object getNMMEREKKB() {
        return nMMEREKKB;
    }

    public void setNMMEREKKB(Object nMMEREKKB) {
        this.nMMEREKKB = nMMEREKKB;
    }

    public Object getNMMODELKB() {
        return nMMODELKB;
    }

    public void setNMMODELKB(Object nMMODELKB) {
        this.nMMODELKB = nMMODELKB;
    }

    public Object getTHBUATAN() {
        return tHBUATAN;
    }

    public void setTHBUATAN(Object tHBUATAN) {
        this.tHBUATAN = tHBUATAN;
    }

    public Object getWARNAKB() {
        return wARNAKB;
    }

    public void setWARNAKB(Object wARNAKB) {
        this.wARNAKB = wARNAKB;
    }

    public Object getNORANGKA() {
        return nORANGKA;
    }

    public void setNORANGKA(Object nORANGKA) {
        this.nORANGKA = nORANGKA;
    }

    public Object getNOMESIN() {
        return nOMESIN;
    }

    public void setNOMESIN(Object nOMESIN) {
        this.nOMESIN = nOMESIN;
    }

    public Object getPKBPOK() {
        return pKBPOK;
    }

    public void setPKBPOK(Object pKBPOK) {
        this.pKBPOK = pKBPOK;
    }

    public Object getPKBDEN() {
        return pKBDEN;
    }

    public void setPKBDEN(Object pKBDEN) {
        this.pKBDEN = pKBDEN;
    }

    public Object getSWDPOK() {
        return sWDPOK;
    }

    public void setSWDPOK(Object sWDPOK) {
        this.sWDPOK = sWDPOK;
    }

    public Object getSWDDEN() {
        return sWDDEN;
    }

    public void setSWDDEN(Object sWDDEN) {
        this.sWDDEN = sWDDEN;
    }

    public Object getBEAADMSTNK() {
        return bEAADMSTNK;
    }

    public void setBEAADMSTNK(Object bEAADMSTNK) {
        this.bEAADMSTNK = bEAADMSTNK;
    }

    public Object getBEAADMTNKB() {
        return bEAADMTNKB;
    }

    public void setBEAADMTNKB(Object bEAADMTNKB) {
        this.bEAADMTNKB = bEAADMTNKB;
    }

    public Object getTOTALBAYAR() {
        return tOTALBAYAR;
    }

    public void setTOTALBAYAR(Object tOTALBAYAR) {
        this.tOTALBAYAR = tOTALBAYAR;
    }

    public Object getTGAKHIRPAJAK() {
        return tGAKHIRPAJAK;
    }

    public void setTGAKHIRPAJAK(Object tGAKHIRPAJAK) {
        this.tGAKHIRPAJAK = tGAKHIRPAJAK;
    }

    public Object getTGAKHIRSTNKB() {
        return tGAKHIRSTNKB;
    }

    public void setTGAKHIRSTNKB(Object tGAKHIRSTNKB) {
        this.tGAKHIRSTNKB = tGAKHIRSTNKB;
    }

    public Object getMILIKKE() {
        return mILIKKE;
    }

    public void setMILIKKE(Object mILIKKE) {
        this.mILIKKE = mILIKKE;
    }

    public String getDESKRIPSI() {
        return dESKRIPSI;
    }

    public void setDESKRIPSI(String dESKRIPSI) {
        this.dESKRIPSI = dESKRIPSI;
    }

}

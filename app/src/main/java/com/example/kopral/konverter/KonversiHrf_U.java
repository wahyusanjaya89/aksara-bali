package com.example.kopral.konverter;

import android.util.Log;

public class KonversiHrf_U {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrfKonversi;
    private boolean suara;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    public KonversiHrf_U() {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.suara = true;
        this.cecek = false;
        this.gantungan = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.tempHasilKonversi = new String[0];
        this.tempKalimat = new char[0];
    }

    public KonversiHrf_U(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.suara = true;
        this.cecek = false;
        this.gantungan = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
    }

    public void setCecek(boolean cck) {
        this.cecek = cck;
    }

    public boolean kndsGantungan() {
        return this.gantungan;
    }

    public void setTempHasilKonversi(String[] xTempHasilKonversi) {
        this.tempHasilKonversi = xTempHasilKonversi;
    }

    public String[] getTempHasilKonversi() {
        return this.tempHasilKonversi;
    }

    public void setTempKalimat(char[] xTempKalimat) {
        this.tempKalimat = xTempKalimat;
    }

    public char[] getTempKalimat() {
        return this.tempKalimat;
    }

    public void setIndeksHrfKonversi(int xIndeksHrfKonversi) {
        this.indexHrfKonversi = xIndeksHrfKonversi;
    }

    public int getIndexHrfKonversi() {
        return this.indexHrfKonversi;
    }

    public void setIndeksHuruf(int xIndeksHurufKe) {
        this.indeksHuruf = xIndeksHurufKe;
    }

    public int getIndexHuruf() {
        return this.indeksHuruf;
    }

    public void konversi_UKecil() {
        if (this.indeksHuruf < 2) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00a1";
            this.indexHrfKonversi++;
        } else if (this.tempKalimat[this.indeksHuruf - 1] == 'r' && this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 2])) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00b1";
            this.indexHrfKonversi++;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00a1";
            this.indexHrfKonversi++;
        }
    }

    public void konversi_U() {
        if (this.indeksHuruf == 0) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "hu";
            this.indexHrfKonversi++;
        } else if (this.indeksHuruf < 1) {
        } else {

            Log.d("KONVERSI_U", "tempKalimat:" + String.valueOf(tempKalimat));
            Log.d("KONVERSI_U_length", "tempKalimatLength:" + String.valueOf(tempKalimat.length));
            Log.d("KONVERSI_U_indeksHuruf", String.valueOf(this.indeksHuruf));

            if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
                if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "hu";
                    this.indexHrfKonversi++;
                    return;
                }
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c0\u00a1";
                this.indexHrfKonversi++;
            } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "hu";
                this.indexHrfKonversi++;
                //ganti
                //} else if (this.tempKalimat[this.indeksHuruf + 1] != 'a') {
            } else if (this.tempKalimat[this.indeksHuruf] != 'a') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "u";
                this.indexHrfKonversi++;
            } else if (this.suara) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00d9";
                this.indeksHuruf++;
                this.indexHrfKonversi++;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "uw";
                this.indeksHuruf++;
                this.indexHrfKonversi++;
            }
        }
    }

    public void konversi_U(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
        if (this.indeksHuruf == 0) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "hu";
            this.indexHrfKonversi++;
        } else if (this.indeksHuruf < 1) {
        } else {
            if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
                if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2])) {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c0u";
                    this.indexHrfKonversi++;
                    return;
                }
                this.tempHasilKonversi[this.indexHrfKonversi] = "hu";
                this.indexHrfKonversi++;
            } else if (this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 1])) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "u";
                this.indexHrfKonversi++;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "hu";
                this.indexHrfKonversi++;
            }
        }
    }
}

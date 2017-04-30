package com.example.kopral.konverter;

public class KonversiHrf_L {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrfKonversi;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    public KonversiHrf_L() {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.gantungan = false;
        this.cecek = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.tempHasilKonversi = new String[0];
        this.tempKalimat = new char[0];
    }

    public KonversiHrf_L(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.gantungan = false;
        this.cecek = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
    }

    public void setCecek(boolean cck) {
        this.cecek = cck;
    }

    public void setGantungan(boolean gntg) {
        this.gantungan = gntg;
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

    public void sub_Konversi_L() {
        if (this.indeksHuruf == this.tempKalimat.length - 1 || this.tempKalimat[this.indeksHuruf + 1] != '\u00e9') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "l";
            this.indexHrfKonversi++;
            this.gantungan = false;
            return;
        }
        this.tempHasilKonversi[this.indexHrfKonversi] = "\u00f2";
        this.indexHrfKonversi++;
        this.indeksHuruf++;
        this.gantungan = false;
    }

    public void konversi_L() {
        if (this.indeksHuruf == 0) {
            sub_Konversi_L();
        } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
            if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                sub_Konversi_L();
            } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 1]) || this.tempKalimat[this.indeksHuruf + 1] == 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00de";
                this.indexHrfKonversi++;
                this.gantungan = true;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                this.indexHrfKonversi++;
                this.tempHasilKonversi[this.indexHrfKonversi] = "l";
                this.indexHrfKonversi++;
                this.gantungan = false;
            }
        } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
            sub_Konversi_L();
        } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 1]) || this.tempKalimat[this.indeksHuruf + 1] == 'r') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00de";
            this.indexHrfKonversi++;
            this.gantungan = true;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = "/";
            this.indexHrfKonversi++;
            this.tempHasilKonversi[this.indexHrfKonversi] = "l";
            this.indexHrfKonversi++;
            this.gantungan = false;
        }
    }
}

package com.example.kopral.konverter;

public class KonversiHrf_R {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrfKonversi;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    public KonversiHrf_R() {
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

    public KonversiHrf_R(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
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

    public boolean kndsGantungan() {
        return this.gantungan;
    }

    public void setGantungan(boolean gntng) {
        this.gantungan = gntng;
    }

    public void setCecek(boolean cck) {
        this.cecek = cck;
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

    public void konversi_R() {
        if (this.indeksHuruf == 0) {
            if (this.tempKalimat[this.indeksHuruf + 1] == '\u00e9') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00cf";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
                return;
            }
            this.tempHasilKonversi[this.indexHrfKonversi] = "r";
            this.indexHrfKonversi++;
            this.gantungan = false;
        } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
            if (!this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) && !this.cecek && this.tempKalimat[this.indeksHuruf - 2] != 'h' && this.tempKalimat[this.indeksHuruf - 2] != 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                this.indexHrfKonversi++;
                if (this.tempKalimat[this.indeksHuruf + 1] == '\u00e9') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "\u00cf";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                } else {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "r";
                    this.indexHrfKonversi++;
                    this.gantungan = false;
                }
                this.gantungan = false;
                //ganti
                //} else if (this.tempKalimat[this.indeksHuruf + 1] == '\u00e9') {
            } else if (this.tempKalimat[this.indeksHuruf] == '\u00e9') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00cf";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "r";
                this.indexHrfKonversi++;
                this.gantungan = false;
            }
        } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
            if (this.indeksHuruf == this.tempKalimat.length - 1 || this.tempKalimat[this.indeksHuruf + 1] == ' ' || this.tempKalimat[this.indeksHuruf + 1] == ',' || this.tempKalimat[this.indeksHuruf + 1] == '.' || this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 1])) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "(";
                this.indexHrfKonversi++;
                this.gantungan = false;
            } else if (this.tempKalimat[this.indeksHuruf + 1] == '\u00e9') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00cf";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "r";
                this.indexHrfKonversi++;
                this.gantungan = false;
            }
            //ganti
            //} else if (this.tempKalimat[this.indeksHuruf + 1] == '\u00e9') {
        } else if (this.tempKalimat[this.indeksHuruf] == '\u00e9') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00cc";
            this.indeksHuruf++;
            this.indexHrfKonversi++;
            this.gantungan = true;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c9";
            this.indexHrfKonversi++;
            this.gantungan = true;
        }
    }
}

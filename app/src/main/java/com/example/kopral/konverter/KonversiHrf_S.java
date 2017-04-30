package com.example.kopral.konverter;

public class KonversiHrf_S {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrfKonversi;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    public KonversiHrf_S() {
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

    public KonversiHrf_S(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
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

    public void setCecek(boolean cck) {
        this.cecek = cck;
    }

    public void setGantungan(boolean gntng) {
        this.gantungan = gntng;
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

    public void konversi_S() {
        if (this.indeksHuruf == 0) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "s";
            this.indexHrfKonversi++;
            this.gantungan = false;
        } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
            if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "s";
                this.indexHrfKonversi++;
                this.gantungan = false;
                return;
            }
            this.tempHasilKonversi[this.indexHrfKonversi] = "u\u00e6";
            this.indexHrfKonversi++;
            this.gantungan = true;
        } else if (this.indeksHuruf != this.tempKalimat.length - 1 && (this.tempKalimat[this.indeksHuruf + 1] == 't' || this.tempKalimat[this.indeksHuruf + 1] == 'T')) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "[\u00d5";
            this.gantungan = true;
            this.indexHrfKonversi++;
            this.indeksHuruf++;
        } else if (this.indeksHuruf != this.tempKalimat.length - 1 && (this.tempKalimat[this.indeksHuruf + 1] == 'n' || this.tempKalimat[this.indeksHuruf + 1] == 'N')) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "[\u00c5";
            this.gantungan = true;
            this.indexHrfKonversi++;
            this.indeksHuruf++;
        } else if (this.indeksHuruf != this.tempKalimat.length - 1 && (this.tempKalimat[this.indeksHuruf + 1] == 's' || this.tempKalimat[this.indeksHuruf + 1] == 'S')) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "]\u00d6";
            this.gantungan = true;
            this.indexHrfKonversi++;
            this.indeksHuruf++;
        } else if (this.indeksHuruf != this.tempKalimat.length - 1 && (this.tempKalimat[this.indeksHuruf + 1] == 'c' || this.tempKalimat[this.indeksHuruf + 1] == 'C')) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "]";
            this.indexHrfKonversi++;
        } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "s";
            this.indexHrfKonversi++;
            this.gantungan = false;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = "u\u00e6";
            this.indexHrfKonversi++;
            this.gantungan = true;
        }
    }
}

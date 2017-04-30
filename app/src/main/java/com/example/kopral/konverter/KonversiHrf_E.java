package com.example.kopral.konverter;

public class KonversiHrf_E {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrfKonversi;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    String tempHrf1;
    String tempHrf2;
    String tempHrf3;

    public KonversiHrf_E() {
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

    public KonversiHrf_E(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
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

    public void setGantungan(boolean gntg) {
        this.gantungan = gntg;
    }

    public boolean kndsGantungan() {
        return this.gantungan;
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

    public void konversi_E() {
        if (this.indeksHuruf == 0) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "eh";
            this.indexHrfKonversi++;
            this.gantungan = false;
        } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
            if (this.cecek || this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "eh";
                this.indexHrfKonversi++;
                this.gantungan = false;
                return;
            }
            tempHrf1 = this.tempHasilKonversi[this.indexHrfKonversi - 1];
            if (!this.gantungan) {
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            } else if (this.tempKalimat[this.indeksHuruf - 1] != 'r' || this.indeksHuruf - 3 <= 0) {
                tempHrf2 = this.tempHasilKonversi[this.indexHrfKonversi - 2];
                this.tempHasilKonversi[this.indexHrfKonversi - 2] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = tempHrf2;
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            } else if (!this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 3]) || this.cecek) {
                tempHrf2 = this.tempHasilKonversi[this.indexHrfKonversi - 2];
                this.tempHasilKonversi[this.indexHrfKonversi - 2] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = tempHrf2;
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            } else {
                tempHrf2 = this.tempHasilKonversi[this.indexHrfKonversi - 2];
                tempHrf3 = this.tempHasilKonversi[this.indexHrfKonversi - 3];
                this.tempHasilKonversi[this.indexHrfKonversi - 3] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi - 2] = tempHrf3;
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = tempHrf2;
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            }
            this.indexHrfKonversi++;
        } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "eh";
            this.indexHrfKonversi++;
            this.gantungan = false;
        } else {
            tempHrf1 = this.tempHasilKonversi[this.indexHrfKonversi - 1];
            if (!this.gantungan) {
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            } else if (this.tempKalimat[this.indeksHuruf - 1] != 'r' || this.indeksHuruf - 3 <= 0) {
                tempHrf2 = this.tempHasilKonversi[this.indexHrfKonversi - 2];
                this.tempHasilKonversi[this.indexHrfKonversi - 2] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = tempHrf2;
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            } else if (!this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 3]) || this.cecek) {
                tempHrf2 = this.tempHasilKonversi[this.indexHrfKonversi - 2];
                this.tempHasilKonversi[this.indexHrfKonversi - 2] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = tempHrf2;
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            } else {
                tempHrf2 = this.tempHasilKonversi[this.indexHrfKonversi - 2];
                tempHrf3 = this.tempHasilKonversi[this.indexHrfKonversi - 3];
                this.tempHasilKonversi[this.indexHrfKonversi - 3] = "e";
                this.tempHasilKonversi[this.indexHrfKonversi - 2] = tempHrf3;
                this.tempHasilKonversi[this.indexHrfKonversi - 1] = tempHrf2;
                this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf1;
            }
            this.indexHrfKonversi++;
        }
    }

    public void konversi_E(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
        if (this.indeksHuruf == 0) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "eh";
            this.indexHrfKonversi++;
        } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
            if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2])) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "e\u00c0";
                this.indexHrfKonversi++;
                this.gantungan = true;
                return;
            }
            this.tempHasilKonversi[this.indexHrfKonversi] = "eh";
            this.indexHrfKonversi++;
        } else if (this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 1])) {
            String tempHrf = this.tempHasilKonversi[this.indexHrfKonversi - 1];
            this.tempHasilKonversi[this.indexHrfKonversi - 1] = "e";
            this.tempHasilKonversi[this.indexHrfKonversi] = tempHrf;
            this.indexHrfKonversi++;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = "eh";
            this.indexHrfKonversi++;
        }
    }
}

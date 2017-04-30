package com.example.kopral.konverter;

public class KonversiHrf_N {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrf;
    private int indexHrfKonversi;
    private boolean kndsNG;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    public KonversiHrf_N() {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.indexHrf = 0;
        this.gantungan = false;
        this.cecek = false;
        this.kndsNG = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.indexHrf = 0;
        this.tempHasilKonversi = new String[0];
        this.tempKalimat = new char[0];
    }

    public void setKndsNg(boolean kndsNg) {
        this.kndsNG = kndsNg;
    }

    public void setGantungan(boolean gntg) {
        this.gantungan = gntg;
    }

    public boolean kndsGantungan() {
        return this.gantungan;
    }

    public boolean kndsCecek() {
        return this.cecek;
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

    public void setIndexHrf(int xIndexHrf) {
        this.indexHrf = xIndexHrf;
    }

    public int getIndexHrf() {
        return this.indexHrf;
    }

    public KonversiHrf_N(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.indexHrf = 0;
        this.gantungan = false;
        this.cecek = false;
        this.kndsNG = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
    }

    public void konversi_N() {
        if (this.indeksHuruf == 0) {
            if (this.tempKalimat[this.indeksHuruf + 1] == 'g' || this.tempKalimat[this.indeksHuruf + 1] == 'G') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
                this.gantungan = false;
            } else if (this.tempKalimat[this.indeksHuruf + 1] == 'y' || this.tempKalimat[this.indeksHuruf + 1] == 'Y') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "z";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
                this.gantungan = false;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "n";
                this.indexHrfKonversi++;
                this.gantungan = false;
            }
        } else if (this.indeksHuruf != this.tempKalimat.length - 1) {
            if (this.tempKalimat[this.indeksHuruf + 1] == 'j' || this.tempKalimat[this.indeksHuruf + 1] == 'J') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "z\u00e9";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
                this.gantungan = true;
                this.cecek = false;
            } else if (this.tempKalimat[this.indeksHuruf + 1] == 'g' || this.tempKalimat[this.indeksHuruf + 1] == 'G') {
                if (this.indeksHuruf + 1 == this.tempKalimat.length - 1 || this.tempKalimat[this.indeksHuruf + 2] == ' ' || this.tempKalimat[this.indeksHuruf + 2] == '.' || this.tempKalimat[this.indeksHuruf + 2] == ',' || this.tempKalimat[this.indeksHuruf + 2] == '?' || this.tempKalimat[this.indeksHuruf + 2] == '!') {
                    if (this.tempKalimat[this.indeksHuruf - 1] == '\u00e9') {
                        this.tempHasilKonversi[this.indexHrfKonversi - 1] = "%";
                        this.indeksHuruf++;
                    } else if (this.tempKalimat[this.indeksHuruf - 1] == 'i') {
                        this.tempHasilKonversi[this.indexHrfKonversi - 1] = "&";
                        this.indeksHuruf++;
                    } else {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "*";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                    }
                    this.gantungan = false;
                    this.cecek = true;
                } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
                    if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = false;
                        this.cecek = false;
                        return;
                    }
                    if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 2]) || this.tempKalimat[this.indeksHuruf + 2] == 'r') {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "\u00e5";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = true;
                    } else {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                        this.indexHrfKonversi++;
                        this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = false;
                    }
                    this.cecek = false;
                } else if (this.kndsNG || !(this.indeksHuruf == this.tempKalimat.length - 3 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 2]) || this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf + 3]) || this.tempKalimat[this.indeksHuruf + 3] == 'r')) {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "*";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                    this.cecek = true;
                } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'h' || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                    this.gantungan = false;
                    this.cecek = false;
                } else {
                    if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 2]) || this.tempKalimat[this.indeksHuruf + 2] == 'r') {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "\u00e5";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = true;
                    } else {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                        this.indexHrfKonversi++;
                        this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = false;
                        this.cecek = false;
                    }
                    this.cecek = false;
                }
            } else if (this.tempKalimat[this.indeksHuruf + 1] == 'y' || this.tempKalimat[this.indeksHuruf + 1] == 'Y') {
                if (this.indeksHuruf == 0) {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "z";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                    this.gantungan = false;
                } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
                    if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'r' || this.tempKalimat[this.indeksHuruf - 2] == 'h') {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "z";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = false;
                    } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 2]) || this.tempKalimat[this.indeksHuruf + 2] == 'r') {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "\u00f1";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = true;
                    } else {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                        this.indexHrfKonversi++;
                        this.tempHasilKonversi[this.indexHrfKonversi] = "z";
                        this.indexHrfKonversi++;
                        this.indeksHuruf++;
                        this.gantungan = false;
                    }
                } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "z";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                    this.gantungan = false;
                } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 2]) || this.tempKalimat[this.indeksHuruf + 2] == 'r') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "\u00f1";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                    this.gantungan = true;
                } else {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                    this.indexHrfKonversi++;
                    this.tempHasilKonversi[this.indexHrfKonversi] = "z";
                    this.indexHrfKonversi++;
                    this.indeksHuruf++;
                    this.gantungan = false;
                }
                this.cecek = false;
            } else if (this.tempKalimat[this.indeksHuruf + 1] == 'c' || this.tempKalimat[this.indeksHuruf + 1] == 'C') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "z\u00c7";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
                this.gantungan = true;
                this.cecek = false;
            } else if (this.indeksHuruf - 1 != 0 && (this.tempKalimat[this.indeksHuruf - 1] == 'r' || this.tempKalimat[this.indeksHuruf - 2] == 'r')) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "x";
                this.indexHrfKonversi++;
                this.gantungan = false;
                this.cecek = false;
            } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
                if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "n";
                    this.indexHrfKonversi++;
                    this.gantungan = false;
                    this.cecek = false;
                } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 1]) || this.tempKalimat[this.indeksHuruf + 1] == 'r') {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c2";
                    this.indexHrfKonversi++;
                    this.gantungan = true;
                    this.cecek = false;
                } else {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                    this.indexHrfKonversi++;
                    this.tempHasilKonversi[this.indexHrfKonversi] = "n";
                    this.indexHrfKonversi++;
                    this.gantungan = false;
                    this.cecek = false;
                }
            } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "n";
                this.indexHrfKonversi++;
                this.gantungan = false;
                this.cecek = false;
            } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 1]) || this.tempKalimat[this.indeksHuruf + 1] == 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c2";
                this.indexHrfKonversi++;
                this.gantungan = true;
                this.cecek = false;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                this.indexHrfKonversi++;
                this.tempHasilKonversi[this.indexHrfKonversi] = "n";
                this.indexHrfKonversi++;
                this.gantungan = false;
                this.cecek = false;
            }
        } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek || this.tempKalimat[this.indeksHuruf - 1] == 'r') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "n";
            this.indexHrfKonversi++;
            this.gantungan = false;
            this.cecek = false;
        } else if (this.indeksHuruf == this.tempKalimat.length - 1 || !this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf + 1]) || this.tempKalimat[this.indeksHuruf + 1] == 'r') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c2";
            this.indexHrfKonversi++;
            this.gantungan = true;
            this.cecek = false;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = "/";
            this.indexHrfKonversi++;
            this.tempHasilKonversi[this.indexHrfKonversi] = "n";
            this.indexHrfKonversi++;
            this.gantungan = false;
            this.cecek = false;
        }
    }

    public void konversi_N(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
        if (this.indeksHuruf + 1 == this.tempKalimat.length) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "n";
            this.indexHrfKonversi++;
        } else if (this.tempKalimat[this.indeksHuruf + 1] == 'g' || this.tempKalimat[this.indeksHuruf + 1] == 'G') {
            if (this.indeksHuruf + 1 == this.tempKalimat.length - 1 || this.tempKalimat[this.indeksHuruf + 2] == ' ' || this.tempKalimat[this.indeksHuruf + 2] == '.' || this.tempKalimat[this.indeksHuruf + 2] == ',') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "*";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
            } else if (this.indeksHuruf + 1 == 1) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
            } else if (this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 1]) || (this.tempKalimat[this.indeksHuruf - 1] == ' ' && this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 2]))) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00e5";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
            } else if (!this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indeksHuruf - 1]) || this.tempKalimat[this.indeksHuruf + 2] == ' ') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\\";
                this.indexHrfKonversi++;
                this.indeksHuruf++;
            }
        } else if (this.tempKalimat[this.indeksHuruf + 1] == 'j' || this.tempKalimat[this.indeksHuruf + 1] == 'J') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "z\u00e9";
            this.indexHrfKonversi++;
            this.indeksHuruf++;
        }
    }
}

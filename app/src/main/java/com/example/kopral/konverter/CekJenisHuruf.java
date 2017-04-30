package com.example.kopral.konverter;

public class CekJenisHuruf {
    boolean itKonsonan;
    boolean itVokal;
    char[] konsonan;
    char[] vokal;

    public CekJenisHuruf() {
        this.vokal = new char[]{'a', 'i', 'u', 'e', 'o', '\u00e9'};
        this.konsonan = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        this.itKonsonan = false;
        this.itVokal = false;
        this.itKonsonan = false;
        this.itVokal = false;
    }

    public boolean cekJenisHurufKonsonan(char hrf) {
        for (char c : this.konsonan) {
            if (hrf == c) {
                this.itKonsonan = true;
            }
        }
        return this.itKonsonan;
    }

    public boolean cekJenisHurufVokal(char hrf) {
        for (char c : this.vokal) {
            if (hrf == c) {
                this.itVokal = true;
            }
        }
        return this.itVokal;
    }
}

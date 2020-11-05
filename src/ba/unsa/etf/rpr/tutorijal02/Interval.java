package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean daLiJePocetnaTackaUIntervalu;
    private boolean daLiJeKrajnjaTackaUIntervalu;

    public Interval() {
        this.pocetnaTacka =0;
        this.krajnjaTacka =0;
        this.daLiJePocetnaTackaUIntervalu = false;
        this.daLiJeKrajnjaTackaUIntervalu = false;
    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean daLiJePocetnaTackaUIntervalu, boolean daLiJeKrajnjaTackaUIntervalu) {
        if(pocetnaTacka>krajnjaTacka) {
            throw new IllegalArgumentException("Početna tačka je veća od krajnje");
        }
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.daLiJePocetnaTackaUIntervalu = daLiJePocetnaTackaUIntervalu;
        this.daLiJeKrajnjaTackaUIntervalu = daLiJeKrajnjaTackaUIntervalu;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isDaLiJePocetnaTackaUIntervalu() {
        return daLiJePocetnaTackaUIntervalu;
    }

    public void setDaLiJePocetnaTackaUIntervalu(boolean daLiJePocetnaTackaUIntervalu) {
        this.daLiJePocetnaTackaUIntervalu = daLiJePocetnaTackaUIntervalu;
    }

    public boolean isDaLiJeKrajnjaTackaUIntervalu() {
        return daLiJeKrajnjaTackaUIntervalu;
    }

    public void setDaLiJeKrajnjaTackaUIntervalu(boolean daLiJeKrajnjaTackaUIntervalu) {
        this.daLiJeKrajnjaTackaUIntervalu = daLiJeKrajnjaTackaUIntervalu;
    }


}

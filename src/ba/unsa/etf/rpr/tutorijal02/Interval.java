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

    public boolean getDaLiJePocetnaTackaUIntervalu() {
        return daLiJePocetnaTackaUIntervalu;
    }

    public void setDaLiJePocetnaTackaUIntervalu(boolean daLiJePocetnaTackaUIntervalu) {
        this.daLiJePocetnaTackaUIntervalu = daLiJePocetnaTackaUIntervalu;
    }

    public boolean getDaLiJeKrajnjaTackaUIntervalu() {
        return daLiJeKrajnjaTackaUIntervalu;
    }

    public void setDaLiJeKrajnjaTackaUIntervalu(boolean daLiJeKrajnjaTackaUIntervalu) {
        this.daLiJeKrajnjaTackaUIntervalu = daLiJeKrajnjaTackaUIntervalu;
    }

    public boolean isNull() {
        if(getPocetnaTacka() == getKrajnjaTacka()) {
            return true;
        }
        return false;
    }

    public boolean isIn(double tacka) {
        if(tacka >= getPocetnaTacka() && tacka <= getKrajnjaTacka()) {
            if(tacka == getPocetnaTacka()) {
                if(getDaLiJePocetnaTackaUIntervalu()) { return true; }
                return false;
            }
            if(tacka == getKrajnjaTacka()) {
                if(getDaLiJeKrajnjaTackaUIntervalu()) { return true; }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String string;
        if(isNull()) {
            string = "()";
            return string;
        }
        if(getDaLiJePocetnaTackaUIntervalu()) { string = "["; }
        else { string = "("; }
        string = string + getPocetnaTacka() + "," + getKrajnjaTacka();
        if(getDaLiJeKrajnjaTackaUIntervalu()) { string = string + "]"; }
        else { string = string + ")"; }
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) o;
        return getPocetnaTacka() == interval.getPocetnaTacka() && getKrajnjaTacka() == interval.getKrajnjaTacka() &&
                getDaLiJePocetnaTackaUIntervalu() == interval.getDaLiJePocetnaTackaUIntervalu() &&
                getDaLiJeKrajnjaTackaUIntervalu() == interval.getDaLiJeKrajnjaTackaUIntervalu();
    }
    public static Interval intersect(Interval interval1, Interval interval) {
        Interval noviInterval = new Interval();
        // za pocetnu tacku intervala
        if(interval1.getPocetnaTacka() > interval.getPocetnaTacka()) {
            noviInterval.setPocetnaTacka(interval1.getPocetnaTacka());
            noviInterval.setDaLiJePocetnaTackaUIntervalu(interval1.getDaLiJePocetnaTackaUIntervalu());
        }
        else if(interval.getPocetnaTacka() > interval1.getPocetnaTacka()) {
            noviInterval.setPocetnaTacka(interval.getPocetnaTacka());
            noviInterval.setDaLiJePocetnaTackaUIntervalu(interval.getDaLiJePocetnaTackaUIntervalu());
        }
        else {
            noviInterval.setPocetnaTacka(interval1.getPocetnaTacka());
            if(interval1.getDaLiJePocetnaTackaUIntervalu() || interval.getDaLiJePocetnaTackaUIntervalu()) {
                noviInterval.setDaLiJePocetnaTackaUIntervalu(true);
            }
            else { noviInterval.setDaLiJePocetnaTackaUIntervalu(false); }
        }
        // sada za krajnju tacku intervala
        if(interval1.getKrajnjaTacka() < interval.getKrajnjaTacka()) {
            noviInterval.setKrajnjaTacka(interval1.getKrajnjaTacka());
            noviInterval.setDaLiJeKrajnjaTackaUIntervalu(interval1.getDaLiJeKrajnjaTackaUIntervalu());
        }
        else if(interval.getKrajnjaTacka() < interval1.getKrajnjaTacka()) {
            noviInterval.setKrajnjaTacka(interval.getKrajnjaTacka());
            noviInterval.setDaLiJeKrajnjaTackaUIntervalu(interval.getDaLiJeKrajnjaTackaUIntervalu());
        }
        else {
            noviInterval.setKrajnjaTacka(interval1.getKrajnjaTacka());
            if(interval1.getDaLiJeKrajnjaTackaUIntervalu() || interval.getDaLiJeKrajnjaTackaUIntervalu()) {
                noviInterval.setDaLiJeKrajnjaTackaUIntervalu(true);
            }
            else { noviInterval.setDaLiJeKrajnjaTackaUIntervalu(true); }
        }
        return noviInterval;
    }

    public Interval intersect(Interval interval) {
        Interval noviInterval = intersect(this,interval);
        return noviInterval;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;

/**
 *
 * @author Augusto
 */
public class Comparador {

    protected boolean comparar(int a, int b, String simb) {
        if (simb == "==" || simb == "=") {
            return (a == b);
        } else if (simb == ">") {
            return (a > b);
        } else if (simb == "<") {
            return (a < b);
        } else if (simb == ">=") {
            return (a >= b);
        } else if (simb == "<=") {
            return (a <= b);
        }
        return false;
    }

    protected boolean comparar(String a, String b, String simb) {
        if (simb == "==" || simb == "=") {
            return (a.compareToIgnoreCase(b) == 0);
        } else if (simb == ">") {
            return (a.compareToIgnoreCase(b) > 0);
        } else if (simb == "<") {
            return (a.compareToIgnoreCase(b) < 0);
        } else if (simb == ">=") {
            return (a.compareToIgnoreCase(b) == 0 || a.compareToIgnoreCase(b) > 0);
        } else if (simb == "<=") {
            return (a.compareToIgnoreCase(b) == 0 || a.compareToIgnoreCase(b) < 0);
        }
        return false;
    }

    protected boolean comparar(Date a, Date b, String simb) {
        if (simb == "==" || simb == "=") {
            return (a.equals(b));
        } else if (simb == ">") {
            return (a.after(b));
        } else if (simb == "<") {
            return (a.before(b));
        } else if (simb == ">=") {
            return (a.equals(b) || a.after(b));
        } else if (simb == "<=") {
            return (a.equals(b) || a.before(b));
        }
        return false;
    }
}

interface Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b);
}

class CompareEstado implements Comparadores {

    Comparador comparador = new Comparador();

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
//        return comparador.comparar(a.getEstado() + a.getCidade(), b.getEstado() + a.getCidade(), "<");
        return a.getEstado().compareTo(b.getEstado()) < 0;
    }
}

class CompareCidade implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getCidade().compareTo(b.getCidade()) < 0;
    }
}

class CompareDatas implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getDtConfirmacao().before(b.getDtConfirmacao());
    }
}

class CompareNumeroCasos implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return (a.getNumeroCasos() < b.getNumeroCasos());
    }
}

//
//class CompareEstadoCidade implements Comparadores {
//
//    Comparador comparador = new Comparador();
//
//    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
////        return comparador.comparar(a.getEstado() + a.getCidade(), b.getEstado() + a.getCidade(), "<");
//        return a.getEstado().compareTo(b.getEstado()) < 0;
//    }
//}

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

}

interface Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b);

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b);
}

class CompareEstado implements Comparadores {

    Comparador comparador = new Comparador();

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getEstado().compareTo(b.getEstado()) < 0;
    }

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getEstado().compareTo(b.getEstado()) == 0;
    }
}

class CompareEstadoHS implements Comparadores {

    Comparador comparador = new Comparador();

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getEstado().compareTo(b.getEstado()) > 0;
    }

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getEstado().compareTo(b.getEstado()) == 0;
    }
}

class CompareCidade implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getCidade().compareTo(b.getCidade()) < 0;
    }

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getCidade().compareTo(b.getCidade()) == 0;
    }
}

class CompareDatas implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getDtConfirmacao().before(b.getDtConfirmacao());
    }

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return a.getDtConfirmacao().equals(b.getDtConfirmacao());
    }
}

class CompareNumeroCasos implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return (a.getNumeroCasos() < b.getNumeroCasos());
    }

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return (a.getNumeroCasos() == b.getNumeroCasos());
    }
}

class CompareNumeroCasosHS implements Comparadores {

    public Boolean comparar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return (a.getNumeroCasos() > b.getNumeroCasos());
    }

    public Boolean igualar(DadosCovid.Entrada a, DadosCovid.Entrada b) {
        return (a.getNumeroCasos() == b.getNumeroCasos());
    }
}

package br.com.viniciusmargotti.javaspringapi.enums;

public enum TipoGraficoEnum {
    LINE(0),
    BAR(2),
    PIE(4);

    private final Integer tipo;

    TipoGraficoEnum(Integer tipo){
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }
}
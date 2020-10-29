public class Fracao {

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    private int numerador;
    private int denominador;
    private boolean positiva;
    private double valorNumerico;


    public Fracao(int numerador, int denominador, boolean positiva) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.positiva = positiva;
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {
        if(denominador != 0){
            valorNumerico = (double) numerador/(double) denominador;
            if(positiva == true){
                return valorNumerico;
            } else return -valorNumerico;
        }
        return 0;
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si)
     *
     * @return uma fração irredutível equivalente a esta
     */
    public Fracao getFracaoIrredutivel() {
        if(denominador != 0) {
            int mdc = mdc(numerador, denominador);
            if(mdc == 1) return this;
            if (mdc == numerador) {
                numerador = numerador / mdc;
                denominador = denominador/mdc;
                return new Fracao(numerador,denominador,positiva);
            } else return this;
        } return null;
    }

    public int getNumerador(){
        if(positiva == true) {
            return numerador;
        }else return -(numerador);
    }

    public int getDenominador(){
        return denominador;
    }

    public boolean isPositiva(){
        return positiva;
    }

    @Override
    public boolean equals(Object objeto){
        if(((Fracao) objeto).getValorNumerico() == this.getValorNumerico()){
            return true;
        }else return false;
    }


    public int mdc (int a, int b){
        if(b==0) {
            return a;
        } else return mdc(b, a%b);

    }
}
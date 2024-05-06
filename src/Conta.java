public class Conta{
    private int numero;
    private double saldo;
    private Cliente dono = new Cliente();
    private String agencia;
    private Operacao[] operacoes = new Operacao[0];
    public static int totalContas = 0;

    public Cliente getDono(){
        return this.dono;
    }
    public void setDono(Cliente novoDono){
        this.dono = novoDono;
    }
    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int novoNumero){
        this.numero = novoNumero;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getAgencia(){
        return this.agencia;
    }
    public void setAgencia(String novaAgencia){
        this.agencia = novaAgencia;
    }

    Conta(String nome, double saldo, String agencia, int numero){
        this.dono.nome = nome;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
        totalContas++;
    }

    private void registroOperacao(char tipo, double valor){
        Operacao[] operacoesAntiga = operacoes;
        operacoes = new Operacao[operacoes.length+1];
        for (int i=0;i<operacoesAntiga.length;i++){
            operacoes[i] = operacoesAntiga[i];
        }
        operacoes[operacoes.length-1] = new Operacao(tipo,valor);
    }

    public void extrato(){
        for (Operacao opr : operacoes) {
            System.out.println(opr.data + "\t" + opr.tipo + "\t" + opr.valor);
        }
    }
    public boolean deposito(double valor){
        if (valor > 0) {
            this.saldo += valor;
            registroOperacao('d', valor);
            return true;
        }
        return false;
    }
    public boolean saque(double valor){
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            registroOperacao('s', valor);
            return true;
        }
        return false;
    }
    public boolean transferir(Conta destino, double valor){
        boolean saque = this.saque(valor);
        if (saque){
            boolean deposito = destino.deposito(valor);
            return deposito;
        }
        return false;
    }
    public void imprimir(){
        System.out.printf("Dono : %s\nSaldo : %.2f\nNumero : %d\nAgencia : %s\n", this.dono.nome, this.saldo, this.numero, this.agencia);
    }
}

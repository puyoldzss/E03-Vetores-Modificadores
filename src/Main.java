public class Main{
    public static void main(String[] args){
        Conta c1 = new Conta("Puyas",2500,"169-9",16);
        Conta c2 = new Conta("Cuca",100,"222-4",03);


        c1.saque(100);
        c1.deposito(600);
        c2.saque(100);
        c2.deposito(1000);
        c2.transferir(c1, 500);
        c2.saque(300);
        c1.extrato();
        System.err.println("......");
        c2.extrato();
        System.out.printf("Media de operacoes por conta : %.2f\n",(float) ((float)Operacao.totalOperacoes/(float)Conta.totalContas));

    }
}
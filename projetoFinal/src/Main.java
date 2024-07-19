import java.util.Scanner;

public class Main {
    public enum InssEnum{
        FAIXA1(0.075f),
        FAIXA2(0.090f),
        FAIXA3(0.120f),
        FAIXA4(0.140f);

        private float percentual;
        InssEnum(float percentual){
            this.percentual = percentual;
        }

        private float getPercentual(){
            return this.percentual;
        }

    }

    public enum IrrfEnum{
        FAIXA1(0.000f),
        FAIXA2(0.075f),
        FAIXA3(0.150f),
        FAIXA4(0.225f),
        FAIXA5(0.275f);

        private float percentual;
        IrrfEnum(float percentual){
            this.percentual = percentual;
        }

        private float getPercentual(){
            return this.percentual;
        }
    }

    public static String getFaixaInss(float salario) {
        if (salario > 0 && salario <= 1212.00) {
            return "FAIXA1";
        } else if (salario > 1212.00 && salario <= 2427.35) {
            return "FAIXA2";
        } else if (salario > 2427.35 && salario <= 3641.03) {
            return "FAIXA3";
        } else if (salario > 3641.03) {
            return "FAIXA4";
        } else {
            return "Salário invalido";
        }
    }

    public static String getFaixaIrrf(float salario){
        if (salario>0 && salario<=1903.98) {
            return "FAIXA1";
        }
        else if (salario>1903.98 && salario<=2826.65) {
            return "FAIXA2";
        }
        else if (salario>2826.65 && salario<=3751.05) {
            return "FAIXA3";
        }
        else if (salario>3751.05 && salario <=4664.68){
            return "FAIXA4";
        }
        else if (salario>4664.68){
            return "FAIXA5";
        }
        else {
            return "Salário invalido";
        }

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        float [] salarios = new float[5];

        for(int i=0; i<salarios.length; i++){
            System.out.printf("Digite o salário bruto do funcionario %d: R$ ", i+1);
            salarios[i] = s.nextFloat();
        }

        for (int i=0; i< salarios.length;i++){
            float salarioBruto = salarios[i];
            float salarioComDeducao = salarioBruto;
            InssEnum inss = InssEnum.valueOf(getFaixaInss(salarioBruto));
            IrrfEnum irrf = IrrfEnum.valueOf(getFaixaIrrf(salarioBruto));


            float deducaoInss = salarioBruto * (inss.percentual);
            float deducaoIrrf = salarioBruto * (irrf.percentual);


            //Desconto INSS
            salarioComDeducao = salarioBruto -deducaoInss - deducaoIrrf;


            System.out.printf("###### Contracheque - Funcionario %d #######\n",i+1);
            System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
            System.out.printf("Dedução do inss: -R$ %.2f\n", deducaoInss);
            System.out.printf("Deducao do IRRF: -R$ %.2f\n", deducaoIrrf);
            System.out.printf("Salário líquido: %.2f\n", salarioComDeducao);
            System.out.printf("###### Fim do Contracheque - Funcionario %d #######\n\n", i+1);


            }
        }


    }

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

            File arquivoCSV = new File ("C:\\funcionarios.csv");

            ArrayList<Funcionario> funcionarios = new ArrayList<>();

            try
            {
                String leitura_linhas = new String();

                Scanner leitura = new Scanner (arquivoCSV);

                leitura.nextLine();

                while(leitura.hasNext())
                {
                    leitura_linhas = leitura.nextLine();
                    String [] vetorValores = leitura_linhas.split(",");

                    Funcionario F = new Funcionario(vetorValores[0],Integer.parseInt(vetorValores[3]),Double.parseDouble(vetorValores[4]));
                    if(Integer.parseInt(vetorValores[3]) > 0) {
                        funcionarios.add(F);
                    }
                }

                for(Funcionario func:funcionarios) {
//                    System.out.println("Id = " + func.getId());
//                    System.out.println("Qtd Filhos = " + func.getFilhos());
//                    System.out.println("Salário = " + func.getSalario());
                      func.preencheCSV(func);
                }

            } catch(FileNotFoundException e)
            {
                System.out.println("Arquivo não encontrado!");
            }
    }
}

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Funcionario {

    private String id;
    private int filhos;
    private double salario;

    public Funcionario(String id, int filhos, double salario) {
        this.id = id;
        this.filhos = filhos;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public int getFilhos() {
        return filhos;
    }

    public double getSalario() {
        return salario;
    }

    public void preencheCSV(Funcionario f1) {

        OutputStream os = null;
        OutputStreamWriter osr = null;
        BufferedWriter bw = null;
        String linhaEscrever;

        try {
            os = new FileOutputStream("func_filtrado.csv", true); //salvar no arquivo (false = apaga tudo que tinha e salva o novo conteudo)
            osr = new OutputStreamWriter(os); //conversor
            bw = new BufferedWriter(osr); //o q vai digitar

            bw.newLine();
            bw.write(f1.getId() + ",");
            bw.write(f1.getFilhos() + ",");
            bw.write(f1.getSalario() + "\n");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

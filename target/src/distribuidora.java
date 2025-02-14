import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class distribuidora {
    public static void main(String[] args) {
        List<Double> faturamentos = new ArrayList<>();

        // Caminho para o arquivo JSON
        String caminhoArquivo = "D:/rodrigo/targetsistemas/teste-target-sistemas/target/faturamento.json";
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.startsWith("{\"valor\":")) {
                    String valorStr = linha.split(":")[1].replace("}", "").trim();
                    Double valor = Double.parseDouble(valorStr);
                    if (valor > 0) {
                        faturamentos.add(valor);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!faturamentos.isEmpty()) {
            Double menorFaturamento = faturamentos.stream().min(Double::compare).orElse(0.0);
            Double maiorFaturamento = faturamentos.stream().max(Double::compare).orElse(0.0);
            Double somaFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();
            Double mediaFaturamento = somaFaturamento / faturamentos.size();
            long diasAcimaMedia = faturamentos.stream().filter(f -> f > mediaFaturamento).count();

            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);
        } else {
            System.out.println("Nenhum faturamento registrado.");
        }
    }
}


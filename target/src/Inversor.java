import java.util.Scanner;

public class Inversor {
    public static void main(String[] args) {
        // entrada do usuário 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe uma string para inverter:");
        String entrada = scanner.nextLine();
        
        // Inverter a string manualmente
        String invertida = "";
        for (int i = entrada.length() - 1; i >= 0; i--) {
            invertida += entrada.charAt(i);
        }
        
        // Exibir a string invertida
        System.out.println("String invertida: " + invertida);
    }
}
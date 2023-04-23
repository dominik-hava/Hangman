import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<10; i++){
            System.out.println("Zadejte libovolné číslo");
            int number = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Zadejte slovo:");
            String slovo = scanner.nextLine();
            System.out.println(slovo);
            
            if(number<50){
                    System.out.println("Číslo je menší než 50");
                }
            else if(number < 100){
                System.out.println("Číslo je mezi 50 a 100");
            }
            else{
                System.out.println("Číslo je větší něž sto!");
            }
        }
        scanner.close();
        
    }
}

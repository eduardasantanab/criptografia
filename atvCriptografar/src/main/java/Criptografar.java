import java.util.Scanner;

public class Criptografar {

    public static int insereNomes(String[] vet, int qtdPreenchidas, String nome) {
        int pos, i;
        if (qtdPreenchidas == 0) {
            vet[0] = nome;
            qtdPreenchidas++;
            return qtdPreenchidas;
        } else if (qtdPreenchidas == vet.length) {
            return -1;
        } else {
            for (pos = 0; pos <= qtdPreenchidas - 1; pos++) {
                if (vet[pos].compareToIgnoreCase(nome) == 0) {
                    return -2;
                } else if (vet[pos].compareToIgnoreCase(nome) > 0) {
                    break;
                } else {
                    vet[pos + 1] = nome;
                    qtdPreenchidas++;
                }
            }
            for (i = qtdPreenchidas - 1; i >= pos; i--) {
                vet[pos + 1] = vet[pos];
                vet[pos] = nome;
                qtdPreenchidas++;
            }
            return qtdPreenchidas;
        }
    }


    public static void exibeNomes(String[] vet, int qtdPreenchidas) {
        for (int i = 0; i < qtdPreenchidas; i++) {
            System.out.println("[" + i + "] = " + vet[i]);
        }
    }


    public static void main(String[] args) {
        String[] nomes = new String[3];
        int preenchidos = 0;
        String nomePreenche;
        char S;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Informe um nome: ");
            nomePreenche = input.next();
            preenchidos = insereNomes(nomes, preenchidos, nomePreenche);

            if (preenchidos == -1) {
                System.out.println("O vetor já está totalmente preenchido!");
                break;
            } else if (preenchidos == -2) {
                System.out.println("O nome informado já foi inserido anteriormente.");
            } else {
                System.out.println("O nome foi inserido com sucesso!");
            }
            System.out.println("Deseja inserir um novo nome? [S / N]");
            S = input.next().toLowerCase().trim().charAt(0);
        } while (S == 's');

        exibeNomes(nomes, preenchidos);










































//
//    public static void main(String[] args){
//        String frase;
//
//        Scanner input = new Scanner(System.in);
//
//        frase = input.nextLine();
//
//
////        trocar a vogal ‘a’ por ‘@’, a vogal ‘e’ por ‘$’, a
////        vogal ‘i’ por ‘&’, a vogal ‘o’ por ‘*’ e a vogal ‘u’ por ‘#’.

    }


}

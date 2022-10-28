import java.util.Arrays;
import java.util.Scanner;

public class Cripto {

    public static boolean validaMensagem(String frase) {
        int tamanho = frase.length();
        boolean valida = false;

        for (int i = 0; i < tamanho; i++) {
            if (Character.isLetter(frase.charAt(i))) {
                valida = true;
            } else if (Character.isSpaceChar(frase.charAt(i))) {
                valida = true;
            } else {
                valida = false;
                break;
            }
        }
        return valida;
    }

    public static String alteraFrase(char letra, int desloc, int indice) {
        int pos, novaPos;
        String novaLetra = null;

        String[] alfabetoLetra = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int[] alfabetoNum = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

        if (indice == 1) { //lógica criptografar
            for (pos = 0; pos < alfabetoLetra.length; pos++) {
                if (String.valueOf(letra).compareToIgnoreCase(alfabetoLetra[pos]) == 0) {
                    if (pos == 25) { //se a letra desloca para frente a partir de 'z'
                        novaPos = (-1 + desloc);
                        novaLetra = alfabetoLetra[novaPos];
                    } else {
                        novaPos = alfabetoNum[pos] + desloc;
                        if (novaPos > 26) {
                            novaLetra = alfabetoLetra[novaPos - 26];
                        } else {
                            novaLetra = alfabetoLetra[novaPos];
                        }
                        break;
                    }
                } else if (Character.isSpaceChar(letra)) {
                    novaLetra = " ";
                    break;
                }
            }
        } else { //lógica decriptografar
            for (pos = 0; pos < alfabetoLetra.length; pos++) {
                if (String.valueOf(letra).compareToIgnoreCase(alfabetoLetra[pos]) == 0) {
                    if (pos == 0) { //se a letra desloca para trás a partir de 'a'
                        novaPos = (26 - desloc);
                    } else {
                        novaPos = (alfabetoNum[pos] - desloc);
                        if (novaPos < 0) {
                            novaLetra = alfabetoLetra[novaPos + 26];
                        } else {
                            novaLetra = alfabetoLetra[novaPos];
                        }
                        break;
                    }
                } else if (Character.isSpaceChar(letra)) {
                    novaLetra = " ";
                    break;
                }
            }
        }
        return novaLetra;
    }

    public static String criptografa(String frase, int desloc) {
        int tamanho = frase.length();

        String[] vetFrase = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetFrase[i] = String.valueOf(frase.charAt(i));
        }

        for (int i = 0; i < tamanho; i++) {
            vetFrase[i] = alteraFrase(frase.charAt(i), desloc, 1);
        }

        return Arrays.toString(vetFrase);  //return frase criptografada
    }

    public static String decriptografa(String frase, int desloc) {
        int tamanho = frase.length();

        String[] vetFrase = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetFrase[i] = String.valueOf(frase.charAt(i));
        }

        for (int i = 0; i < tamanho; i++) {
            vetFrase[i] = alteraFrase(frase.charAt(i), desloc, 2);
        }

        return Arrays.toString(vetFrase);  //return frase decriptografada
    }

    public static void main(String[] args) {
        String resultado;
        boolean valido;
        String frase;
        int tamanho;
        int opcao;
        int deslocamento;

        Scanner input = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        frase = input.nextLine();

        System.out.println("Informe a opção que deseja realizar: 1 - Criptografar ou 2 - Decriptografar");
        opcao = input.nextInt();

        System.out.println("Qual o deslocamento que será utilizado pela Cifra de César? ");
        deslocamento = input.nextInt();

        valido = validaMensagem(frase);

        if (opcao == 1) { //criptografa
            if (valido) {
                resultado = criptografa(frase, deslocamento).replaceAll(",", "");
                tamanho = resultado.length();

                System.out.print("A frase criptografada é: ");
                for (int i = 1; i < tamanho - 1; i++) {
                    System.out.print(resultado.charAt(i));
                }
            } else {
                System.out.println("A frase está no formato inválido! Não contém apenas letras ou espaços");
            }
        } else if (opcao == 2) { //decriptografa
            if (valido) {
                resultado = decriptografa(frase, deslocamento).replaceAll(",", "");
                tamanho = resultado.length();

                System.out.print("A frase decriptografada é: ");
                for (int i = 1; i < tamanho - 1; i++) {
                    System.out.print(resultado.charAt(i));
                }
            } else {
                System.out.println("A frase está no formato inválido! Não contém apenas letras ou espaços");
            }
        } else { //inválido
            System.out.println("A opção informada não existe!");
        }
    }
}
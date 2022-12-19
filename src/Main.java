import java.util.Scanner;

class JogoDaVelha {
    boolean turnoJ1 = true;
    char simbolo = '-';

    public void inicializarTabuleiro(char[][] tabuleiro) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                tabuleiro[linha][coluna] = '#';
            }
        }
    }

    public void desenharTabuleiro(char[][] tabuleiro) {
        for (char[] linha : tabuleiro) {
            for (char elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    private boolean validarJogada(char[][] tabuleiro, int l, int c) {
        if (l < 0 || l > tabuleiro.length || c < 0 || c > tabuleiro.length) {
            System.out.println("Posição inválida!");
        }

        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                if (tabuleiro[linha][coluna] != '#') {
                        System.out.println("Uma jogada nessa posição já foi feita!");
                } else {
                    break;
                }
            }
        }

        return true;
    }

    public void realizarJogada(char[][] tabuleiro) {
        if (turnoJ1) {
            simbolo = 'X';
        } else {
            simbolo = 'O';
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Jogador(a) " + simbolo + ", insira a posição na linha que deseja jogar (0, 1 ou 2): ");
            int jogadaLinha = scanner.nextInt();
            System.out.print("Jogador(a) " + simbolo + ", insira a posição na coluna que deseja jogar (0, 1 ou 2): ");
            int jogadaColuna = scanner.nextInt();

            boolean jogadaValida = validarJogada(tabuleiro, jogadaLinha, jogadaColuna);

            if(jogadaValida) {
                tabuleiro[jogadaLinha][jogadaColuna] = simbolo;
            }

            desenharTabuleiro(tabuleiro);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        JogoDaVelha jogo = new JogoDaVelha();

        jogo.inicializarTabuleiro(tabuleiro);
        jogo.realizarJogada(tabuleiro);
    }
}
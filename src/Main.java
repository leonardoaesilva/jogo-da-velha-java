import java.util.Scanner;

class JogoDaVelha {
    boolean jogoFinalizado = true;
    boolean turnoJ1 = true;
    char simbolo;

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

    public void executarJogo(char[][] tabuleiro) {
        jogoFinalizado = false;

        while (!jogoFinalizado) {

            if (turnoJ1) {
                simbolo = 'X';
            } else {
                simbolo = 'O';
            }
            realizarJogada(tabuleiro, turnoJ1, simbolo);
        }
    }

    private void realizarJogada(char[][] tabuleiro, boolean turno, char simbolo) {
        Scanner scanner = new Scanner(System.in);

        while (!haVencedor(tabuleiro) && !derVelha(tabuleiro)) {
            System.out.println("Turno de " + simbolo);
            System.out.print("Jogador(a), insira a posição na LINHA que deseja jogar (0, 1 ou 2): ");
            int jogadaLinha = scanner.nextInt();
            System.out.print("Jogador(a), insira a posição na COLUNA que deseja jogar (0, 1 ou 2): ");
            int jogadaColuna = scanner.nextInt();

            boolean jogadaValida = validarJogada(tabuleiro, jogadaLinha, jogadaColuna);

            if (jogadaValida) {
                tabuleiro[jogadaLinha][jogadaColuna] = simbolo;
                desenharTabuleiro(tabuleiro);
                turno = !turno;
            }
        }
    }

    private boolean validarJogada(char[][] tabuleiro, int linha, int coluna) {
        if (linha < 0 || linha > tabuleiro.length || coluna < 0 || coluna > tabuleiro.length) {
            System.out.println("Posição inválida!");
            return false;
        } else {
            for (int lin = 0; lin < tabuleiro.length; lin++) {
                for (int col = 0; col < tabuleiro[lin].length; col++) {
                    if (tabuleiro[linha][coluna] != '#') {
                        System.out.println("Uma jogada nessa posição já foi feita!");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean haVencedor(char[][] tabuleiro) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            if (tabuleiro[linha][0] != '#' && tabuleiro[linha][0] == tabuleiro[linha][1] && tabuleiro[linha][1] == tabuleiro[linha][2]) {
                System.out.println(tabuleiro[linha][0] + " venceu!");
                jogoFinalizado = true;
            }
        }

        for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
            if (tabuleiro[0][coluna] != '#' && tabuleiro[0][coluna] == tabuleiro[1][coluna] && tabuleiro[1][coluna] == tabuleiro[2][coluna]) {
                System.out.println(tabuleiro[0][coluna] + " venceu!");
                jogoFinalizado = true;
            }
        }

        if (tabuleiro[0][0] != '#' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            System.out.println(tabuleiro[0][0] + " venceu!");
            jogoFinalizado = true;
        }

        if (tabuleiro[0][2] != '#' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            System.out.println(tabuleiro[0][0] + " venceu!");
            jogoFinalizado = true;
        }

        return jogoFinalizado;
    }

    private boolean derVelha(char[][] tabuleiro) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                if (tabuleiro[linha][coluna] == '#') { return false; }
            }
        }

        System.out.println("VELHA! Possibilidades de jogadas esgotadas.");
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        JogoDaVelha jogo = new JogoDaVelha();

        jogo.inicializarTabuleiro(tabuleiro);
        System.out.println("Jogo iniciado!");
        jogo.desenharTabuleiro(tabuleiro);
        jogo.executarJogo(tabuleiro);
    }
}

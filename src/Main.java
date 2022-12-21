import java.util.Scanner;

class JogoDaVelha {
    boolean jogoFinalizado = true;
    boolean turnoO = true;
    char simbolo = 'O';

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

        while (!haVencedor(tabuleiro) || !derVelha(tabuleiro)) {
            if (!turnoO) {
                simbolo = 'X';
            } else {
                simbolo = 'O';
            }
            realizarJogada(tabuleiro, simbolo);
        }
    }

    private void realizarJogada(char[][] tabuleiro, char simbolo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Turno de (" + simbolo + ")");
        System.out.print("Jogador(a), insira a posição na LINHA que deseja jogar (0, 1 ou 2): ");
        int jogadaLinha = scanner.nextInt();
        System.out.print("Jogador(a), insira a posição na COLUNA que deseja jogar (0, 1 ou 2): ");
        int jogadaColuna = scanner.nextInt();

        boolean jogadaValida = validarJogada(tabuleiro, jogadaLinha, jogadaColuna);

        if (jogadaValida) {
            tabuleiro[jogadaLinha][jogadaColuna] = simbolo;
            desenharTabuleiro(tabuleiro);
            turnoO = !turnoO;
        }
    }

    private boolean validarJogada(char[][] tabuleiro, int linha, int coluna) {
        if (!posicaoValida(tabuleiro, linha, coluna) || !posicaoDisponivel(tabuleiro, linha, coluna)) {
            return false;
        }

        return true;
    }

    private boolean posicaoValida(char[][] tabuleiro, int linha, int coluna) {
        if (linha < 0 || linha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro.length) {
            System.out.println("Posição inválida!");
            return false;
        }

        return true;
    }

    private boolean posicaoDisponivel(char[][] tabuleiro, int linha, int coluna) {
        for (int lin = 0; lin < tabuleiro.length; lin++) {
            for (int col = 0; col < tabuleiro[lin].length; col++) {
                if (tabuleiro[linha][coluna] != '#') {
                    System.out.println("Uma jogada nessa posição já foi feita!");
                    return false;
                }
            }
        }

        return true;
    }

    // TODO: 20/12/2022 garantir a parada em caso de vitória
    private boolean haVencedor(char[][] tabuleiro) {
        if (checarLinhas(tabuleiro) || checarColunas(tabuleiro) || checarDiagonais(tabuleiro)) {
            jogoFinalizado = true;
        }

        return jogoFinalizado;
    }

    private boolean checarDiagonais(char[][] tabuleiro) {
        if (tabuleiro[0][0] != '#' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            System.out.println("(" + tabuleiro[0][0] + ") venceu o jogo pela diagonal principal!");
            return true;
        } else if (tabuleiro[0][2] != '#' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            System.out.println("(" + tabuleiro[0][2] + ") venceu o jogo pela diagonal secundária!");
            return true;
        }

        return false;
    }

    private boolean checarLinhas(char[][] tabuleiro) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            if (tabuleiro[linha][0] != '#' && tabuleiro[linha][0] == tabuleiro[linha][1] && tabuleiro[linha][1] == tabuleiro[linha][2]) {
                System.out.println("(" + tabuleiro[linha][0] + ") venceu o jogo pela linha " + (linha + 1) + "!");
                return true;
            }
        }

        return false;
    }

    private boolean checarColunas(char[][] tabuleiro) {
        for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
            if (tabuleiro[0][coluna] != '#' && tabuleiro[0][coluna] == tabuleiro[1][coluna] && tabuleiro[1][coluna] == tabuleiro[2][coluna]) {
                System.out.println("(" + tabuleiro[0][coluna] + ") venceu o jogo pela coluna " + (coluna + 1) + "!");
                return true;
            }
        }

        return false;
    }

    // TODO: 20/12/2022 funcionar o caso de velha no jogo
    private boolean derVelha(char[][] tabuleiro) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                if (tabuleiro[linha][coluna] == '#') {
                    jogoFinalizado = false;
                }
            }
        }

        if (jogoFinalizado) {
            System.out.println("VELHA! Possibilidades de jogadas esgotadas.");
        }

        return jogoFinalizado;
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        JogoDaVelha jogoDaVelha = new JogoDaVelha();

        jogoDaVelha.inicializarTabuleiro(tabuleiro);
        System.out.println("Jogo iniciado!");
        jogoDaVelha.desenharTabuleiro(tabuleiro);
        jogoDaVelha.executarJogo(tabuleiro);
    }
}

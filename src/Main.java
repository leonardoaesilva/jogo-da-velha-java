class JogoDaVelha {
    public void inicializarTabuleiro(char[][] tabuleiro) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                tabuleiro[linha][coluna] = '#';
            }
        }
    }

    public void desenharTabuleiro(char[][] tabuleiro) {
        for (char[] linha : tabuleiro) {
            for (char coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        JogoDaVelha jogo = new JogoDaVelha();

        jogo.inicializarTabuleiro(tabuleiro);
        jogo.desenharTabuleiro(tabuleiro);
    }
}
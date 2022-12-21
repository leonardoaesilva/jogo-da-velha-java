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

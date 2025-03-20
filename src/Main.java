/*
VAR
    codigo, quantidade: Inteiro
    tipo: Caractere
    preco, total: Real

INICIO
    Ler codigo
    Ler tipo
    Ler quantidade

    SE codigo = 1 ENTAO
        SE tipo = 'N' ENTAO
            preco <- 1.50
        SENAO
            preco <- 1.70
        FIM SE
    SENAO SE codigo = 2 ENTAO
        SE tipo = 'N' ENTAO
            preco <- 1.60
        SENAO
            preco <- 1.70
        FIM SE
    SENAO SE codigo = 3 ENTAO
        SE tipo = 'N' ENTAO
            preco <- 1.40
        SENAO
            preco <- 1.45
        FIM SE
    FIM SE

    total <- preco * quantidade

    SE total > 100 ENTAO
        total <- total * 0.95
    FIM SE

    Escreva "Valor total: ", total
FIM

TESTE DE MESA

Código	Tipo	Quantidade	Preço Unitário	Total	Desconto?	Total Final
1	    N	    50	        1.50	        75.00	Não	        75.00
2	    D	    100	        1.70	        170.00	Sim     	161.50
3	    N	    100	        1.40	        140.00	Sim	        133
 */

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int codigo, quantidade;
        String tipo;
        double preco = 0, total;

        // Entrada de dados
        String sCodigo = JOptionPane.showInputDialog(null, "Digite o código do refrigerante (1, 2 ou 3):");
        codigo = Integer.parseInt(sCodigo);

        if (codigo < 1 || codigo > 3) {
            JOptionPane.showMessageDialog(null, "Código inválido! Digite 1, 2 ou 3.");
            return;
        }

        tipo = JOptionPane.showInputDialog(null, "Digite o tipo (N para Normal, D para Diet):");

        if (!tipo.equals("N") && !tipo.equals("D")) {
            JOptionPane.showMessageDialog(null, "Tipo inválido! Digite N ou D.");
            return;
        }

        String sQuantidade = JOptionPane.showInputDialog(null, "Digite a quantidade:");
        quantidade = Integer.parseInt(sQuantidade);

        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida! Digite um número maior que zero.");
            return;
        }

        // Determinação do preço
        if (codigo == 1) { // Meia-Cola
            if (tipo.equals("N")) {
                preco = 1.50;
            } else {
                preco = 1.70;
            }
        } else if (codigo == 2) { // Limonax
            if (tipo.equals("N")) {
                preco = 1.60;
            } else {
                preco = 1.70;
            }
        } else if (codigo == 3) { // Orange
            if (tipo.equals("N")) {
                preco = 1.40;
            } else {
                preco = 1.45;
            }
        }

        // Cálculo do total bruto
        total = preco * quantidade;

        // Aplicação do desconto (5% se total for maior que R$ 100)
        if (total > 100) {
            total = total * 0.95;
        }

        // Exibição do resultado
        JOptionPane.showMessageDialog(null, "Valor total: R$ " + String.format("%.2f", total));
    }
}
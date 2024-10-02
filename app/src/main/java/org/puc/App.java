package org.puc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var tree = MorseBinaryTree.filled();

        var shouldQuit = false;
        var inputScanner = new Scanner(System.in);

        while (!shouldQuit) {
            String menuString = """
                    > 1 - Adicionar novo elemento
                    > 2 - Visualizar fila
                    > 3 - Sair""";

            System.out.println("\nEscolha uma função:");
            System.out.println(menuString);
            System.out.print("\n> ");

            var inputLine = inputScanner.nextLine();
            switch (inputLine) {
                case "1":
                    System.out.println("Descreva o novo elemento da árvore (digite \"voltar\" para voltar):");

                    System.out.print("Caractere: ");
                    var symbol = inputScanner.nextLine();
                    if (symbol.equalsIgnoreCase("voltar"))
                        continue;

                    if (symbol.length() > 1) {
                        System.out.println("Insira apenas um caractere");
                        break;
                    }

                    System.out.print("Em morse: ");
                    var morse = inputScanner.nextLine();
                    if (morse.equalsIgnoreCase("voltar"))
                        continue;

                    try {
                        tree.insert(symbol.charAt(0), morse);
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir elemento - verifique seu código morse");
                        break;
                    }

                    System.out.println("Elemento inserido com sucesso!");
                    break;

                case "2":
                    tree.print();
                    break;
                case "3":
                    shouldQuit = true;
                    break;
                default:
                    System.out.println("Função inválida.");
                    break;
            }
        }

        inputScanner.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.bank;

import java.util.Locale;
import java.util.Scanner;
import model.entidades.Conta;
import model.exception.DomainException;

/**
 *
 * @author Joel Sousa
 */
public class Program {
    public static void main(String[] args){
            Locale.setDefault(Locale.US);
            Scanner read = new Scanner(System.in);
            try{
            System.out.print("Nome titular: ");
            String nome = read.nextLine();
            System.out.print("numero da conta: ");
            Integer numConta = read.nextInt();
            System.out.print("valor do saldo :");
            Double saldo= read.nextDouble();
            System.out.print("Limite de saque: ");
            Double limiteSaque = read.nextDouble();
            System.out.println("");
            
            Conta c1 = new Conta(numConta, nome,saldo, limiteSaque);
            
            System.out.println(c1.ToString());
            System.out.println("");
            
            System.out.print("Quanto Deseja Sacar ? ");
            Double vlSaque = read.nextDouble();
            c1.saque(vlSaque);
            }
            catch(DomainException erro){
                System.out.println("Erro : "+erro.getMessage());
            }
            catch(Exception erro){
                System.out.println("ERROR ! "
                        + "\nVerifique se os dados foram digitados corretamente !");
            }
           

    }
}

package main.com;
import metier.*;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        try {
            Compte cp1 = new CompteCourant(1, 8000, 5000);
            Compte cp2 = new CompteEparne(2, 30000, 5.5);
            cp1.verser(50000);
            cp1.retirer(3000);
            cp1.virement(400, cp2);
            cp1.verser(4000);
            cp1.retirer(7000);
            System.out.println("Solde CP1 = " + cp1.consulterSolde());
            System.out.println("Solde CP2 = " + cp2.consulterSolde());
            System.out.println("Total des veresement CP1 = " + cp1.totalVersements());
            System.out.println("Total des retraits CP1 = " + cp1.totalRetraits());

            List<Operation> listOperation = cp1.getOperations();

            for (Operation o:listOperation){
                System.out.println(o.getClass().getSimpleName() +" --- " +o.getNumero() + " -- " + o.getDateOperation() + " -- " + o.getMontant());
            }

            System.out.println("Total des veresement CP1 = " + cp1.totalVersements());
            System.out.println("Total des retraits CP1 = " + cp1.totalRetraits());

            //cp1.retirer(800000);

            System.out.println("Mettre à jour le solde");

            cp1.updateSolde();
            cp2.updateSolde();

            System.out.println("Solde CP1 = " + cp1.consulterSolde());
            System.out.println("Solde CP2 = " + cp2.consulterSolde());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
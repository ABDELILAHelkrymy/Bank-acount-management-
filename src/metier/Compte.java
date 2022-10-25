package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
    protected int code;
    protected double solde;
    protected List<Operation> operations = new ArrayList<>();

    public Compte() {
        super();
    }

    public Compte(int code, double solde) {
        super();
        this.code = code;
        this.solde = solde;
    }

    public void verser(double mt){
        Versement v = new Versement(operations.size() + 1 , new Date(), mt);
        operations.add(v);
        solde += mt;
    }

    public abstract void retirer(double mt);

    public void virement(double mt, Compte cp2){
        retirer(mt);
        cp2.verser(mt);
    }

    public double consulterSolde(){
        return solde;
    }

    public abstract void updateSolde();

    public List<Operation> getOperations(){
        return operations;
    }

    public double totalVersements(){
        double somme = 0;
        for (Operation o:operations){
            if (o instanceof Versement){
                somme += o.getMontant();
            }
        }
        return somme;
    }

    public double totalRetraits(){
        double somme = 0;
        for (Operation o:operations){
            if (o instanceof Retrait){
                somme += o.getMontant();
            }
        }
        return somme;
    }



}

package metier;

import java.util.Date;

public class CompteEparne extends Compte{
    private double taux;

    public CompteEparne() {
        super();
    }

    public CompteEparne(int code, double solde, double taux) {
        super(code, solde);
        this.taux = taux;
    }

    @Override
    public void retirer(double mt) {
        if (mt > solde ) throw new RuntimeException("solde insuffisant");
        Retrait r = new Retrait(operations.size()+1, new Date(), mt);
        operations.add(r);
        solde = solde - mt;
    }

    @Override
    public void updateSolde() {
        solde = solde*(1+taux/100);
    }
}

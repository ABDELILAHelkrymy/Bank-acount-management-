package metier;

import java.util.Date;

public class CompteCourant extends Compte{

    private double decouvert;
    @Override
    public void retirer(double mt) {
        if (mt > solde+decouvert ) throw new RuntimeException("solde insuffisant");
        Retrait r = new Retrait(operations.size()+1, new Date(), mt);
        operations.add(r);
        solde = solde - mt;
    }

    @Override
    public void updateSolde() {

    }

    public CompteCourant() {
        super();
    }

    public CompteCourant(int code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }
}

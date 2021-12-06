package decorateurMagasin;

public abstract class DecorateurIHM implements AbstractionIHM {
    AbstractionIHM abstraction;
    
    public DecorateurIHM(AbstractionIHM abstraction){
        this.abstraction = abstraction;
    }
}

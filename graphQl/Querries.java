package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    private LogementRepository logementRepository;
    public Querries (RendezVousRepository repoR , LogementRepository logR){
        this.rendezVousRepository= repoR;
        this.logementRepository=logR;
    }
    public List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }
    public List<RendezVous> getRendezVousByLogementRef(int refLog) {
        return rendezVousRepository.getListeRendezVousByLogementRef(refLog);
    }
    public RendezVous getRendezVousById(int id) {
        return rendezVousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé avec l'identifiant : " + id));
    }
    public List<Logement> getallLogement(){
        return this.logementRepository.getAllLogements();
    }
    public Logement getLogementByRef(int reference) {
        return  logementRepository.getLogementsByReference(reference);
    }
    public List<Logement> getLogementByType(Logement.Type type) {
        return (List<Logement>) logementRepository.getLogementsByType(type);
    }
}
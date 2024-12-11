package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
    private final RendezVousRepository rendezVousRepository;
    private final LogementRepository logementRepository;

    public Mutation(RendezVousRepository rendezVousRepository,  LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }

    public RendezVous createRendezVous(int id, String date, String heure, int refLog, String numTel) {
        RendezVous rendezVous = new RendezVous(id, date, heure, rendezVousRepository.getLogementByRDV(refLog), numTel);
        if (rendezVousRepository.addRendezVous(rendezVous)) {
            return rendezVous;
        }
        return null;
    }

    public boolean updateRendezVous(int id, String date, String heure, String numTel) {
        RendezVous rendezVous = new RendezVous(id, date, heure, rendezVousRepository.getLogementByRDV(id), numTel);
        return rendezVousRepository.updateRendezVous(rendezVous);
    }

    public boolean deleteRendezVous(int id) {
        return rendezVousRepository.deleteRendezVous(id);
    }


    //Logement

    public Logement createLogement(int reference, String adresse){
        Logement logement = new Logement(reference,adresse);
       logementRepository.saveLogement(logement);
            return logement;

    }

}

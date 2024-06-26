package elena.GestionePrenotazioni.Service;

import elena.GestionePrenotazioni.Bean.Edificio;
import elena.GestionePrenotazioni.Bean.Prenotazione;
import elena.GestionePrenotazioni.Repository.PostazioneRepository;
import elena.GestionePrenotazioni.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneService postazioneService;


    public void inserisciPrenotazione(Prenotazione prenotazione) {
        if (postazioneService.verificaPostazioneLibera(prenotazione.getPostazione(), prenotazione.getData()) &&
                prenotazioneRepository.findByUtenteAndData(prenotazione.getUtente(), prenotazione.getData()).isEmpty()) {
            prenotazioneRepository.save(prenotazione);
            System.out.println("Prenotazione è stata aggiunta");
        } else {
            System.out.println("La postazione non è disponibile per la data selezionata");
        }
    }

    public void eliminaPrenotazione(int id) {
        prenotazioneRepository.deleteById(id);
    }
}

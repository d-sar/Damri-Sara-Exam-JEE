package sara.damri.examenbackend;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sara.damri.examenbackend.Entities.*;
import sara.damri.examenbackend.Repositories.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ExamenBackendApplication  implements CommandLineRunner{

private ClientRepository clientleRepo;


    public static void main(String[] args) {
        SpringApplication.run(ExamenBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {



    }


        @Bean
        CommandLineRunner initData(
                ClientRepository clientRepository,
                CreditRepository creditRepository,
                RemboursementRepository remboursementRepository,
                CreditPersonnelRepository creditPersonnelRepository,
                CreditImmobilierRepository creditImmobilierRepository,
                CreditProfessionnelRepository creditProfessionnelRepository) {

            return args -> {
                // 1. Création des clients
                Client client1 = new Client();
                client1.setName("Sara DAMRI");
                client1.setEmail("sara@gmail.com");

                Client client2 = new Client();
                client2.setName("Ahmed BENALI");
                client2.setEmail("ahmed@example.com");

                clientRepository.saveAll(List.of(client1, client2));

                // 2. Création des crédits
                // Crédit Personnel
                CreditPersonnel creditPersonnel = new CreditPersonnel();
                creditPersonnel.setDateDemande(LocalDate.now());
                creditPersonnel.setStatut(StatutCredit.EN_COURS);
                creditPersonnel.setMontant(50000.0);
                creditPersonnel.setDureeMois(60);
                creditPersonnel.setTauxInteret(4.5);
                creditPersonnel.setMotif("Achat voiture");
                creditPersonnel.setClient(client1);

                // Crédit Immobilier
                CreditImmobilier creditImmobilier = new CreditImmobilier();
                creditImmobilier.setDateDemande(LocalDate.now().minusMonths(1));
                creditImmobilier.setStatut(StatutCredit.ACCEPTE);
                creditImmobilier.setDateAcceptation(LocalDate.now().minusDays(20));
                creditImmobilier.setMontant(2000000.0);
                creditImmobilier.setDureeMois(240);
                creditImmobilier.setTauxInteret(3.2);
                creditImmobilier.setTypeBien(TypeBien.APPARTEMENT);
                creditImmobilier.setClient(client1);

                // Crédit Professionnel
                CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
                creditProfessionnel.setDateDemande(LocalDate.now().minusWeeks(2));
                creditProfessionnel.setStatut(StatutCredit.ACCEPTE);
                creditProfessionnel.setDateAcceptation(LocalDate.now().minusWeeks(1));
                creditProfessionnel.setMontant(1000000.0);
                creditProfessionnel.setDureeMois(120);
                creditProfessionnel.setTauxInteret(3.8);
                creditProfessionnel.setMotif("Expansion entreprise");

                creditProfessionnel.setClient(client2);

                creditRepository.saveAll(List.of(
                        creditPersonnel,
                        creditImmobilier,
                        creditProfessionnel
                ));

                // 3. Création des remboursements
                Remboursement remboursement1 = new Remboursement();
                remboursement1.setDate(LocalDate.now().plusMonths(1));
                remboursement1.setMontant(10000.0);
                remboursement1.setType(TypeRemboursement.MENSUALITE);
                remboursement1.setCredit(creditPersonnel);

                Remboursement remboursement2 = new Remboursement();
                remboursement2.setDate(LocalDate.now());
                remboursement2.setMontant(50000.0);
                remboursement2.setType(TypeRemboursement.ANTICIPE);
                remboursement2.setCredit(creditImmobilier);

                remboursementRepository.saveAll(List.of(remboursement1, remboursement2));

                // 4. Affichage des données
                System.out.println("\n=== Clients et leurs crédits ===");
                clientRepository.findAll().forEach(client -> {
                    System.out.printf("%s (%s) a %d crédits:%n",
                            client.getName(), client.getEmail(), client.getCredits().size());

                    client.getCredits().forEach(credit -> {
                        String type = "";
                        if (credit instanceof CreditPersonnel) {
                            type = "Personnel - Motif: " + ((CreditPersonnel) credit).getMotif();
                        } else if (credit instanceof CreditImmobilier) {
                            type = "Immobilier - Type: " + ((CreditImmobilier) credit).getTypeBien();
                        }

                        System.out.printf("- %s | %s | %.2f DH | %s%n",
                                credit.getClass().getSimpleName(),
                                type,
                                credit.getMontant(),
                                credit.getStatut());
                    });
                });

                System.out.println("\n=== Remboursements ===");
                remboursementRepository.findAll().forEach(r -> {
                    System.out.printf("%s | %.2f DH | %s | Crédit: %d (%s)%n",
                            r.getDate(),
                            r.getMontant(),
                            r.getType(),
                            r.getCredit().getId(),
                            r.getCredit().getClass().getSimpleName());
                });
            };
        }
    }


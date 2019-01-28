import entities.Diagnose;
import entities.Medicament;
import entities.Patient;
import entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();

        Set<Medicament> medicaments = new HashSet<>();
        medicaments.add(new Medicament("medicament1"));
        medicaments.add(new Medicament("medicament2"));
        medicaments.add(new Medicament("medicament3"));

        Set<Diagnose> diagnoses = new HashSet<>();
        diagnoses.add(new Diagnose("diagnose1"));
        diagnoses.add(new Diagnose("diagnose2"));
        diagnoses.add(new Diagnose("diagnose3"));

        Patient patient = new Patient("Dragan", "Draganov");

        patient.setDiagnoses(diagnoses);
        patient.setMedicaments(medicaments);

        Visitation visitation =new Visitation();
        visitation.setPatient(patient);

        em.getTransaction().begin();

        em.persist(visitation);

        em.getTransaction().commit();
        em.close();
    }
}

package universiteotomasyonu.kullanici.idareci;

public interface DersProgrami {
    String[] gunler = {"Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma"};
    String[] saatler = {"08:30-09:20", "09:25-10:15", "10:20-11:10", "12:10-13:00", "13:05-13:55", "14:55-15:45 ", "15:50-16:40"};

    void programHazirla();
}

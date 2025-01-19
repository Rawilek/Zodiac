import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Zodiac {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w grze Zodiak! Podaj swoją datę urodzenia (w formacie RRRR-MM-DD):");

        LocalDate birthDate = null;
        while (birthDate == null) {
            try {
                String input = scanner.nextLine();
                birthDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie:");
            }
        }

        String zodiacSign = getZodiacSign(birthDate);
        System.out.println("Twój znak zodiaku to: " + zodiacSign);

        System.out.println("Wybierz opcję:");
        System.out.println("1. Wylosuj wróżbę");
        System.out.println("2. Otrzymaj imię wróżbity");
        System.out.println("3. Poznaj ciekawostkę o swoim znaku zodiaku");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                String fortune = getRandomFortune();
                System.out.println("Twoja wróżba: " + fortune);
            }
            case 2 -> {
                String prophetName = generateProphetName();
                System.out.println("Imię Twojego wróżbity: " + prophetName);
            }
            case 3 -> {
                String fact = getZodiacFact(zodiacSign);
                System.out.println("Ciekawostka: " + fact);
            }
            default -> System.out.println("Niepoprawna opcja.");
        }

        scanner.close();
    }

    private static String getZodiacSign(LocalDate birthDate) {
        Month day = birthDate.getMonth();
        int date = birthDate.getDayOfMonth();

        if ((day == Month.MARCH && date >= 21) || (day == Month.APRIL && date <= 19)) {
            return "Baran";
        } else if ((day == Month.APRIL && date >= 20) || (day == Month.MAY && date <= 20)) {
            return "Byk";
        } else if ((day == Month.MAY && date >= 21) || (day == Month.JUNE && date <= 20)) {
            return "Bliźnięta";
        } else if ((day == Month.JUNE && date >= 21) || (day == Month.JULY && date <= 22)) {
            return "Rak";
        } else if ((day == Month.JULY && date >= 23) || (day == Month.AUGUST && date <= 22)) {
            return "Lew";
        } else if ((day == Month.AUGUST && date >= 23) || (day == Month.SEPTEMBER && date <= 22)) {
            return "Panna";
        } else if ((day == Month.SEPTEMBER && date >= 23) || (day == Month.OCTOBER && date <= 22)) {
            return "Waga";
        } else if ((day == Month.OCTOBER && date >= 23) || (day == Month.NOVEMBER && date <= 21)) {
            return "Skorpion";
        } else if ((day == Month.NOVEMBER && date >= 22) || (day == Month.DECEMBER && date <= 21)) {
            return "Strzelec";
        } else if ((day == Month.DECEMBER && date >= 22) || (day == Month.JANUARY && date <= 19)) {
            return "Koziorożec";
        } else if ((day == Month.JANUARY && date >= 20) || (day == Month.FEBRUARY && date <= 18)) {
            return "Wodnik";
        } else {
            return "Ryby";
        }
    }

    private static String getRandomFortune() {
        List<String> fortunes = new ArrayList<>(Arrays.asList(
                "Dziś spotkasz kogoś wyjątkowego.",
                "Twoje marzenia się spełnią, jeśli uwierzysz w siebie.",
                "Przed Tobą szczęśliwy dzień.",
                "Czeka Cię miła niespodzianka.",
                "Twoje wysiłki zostaną docenione."
        ));

        Random random = new Random();
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    private static String generateProphetName() {
        List<String> names = new ArrayList<>(Arrays.asList(
                "Merlin", "Cassandra", "Sybil", "Nostradamus", "Pythia"
        ));

        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    private static String getZodiacFact(String zodiacSign) {
        Map<String, String> facts = new HashMap<>();
        facts.put("Baran", "Barany są znane z odwagi i energii.");
        facts.put("Byk", "Byki są praktyczne i niezawodne.");
        facts.put("Bliźnięta", "Bliźnięta są towarzyskie i elastyczne.");
        facts.put("Rak", "Raki są emocjonalne i opiekuńcze.");
        facts.put("Lew", "Lwy są pewne siebie i charyzmatyczne.");
        facts.put("Panna", "Panny są analityczne i zorganizowane.");
        facts.put("Waga", "Wagi cenią harmonię i piękno.");
        facts.put("Skorpion", "Skorpiony są pasjonujące i tajemnicze.");
        facts.put("Strzelec", "Strzelce są optymistyczne i niezależne.");
        facts.put("Koziorożec", "Koziorożce są ambitne i zdyscyplinowane.");
        facts.put("Wodnik", "Wodniki są innowacyjne i niezależne.");
        facts.put("Ryby", "Ryby są kreatywne i wrażliwe.");

        return facts.getOrDefault(zodiacSign, "Brak informacji o tym znaku zodiaku.");
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class TutorLink {

    private static final String FILENAME = "data.csv";
    private static final int NUM_SUBJECTS = 3;
    public ArrayList<Person> tutors;
    public ArrayList<Person> tutees;

    public void processData() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILENAME));
        // skip first line with table headings
        sc.nextLine();
        while (sc.hasNextLine()) {
            Scanner ls = new Scanner(sc.nextLine());
            ls.useDelimiter(",");
            Person p = new Person();
            // parse through data, add info to person
            p.name = ls.next();
            p.email = ls.next();
            p.isTutor = ls.next().equals("Tutor");
            for (int i = 0; i < NUM_SUBJECTS; i++) {
                String subj = ls.next();
                if (!subj.equals("N/A")) {
                    p.subjects.add(subj);
                }
            }
            ls.close();
            if (p.isTutor) {
                tutors.add(p);
            } else {
                // is a tutee
                tutees.add(p);
            }
        }
        sc.close();
    }

    // match tutees to tutors & vice versa
    public void getMatches() {
        for (Person tutor : tutors) {
            for (Person tutee : tutees) {
                if (isMatch(tutor, tutee)) {
                    tutor.matches.add(tutee);
                    tutee.matches.add(tutor);
                }
            }
        }
    }

    private static boolean isMatch(Person tutor, Person tutee) {
        for (String subj : tutor.subjects) {
            if (tutee.subjects.contains(subj)) {
                return true;
            }
        }
        return false;
    }


    public static class Person {

        private String name;
        private String email;
        private boolean isTutor;
        private ArrayList<String> subjects;
        private ArrayList<Person> matches;

        public Person() {
            subjects = new ArrayList<>();
            matches = new ArrayList<>();
        }

        public String toString() {
            return name;
        }

    }

}
